package com.wkw.dao;

import com.wkw.entity.OrderBookEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * create by wkw
 */
public interface OrderDao {

    /**
     * ����һ��ԤԼ��¼
     * stuId ��ISBN��ͻʱ����ʧ��
     * @param stuID
     * @param bookISBN
     * @return ���� 0 ����ɹ�Ϊ 1
     */
    int insertOne(@Param("stuID") String stuID, @Param("bookISBN") String bookISBN);


    /**
     * ɾ��һ����һ�����ԤԼ��¼
     * @param stuID
     * @param bookISBN
     * @return ����1 �ɹ�ɾ����0ɾ��ʧ�ܣ��������ݿ��޶���
     */
    int delOne(@Param("stuID") String stuID, @Param("bookISBN") String bookISBN);

    /**
     * ɾ��limitԤԼ����ļ�¼
     * @param bookISBN
     * @param limit
     * @return
     */
    int delOneByISBN(@Param("bookISBN") String bookISBN,@Param("limit") int limit);

    /**
     * ��ѯ 1 ����¼
     * @param bookISBN
     * @return
     */
    OrderBookEntity queryOneByISBN(String bookISBN);
    /**
     * ��ѯĳ�˵�ԤԼ��¼
     * @param stuID
     * @return
     */
    List<OrderBookEntity> queryByID(String stuID);

    /**
     * ��ѯĳ�����ԤԼ��¼
     * @param bookISBN
     * @return
     */
    List<OrderBookEntity> queryByISBN(String bookISBN);

    /**
     * ����һ��ISBN��stuID��ѯһ����¼
     * @param bookISBN
     * @param stuID
     * @return
     */
    OrderBookEntity queryByIDAndISBN (@Param("bookISBN") String bookISBN,@Param("stuID") String stuID);

}
