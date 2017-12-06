package com.wkw.dao;

import com.wkw.entity.BorrowBookEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * create by wkw
 */
public interface BorrowDao {

    /**
     * 借书插入记录
     * @param bookISBN
     * @param stuID
     * @param expectReturnTime 应归还时间
     * @return
     */
    int insertOne(@Param("bookISBN") String bookISBN,
                  @Param("stuID")String stuID,@Param("expectReturnTime")Date expectReturnTime);

    /**
     *  还书删除记录
     * @param borrowID 唯一借阅编号
     * @return 状态是否成功
     */
    int delOne(int borrowID);

    /**
     * 查询一个人的借书记录
     * @param stuID
     * @return
     */
    List<BorrowBookEntity> queryByID(String stuID);


    /**
     * 根据唯一编号查询一个借书记录
     * @param borrowID
     * @return
     */
    BorrowBookEntity queryBorrowByID(int borrowID);


    /**
     * 查询一个学生特定ISBN的最新借书记录
     * @param bookISBN
     * @param stuID
     * @return
     */
    BorrowBookEntity queryByIDAndISBN(@Param("bookISBN") String bookISBN,@Param("stuID") String stuID);

}
