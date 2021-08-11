package com.bjpowernode.dao.impl;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> selectStudents() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        String sqlId = "com.bjpowernode.dao.StudentDao.selectStudents";
        List<Student> studentList = sqlSession.selectList(sqlId);
        sqlSession.close();
        return studentList;
    }

    @Override
    public int insertStudents(Student student) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        String sqlId = "com.bjpowernode.dao.StudentDao.insertStudents";
        int num = sqlSession.insert(sqlId,student);
        sqlSession.commit();
        sqlSession.close();
        return num;
    }
}
