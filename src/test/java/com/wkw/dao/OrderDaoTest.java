package com.wkw.dao;

import com.wkw.entity.OrderBookEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * create by wkw
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class OrderDaoTest {

    @Autowired
    private OrderDao orderDao;
    @Test
    public void insertOne() throws Exception {
        String id="2015211383";
        String ISBN ="110000";
        int insertResult = orderDao.insertOne(id,ISBN);
        System.out.println("insertResult:" + insertResult);
    }

    @Test
    public void delOne() throws Exception {
        String id="2015211383";
        String ISBN ="110000";
        int insertResult = orderDao.delOne(id,ISBN);
        System.out.println("insertResult:" + insertResult);
    }

    @Test
    public void delOneByISBN() throws Exception {
        String ISBN = "111000";
        orderDao.delOneByISBN(ISBN,1);
    }

    @Test
    public void queryByID() throws Exception {
        String id="2015211383";
        List<OrderBookEntity> list = orderDao.queryByID(id);
        for(OrderBookEntity entity:list){
            System.out.println(entity);
            System.out.println(entity.getBook());
        }
    }

    @Test
    public void queryByISBN() throws Exception {
        String ISBN ="10000";
        List<OrderBookEntity> list = orderDao.queryByISBN(ISBN);
        for(OrderBookEntity entity:list){
            System.out.println(entity);
            System.out.println(entity.getStudent());
        }
    }

    @Test
    public void queryByIDAndISBN() throws Exception{
        String id="2015211383";
        String ISBN ="110000";
        OrderBookEntity orderBookEntity=orderDao.queryByIDAndISBN(ISBN,id);
        System.out.println(orderBookEntity);
        System.out.println(orderBookEntity.getBook());
    }


}