package com.bjpowernode;

import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Myapp1 {

    public static void main(String[] args) {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        String sqlId = "com.bjpowernode.dao.StudentDao" + "." + "selectStudents";
        List<Student> studentList = sqlSession.selectList(sqlId);
        for(Student stu: studentList){
            System.out.println("查询学生：" + stu);
        }
        sqlSession.close();

    }
}
