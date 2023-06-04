package com.example.user;


import com.example.user.model.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping@Tag(name="회원가입",description = "")
    public int insBoard(@RequestBody UserInsDto dto){
        return service.insBoard(dto);
    }

    @PatchMapping@Tag(name="회원정보수정",description = "")
    public int upUserInfo(@RequestBody UserUpInfoDto iDto) {
        return service.upUserInfo(iDto);
    }

    @DeleteMapping("/{idx}")@Tag(name="회원탈퇴",description = "")
    public int delBoard (@PathVariable int idx){
        UserEntity entity = new UserEntity();
        entity.setIdx(idx);
        return service.delBoard(entity);
    }

    @GetMapping
    public List<UserVo> selBoardAll(@RequestParam (defaultValue = "40") int row,
                                    @RequestParam @Min(1) int page){
        UserIdx uidx = new UserIdx();
        uidx.setPage(page);
        uidx.setRow(row);
        return service.selBoardAllPaging(uidx);
    }

    @GetMapping("/{idx}")
    public UserVo selById(@PathVariable int idx){
        UserEntity entity = new UserEntity();
        UserDto dto = new UserDto();
        entity.setIdx(idx);
        return service.selById(dto);
    }

    @PatchMapping(name="/pic", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public int patchUserPhoto(@RequestParam int idx, @RequestPart MultipartFile pic){
        UserUpPhotoDto pDto = new UserUpPhotoDto();
        pDto.setIdx(idx);
        return service.upUserPhotoDto(pic,pDto);
    }
}
