package com.example.springtest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springtest.pojo.Departments;
import org.apache.ibatis.annotations.Mapper;

/**
 * @className: DepartmentsMapper
 * @description: DepartmentsMapper
 * @author: zhangyichao
 * @date: 2022/10/7
 **/
@Mapper
public interface DepartmentsMapper extends BaseMapper<Departments> {

}
