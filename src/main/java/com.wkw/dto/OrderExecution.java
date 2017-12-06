package com.wkw.dto;

import com.wkw.entity.OrderBookEntity;
import com.wkw.enums.StuActStatEnum;

/**
 * create by wkw
 */
public class OrderExecution {
    private String bookISBN;
    private int state;
    private String stateInfo;
    private OrderBookEntity orderBookEntity;


    public OrderExecution(String bookISBN, StuActStatEnum statEnum, OrderBookEntity orderBookEntity) {
        this.bookISBN = bookISBN;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStatInfo();
        this.orderBookEntity = orderBookEntity;
    }

    public OrderExecution(String bookISBN, StuActStatEnum statEnum) {

        this.bookISBN = bookISBN;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getStatInfo();
    }

    @Override
    public String toString() {
        return "OrderExecution{" +
                "bookISBN='" + bookISBN + '\'' +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", orderBookEntity=" + orderBookEntity +
                '}';
    }
}
