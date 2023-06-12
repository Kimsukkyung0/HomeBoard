package com.example.todo;

import com.example.todo.model.TodoInsDto;
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
}
