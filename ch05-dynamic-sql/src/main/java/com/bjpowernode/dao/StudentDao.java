package com.bjpowernode.dao;


import com.bjpowernode.domain.Student;

import java.util.List;

public interface StudentDao {

    //条件语句IF
    List<Student> selectStudentIf(Student student);

    //条件语句where
    List<Student> selectStudentWhere(Student student);

    //循环语句foreach
    List<Student> selectStudentForEachOne(List<Integer> idList);
    List<Student> selectStudentForEachTwo(List<Student> studentList);

    //使用pagehelper分页查看数据
    List<Student> selectAll();

}
