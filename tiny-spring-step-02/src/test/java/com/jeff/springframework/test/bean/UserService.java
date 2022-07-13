package com.jeff.springframework.test.bean;

/**
 * @program: tiny-spring
 * @author: Jeff Hu 2022/06/21 15:59
 */
public class UserService {

    private String name;

    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo(){
        System.out.println("查询用户信息");
    }

}
