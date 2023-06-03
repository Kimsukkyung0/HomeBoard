package com.example.user.model;

import lombok.Data;

@Data
public class UserInsDto {
    private String name;
    private String uid;
    private String upw;
    private int age;
    private String job;
    private String address;
    private String mobile;
}
