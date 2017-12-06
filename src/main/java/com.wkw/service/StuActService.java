package com.wkw.service;

import com.wkw.dto.OrderExecution;
import com.wkw.dto.ReturnExecution;
import com.wkw.dto.StuActExecution;
import com.wkw.entity.BookEntity;
import com.wkw.entity.BorrowBookEntity;
import com.wkw.entity.OrderBookEntity;
import com.wkw.entity.StudentEntity;
import com.wkw.enums.SearchBookType;

import java.util.List;

/**
 * created by wkw
 * 用户行为测试类
 * 1 借书
 */
public interface StuActService {

    /**
     * 借书
     * @param stuID
     * @param bookISBN
     * @return
     */
    StuActExecution borrowBook(String stuID, String bookISBN);

    /**
     * 还书
     * @param borrowID 借书ID
     * @return
     */
    StuActExecution returnBook(int borrowID);

    /**
     * 预约
     * @param stuID
     * @param bookISBN
     * @return
     */
    StuActExecution orderBook(String stuID, String bookISBN);

    /**
     * 取消预约操作
     * @param stuID
     * @param bookISBN
     * @return
     */
    StuActExecution cancelOrder(String stuID,String bookISBN);

    /**
     * 搜索图书表
     * @param type 查询类型  书名 作者  出版社等等
     * @param key
     * @return
     */
    List<BookEntity> queryBook(SearchBookType type , String key);

    /**
     * 查询借书表
     * @param stuID
     * @return
     */
    List<BorrowBookEntity> queryBorrowBook(String stuID);

    /**
     * 查询预约表
     * @param stuID
     * @return
     */
    List<OrderBookEntity> queryOrderBook(String stuID);


    /**
     * 查询自己的基本信息,也可以用来登录
     * @param stuID
     * @return
     */
    StudentEntity queryMyInfo(String stuID);

    /**
     * 得到一本书的详细信息
     * @param bookISBN
     * @return
     */
    BookEntity queryByISBN(String bookISBN);

    /**
     * 注册函数
     * @param stuID
     * @param password
     */
    void register(String stuID,String password);

}
