package com.example.springtest.controller;

import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: IndexController
 * @description: IndexController
 * @author: zhangyichao
 * @date: 2021/11/22
 **/
@RestController
@RequestMapping("{api.prefix}")
public class IndexController  {

    // http://localhost:8080/spring-test/index
    @RequestMapping("/index")
    public String index(){

        String result="hello world";
        return result;
    }
}
