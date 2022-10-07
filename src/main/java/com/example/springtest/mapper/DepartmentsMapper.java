package com.example.springtest.mapper;

import com.example.springtest.pojo.Departments;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @className: DepartmentsMapper
 * @description: DepartmentsMapper
 * @author: zhangyichao
 * @date: 2022/10/7
 **/
@Mapper
public interface DepartmentsMapper {

    @Select("SELECT dept_no,dept_name from departments")
    List<Departments> findAll();
}
