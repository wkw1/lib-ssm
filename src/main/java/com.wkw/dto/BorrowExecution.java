package com.wkw.dto;

import com.wkw.entity.BorrowBookEntity;
import com.wkw.enums.StuActStatEnum;

/**
 * create by wkw
 */
public class BorrowExecution {
    private String bookISBN;
    private int state;
    private String stateInfo;
    private BorrowBookEntity borrowBookEntity;

    public BorrowExecution(String bookISBN, StuActStatEnum statEnum,
                           BorrowBookEntity borrowBookEntity) {
        this.bookISBN = bookISBN;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStatInfo();
        this.borrowBookEntity = borrowBookEntity;
    }

    public BorrowExecution(String bookISBN, StuActStatEnum statEnum) {
        this.bookISBN = bookISBN;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStatInfo();
    }

    @Override
    public String toString() {
        return "BorrowExecution{" +
                "bookISBN='" + bookISBN + '\'' +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", borrowBookEntity=" + borrowBookEntity +
                '}';
    }
}
