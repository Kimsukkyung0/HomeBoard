package com.example.board;

import com.example.board.module.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    BoardMapper mapper;

    @Autowired
    public BoardService(){
        this.mapper = mapper;
    }

    public int insBoard(BoardDto dto){
        return mapper.insBoard(dto);
    }
}
