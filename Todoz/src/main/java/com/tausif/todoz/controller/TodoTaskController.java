package com.tausif.todoz.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tausif.todoz.entity.TodoTask;
import com.tausif.todoz.model.TodoTaskDto;

@RestController
public interface TodoTaskController {
	@PostMapping("/private/todotask")
    public TodoTask createTodoTask(@RequestBody TodoTaskDto todoTask);
    
    @DeleteMapping("/private/todotask/{id}")
    public TodoTask deleteTodoTask(@PathVariable("id") long id);
    
    @GetMapping("/private/todotask/{id}")
	public TodoTask getTodoTask(@PathVariable("id") long id);
	
    @GetMapping("/private/todotask")
	public List<TodoTask> getTodoTask();
}
