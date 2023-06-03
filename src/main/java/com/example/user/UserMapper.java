package com.example.user;


import com.example.user.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int insUser(UserInsDto dto);
    int upUserInfo(UserDto dto);
    int delUser(UserEntity entity);
    List<UserVo> selAllUsers(UserIdx idx);
    UserVo selById(UserDto dto);
}
