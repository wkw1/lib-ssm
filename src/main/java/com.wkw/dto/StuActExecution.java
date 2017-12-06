package com.wkw.dto;

import com.wkw.enums.StuActStatEnum;
import lombok.Data;

/**
 * create by wkw
 */
@Data
public class StuActExecution<T> {
    private int state;
    private String statInfo;
    private T data;

    public StuActExecution(StuActStatEnum state) {
        this.state = state.getState();
        this.statInfo = state.getStatInfo();
    }

    public StuActExecution(StuActStatEnum state, T data) {
        this.state = state.getState();
        this.statInfo = state.getStatInfo();
        this.data = data;
    }
}
