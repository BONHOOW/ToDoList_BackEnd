package com.example.todolist.service;

import com.example.todolist.repository.Todo;
import com.example.todolist.repository.TodoRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getTodos() {
        return (List<Todo>) todoRepository.findAll();
    }

    public Todo insertTodo(String todoName) {
        Todo todo = new Todo();
        todo.setTodoName(todoName);
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Long todoId) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new RuntimeException("Todo not found"));

        todo.setCompleted(!todo.isCompleted());

        return todoRepository.save(todo);
    }

    public void deleteTodo(Long todoId) {
        todoRepository.deleteById(todoId);
    }
}
