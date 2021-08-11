package com.bjpowernode.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {

    private static SqlSessionFactory factory = null;
    static {
        try {
            //1.定义mybatis主配置文件的名称，从类路径的根开始（target/classes）
            String config = "mybatis.xml";
            //2.读取该config文件
            InputStream in = Resources.getResourceAsStream(config);
            //3.创建sqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //4.创建SqlSessionFactory对象
            factory = builder.build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession() {
        SqlSession sqlSession = null;
        if(factory != null){
            sqlSession = factory.openSession();
        }
        return sqlSession;
    }

}
