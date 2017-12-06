package com.wkw.enums;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * create by wkw
 */

public enum StuActStatEnum {

    REGISTER_FIAL(01,"ע��ʧ��"),
    REGISTER_SUCCESS(02,"ע��ɹ�"),
    REGISTER_NO_INFO(03,"δ¼����Ϣ"),
    REGISTER_DOWN(04,"��ע��"),

    BORROW_EXCESS(11,"������������"),
    BORROW_SUCCESS(10,"����ɹ�"),
    BORROW_NOSTOCk(12,"�����޿��"),
    BORROW_FAIL(13,"����ʧ��"),

    RETURN_SUCCESS(20,"����ɹ�"),
    RETURN_FAIL(21,"����ʧ��"),
    RETURN_NOT_BORROW(22,"�޽��Ĵ���"),
    RETURN_NO_BOOK(23,"�޽��Ĵ���"),

    ORDER_SUCCESS(30,"ԤԼ�ɹ�"),
    ORDER_FAIL(31,"ԤԼʧ��"),
    ORDER_REPEAT(32,"�ظ�ԤԼ"),
    ORDER_NOT_ORDER(33,"δԤԼͼ��"),

    INNER_ERROR(0,"�ڲ�����");

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
