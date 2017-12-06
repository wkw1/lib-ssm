package com.wkw.dto.json;

import java.util.List;

/**
 * create by wkw
 */
public class ListJson<T> {
    private boolean success;
    private List<T> data;
    private String error;


    public ListJson(boolean success, List<T> data) {
        this.success = success;
        this.data = data;
    }

    public ListJson(boolean success, String error) {
        this.success = success;
        this.error = error;
    }
}
