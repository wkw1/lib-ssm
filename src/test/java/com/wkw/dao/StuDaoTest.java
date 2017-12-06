package com.wkw.dao;

import com.wkw.entity.StudentEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * create by wkw
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class StuDaoTest {
    @Autowired
    private StuDao stuDao;
    @Test
    public void queryByID() throws Exception {
        String id =  "2015211303";
        StudentEntity studentEntity = stuDao.queryByID(id);
        System.out.println("ID:"+studentEntity);
    }

    @Test
    public void queryByName() throws Exception {
        String name ="wkw";
        List<StudentEntity> list = stuDao.queryByName(name);
        for(StudentEntity studentEntity:list){
            System.out.println(studentEntity);
        }
    }

    @Test
    public void queryBySchool() throws Exception {
        String school ="计算机学院";
        List<StudentEntity> list = stuDao.queryBySchool(school);
        for(StudentEntity studentEntity:list){
            System.out.println(studentEntity);
        }
    }

    @Test
    public void addBorrowNum() throws Exception {
        String id="2015211383";
        int result =  stuDao.addBorrowNum(id);
        System.out.println("result:" +result);
    }

    @Test
    public void reduceBorrowNum() throws Exception {
        String id="2015211383";
        int result =  stuDao.reduceBorrowNum(id);
        System.out.println("result:" +result);
    }

    @Test
    public void setPassword(){
        String id="2015211353";
        String password="2015211353";
        int result =  stuDao.setPassword(id,password);
        System.out.println("result:" +result);
    }

    @Test
    public void insertOne(){
        StudentEntity studentEntity=new StudentEntity();
        studentEntity.setStuID("2015211313");
        studentEntity.setStuName("xiaoming");
        studentEntity.setPhone("110");
        studentEntity.setSchool("电子院");
        studentEntity.setEmail("wkw@bupt.edu.cn");

        int result=stuDao.insertOne(studentEntity);
        System.out.println("result:"+result);
    }
}