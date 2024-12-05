package org.wangxiaolang.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserRoles {
    private Long id;
    private Long userId;
    private Long roleId;
    private Date createdAt;
}