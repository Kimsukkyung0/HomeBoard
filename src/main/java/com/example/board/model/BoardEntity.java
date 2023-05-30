package com.example.board.model;

import lombok.Data;

@Data
public class BoardEntity {
    private int idx;
    private String name;
    private int age;
    private String job;
    private String address;
    private String mobile;
    private String createdAt;
    private String editedAt;
}
