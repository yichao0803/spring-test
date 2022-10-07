package com.example.springtest.chain_of_responsibility.middleware;

/**
 * @className: UserExistsMiddleware
 * @description: 检查用户登录信息
 * @author: zhangyichao
 * @date: 2022/10/7
 **/

import com.example.springtest.chain_of_responsibility.server.Server;

/**
 * @author GaoMing
 * @date 2021/7/21 - 21:16
 */
public class UserExistsMiddleware extends Middleware{
    private Server server;

    public UserExistsMiddleware(Server server) {
        this.server = server;
    }

    public boolean check(String email, String password) {
        if (!server.hasEmail(email)) {
            System.out.println("This email is not registered!");
            return false;
        }
        if (!server.isValidPassword(email, password)) {
            System.out.println("Wrong password!");
            return false;
        }
        return checkNext(email, password);
    }
}