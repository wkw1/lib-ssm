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
 * �û���Ϊ������
 * 1 ����
 */
public interface StuActService {

    /**
     * ����
     * @param stuID
     * @param bookISBN
     * @return
     */
    StuActExecution borrowBook(String stuID, String bookISBN);

    /**
     * ����
     * @param borrowID ����ID
     * @return
     */
    StuActExecution returnBook(int borrowID);

    /**
     * ԤԼ
     * @param stuID
     * @param bookISBN
     * @return
     */
    StuActExecution orderBook(String stuID, String bookISBN);

    /**
     * ȡ��ԤԼ����
     * @param stuID
     * @param bookISBN
     * @return
     */
    StuActExecution cancelOrder(String stuID,String bookISBN);

    /**
     * ����ͼ���
     * @param type ��ѯ����  ���� ����  ������ȵ�
     * @param key
     * @return
     */
    List<BookEntity> queryBook(SearchBookType type , String key);

    /**
     * ��ѯ�����
     * @param stuID
     * @return
     */
    List<BorrowBookEntity> queryBorrowBook(String stuID);

    /**
     * ��ѯԤԼ��
     * @param stuID
     * @return
     */
    List<OrderBookEntity> queryOrderBook(String stuID);


    /**
     * ��ѯ�Լ��Ļ�����Ϣ,Ҳ����������¼
     * @param stuID
     * @return
     */
    StudentEntity queryMyInfo(String stuID);

    /**
     * �õ�һ�������ϸ��Ϣ
     * @param bookISBN
     * @return
     */
    BookEntity queryByISBN(String bookISBN);

    /**
     * ע�ắ��
     * @param stuID
     * @param password
     */
    void register(String stuID,String password);

}
