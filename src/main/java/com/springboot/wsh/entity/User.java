package com.springboot.wsh.entity;

import java.io.Serializable;

/**
 * @Title: User
 * @ProjectName springboot_swagger
 * @Description: 用户实体类
 * @Author WeiShiHuai
 * @Date 2018/9/29 17:58
 */
public class User implements Serializable {

    private Long id;
    private String username;
    private String password;

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
