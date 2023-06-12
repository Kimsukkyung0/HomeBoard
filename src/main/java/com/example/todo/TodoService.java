package com.example.todo;

import com.example.todo.model.TodoInsDto;
import com.example.todo.model.TodoUpdDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private final TodoMapper mapper;

    @Autowired
    public TodoService(TodoMapper mapper){
        this.mapper = mapper;
    }

    public int InsTodo(TodoInsDto dto){
        return mapper.insTodo(dto);

    }
    public int updTodo(TodoUpdDto dto){
        return mapper.updTodo(dto);
    };
}
