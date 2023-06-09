package com.example.user.model;

import lombok.Data;

@Data
public class UserEntity {
    private int idx;
    private String name;
    private int age;
    private String uid;
    private String upw;
    private String mainPic;
    private String job;
    private String address;
    private String mobile;
    private String createdAt;
    private String editedAt;
}
