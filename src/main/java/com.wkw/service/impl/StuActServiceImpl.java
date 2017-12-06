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
     * 借书操作
     * TODO 学生相关信息的更改 借书数目
     * @param stuID
     * @param bookISBN
     * @return
     */
    @Transactional
    public StuActExecution borrowBook(String stuID, String bookISBN)
             throws SystemEp ,StuActEp{
        try{
            int r0 = stuDao.addBorrowNum(stuID);
            if(r0<=0)//借书数量达到限额
                throw new StuActEp(StuActStatEnum.BORROW_EXCESS);

            int r1=bookDao.reduceOne(bookISBN);
            if(r1<=0)//图书表数量减一失败
                throw new StuActEp(StuActStatEnum.BORROW_NOSTOCk);

            //借书表插入此条数据
            int r2 = borrowDao.insertOne(bookISBN, stuID, ReturnTime.getReturnTime());
            if (r2 <= 0) //借书表插入数据失败
                throw new StuActEp(StuActStatEnum.BORROW_FAIL);

            //借书成功
            BorrowBookEntity bookEntity = borrowDao.queryByIDAndISBN(bookISBN, stuID);
            return new StuActExecution(StuActStatEnum.BORROW_SUCCESS, bookEntity);

        }catch (StuActEp ep){
            throw ep;
        }
        catch(Exception e){
            throw new SystemEp("系统异常:"+e.getMessage());
        }
    }

    /**
     * 还书操作
     * @param borrowID
     * @return
     */
    @Transactional
    public StuActExecution returnBook(int borrowID) throws
                  StuActEp,SystemEp{
        try{
            //查询得到要归还书的实体
            BorrowBookEntity borrowBookEntity = borrowDao.queryBorrowByID(borrowID);
            if(borrowBookEntity==null)
                throw new StuActEp(StuActStatEnum.RETURN_NO_BOOK);

            //读者借书数量减一
            int r0=stuDao.reduceBorrowNum(borrowBookEntity.getStuID());
            if(r0<=0)
                throw new StuActEp(StuActStatEnum.RETURN_FAIL);

            // 读书表数量加1
            int r1=bookDao.addOne(borrowBookEntity.getBookISBN());
            if(r1<=0)
                throw new StuActEp(StuActStatEnum.RETURN_FAIL);

            // 借书表删除此条数据
            int r2=borrowDao.delOne(borrowID);
            if(r2<=0)
                throw new StuActEp(StuActStatEnum.RETURN_FAIL);

            // 还书表增加一条记录
            Date date = new Date();
            int r3=returnDao.insertOne(borrowBookEntity,date);
            if(r3<=0)
                throw new StuActEp(StuActStatEnum.RETURN_FAIL);

            //查询预约表是否有人预约此书，有人预约则将书借阅给他
            OrderBookEntity orderBookEntity=orderDao.queryOneByISBN(borrowBookEntity.getBookISBN());
            if (orderBookEntity!=null){
                //有人预约图书，此人借阅此图书
                borrowBook(orderBookEntity.getStuID(),orderBookEntity.getBookISBN());
                //删除预约记录
                cancelOrder(orderBookEntity.getStuID(),orderBookEntity.getBookISBN());
            }

            ReturnBookEntity returnBookEntity = new ReturnBookEntity(borrowBookEntity, date);
            StuActExecution stuActExecution = new StuActExecution(StuActStatEnum.RETURN_SUCCESS, returnBookEntity);
            return stuActExecution;
        }catch (StuActEp ep){
            throw ep;
        }catch(Exception e){
            throw new SystemEp("系统异常"+e.getMessage());
        }
    }

    /**
     * 预约操作
     * @param stuID
     * @param bookISBN
     * @return
     */
    public StuActExecution orderBook(String stuID, String bookISBN)
    throws StuActEp,SystemEp{
        try{
            //插入预约记录
            int r1=orderDao.insertOne(stuID,bookISBN);
            if(r1<=0)
                throw new StuActEp(StuActStatEnum.ORDER_REPEAT);

            //查询得到预约实体 TODO 不用查询直接得到较少交互次数
            OrderBookEntity orderBookEntity = orderDao.queryByIDAndISBN(stuID, bookISBN);
            if (orderBookEntity == null)
                throw new StuActEp(StuActStatEnum.ORDER_FAIL);

            return new StuActExecution(StuActStatEnum.ORDER_SUCCESS, orderBookEntity);
        }catch(StuActEp ep){
            throw ep;
        }catch (Exception e){
            throw new SystemEp("系统异常");
        }
    }

    /**
     * 取消预约
     * 1，用户主动取消预约
     * 2，用户预约的图书有剩余（其它用户还书，系统管理员录入图书等等），系统自动分配给用户
     * @param stuID
     * @param bookISBN
     * @return
     */
    public StuActExecution cancelOrder(String stuID, String bookISBN) {

        //删除预约记录
        int r0=orderDao.delOne(stuID,bookISBN);
        if(r0<=0)
            throw new StuActEp(StuActStatEnum.ORDER_NOT_ORDER);

        return new StuActExecution(StuActStatEnum.ORDER_SUCCESS);
    }

    /**
     * 查询函数
     * @param type 查询类型  书名 作者  出版社等等
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
     * 学生查询自己的借书记录
     * @param stuID
     * @return
     */
    public List<BorrowBookEntity> queryBorrowBook(String stuID) {
        List<BorrowBookEntity> lists = borrowDao.queryByID(stuID);
        return lists;
    }

    /**
     * 学生查询自己的预约记录
     * @param stuID
     * @return
     */
    public List<OrderBookEntity> queryOrderBook(String stuID) {
        List<OrderBookEntity> lists = orderDao.queryByID(stuID);
        return lists;
    }

    /**
     * 查询自己的信息
     * @param stuID
     * @return
     */
    public StudentEntity queryMyInfo(String stuID) {
        return stuDao.queryByID(stuID);
    }

    /**
     * 查询图书详细信息
     * @param bookISBN
     * @return
     */
    public BookEntity queryByISBN(String bookISBN) {
        return bookDao.queryByISBN(bookISBN);
    }

    /**
     * 注册函数
     * @param stuID
     * @param password
     */
    public void register(String stuID, String password) throws StuActEp{
        try{
            //学生列表无此信息
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
