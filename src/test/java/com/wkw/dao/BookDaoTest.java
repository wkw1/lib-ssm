package com.wkw.dao;

import com.wkw.entity.BookEntity;
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
public class BookDaoTest {

    @Resource
    private BookDao bookDao;
    @Test
    public void reduceOne() throws Exception {
        int reduce = bookDao.reduceOne("1000");
        System.out.println("reduce:"+reduce);
    }

    @Test
    public void addOne() throws Exception {
        int add = bookDao.addOne("1000");
        System.out.println("add:"+add);
    }

    @Test
    public void queryByISBN() throws Exception {
        String isbn = "1000";

        BookEntity bookEntity = bookDao.queryByISBN(isbn);
        System.out.println(bookEntity);
    }

    @Test
    public void queryAll() throws Exception {
        List<BookEntity> list = bookDao.queryAll(0,4);
        for(BookEntity bookEntity:list){
            System.out.println(bookEntity);
        }
    }

    @Test
    public void queryByName() throws Exception {
        String name = "开发";
        List<BookEntity> list = bookDao.queryByName(name);
        for(BookEntity bookEntity:list){
            System.out.println(bookEntity);
        }
    }

    @Test
    public void queryByType() throws Exception {
        String type = "计算机";
        List<BookEntity> list = bookDao.queryByType(type);
        for(BookEntity bookEntity:list){
            System.out.println(bookEntity);
        }
    }

    @Test
    public void queryByAuthor() throws Exception {
        String author = "wkw";
        List<BookEntity> list = bookDao.queryByAuthor(author);
        for(BookEntity bookEntity:list){
            System.out.println(bookEntity);
        }

    }


    @Test
    public void queryByPress() throws Exception {
        String press = "hhhh";
        List<BookEntity> list = bookDao.queryByPress(press);
        for(BookEntity bookEntity:list){
            System.out.println(bookEntity);
        }
    }

    @Test
    public void queryByIntroduction() throws Exception {
        String introduction = "假书";
        List<BookEntity> list = bookDao.queryByIntroduction(introduction);
        for(BookEntity bookEntity:list){
            System.out.println(bookEntity);
        }

    }


}