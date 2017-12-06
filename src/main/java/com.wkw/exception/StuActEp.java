package com.wkw.exception;

import com.wkw.enums.StuActStatEnum;
import lombok.Data;

/**
 * created by wkw
 * ѧ����һЩ�����׳����쳣
 */
@Data
public class StuActEp extends RuntimeException{
    private StuActStatEnum state;

    public StuActEp( StuActStatEnum state) {
        this.state = state;
    }

    public StuActEp(String message, Throwable cause, StuActStatEnum state) {
        super(message, cause);
        this.state = state;
    }
}
