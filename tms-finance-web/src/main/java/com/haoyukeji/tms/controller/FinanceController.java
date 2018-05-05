package com.haoyukeji.tms.controller;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.haoyukeji.tms.entity.TicketOutStore;
import com.haoyukeji.tms.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/finance")
public class FinanceController {

    @Autowired
    private TicketService ticketService;

    /**
     * 财务首页
     * @return
     */
    @GetMapping
    public String home(@RequestParam(required = false,defaultValue = "未支付") String state,
                       @RequestParam(required = false,defaultValue = "1",name = "p") Integer pageNo,
                       Model model) {
        Map<String,Object> queryParam = Maps.newHashMap();
        queryParam.put("state",state);

        PageInfo<TicketOutStore> pageInfo = ticketService.findTicketOutStoreByPageNoAndQueryParam(pageNo,queryParam);
        model.addAttribute("page",pageInfo);
        return "/finance/home";
    }

    /**
     * 支付页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/{id:\\d+}/new")
    public String ticketFinance(@PathVariable Integer id, Model model) {
        TicketOutStore ticketOutStore = ticketService.findTicketOutStoreById(id);
        model.addAttribute("outTicket",ticketOutStore);
        return "/finance/new";
    }

    @PostMapping("/{id:\\d+}/new")
    public String ticketFinance(Integer id, String payType) {
        ticketService.saveTicketFinance(id,payType);
        return "redirect:/finance";
    }



}
