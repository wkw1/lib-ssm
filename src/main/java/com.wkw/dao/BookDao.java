package com.wkw.dao;

import com.wkw.entity.BookEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * �û�����dao��ӿ�
 */
public interface BookDao {

    int reduceOne(String bookISBN);

    int addOne(String bookISBN);

    BookEntity queryByISBN(String bookISBN);

    List<BookEntity> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    List<BookEntity> queryByName(String bookName);

    List<BookEntity> queryByType(String bookType);

    List<BookEntity> queryByPress(String bookPress);

    List<BookEntity> queryByIntroduction(String bookIntroduction);

    List<BookEntity> queryByAuthor(String bookAuthor);

}
