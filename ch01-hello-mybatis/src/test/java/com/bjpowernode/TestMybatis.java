package com.bjpowernode;

import com.bjpowernode.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestMybatis {

    @Test
    public void testInsert() throws IOException {

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
        String sqlId = "com.bjpowernode.dao.StudentDao" + "." + "insertStudents";
        System.out.println("6");

        Student stu = new Student();
        stu.setId(1006);
        stu.setName("刘备");
        stu.setEmail("liubei@163.com");
        stu.setAge(22);

        int num = sqlSession.insert(sqlId,stu);
        sqlSession.commit();
        System.out.println("7");
        System.out.println("执行的结果：" + num);
        System.out.println("8");
        sqlSession.close();
    }

}
