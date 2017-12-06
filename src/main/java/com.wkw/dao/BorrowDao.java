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
     * ��������¼
     * @param bookISBN
     * @param stuID
     * @param expectReturnTime Ӧ�黹ʱ��
     * @return
     */
    int insertOne(@Param("bookISBN") String bookISBN,
                  @Param("stuID")String stuID,@Param("expectReturnTime")Date expectReturnTime);

    /**
     *  ����ɾ����¼
     * @param borrowID Ψһ���ı��
     * @return ״̬�Ƿ�ɹ�
     */
    int delOne(int borrowID);

    /**
     * ��ѯһ���˵Ľ����¼
     * @param stuID
     * @return
     */
    List<BorrowBookEntity> queryByID(String stuID);


    /**
     * ����Ψһ��Ų�ѯһ�������¼
     * @param borrowID
     * @return
     */
    BorrowBookEntity queryBorrowByID(int borrowID);


    /**
     * ��ѯһ��ѧ���ض�ISBN�����½����¼
     * @param bookISBN
     * @param stuID
     * @return
     */
    BorrowBookEntity queryByIDAndISBN(@Param("bookISBN") String bookISBN,@Param("stuID") String stuID);

}
