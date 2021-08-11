package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

//动态代理
public class TestMybatis {

    @Test
    public void testSelectStudent() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> studentList = dao.selectStudents();

        for(Student stu:studentList){
            System.out.println("查询结果：" + stu);
        }
    }

    @Test
    public void testInsertStudent() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Student stu = new Student();
        stu.setId(1007);
        stu.setName("赵云");
        stu.setEmail("liubei@163.com");
        stu.setAge(22);

        int num = dao.insertStudents(stu);
        sqlSession.commit();

        System.out.println("添加数据数量：" + num);
    }

}
