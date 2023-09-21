package com.example.todo;

import com.example.todo.model.TodoInsDto;
import com.example.todo.model.TodoUpdDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping("/{tIdx}")
    public int PutTodo(@PathVariable int tIdx ,@RequestBody TodoUpdDto dto){
//        TodoUpdDto dto = new TodoUpdDto();
        dto.setTIdx(tIdx);
        return service.updTodo(dto);
    }     

}
