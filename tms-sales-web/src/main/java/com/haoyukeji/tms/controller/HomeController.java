package com.haoyukeji.tms.controller;

import com.haoyukeji.tms.entity.Ticket;
import com.haoyukeji.tms.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private StoreService storeService;

    @GetMapping("/ticket/new")
    public String newTicketCus(Model model) {

        return "/ticket/new";
    }

    @PostMapping("/ticket/new")
    public String newTicketCus(Ticket ticket) {

        return "redirect:/";
    }

}
