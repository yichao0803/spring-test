package com.example.springtest;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @className: SprinTest
 * @description: SprinTest
 * @author: zhangyichao
 * @date: 2022/7/11
 **/
public class SprinTest {
    public static void main(String[] args) {
//        extracted1();
//        extracted2();
//
//        int a = Integer.getInteger("jute.maxbuffer",
//                4096 * 1024);
//
//        System.out.println("a:" + a);

        TestEnum object1= TestEnum.AUTUMN;
        System.out.println(object1.hashCode());

        Object object2=TestEnum.SPRING;
        System.out.println(object2.hashCode());


        Map<String,Object> maps=new HashMap<>();
        maps.put("realSyncDb",object1);
        maps.put("realSyncSourceDbs",object2);

        String jsonObject = JSONUtil.toJsonPrettyStr(maps);
        System.out.println(jsonObject);

        JSON json= JSONUtil.parse(jsonObject);
        json.getByPath("realSyncDb");

        json.getByPath("realSyncSourceDbs");



    }

    private static void extracted1() {
        long a = 1L;
        long b = 2L;
        long c = 1L;
        System.out.println("a==b:" + (a == b));
        System.out.println("a==c:" + (a == c));
    }

    private static void extracted2() {
        Long a = 1L;
        Long b = 2L;
        Integer c = 1;
        System.out.println("a==b:" + (a == b));
        System.out.println("a==c:" + (a.intValue() == c));
    }



}
