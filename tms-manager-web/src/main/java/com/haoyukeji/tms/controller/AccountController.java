package com.haoyukeji.tms.controller;

import com.haoyukeji.tms.controller.exception.NotFoundException;
import com.haoyukeji.tms.dto.ResponseBean;
import com.haoyukeji.tms.entity.Account;
import com.haoyukeji.tms.entity.Role;
import com.haoyukeji.tms.exception.ServiceException;
import com.haoyukeji.tms.service.AccountService;
import com.haoyukeji.tms.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/manager/account")
public class AccountController {

    @Autowired
    private RolePermissionService rolePermissionService;
    @Autowired
    private AccountService accountService;

    @GetMapping
    public String home(Model model) {
        List<Account> accountList = accountService.findAllAccountWithRole();
        model.addAttribute("accountList",accountList);
        return "/manager/account/home";
    }

    /**
     * 新增账号
     * @param model
     * @return
     */
    @GetMapping("/new")
    public String newAccount(Model model) {
        List<Role> roleList = rolePermissionService.findAllRole();

        model.addAttribute("roleList",roleList);
        return "/manager/account/new";
    }

    /**
     * 新增账号
     * @param account
     * @param roleId
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/new")
    public String newAccount(Account account, Integer[] roleId, RedirectAttributes redirectAttributes) {
        accountService.saveAccount(account,roleId);
        redirectAttributes.addFlashAttribute("message","添加账号成功");
        return "redirect:/manager/account";
    }

    /**
     * 编辑账号
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/{id:\\d+}/edit")
    public String updateAccount(@PathVariable Integer id,Model model) {
       Account account = accountService.findAccountById(id);
       //判断账号是否为空
        if (account == null) {
            throw new NotFoundException();
        }
        //查询所有的角色
        List<Role> roleList = accountService.findAllRole();
        //查询账号所拥有的角色
        List<Role> accountList = rolePermissionService.findRoleByAccountId(id);

        model.addAttribute("account",account);
        model.addAttribute("roleList",roleList);
        model.addAttribute("accountRole",accountList);
        return "/manager/account/edit";
    }

    @PostMapping("/{id:\\d+}/edit")
    public String updateAccount(Account account,Integer[] roleId, RedirectAttributes redirectAttributes) {
        accountService.updateAccount(account,roleId);
        redirectAttributes.addFlashAttribute("message","修改成功");
        return "redirect:/manager/account";
    }

    @GetMapping("{id:\\d+}/del")
    public @ResponseBody ResponseBean delAccount(@PathVariable Integer id) {

        try {
            accountService.delAccountById(id);
            return ResponseBean.success();
        }catch (ServiceException ex) {
            return ResponseBean.error(ex.getMessage());
        }
    }

}
