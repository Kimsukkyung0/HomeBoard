package com.example.user;

import com.example.user.model.*;
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
        return mapper.insUser(dto);
    }

    public int upUserInfo(UserUpInfoDto iDto){
//        UserDto uDto = new UserDto();
//        iDto.setIdx(uDto.getIdx()); //Got idx from controller already set and put
//        iDto.setAddress(uDto.getAddress());
//        iDto.setJob(uDto.getJob());
//        iDto.setMobile(uDto.getMobile());
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
