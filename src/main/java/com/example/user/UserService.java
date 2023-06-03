package com.example.user;

import com.example.user.model.UserDto;
import com.example.user.model.UserVo;
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
    public int insBoard(UserDto dto){
        return mapper.insUser(dto);
    }
    public int upBoard(UserDto dto){return mapper.upUser(dto);}
    public int delBoard(UserDto dto){return mapper.delUser(dto);}
    public List<UserVo> selBoardAllPaging(UserDto dto){
        dto.setStartIdx((dto.getPage()-1)*dto.getRow());
        return mapper.selAllUsers(dto);
    }
    public UserVo selById(UserDto dto) {return mapper.selById(dto);}

}
