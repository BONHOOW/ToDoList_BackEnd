package com.example.todolist.controller;

import com.example.todolist.repository.Todo;
import com.example.todolist.service.TodoService;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Getter
@RestController
@RequestMapping("/todo")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getTodos() {
        return todoService.getTodos();
    }

    @PostMapping
    public Todo insertTodo(@RequestBody TodoRequest todoRequest) {
        return todoService.insertTodo(todoRequest.getTodoName());
    }

    @PutMapping(path = "/{todoId}")
    public Todo updateTodo(@PathVariable("todoId") Long todoId) {
        return todoService.updateTodo(todoId);
    }

    @DeleteMapping(path = "/{todoId}")
    public void deleteTodo(@PathVariable("todoId") Long todoId) {
        todoService.deleteTodo(todoId);
    }

}
