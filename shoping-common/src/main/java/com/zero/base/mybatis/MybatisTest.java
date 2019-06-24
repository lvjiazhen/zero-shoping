package com.zero.base.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisTest {
	public static void main(String[] args) throws InterruptedException {
		String resource = "mybatis-config.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlMapper = new  SqlSessionFactoryBuilder().build(reader);

            SqlSession session = sqlMapper.openSession();
            SqlSession session1= sqlMapper.openSession();
            session.selectOne("SELECT * FROM sys_users");
            System.out.println(session);
            System.out.println(session1);
            System.out.println(session.getConfiguration().getDefaultExecutorType());
            Environment environment = session.getConfiguration().getEnvironment();
            System.out.println(session.getConfiguration().getEnvironment());
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
    }
	}


