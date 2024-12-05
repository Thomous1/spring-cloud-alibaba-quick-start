package org.wangxiaolang.serviceprovider.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.wangxiaolang.dto.Permissions;
import org.wangxiaolang.dto.RolePermissions;
import org.wangxiaolang.dto.Roles;
import org.wangxiaolang.dto.UserRoles;
import org.wangxiaolang.serviceprovider.entity.PermissionsDO;
import org.wangxiaolang.serviceprovider.entity.RolePermissionsDO;
import org.wangxiaolang.serviceprovider.entity.RolesDO;
import org.wangxiaolang.serviceprovider.entity.UserRolesDO;
import org.wangxiaolang.serviceprovider.service.PermissionsService;
import org.wangxiaolang.serviceprovider.service.RolePermissionsService;
import org.wangxiaolang.serviceprovider.service.RolesService;
import org.wangxiaolang.serviceprovider.service.UserRolesService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: zuoyuwang
 * @create: 2024年12月05日 15:20
 **/
@RestController
public class UserRolesController {

    @Autowired
    private PermissionsService permissionsService;
    @Autowired
    private UserRolesService userRolesService;
    @Autowired
    private RolesService rolesService;
    @Autowired
    private RolePermissionsService rolePermissionsService;

    @GetMapping("/roles/getUserRoles")
    List<UserRoles> getUserRoles(@RequestParam(name = "loginId") long loginId){
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("user_id",loginId);
        List<UserRolesDO> list = userRolesService.list(queryWrapper);
        return list.stream().map(userRolesDO -> {
            UserRoles userRoles = new UserRoles();
            BeanUtil.copyProperties(userRolesDO, userRoles);
            return userRoles;
        }).collect(Collectors.toList());
    }

    @GetMapping("/roles/getRolePermissions")
    List<RolePermissions> getRolePermissions(@RequestParam(name = "roleId") Long roleId){
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("role_id",roleId);
        List<RolePermissionsDO> list = rolePermissionsService.list(queryWrapper);
        return list.stream().map(rolePermissionsDO -> {
            RolePermissions rolePermissions = new RolePermissions();
            BeanUtil.copyProperties(rolePermissionsDO, rolePermissions);
            return rolePermissions;
        }).collect(Collectors.toList());
    }

    @GetMapping("/roles/getPermissionId")
    Permissions getPermissionById(@RequestParam(name = "permissionId") Long permissionId){
        PermissionsDO permissionsDO = permissionsService.getById(permissionId);
        Permissions permissions = new Permissions();
        BeanUtil.copyProperties(permissionsDO, permissions);
        return permissions;
    }

    @GetMapping("/roles/getRoleById")
    Roles getRoleById(@RequestParam(name = "roleId")Long roleId){
        RolesDO rolesDO = rolesService.getById(roleId);
        Roles roles = new Roles();
        BeanUtil.copyProperties(rolesDO, roles);
        return roles;
    }
}