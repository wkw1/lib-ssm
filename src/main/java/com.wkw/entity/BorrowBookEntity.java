package com.wkw.entity;

import java.util.Date;

public class BorrowBookEntity {

    private int borrowID;//���ı�ţ�Ψһ
    private String stuID;//�����ߵ�ID
    private String bookISBN;//���Ψһ��ʶ
    private Date borrowTime;//����ʱ��
    private Date expectReturnTime;//Ӧ�ù黹ʱ��

    //һ�Զ��ϵӳ��
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
