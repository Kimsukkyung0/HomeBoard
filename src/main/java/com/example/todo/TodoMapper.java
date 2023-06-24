package com.example.todo;

import com.example.todo.model.TodoInsDto;
import com.example.todo.model.TodoUpdDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoMapper {
    public int insTodo (TodoInsDto dto);

    public int updTodo(TodoUpdDto dto);
}
