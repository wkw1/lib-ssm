package com.wkw.entity;

import java.util.Date;

/**
 * create by wkw
 */
public class OrderBookEntity {

    private String stuID;//ԤԼ�ߵ�ID
    private String bookISBN;//���Ψһ��ʶ
    private Date orderTime;//ԤԼʱ��

    //һ�Զ��ϵӳ��
    private StudentEntity student;
    private BookEntity book;

    @Override
    public String toString() {
        return "OrderBookEntity{" +
                ", stuID='" + stuID + '\'' +
                ", bookISBN='" + bookISBN + '\'' +
                ", orderTime=" + orderTime +
                '}';
    }


    public String getStuID() {
        return stuID;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    public BookEntity getBook() {
        return book;
    }

    public void setBook(BookEntity book) {
        this.book = book;
    }
}
