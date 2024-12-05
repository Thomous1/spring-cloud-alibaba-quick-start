package org.wangxiaolang.dto;

import lombok.Data;

/**
 * @description:
 * @author: zuoyuwang
 * @create: 2024年12月04日 18:01
 **/
@Data
public class User {
    private Long id;
    private String username;
    private String password;
    public User() {}
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}