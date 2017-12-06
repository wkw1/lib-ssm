package com.wkw.service.impl;

import com.wkw.dao.*;
import com.wkw.dto.OrderExecution;
import com.wkw.dto.StuActExecution;
import com.wkw.entity.*;
import com.wkw.enums.SearchBookType;
import com.wkw.enums.StuActStatEnum;
import com.wkw.exception.*;
import com.wkw.service.StuActService;
import com.wkw.unit.ReturnTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * created by wkw
 */
@Service
public class StuActServiceImpl implements StuActService {

    @Autowired
    private BookDao bookDao;
    @Autowired
    private BorrowDao borrowDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ReturnDao returnDao;
    @Autowired
    private StuDao stuDao;

    /**
     * �������
     * TODO ѧ�������Ϣ�ĸ��� ������Ŀ
     * @param stuID
     * @param bookISBN
     * @return
     */
    @Transactional
    public StuActExecution borrowBook(String stuID, String bookISBN)
             throws SystemEp ,StuActEp{
        try{
            int r0 = stuDao.addBorrowNum(stuID);
            if(r0<=0)//���������ﵽ�޶�
                throw new StuActEp(StuActStatEnum.BORROW_EXCESS);

            int r1=bookDao.reduceOne(bookISBN);
            if(r1<=0)//ͼ���������һʧ��
                throw new StuActEp(StuActStatEnum.BORROW_NOSTOCk);

            //���������������
            int r2 = borrowDao.insertOne(bookISBN, stuID, ReturnTime.getReturnTime());
            if (r2 <= 0) //������������ʧ��
                throw new StuActEp(StuActStatEnum.BORROW_FAIL);

            //����ɹ�
            BorrowBookEntity bookEntity = borrowDao.queryByIDAndISBN(bookISBN, stuID);
            return new StuActExecution(StuActStatEnum.BORROW_SUCCESS, bookEntity);

        }catch (StuActEp ep){
            throw ep;
        }
        catch(Exception e){
            throw new SystemEp("ϵͳ�쳣:"+e.getMessage());
        }
    }

    /**
     * �������
     * @param borrowID
     * @return
     */
    @Transactional
    public StuActExecution returnBook(int borrowID) throws
                  StuActEp,SystemEp{
        try{
            //��ѯ�õ�Ҫ�黹���ʵ��
            BorrowBookEntity borrowBookEntity = borrowDao.queryBorrowByID(borrowID);
            if(borrowBookEntity==null)
                throw new StuActEp(StuActStatEnum.RETURN_NO_BOOK);

            //���߽���������һ
            int r0=stuDao.reduceBorrowNum(borrowBookEntity.getStuID());
            if(r0<=0)
                throw new StuActEp(StuActStatEnum.RETURN_FAIL);

            // �����������1
            int r1=bookDao.addOne(borrowBookEntity.getBookISBN());
            if(r1<=0)
                throw new StuActEp(StuActStatEnum.RETURN_FAIL);

            // �����ɾ����������
            int r2=borrowDao.delOne(borrowID);
            if(r2<=0)
                throw new StuActEp(StuActStatEnum.RETURN_FAIL);

            // ���������һ����¼
            Date date = new Date();
            int r3=returnDao.insertOne(borrowBookEntity,date);
            if(r3<=0)
                throw new StuActEp(StuActStatEnum.RETURN_FAIL);

            //��ѯԤԼ���Ƿ�����ԤԼ���飬����ԤԼ������ĸ���
            OrderBookEntity orderBookEntity=orderDao.queryOneByISBN(borrowBookEntity.getBookISBN());
            if (orderBookEntity!=null){
                //����ԤԼͼ�飬���˽��Ĵ�ͼ��
                borrowBook(orderBookEntity.getStuID(),orderBookEntity.getBookISBN());
                //ɾ��ԤԼ��¼
                cancelOrder(orderBookEntity.getStuID(),orderBookEntity.getBookISBN());
            }

            ReturnBookEntity returnBookEntity = new ReturnBookEntity(borrowBookEntity, date);
            StuActExecution stuActExecution = new StuActExecution(StuActStatEnum.RETURN_SUCCESS, returnBookEntity);
            return stuActExecution;
        }catch (StuActEp ep){
            throw ep;
        }catch(Exception e){
            throw new SystemEp("ϵͳ�쳣"+e.getMessage());
        }
    }

