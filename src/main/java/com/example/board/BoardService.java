package com.example.board;

import com.example.board.module.BoardDto;
import com.example.board.module.BoardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    private final BoardMapper mapper;

    @Autowired
    public BoardService(BoardMapper mapper){
        this.mapper = mapper;
    }

    public int insBoard(BoardDto dto){
        return mapper.insBoard(dto);
    }

    public int upBoard(BoardDto dto){return mapper.upBoard(dto);}

    public int delBoard(BoardDto dto){return mapper.delBoard(dto);}
}
