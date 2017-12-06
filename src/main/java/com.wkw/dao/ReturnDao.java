package com.wkw.dao;

import com.wkw.entity.BorrowBookEntity;
import com.wkw.entity.ReturnBookEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * create by wkw
 *
 * 还书表操作接口
 */
public interface ReturnDao {

    /**
     * 插入一条记录
     * @param record
     * @param returnTime
     * @return
     */
    int insertOne(@Param("record") BorrowBookEntity record, @Param("returnTime") Date returnTime);

    /**
     * 查询某个学生的还书记录
     * @param stuID
     * @return
     */
    List<ReturnBookEntity> queryByID(String stuID);

}
