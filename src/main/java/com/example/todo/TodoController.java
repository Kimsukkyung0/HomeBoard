package com.example.todo;

import com.example.todo.model.TodoInsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class TodoController {
    private final TodoService service;

    @Autowired
    public TodoController(TodoService service){
        this.service = service;
    }

    @PostMapping
    public int PostTodo(@RequestBody TodoInsDto dto){
        return service.InsTodo(dto);
    }
}
