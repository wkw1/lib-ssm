package com.wkw.entity;

import java.util.Date;

public class BorrowBookEntity {

    private int borrowID;//借阅编号，唯一
    private String stuID;//借书者的ID
    private String bookISBN;//书的唯一标识
    private Date borrowTime;//借书时间
    private Date expectReturnTime;//应该归还时间

    //一对多关系映射
    private StudentEntity student;
    private BookEntity book;

    public int getBorrowID() {
        return borrowID;
    }

    public void setBorrowID(int borrowID) {
        this.borrowID = borrowID;
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

    public Date getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Date borrowTime) {
        this.borrowTime = borrowTime;
    }

    public Date getExpectReturnTime() {
        return expectReturnTime;
    }

    public void setExpectReturnTime(Date expectReturnTime) {
        this.expectReturnTime = expectReturnTime;
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

    @Override
    public String toString() {
        return "BorrowBookEntity{" +
                "borrowID=" + borrowID +
                ", stuID='" + stuID + '\'' +
                ", bookISBN='" + bookISBN + '\'' +
                ", borrowDate=" + borrowTime +
                ", expectReturnTime=" + expectReturnTime +
                '}';
    }
}
