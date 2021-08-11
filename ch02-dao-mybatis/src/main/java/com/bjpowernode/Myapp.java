package com.bjpowernode;

import com.bjpowernode.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Myapp {
    public static void main(String[] args) throws IOException {

        String config = "mybatis.xml";
        System.out.println("1");
        InputStream in = Resources.getResourceAsStream(config);
        System.out.println("2");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        System.out.println("3");
        SqlSessionFactory factory = builder.build(in);
        System.out.println("4");
        SqlSession sqlSession = factory.openSession();
        System.out.println("5");
        String sqlId = "com.bjpowernode.dao.StudentDao" + "." + "selectStudents";
        System.out.println("6");
        List<Student> studentList = sqlSession.selectList(sqlId);
        System.out.println("7");

        for(Student stu: studentList){
            System.out.println("查询学生：" + stu);
        }
        System.out.println("8");
        sqlSession.close();

    }
}
