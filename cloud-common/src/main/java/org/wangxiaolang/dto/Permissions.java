package org.wangxiaolang.dto;

import lombok.Data;

import java.util.Date;

@Data
public class Permissions {

    private Long id;
    private String name;
    private String description;
    private Date createdAt;
}