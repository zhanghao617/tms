package com.haoyukeji.tms.controller;

import com.haoyukeji.tms.entity.Store;
import com.haoyukeji.tms.entity.TicketInStock;
import com.haoyukeji.tms.entity.TicketOutStore;
import com.haoyukeji.tms.exception.ServiceException;
import com.haoyukeji.tms.service.StoreService;
import com.haoyukeji.tms.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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


    @GetMapping("/out")
    public String ticketOutHome(Model model) {

        return "/ticket/out/home";
    }

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

}
