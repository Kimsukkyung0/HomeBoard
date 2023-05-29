package com.example.board.module;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardVo {
    private int idx;
    private String name;
    private int age;
    private String job;
}
