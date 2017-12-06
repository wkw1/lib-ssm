package com.wkw.service;

import com.wkw.dto.StuActExecution;
import com.wkw.entity.BookEntity;
import com.wkw.entity.BorrowBookEntity;
import com.wkw.entity.OrderBookEntity;
import com.wkw.entity.StudentEntity;
import com.wkw.enums.SearchBookType;
import com.wkw.exception.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


/**
 * create by wkw
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class StuActServiceImplTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StuActService stuActService;

    @Test
    public void borrowBook() throws Exception {
        String bookISBN = "10000";
        String stuID ="2015211353";
        try{
            StuActExecution stuActExecution = stuActService.borrowBook(stuID,bookISBN);
            System.out.println(stuActExecution);
        }catch(StuActEp ep){
            logger.error(ep.getState().getStatInfo());
        }catch(SystemEp ep){
            logger.error(ep.getMessage());
        }
    }

    @Test
    public void returnBook() throws Exception {
        int id=32;
        try{
            StuActExecution returnExecution = stuActService.returnBook(id);
            System.out.println(returnExecution);
            System.out.println(returnExecution.getData());
        }catch (ReturnBookEp ep){
            logger.error(ep.getMessage());
        }catch (SystemEp ep){
            logger.error(ep.getMessage());
        }
    }

    @Test
    public void orderBook() throws Exception {
        String bookISBN = "1111000";
        String stuID ="2015211383";
        try{
            StuActExecution execution=stuActService.orderBook(stuID,bookISBN);
            System.out.println(execution);
        }catch (StuActEp ep){
            logger.error(ep.getMessage());
        }catch (SystemEp ep){
            System.out.println(ep.getMessage());
        }

    }

    @Test
    public void queryBook() throws Exception {
        String type="ºÚΩÈ";
        String key="’Ê È";
        SearchBookType searchBookType = SearchBookType.stateof(type);
        List<BookEntity> lists = stuActService.queryBook(searchBookType,key);
        for(BookEntity bookEntity:lists){
            System.out.println(bookEntity);
        }
    }

    @Test
    public void queryBorrowBook() throws Exception {
        String stuID="2015211383";
        List<BorrowBookEntity> lists = stuActService.queryBorrowBook(stuID);
        for(BorrowBookEntity entity:lists){
            System.out.println(entity);
        }
    }

    @Test
    public void queryOrderBook() throws Exception {
        String stuID="2015211383";
        List<OrderBookEntity> lists = stuActService.queryOrderBook(stuID);
        for(OrderBookEntity entity:lists){
            System.out.println(entity);
        }
    }

    @Test
    public void queryMyInfo() throws Exception {
        String stuID="2015211383";
        StudentEntity studentEntity = stuActService.queryMyInfo(stuID);
        System.out.println(studentEntity);
    }

    @Test
    public void queryByISBN() throws Exception {
        String bookISBN="1111000";
        BookEntity bookEntity = stuActService.queryByISBN(bookISBN);
        System.out.println(bookEntity);
    }

}