package com.example.board;


import com.example.board.module.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class BoardController {

    BoardService service;

    @Autowired
    public BoardController(){
        this.service = service;
    }

    public int insBoard(BoardDto dto){
        return service.insBoard(dto);
    }



}
