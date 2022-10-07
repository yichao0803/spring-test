package com.example.springtest.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springtest.mapper.DepartmentsMapper;
import com.example.springtest.pojo.Departments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @className: IndexController
 * @description: IndexController
 * @author: zhangyichao
 * @date: 2021/11/22
 **/
@RestController
@RequestMapping("{api.prefix}")
public class IndexController  {

    @Resource
    DepartmentsMapper departMentsMapper;

    // http://localhost:8080/spring-test/index
    @RequestMapping("/index")
    public String index(){

        String result="hello world";
        return result;
    }
    @RequestMapping("/dept-ments")
    public List<Departments> departMentsList(){
        QueryWrapper<Departments> queryWrapper=new QueryWrapper<>();

        return departMentsMapper.selectList(queryWrapper);
    }
}