    /**
     * ԤԼ����
     * @param stuID
     * @param bookISBN
     * @return
     */
    public StuActExecution orderBook(String stuID, String bookISBN)
    throws StuActEp,SystemEp{
        try{
            //����ԤԼ��¼
            int r1=orderDao.insertOne(stuID,bookISBN);
            if(r1<=0)
                throw new StuActEp(StuActStatEnum.ORDER_REPEAT);

            //��ѯ�õ�ԤԼʵ�� TODO ���ò�ѯֱ�ӵõ����ٽ�������
            OrderBookEntity orderBookEntity = orderDao.queryByIDAndISBN(stuID, bookISBN);
            if (orderBookEntity == null)
                throw new StuActEp(StuActStatEnum.ORDER_FAIL);

            return new StuActExecution(StuActStatEnum.ORDER_SUCCESS, orderBookEntity);
        }catch(StuActEp ep){
            throw ep;
        }catch (Exception e){
            throw new SystemEp("ϵͳ�쳣");
        }
    }

    /**
     * ȡ��ԤԼ
     * 1���û�����ȡ��ԤԼ
     * 2���û�ԤԼ��ͼ����ʣ�ࣨ�����û����飬ϵͳ����Ա¼��ͼ��ȵȣ���ϵͳ�Զ�������û�
     * @param stuID
     * @param bookISBN
     * @return
     */
    public StuActExecution cancelOrder(String stuID, String bookISBN) {

        //ɾ��ԤԼ��¼
        int r0=orderDao.delOne(stuID,bookISBN);
        if(r0<=0)
            throw new StuActEp(StuActStatEnum.ORDER_NOT_ORDER);

        return new StuActExecution(StuActStatEnum.ORDER_SUCCESS);
    }

    /**
     * ��ѯ����
     * @param type ��ѯ����  ���� ����  ������ȵ�
     * @param key
     * @return
     */
    public List<BookEntity> queryBook(SearchBookType type, String key) {

        List<BookEntity> bookEntities;
        switch (type){
            case BOOK_ISBN:
                bookEntities = new ArrayList<BookEntity>();
                bookEntities.add(bookDao.queryByISBN(key));
                break;
            case BOOK_NAME:
                bookEntities = bookDao.queryByName(key);
                break;
            case BOOK_PRESS:
                bookEntities = bookDao.queryByPress(key);
                break;
            case BOOK_AUTHOR:
                bookEntities = bookDao.queryByAuthor(key);
                break;
            case BOOK_INTRODUCTION:
                bookEntities = bookDao.queryByIntroduction(key);
                break;
            case BOOK_TYPE:
            default:
                bookEntities=null;
                break;
        }
        return bookEntities;
    }

    /**
     * ѧ����ѯ�Լ��Ľ����¼
     * @param stuID
     * @return
     */
    public List<BorrowBookEntity> queryBorrowBook(String stuID) {
        List<BorrowBookEntity> lists = borrowDao.queryByID(stuID);
        return lists;
    }

    /**
     * ѧ����ѯ�Լ���ԤԼ��¼
     * @param stuID
     * @return
     */
    public List<OrderBookEntity> queryOrderBook(String stuID) {
        List<OrderBookEntity> lists = orderDao.queryByID(stuID);
        return lists;
    }

    /**
     * ��ѯ�Լ�����Ϣ
     * @param stuID
     * @return
     */
    public StudentEntity queryMyInfo(String stuID) {
        return stuDao.queryByID(stuID);
    }

    /**
     * ��ѯͼ����ϸ��Ϣ
     * @param bookISBN
     * @return
     */
    public BookEntity queryByISBN(String bookISBN) {
        return bookDao.queryByISBN(bookISBN);
    }

    /**
     * ע�ắ��
     * @param stuID
     * @param password
     */
    public void register(String stuID, String password) throws StuActEp{
        try{
            //ѧ���б��޴���Ϣ
            StudentEntity studentEntity=stuDao.queryByID(stuID);
            if (studentEntity==null){
                throw new StuActEp(StuActStatEnum.REGISTER_NO_INFO);
            }
            if(studentEntity.getPassword()!=null)
                throw new StuActEp(StuActStatEnum.REGISTER_DOWN);

            int r0=stuDao.setPassword(stuID,password);
            if (r0<=0)
                throw new StuActEp(StuActStatEnum.REGISTER_FIAL);
        }catch (StuActEp ep){
            throw ep;
        }
    }
}
