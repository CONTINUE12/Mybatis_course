package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MybatisUtils;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//动态代理
public class TestMybatis {

    @Test
    public void testSelectStudentIf() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Student student = new Student();
        student.setName("李四");
        student.setAge(20);
        List<Student> students = dao.selectStudentIf(student);
        for(Student stu:students){
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectStudentWhere() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Student student = new Student();
//        student.setName("李四");
        student.setAge(20);
        List<Student> students = dao.selectStudentWhere(student);
        for(Student stu:students){
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectStudentForEachOne() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> studentList = new ArrayList<>();
        Student s1 = new Student();
        s1.setId(1001);
        studentList.add(s1);
        Student s2 = new Student();
        s2.setId(1005);
        studentList.add(s2);

        List<Student> students = dao.selectStudentForEachTwo(studentList);
        for(Student stu:students){
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectAll() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        PageHelper.startPage(1,3);
        List<Student> students = dao.selectAll();
        for(Student stu:students){
            System.out.println(stu);
        }
        sqlSession.close();
    }


}
