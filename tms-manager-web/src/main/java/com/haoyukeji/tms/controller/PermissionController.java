package com.haoyukeji.tms.controller;

import com.haoyukeji.tms.dto.ResponseBean;
import com.haoyukeji.tms.entity.Permissions;
import com.haoyukeji.tms.exception.ServiceException;
import com.haoyukeji.tms.service.RolePermissionService;
import com.haoyukeji.tms.shiro.CustomerFilterChainDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * 权限控制器
 * @author Administrator
 */
@Controller
@RequestMapping("/manager/permission")
public class PermissionController {

    @Autowired
    private RolePermissionService rolePermissionService;
    @Autowired
    private CustomerFilterChainDefinition customerFilterChainDefinition;

    @GetMapping
    public String home(Model model) {
        List<Permissions> permissionList = rolePermissionService.findAllPermission();
        model.addAttribute("permissionList",permissionList);
        return "/manager/permission/home";
    }


    /**
     * 新增权限
     * @return
     */
    @GetMapping("/new")
    public String newPermission(Model model) {

        List<Permissions> permissionList = rolePermissionService.findPermissionByType(Permissions.MENU_TYPE);
        model.addAttribute("permissionList",permissionList);
        return "/manager/permission/new";
    }

    @PostMapping("/new")
    public String newPermission(Permissions permissions, RedirectAttributes redirectAttributes) {
        rolePermissionService.savePermission(permissions);
        //刷新shiro的权限
        customerFilterChainDefinition.updateUelPermission();
        redirectAttributes.addFlashAttribute("message","添加成功");
        return "redirect:/manager/permission";
    }

    /**
     * 删除权限
     * @param id
     * @return
     */
    @GetMapping("/{id:\\d+}/del")
    public @ResponseBody ResponseBean delPermission(@PathVariable Integer id) {
        try {
            rolePermissionService.delPermissionById(id);
            //刷新shiro的权限
            customerFilterChainDefinition.updateUelPermission();
            return ResponseBean.success();
        }catch (ServiceException ex) {
            return ResponseBean.error(ex.getMessage());
        }
    }

    /**
     * 权限修改
     * @param id
     * @param model
     * @param redirectAttributes
     * @return
     */
    @GetMapping("{id:\\d+}/edit")
    public String updatePermissions (@PathVariable Integer id,
                                     Model model,
                                     RedirectAttributes redirectAttributes) {
        Permissions permissions = rolePermissionService.findPermissionById(id);
        List<Permissions> permissionList = rolePermissionService.findPermissionByType(Permissions.MENU_TYPE);

        model.addAttribute("permissionList",permissionList);
        model.addAttribute("permissions",permissions);
        redirectAttributes.addFlashAttribute("message","修改成功");

        return "manager/permission/edit";
    }
}
