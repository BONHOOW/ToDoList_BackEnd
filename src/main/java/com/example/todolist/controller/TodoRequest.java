package com.example.todolist.controller;

import lombok.Getter;

@Getter
public class TodoRequest {
    String todoName;

    public TodoRequest() {

    }

    public TodoRequest(String todoName) {
        this.todoName = todoName;
    }

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }
}
