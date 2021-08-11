package com.bjpowernode.dao;

import com.bjpowernode.domain.Student;

import java.util.List;

//接口操作数据表
public interface StudentDao {

    //查询方法
    public List<Student> selectStudents();

    //插入方法
    public int insertStudents(Student student);

}
