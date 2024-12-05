package org.wangxiaolang.cloudgateway.config.auth;

import cn.dev33.satoken.stp.StpInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.wangxiaolang.cloudgateway.client.ServiceProviderClient;
import org.wangxiaolang.dto.Permissions;
import org.wangxiaolang.dto.RolePermissions;
import org.wangxiaolang.dto.Roles;
import org.wangxiaolang.dto.UserRoles;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 自定义权限实现
 * @author: zuoyuwang
 * @create: 2024年12月05日 14:20
 **/

@Component
public class StpInterfaceImpl implements StpInterface {

    @Autowired
    private ServiceProviderClient serviceProviderClient;

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {

        // 根据用户id从用户角色表中获取角色id
        List<UserRoles> roleIds = serviceProviderClient.getUserRoles(Long.valueOf((String) loginId));
        List<Long> rolesList = roleIds.stream().map(UserRoles::getRoleId).collect(Collectors.toList());
        if (!(rolesList.size() >0)){
            //没有任何权限
            return null;
        }
        List<String> list = new ArrayList<>();
        rolesList.forEach(roleId ->{
            // 根据角色id从角色权限表中获取权限id
            List<RolePermissions> rolePermissions = serviceProviderClient.getRolePermissions(roleId);
            // 根据权限id从权限表中获取权限名称
            rolePermissions.forEach(permissionsId->{
                Permissions permissions = serviceProviderClient.getPermissionById(permissionsId.getPermissionId());
                list.add(permissions.getName());
            });
        });
        // 返回用户所有权限，
        return list;
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        //根据用户id从用户角色表中获取角色id
        List<UserRoles> roleIds = serviceProviderClient.getUserRoles((long)loginId);
        List<String> list = new ArrayList<>();

        if (!(roleIds.size() >0)){
        // 用户没有分配角色
            return null;
        }
        roleIds.forEach(roleId ->{
            Roles byId = serviceProviderClient.getRoleById(roleId.getRoleId());
            list.add(byId.getName());
        });
        // 返回用户所有角色标识集合
        return list;
    }
}