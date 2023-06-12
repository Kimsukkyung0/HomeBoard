package com.example.todo.model;

import lombok.Data;

@Data
public class TodoInsDto {
    private String ctnt;
    private char completed;
    private int idx;
}
