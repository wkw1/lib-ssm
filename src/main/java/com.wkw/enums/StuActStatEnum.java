package com.wkw.enums;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * create by wkw
 */

public enum StuActStatEnum {

    REGISTER_FIAL(01,"注册失败"),
    REGISTER_SUCCESS(02,"注册成功"),
    REGISTER_NO_INFO(03,"未录入信息"),
    REGISTER_DOWN(04,"已注册"),

    BORROW_EXCESS(11,"借书数量已满"),
    BORROW_SUCCESS(10,"借书成功"),
    BORROW_NOSTOCk(12,"此书无库存"),
    BORROW_FAIL(13,"借书失败"),

    RETURN_SUCCESS(20,"还书成功"),
    RETURN_FAIL(21,"还书失败"),
    RETURN_NOT_BORROW(22,"无借阅此书"),
    RETURN_NO_BOOK(23,"无借阅此书"),

    ORDER_SUCCESS(30,"预约成功"),
    ORDER_FAIL(31,"预约失败"),
    ORDER_REPEAT(32,"重复预约"),
    ORDER_NOT_ORDER(33,"未预约图书"),

    INNER_ERROR(0,"内部错误");

    @Setter@Getter
    private int state;
    @Setter@Getter
    private String statInfo;

    StuActStatEnum(int state,String statInfo){
        this.state=state;
        this.statInfo=statInfo;
    }

    @Override
    public String toString() {
        return "state:"+state+
                "stateInfo:"+statInfo;
    }
}
