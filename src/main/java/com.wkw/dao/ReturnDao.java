package com.wkw.dao;

import com.wkw.entity.BorrowBookEntity;
import com.wkw.entity.ReturnBookEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * create by wkw
 *
 * ���������ӿ�
 */
public interface ReturnDao {

    /**
     * ����һ����¼
     * @param record
     * @param returnTime
     * @return
     */
    int insertOne(@Param("record") BorrowBookEntity record, @Param("returnTime") Date returnTime);

    /**
     * ��ѯĳ��ѧ���Ļ����¼
     * @param stuID
     * @return
     */
    List<ReturnBookEntity> queryByID(String stuID);

}
