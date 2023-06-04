package com.example.user;

import com.example.user.model.*;
import com.green.boardver3.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static org.apache.commons.lang3.ArrayUtils.lastIndexOf;

@Service
public class UserService {
    private final UserMapper mapper;

    @Autowired
    public UserService(UserMapper mapper){
        this.mapper = mapper;
    }
    public int insBoard(UserInsDto dto){
        CommonUtils utils = new CommonUtils();

        dto.setUpw(utils.encodeSha256(dto.getUpw()));
        return mapper.insUser(dto);
    }

    public int upUserInfo(UserUpInfoDto iDto){
        UserDto uDto = new UserDto();
//
//        iDto.setUpw(uDto.getUpw());
        return mapper.upUserInfo(iDto);
    }
    public int delBoard(UserEntity entity){return mapper.delUser(entity);}
    public List<UserVo> selBoardAllPaging(UserIdx uidx){
        uidx.setStartIdx((uidx.getPage()-1)*uidx.getRow());
        return mapper.selAllUsers(uidx);
    }
    public UserVo selById(UserDto dto) {return mapper.selById(dto);}

    public int upUserPhotoDto(MultipartFile pic,UserUpPhotoDto pDto){
        // user/pk/uuid.jpg
        // user/1/abcd.jpg

        String originalFileName = pic.getOriginalFilename();
        int idx = originalFileName.lastIndexOf(".");
        String fileName = originalFileName.substring(idx);





        return mapper.upUserPhoto(pDto);
    }

}
