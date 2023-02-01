package com.collage.wxz.entity;


import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private static final int USER = 2;
    private static final int CUSTOMER = 1;
    private static final int ADMIN = 0;
    private Integer studentId;
    private String username;
    private String password;
    private Integer age;
    private Integer gender;
    private Integer userClassification;
    private String nick;
    private String userSign;
    private String email;
    private Integer tel;
    private String token;
}
