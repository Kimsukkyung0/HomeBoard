package com.example.board;


import com.example.board.module.BoardDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    int insBoard(BoardDto dto);
}
