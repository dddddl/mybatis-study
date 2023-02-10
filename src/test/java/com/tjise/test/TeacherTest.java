package com.tjise.test;

import com.tjise.entity.Student;
import com.tjise.entity.Teacher;
import com.tjise.mapper.TeacherMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TeacherTest {
    private SqlSession session;
    private TeacherMapper teacherMapper;

    @Before
    public void init() throws IOException {
        System.out.println("init");

        //通过Resources类加载和读取配置文件
        InputStream is = Resources.getResourceAsStream("mybatis.xml");

        //根据配置文件的信息创建SqlSessionFactory对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        session = sessionFactory.openSession();

        teacherMapper = session.getMapper(TeacherMapper.class);

    }

    @Test
    public void testSession() {
        List<Teacher> teacherList = teacherMapper.getTeacher2(2);
        System.out.println(teacherList);
    }

    @After
    public void destory() {
        session.close();
    }
}
