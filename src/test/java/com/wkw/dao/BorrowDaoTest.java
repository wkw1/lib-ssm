package com.wkw.dao;

import com.wkw.entity.BorrowBookEntity;
import com.wkw.unit.ReturnTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

/**
 * create by wkw
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class BorrowDaoTest {

    @Resource
    private BorrowDao borrowDao;

    @Test
    public void insertOne() throws Exception {
        String bookISBN = "1111000";
        String stuID ="2015211383";
        int insertResult = borrowDao.insertOne(bookISBN,stuID, ReturnTime.getReturnTime());
        System.out.println("insertResult:" +insertResult);
    }

    @Test
    public void queryByID() throws Exception {
        String stuID = "2015211383";
        List<BorrowBookEntity> list = borrowDao.queryByID(stuID);
        for(BorrowBookEntity entity:list){
            System.out.println(entity);
            System.out.println(entity.getBook());
        }
    }

    @Test
    public void queryBorrowByID() throws Exception {
        int id =1;
        BorrowBookEntity borrowBookEntity =  borrowDao.queryBorrowByID(id);
        System.out.println(borrowBookEntity);
        System.out.println(borrowBookEntity.getBook());
        System.out.println(borrowBookEntity.getStudent());
    }

    @Test
    public void delOne() throws Exception {
        int id=1;
        borrowDao.delOne(id);
    }


    @Test
    public void queryByIDAndISBN() throws Exception {
        String bookISBN = "1111000";
        String stuID ="2015211383";
        System.out.println(borrowDao.queryByIDAndISBN(bookISBN,stuID));
    }
}