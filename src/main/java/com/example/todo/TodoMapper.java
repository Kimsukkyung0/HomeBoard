package com.example.todo;

import com.example.todo.model.TodoInsDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoMapper {
    public int insTodo (TodoInsDto dto);
}
