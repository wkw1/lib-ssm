package com.wkw.dto;

import com.wkw.entity.BorrowBookEntity;
import com.wkw.entity.ReturnBookEntity;
import com.wkw.enums.StuActStatEnum;

/**
 * create by wkw
 */
public class ReturnExecution {
    private String bookISBN;
    private int state;
    private String stateInfo;
    private ReturnBookEntity returnBookEntity;

    public ReturnExecution(String bookISBN, StuActStatEnum statEnum, ReturnBookEntity returnBookEntity) {
        this.bookISBN = bookISBN;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStatInfo();
        this.returnBookEntity = returnBookEntity;
    }

    public ReturnExecution(String bookISBN, StuActStatEnum statEnum) {
        this.bookISBN = bookISBN;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStatInfo();
    }

    public String getBookISBN() {
        return bookISBN;
    }

    public void setBookISBN(String bookISBN) {
        this.bookISBN = bookISBN;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public ReturnBookEntity getReturnBookEntity() {
        return returnBookEntity;
    }

    public void setReturnBookEntity(ReturnBookEntity returnBookEntity) {
        this.returnBookEntity = returnBookEntity;
    }

    @Override
    public String toString() {
        return "ReturnExecution{" +
                "bookISBN='" + bookISBN + '\'' +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                '}';
    }
}
