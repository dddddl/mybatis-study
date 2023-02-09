package com.tjise.test;

import com.tjise.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CRUDTest {

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
    public void findUserListTest() {
        List<User> userList = session.selectList("usermp.findUserList");
        System.out.println(userList);
    }

    @Test
    public void findUserByNameTest() {
        List<User> userList = session.selectList("usermp.findUserByName", "小");
        System.out.println(userList);
    }

    @Test
    public void findUserByScoreTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("minScore", 60);
        map.put("maxScore", 100);

        List<User> userList = session.selectList("usermp.findUserByScore", map);
        System.out.println(userList);
    }

    //实现分页效果
    @Test
    public void findUserByPage() {
        int pageSize = 2;
        int currentPage = 2;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageSize", pageSize);
        map.put("currentPage", (currentPage - 1) * pageSize);
        List<User> userList = session.selectList("usermp.findUserByPage", map);
        System.out.println(userList);
    }

    //插入数据
    @Test
    public void testInsertUser() {
        try {
            User user = new User(6,"user7", "123456", 10);
            int rows = session.insert("usermp.insertUser", user);
            System.out.println(rows);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }

    }

    //修改数据
    @Test
    public void testUpdateUser(){
        try {
            User user = session.selectOne("usermp.findUserById", 1);
            System.out.println(user);
            user.setPwd("789");
            int rows = session.update("usermp.updateUser", user);
            System.out.println(rows);

            session.commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }

    //修改数据
    @Test
    public void testDeleteUser(){
        try {
            int rows = session.delete("usermp.deleteUser", 8);
            System.out.println(rows);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        }
    }



    @After
    public void destory() {
        session.close();
    }
}
