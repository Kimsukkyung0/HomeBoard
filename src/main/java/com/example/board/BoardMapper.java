package com.example.board;


import com.example.board.model.BoardDto;
import com.example.board.model.BoardVo;
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
