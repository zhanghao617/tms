package com.haoyukeji.tms.controller;

import com.haoyukeji.tms.controller.exception.NotFoundException;
import com.haoyukeji.tms.dto.ResponseBean;
import com.haoyukeji.tms.entity.Store;
import com.haoyukeji.tms.exception.ServiceException;
import com.haoyukeji.tms.fileStore.QiniuStore;
import com.haoyukeji.tms.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService storeService;
    @Autowired
    private QiniuStore qiniuStore;

    @GetMapping
    public String home(Model model) {
        List<Store> storeList = storeService.findAllStore();
        model.addAttribute("storeList",storeList);
        return "/store/home";
    }

    @GetMapping("/new")
    public String newStore (Model model) {
        String upToken = qiniuStore.getUploadToken();
        model.addAttribute("upToken",upToken);
        return "/store/new";
    }

    @PostMapping("/new")
    public String newStore(Store store, RedirectAttributes redirectAttributes) {
        storeService.saveNewStore(store);
        redirectAttributes.addFlashAttribute("message","添加销售点成功");
        return "redirect:/store";

    }

    /**
     * 修改账号
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/{id:\\d+}/edit")
    public String updateStore(@PathVariable Integer id, Model model) {
        String upToken = qiniuStore.getUploadToken();
        Store store = storeService.findStoreById(id);
        if (store == null) {
            throw new NotFoundException();
        }
        model.addAttribute("upToken",upToken);
        model.addAttribute("store",store);
        return "/store/edit";
    }

    @PostMapping("/{id:\\d+}/edit")
    public String updateStore(Store store, RedirectAttributes redirectAttributes) {
        storeService.updateStore(store);
        redirectAttributes.addFlashAttribute("message","修改成功");
        return "redirect:/store";
    }

    @GetMapping("/{id:\\d+}/del")
    public @ResponseBody ResponseBean delStore(@PathVariable Integer id) {
        try {
            storeService.delStoreWithAccountById(id);
            return ResponseBean.success();
        }catch (ServiceException ex) {
            return ResponseBean.error(ex.getMessage());
        }

    }

}
