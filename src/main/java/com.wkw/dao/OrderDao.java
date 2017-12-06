package com.wkw.dao;

import com.wkw.entity.OrderBookEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * create by wkw
 */
public interface OrderDao {

    /**
     * 插入一条预约记录
     * stuId 和ISBN冲突时插入失败
     * @param stuID
     * @param bookISBN
     * @return 返回 0 插入成功为 1
     */
    int insertOne(@Param("stuID") String stuID, @Param("bookISBN") String bookISBN);


    /**
     * 删除一个人一本书的预约记录
     * @param stuID
     * @param bookISBN
     * @return 返回1 成功删除，0删除失败（或者数据可无对象）
     */
    int delOne(@Param("stuID") String stuID, @Param("bookISBN") String bookISBN);

    /**
     * 删除limit预约此书的记录
     * @param bookISBN
     * @param limit
     * @return
     */
    int delOneByISBN(@Param("bookISBN") String bookISBN,@Param("limit") int limit);

    /**
     * 查询 1 条记录
     * @param bookISBN
     * @return
     */
    OrderBookEntity queryOneByISBN(String bookISBN);
    /**
     * 查询某人的预约记录
     * @param stuID
     * @return
     */
    List<OrderBookEntity> queryByID(String stuID);

    /**
     * 查询某本书的预约记录
     * @param bookISBN
     * @return
     */
    List<OrderBookEntity> queryByISBN(String bookISBN);

    /**
     * 根据一个ISBN和stuID查询一条记录
     * @param bookISBN
     * @param stuID
     * @return
     */
    OrderBookEntity queryByIDAndISBN (@Param("bookISBN") String bookISBN,@Param("stuID") String stuID);

}
