package com.wkw.entity;

import lombok.Data;

import java.util.Date;

@Data
public class BookEntity {
    private String bookISBN;//书的ISBN
    private String bookName;//书名
    private String bookImgSrc;//封面链接
    private String bookIntroduction;//简介
    private String bookAuthor;//作者
    private String bookPress;//出版社
    private int powerNeed;//借书所需权限,也表示用户种类 1表示学生，2表示老师
    private Date storageTime;//图书入库时间
    private String bookType;
    private int totalNumber;//书的剩余数量
    private int remainingNumber;//书的总数量

    @Override
    public String toString() {
        return "BookEntity{" +
                "bookISBN='" + bookISBN + '\'' +
                ", bookName='" + bookName + '\'' +
                ", bookImgSrc='" + bookImgSrc + '\'' +
                ", bookIntroduction='" + bookIntroduction + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPress='" + bookPress + '\'' +
                ", powerNeed=" + powerNeed +
                ", storageTime=" + storageTime +
                ", bookType='" + bookType + '\'' +
                ", total_number=" + totalNumber +
                ", remaining_number=" + remainingNumber +
                '}';
    }
}
