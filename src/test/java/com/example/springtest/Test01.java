package com.example.springtest;

import com.baomidou.mybatisplus.core.toolkit.AES;

/**
 * @className: Test01
 * @description: TODO
 * @author: zhangyichao
 * @date: 2023/2/20
 **/
public class Test01 {
    public static void main(String[] args) {

        // 生成 16 位随机 AES 密钥
        // String randomKey = AES.generateRandomKey();
        String randomKey ="DXswnefztUx7JY3S";
        System.out.println(randomKey);//7a10eda6bd25ae0c// 随机密钥加密
        String url = AES.encrypt("jdbc:p6spy:mysql://domain.kd.db:3306/db_themis?allowMultiQueries=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai&zeroDateTimeBehavior=convertToNull&connectTimeout=6000&socketTimeout=6000",
                randomKey);
        System.out.println("mpw:"+url);
        String username = AES.encrypt("root", randomKey);
        System.out.println("mpw:"+username);
        String pwd = AES.encrypt("MIIBIjAN", randomKey);
        System.out.println("mpw:"+pwd);
    }

}
