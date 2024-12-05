package org.wangxiaolang.dto;

import lombok.Data;

import java.util.Date;

@Data
public class RolePermissions {
    private Long id;
    private Long roleId;
    private Long permissionId;
    private Date createdAt;
}