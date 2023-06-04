package com.example.user;

import com.example.user.model.*;
import com.green.boardver3.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
