package com.example.springtest;

/**
 * @className: TestEnum
 * @description: TestEnum
 * @author: zhangyichao
 * @date: 2022/9/3
 **/
public enum TestEnum {
    SPRING("SPRING","春天"),
    SUMMER("SUMMER","夏天"),
    AUTUMN("AUTUMN","秋天"),
    WINTER("WINTER","冬天");

    private final String name;
    private final Object defaultValue;

    TestEnum(String name,Object defaultValue) {
        this.name = name;
        this.defaultValue = defaultValue;
    }
}
