package com.wkw.entity;

import lombok.Data;

@Data
public class StudentEntity {

    private String stuID;
    private String stuName;
    private String school;
    private String email;
    private String phone;
    private String password;
    private String headImg;

    private int power;
    private int borrowNumber;

}
