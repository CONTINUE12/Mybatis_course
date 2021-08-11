package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.dao.impl.StudentDaoImpl;
import com.bjpowernode.domain.Student;
import org.junit.Test;

import java.util.List;

public class TestMybatis {

    @Test
    public void testSelectStudent() {
        StudentDao dao = new StudentDaoImpl();
        List<Student> studentList = dao.selectStudents();
        for(Student stu: studentList){
            System.out.println("查询结果：" + stu);
        }
    }

    @Test
    public void testInsertStudent() {
        StudentDao dao = new StudentDaoImpl();
        Student stu = new Student();
        stu.setId(1007);
        stu.setName("赵云");
        stu.setEmail("liubei@163.com");
        stu.setAge(22);
        int num = dao.insertStudents(stu);
        System.out.println("添加对象的数量：" + num);
    }
}
