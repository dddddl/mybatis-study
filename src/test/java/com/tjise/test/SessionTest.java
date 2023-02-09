package com.tjise.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class SessionTest {


    private SqlSession session;

    @Before
    public void init() throws IOException {
        System.out.println("init");

        //通过Resources类加载和读取配置文件
        InputStream is = Resources.getResourceAsStream("mybatis.xml");

        //根据配置文件的信息创建SqlSessionFactory对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        session = sessionFactory.openSession();

    }

    @Test
    public void testSession(){
        System.out.println(session);
        System.out.println(session.getConnection());
    }

    @After
    public void destory() {
        session.close();
    }

}
