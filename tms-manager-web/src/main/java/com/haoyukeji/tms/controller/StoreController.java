package com.haoyukeji.tms.controller;

import com.haoyukeji.tms.entity.Store;
import com.haoyukeji.tms.fileStore.QiniuStore;
import com.haoyukeji.tms.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private StoreService storeService;
    @Autowired
    private QiniuStore qiniuStore;

    @GetMapping
    public String home() {
        return "/store/home";
    }

    @GetMapping("/new")
    public String newStore (Model model) {
        String upToken = qiniuStore.getUploadToken();
        model.addAttribute(upToken);
        return "/store/new";
    }

    @PostMapping("/new")
    public String newStore(Store store, RedirectAttributes redirectAttributes) {
        storeService.saveNewStore(store);
        redirectAttributes.addFlashAttribute("message","添加销售点成功");
        return "/store";

    }

}
