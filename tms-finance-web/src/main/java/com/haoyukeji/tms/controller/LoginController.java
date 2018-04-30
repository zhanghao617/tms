package com.haoyukeji.tms.controller;

import com.haoyukeji.tms.service.AccountService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 登陆,首页控制器
 */
@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

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

            if (subject.hasRole("finance") || subject.hasRole("store")) {
                //登录后跳转目标的判断
                SavedRequest savedRequest = WebUtils.getSavedRequest(request);
                String url = "/home";
                if (savedRequest != null) {
                    url = savedRequest.getRequestUrl();
                }
                return "redirect:" + url;
            } else {
                logger.info(" {} 权限不足，登陆失败", accountMobile);
                redirectAttributes.addFlashAttribute("message","权限不足，请申请权限后登录");
            }

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

    /**
     * 登陆成功后跳转的页面
     */
    @GetMapping("/home")
    public String home() {
        return "/home";
    }


    @GetMapping("/401")
    public String unauthorizedUrl() {
        return "error/401";
    }
}
