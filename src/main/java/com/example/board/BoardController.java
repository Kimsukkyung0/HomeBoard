package com.example.board;


import com.example.board.module.BoardDto;
import com.example.board.module.BoardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class BoardController {

    private final BoardService service;

    @Autowired
    public BoardController(BoardService service){
        this.service = service;
    }

    @PostMapping
    public int insBoard(@RequestBody BoardDto dto){
        return service.insBoard(dto);
    }

    @PutMapping
    public int upBoard(@RequestBody BoardDto dto){return service.upBoard(dto);}

    @DeleteMapping("/{idx}")
    public int delBoard (@PathVariable int idx){
        BoardDto dto = new BoardDto();
        dto.setIdx(idx);
        return service.delBoard(dto);

    }

}
