package com.haoyukeji.tms.controller;

import com.haoyukeji.tms.dto.ResponseBean;
import com.haoyukeji.tms.entity.Store;
import com.haoyukeji.tms.entity.TicketInStock;
import com.haoyukeji.tms.entity.TicketOutStore;
import com.haoyukeji.tms.exception.ServiceException;
import com.haoyukeji.tms.service.StoreService;
import com.haoyukeji.tms.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;
    @Autowired
    private StoreService storeService;

    @GetMapping("/store")
    public String home(Model model) {
        List<TicketInStock> ticketList = ticketService.findAllTicketInStore();
        model.addAttribute("ticketList",ticketList);
        return "/ticket/store/home";
    }

    /**
     * 新增年票入库
     * @param model
     * @return
     */
    @GetMapping("/store/new")
    public String newTicketIn(Model model) {

        return "/ticket/store/new";
    }

    @PostMapping("/store/new")
    public String newTicketIn(TicketInStock ticketInStock,
                              RedirectAttributes redirectAttributes) {

        try {
            ticketService.saveTicketInStore(ticketInStock);
            redirectAttributes.addFlashAttribute("message", "新增入库成功");
        }catch (ServiceException ex) {
            redirectAttributes.addFlashAttribute("message",ex.getMessage());
            ex.printStackTrace();
        }
        return "redirect:/ticket/store";
    }

    /**
     * 删除入库记录
     * @param id
     * @param redirectAttributes
     * @return
     */
    @GetMapping("/store/{id:\\d+}/del")
    public String delInStore(@PathVariable Integer id ,RedirectAttributes redirectAttributes) {
        ticketService.delInStoreById(id);
        redirectAttributes.addFlashAttribute("message","删除成功");
        return "redirect:/ticket/store";
    }


    /**
     * 年票下发首页
     * @param model
     * @return
     */
    @GetMapping("/out")
    public String ticketOutHome(Model model) {
        List<TicketOutStore> ticketOutStores = ticketService.findAllTicketOutStore();
        model.addAttribute("ticketOutStores",ticketOutStores);
        return "/ticket/out/home";
    }

    /**
     * 年票下发
     * @param model
     * @return
     */
    @GetMapping("/out/new")
    public  String outTicketOut(Model model) {
        List<Store> storeList = storeService.findAllStore();
        model.addAttribute("storeList",storeList);
        return "/ticket/out/new";
    }

    @PostMapping("/out/new")
    public String newTicketOut(TicketOutStore ticketOutStore,
                               RedirectAttributes redirectAttributes) {
        try {
            ticketService.saveTicketOutStore(ticketOutStore);
        }catch (ServiceException ex) {
            redirectAttributes.addFlashAttribute("message",ex.getMessage());
        }
        return "redirect:/ticket/out";
    }

    /**
     * 删除年票下发记录
     */
    @GetMapping("/out/{id:\\d+}/del")
    @ResponseBody
    public ResponseBean delTicketOut(@PathVariable Integer id) {
        ticketService.delOutStoreById(id);
        return ResponseBean.success();
    }

    /**
     * 年票统计
     * @param model
     * @return
     */
    @GetMapping("/chart")
    public String chartTicket(Model model) {
        Map<String,Long> resultMap = ticketService.countTicketByState();
        model.addAttribute("resultMap",resultMap);
        return "/ticket/chart/home";
    }

}
