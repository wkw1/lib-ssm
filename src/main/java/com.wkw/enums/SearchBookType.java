package com.wkw.enums;

/**
 * created by wkw
 *
 * ��������
 * ����
 * ������
 * ����
 * ���
 * ������
 */
public enum SearchBookType {
    BOOK_NAME("����"),
    BOOK_PRESS("������"),
    BOOK_AUTHOR("����"),
    BOOK_INTRODUCTION("���"),
    BOOK_ISBN("ISBN"),
    BOOK_TYPE("�������");

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
