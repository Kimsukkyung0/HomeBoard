package com.example.user;


import com.example.user.model.UserDto;
import com.example.user.model.UserVo;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@Tag(name="회원", description = "")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service){
        this.service = service;
    }

    @PostMapping
    public int insBoard(@RequestBody UserDto dto){
        return service.insBoard(dto);
    }

    @PutMapping
    public int upBoard(@RequestBody UserDto dto){return service.upBoard(dto);}

    @DeleteMapping("/{idx}")
    public int delBoard (@PathVariable int idx){
        UserDto dto = new UserDto();
        dto.setIdx(idx);
        return service.delBoard(dto);
    }

    @GetMapping
    public List<UserVo> selBoardAll(@RequestParam (defaultValue = "40") int row,
                                    @RequestParam @Min(1) int page){
        UserDto dto = new UserDto();
        dto.setPage(page);
        dto.setRow(row);
        return service.selBoardAllPaging(dto);
    }

    @GetMapping("/{idx}")
    public UserVo selById(@PathVariable int idx){
        UserDto dto = new UserDto();
        dto.setIdx(idx);
        return service.selById(dto);
    }

}
