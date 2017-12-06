package com.wkw.dto.json;

import lombok.Data;

/**
 * create by wkw
 */
@Data
public class JsonData<T> {

    private boolean success;
    private T data;
    private String error;

    public JsonData(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public JsonData(boolean success, T data) {
        this.success = success;
        this.data = data;
    }
}
