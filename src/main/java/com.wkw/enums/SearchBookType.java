package com.wkw.enums;

/**
 * created by wkw
 *
 * 搜索类型
 * 作者
 * 出版社
 * 书名
 * 简介
 * 。。。
 */
public enum SearchBookType {
    BOOK_NAME("书名"),
    BOOK_PRESS("出版社"),
    BOOK_AUTHOR("作者"),
    BOOK_INTRODUCTION("简介"),
    BOOK_ISBN("ISBN"),
    BOOK_TYPE("书的种类");

    private String info;

    SearchBookType(String info){
        this.info=info;
    }

    public static SearchBookType stateof(String info){
        for(SearchBookType type :values()){
            if (type.getInfo().equals(info))
                return type;
        }
        return null;
    }


    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
}
