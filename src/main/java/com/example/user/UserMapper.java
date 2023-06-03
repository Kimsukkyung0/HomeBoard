package com.example.user;


import com.example.user.model.UserDto;
import com.example.user.model.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int insUser(UserDto dto);
    int upUser(UserDto dto);
    int delUser(UserDto dto);
    List<UserVo> selAllUsers(UserDto dto);
    UserVo selById(UserDto dto);
}
