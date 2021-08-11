package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.MyStudent;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MybatisUtils;
import com.bjpowernode.vo.QueryParam;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

//动态代理
public class TestMybatis {

    @Test
    public void testSelectStudent() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Student student = dao.selectStudentsById(1002);
        System.out.println("student" + student);
        sqlSession.close();
    }

    @Test
    public void testSelectMultiParam() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> studentList = dao.selectMulyiParam("李四",22);
        for(Student stu:studentList){
            System.out.println("查询结果：" + stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectMultiObject() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        QueryParam queryParam = new QueryParam();
        queryParam.setParamname("李四");
        queryParam.setParamage(22);
        List<Student> studentList = dao.selectMultiObject(queryParam);
        for(Student stu:studentList){
            System.out.println("查询结果：" + stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectMap() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Map<Object,Object> objectMap = dao.selectMap(1001);
        System.out.println("Map:" + objectMap);
        sqlSession.close();
    }

    @Test
    public void testSelectUseResultMap() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<MyStudent> studentList = dao.selectUseResultMap();
        for(MyStudent stu:studentList){
            System.out.println("查询结果：" + stu);
        }

        sqlSession.close();
    }

    @Test
    public void testSelectUseResultType() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<MyStudent> studentList = dao.selectUseResultType();
        for(MyStudent stu:studentList){
            System.out.println("查询结果：" + stu);
        }

        sqlSession.close();
    }

    @Test
    public void testSelectLikeOne() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        String name = "%张%";
        List<Student> student = dao.selectLikeOne(name);
        for(Student stu:student){
            System.out.println("查询结果：" + stu);
        }

        sqlSession.close();
    }

    @Test
    public void testSelectLikeTwo() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        String name = "李";
        List<Student> student = dao.selectLikeTwo(name);
        for(Student stu:student){
            System.out.println("查询结果：" + stu);
        }

        sqlSession.close();
    }

}
