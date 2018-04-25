package com.haoyukeji.tms.controller;

import com.haoyukeji.tms.entity.Account;
import com.haoyukeji.tms.exception.ServiceException;
import com.haoyukeji.tms.service.AccountService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.mgt.SubjectFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
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
        Subject subject = SecurityUtils.getSubject();

        //判断是否认证，false退出
        if(subject.isAuthenticated()) {
            subject.logout();
        }
        //判断是否被记住，ture跳转home页，false：登陆页
        if (subject.isRemembered()) {
            return "redirect:/home";
        }
        return "login";
    }

    @PostMapping("/")
    public String logining(String accountMobile,
                           String accountPassword,
                           String rememberMe,
                           HttpServletRequest request,
                           RedirectAttributes redirectAttributes) {

        Subject subject = SecurityUtils.getSubject();
        String requestIP = request.getRemoteAddr();
        UsernamePasswordToken usernamePasswordToken =
                new UsernamePasswordToken(accountMobile,DigestUtils.md5Hex(accountPassword),rememberMe != null,requestIP);

        try {
            subject.login(usernamePasswordToken);

            //登录后跳转目标的判断
            SavedRequest savedRequest = WebUtils.getSavedRequest(request);
            String url = "/home";
            if (savedRequest != null) {
                url = savedRequest.getRequestUrl();
            }
            return "redirect:" + url;
        }catch (UnknownAccountException | IncorrectCredentialsException ex) {
            ex.printStackTrace();
            redirectAttributes.addFlashAttribute("message","账号或密码错误");
        } catch (LockedAccountException ex) {
            ex.printStackTrace();
            redirectAttributes.addFlashAttribute("message","账号被锁定");
        } catch (AuthenticationException ex) {
            ex.printStackTrace();
            redirectAttributes.addFlashAttribute("message","账号或密码错误");
        }
        return "redirect:/";
    }
        /*String accountIP = request.getLocalAddr();
        try{
            Account account = accountService.login(accountMobile,accountPassword,accountIP);
            //将登陆对象存入session
            session.setAttribute("current_Account",account);
            return "redirect:/home";
        }catch (ServiceException ex) {
            redirectAttributes.addFlashAttribute("phone",accountMobile);
            redirectAttributes.addFlashAttribute("message",ex.getMessage());
            return "redirect:/";
        }*/

    /**
     * 登陆成功后跳转的页面
     */
    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    /*@GetMapping("/logout")
    public String logout(RedirectAttributes redirectAttributes) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();

        redirectAttributes.addFlashAttribute("message","你已安全退出");
        return "redirect:/";
    }*/

    @GetMapping("/401")
    public String unauthorizedUrl() {
        return "error/401";
    }
}
