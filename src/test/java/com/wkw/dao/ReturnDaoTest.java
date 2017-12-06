package com.wkw.dao;

import com.wkw.entity.BorrowBookEntity;
import com.wkw.entity.ReturnBookEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * create by wkw
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class ReturnDaoTest {

    @Autowired
    ReturnDao returnDao ;

    @Autowired
    BorrowDao borrowDao;

    @Test
    public void insertOne() throws Exception {

        BorrowBookEntity borrowBookEntity=borrowDao.queryBorrowByID(2);
        Date date = new Date();

        returnDao.insertOne(borrowBookEntity,date);
    }

    @Test
    public void queryByID() throws Exception {
        String stuID="2015211383";
        List<ReturnBookEntity> list= returnDao.queryByID(stuID);
        for(ReturnBookEntity entity :list){
            System.out.println(entity);
            System.out.println(entity.getStudent());
            System.out.println(entity.getBook());
        }

    }

}