package com.tjise.test;

import com.tjise.entity.Blob;
import com.tjise.entity.Teacher;
import com.tjise.mapper.BlobMapper;
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

public class BlobTest {

    private SqlSession session;
    private BlobMapper blobMapper;

    @Before
    public void init() throws IOException {
        System.out.println("init");

        //通过Resources类加载和读取配置文件
        InputStream is = Resources.getResourceAsStream("mybatis.xml");

        //根据配置文件的信息创建SqlSessionFactory对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        session = sessionFactory.openSession();

        blobMapper = session.getMapper(BlobMapper.class);

    }

    @Test
    public void testSession() {
        Map<String, String> map = new HashMap<>();
        map.put("title", "1");
//        map.put("author", "2");
        map.put("views", "2");
        List<Blob> blobList = blobMapper.queryBlogChoose(map);
        System.out.println(blobList);
    }

    @After
    public void destory() {
        session.close();
    }

}
