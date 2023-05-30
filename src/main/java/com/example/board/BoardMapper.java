package com.example.board;


import com.example.board.module.BoardDto;
import com.example.board.module.BoardEntity;
import com.example.board.module.BoardVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int insBoard(BoardDto dto);
    int upBoard(BoardDto dto);
    int delBoard(BoardDto dto);
    List<BoardVo> selAllPaging(BoardDto dto);
    BoardVo selById(BoardDto dto);
}
