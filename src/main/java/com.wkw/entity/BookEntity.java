package com.wkw.entity;

import lombok.Data;

import java.util.Date;

@Data
public class BookEntity {
    private String bookISBN;//���ISBN
    private String bookName;//����
    private String bookImgSrc;//��������
    private String bookIntroduction;//���
    private String bookAuthor;//����
    private String bookPress;//������
    private int powerNeed;//��������Ȩ��,Ҳ��ʾ�û����� 1��ʾѧ����2��ʾ��ʦ
    private Date storageTime;//ͼ�����ʱ��
    private String bookType;
    private int totalNumber;//���ʣ������
    private int remainingNumber;//���������

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
