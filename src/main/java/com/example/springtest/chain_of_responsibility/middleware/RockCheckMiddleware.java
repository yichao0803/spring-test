package com.example.springtest.chain_of_responsibility.middleware;

/**
 * @className: RockCheckMiddleware
 * @description: 检查用户角色
 * @author: zhangyichao
 * @date: 2022/10/7
 **/
public class RockCheckMiddleware extends Middleware{
    public boolean check(String email, String password) {
        if (email.equals("admin@example.com")) {
            System.out.println("Hello, admin!");
            return true;
        }
        System.out.println("Hello, user!");
        return checkNext(email, password);
    }
}
