package com.example.board.module;

import lombok.Data;

@Data
public class BoardEntity {
    private int idx;
    private String NAME;
    private int age;
    private String job;
    private String address;
    private String mobile;
    private String createdAt;
    private String editedAt;
}
