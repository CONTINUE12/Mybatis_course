package com.bjpowernode.dao;

import com.bjpowernode.domain.MyStudent;
import com.bjpowernode.domain.Student;
import com.bjpowernode.vo.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    //传递一个参数
    Student selectStudentsById(Integer id);

    //传递多个参数
    List<Student> selectMulyiParam(@Param("myname") String name, @Param("myage") Integer age);

    //使用对象属性传参
    List<Student> selectMultiObject(QueryParam param);

    //返回map类型
    Map<Object,Object> selectMap(Integer id);

    //返回resultMap类型使用
    List<MyStudent>  selectUseResultMap();
    //第二种方法
    List<MyStudent>  selectUseResultType();

    //模糊查询Like方式
    List<Student> selectLikeOne(String anme);
    List<Student> selectLikeTwo(String name);
}
