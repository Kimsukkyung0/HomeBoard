package com.example.todo.model;

import lombok.Data;

@Data
public class TodoUpdDto {
    private int tIdx;
    private String ctnt;
    private char completed;

}
