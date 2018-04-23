package com.haoyukeji.tms.controller;

import com.google.common.collect.Maps;
import com.haoyukeji.tms.controller.exception.NotFoundException;
import com.haoyukeji.tms.entity.Permissions;
import com.haoyukeji.tms.entity.Role;
import com.haoyukeji.tms.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/manager/role")
public class RoleController {

    @Autowired
    private RolePermissionService rolePermissionService;

    @GetMapping
    public String home(Model model) {
        List<Role> roles = rolePermissionService.findAllRoleWithPermission();

        model.addAttribute("roleList",roles);
        return "manager/role/home";
    }

    @GetMapping("/new")
    public String newRole(Model model) {
        List<Permissions> permissionsList = rolePermissionService.findAllPermission();
        model.addAttribute("permissionList",permissionsList);
        return "manager/role/new";
    }

    /**
     * 新增角色
     * @param role
     * @param permissionId
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/new")
    public String newRole(Role role, Integer[] permissionId, RedirectAttributes redirectAttributes) {
        rolePermissionService.saveRole(role,permissionId);
        redirectAttributes.addFlashAttribute("message","新增角色成功");
        return "redirect:/manager/role";
    }

    /**
     * 修改角色
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/{id:\\d+}/edit")
    public String updateRole(@PathVariable Integer id, Model model) {
        //查询角色以及所拥有的权限
        Role role = rolePermissionService.findRolesWithPermissionById(id);
        //判断角色受否为空
        if (role == null) {
            throw new NotFoundException();
        }
        //查询所有的权限列表
        List<Permissions> permissionsList = rolePermissionService.findAllPermission();

        Map<Permissions,Boolean> map  = checkPermissionsList(role.getPermissionList(),permissionsList);

        model.addAttribute("role",role);
        model.addAttribute("permissionsMap",map);

        return "manager/role/edit";
    }


    /**
     * 修改角色
     * @param role
     * @param permissionId
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/{id:\\d+}/edit")
    public String updateRole(Role role,
                             Integer[] permissionId,
                             RedirectAttributes redirectAttributes) {

        rolePermissionService.updateRole(role,permissionId);

        redirectAttributes.addFlashAttribute("message","角色修改成功");
        return "redirect:/manager/role";
    }

    /**
     * 判断是否选择复选框
     * @param rolePermissionList 角色表里的权限集合
     * @param permissionsList   权限的集合
     * @return  有顺序的map集合，已选择返回true
     */
    private Map<Permissions, Boolean> checkPermissionsList(List<Permissions> rolePermissionList, List<Permissions> permissionsList) {
        Map<Permissions,Boolean> resultMap = Maps.newLinkedHashMap();

        //利用双重循环来判断是否选择复选框
        for (Permissions permissions : permissionsList) {
            boolean flag = false;
            for (Permissions rolePermissions : rolePermissionList) {
                if (permissions.getId().equals(rolePermissions.getId())) {
                    flag = true;
                    break;
                }
            }
            resultMap.put(permissions,flag);
        }

        return resultMap;
    }
}
