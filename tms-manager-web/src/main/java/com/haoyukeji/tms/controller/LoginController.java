package com.haoyukeji.tms.controller;

import com.haoyukeji.tms.entity.Account;
import com.haoyukeji.tms.exception.ServiceException;
import com.haoyukeji.tms.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 登陆,首页控制器
 */
@Controller
public class LoginController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/")
    public String logining(String accountMobile,
                           String accountPassword,
                           HttpServletRequest request,
                           HttpSession session,
                           RedirectAttributes redirectAttributes) {

        String accountIP = request.getLocalAddr();
        try{
            Account account = accountService.login(accountMobile,accountPassword,accountIP);
            //将登陆对象存入session
            session.setAttribute("current_Account",account);
            return "redirect:/home";
        }catch (ServiceException ex) {
            redirectAttributes.addFlashAttribute("phone",accountMobile);
            redirectAttributes.addFlashAttribute("message",ex.getMessage());
            return "redirect:/";
        }
    }

    /**
     * 登陆成功后跳转的页面
     */
    @GetMapping("/home")
    public String home() {
        return "/home";
    }
}
