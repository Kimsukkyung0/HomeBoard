package com.example.user.model;

import lombok.Data;

@Data
public class UserDto {
    private int idx;
    private String name;
    private int age;
    private String job;
    private String address;
    private String mobile;
    private int row;
    private int startIdx;
    private int page;
}
