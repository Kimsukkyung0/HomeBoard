package com.example.board.model;

import lombok.Data;

@Data
public class BoardDto {
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
