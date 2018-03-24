package com.tausif.todoz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tausif.todoz.dao.TodoTaskRepository;
import com.tausif.todoz.dao.UserRepository;
import com.tausif.todoz.entity.TodoTask;
import com.tausif.todoz.entity.User;
import com.tausif.todoz.model.TodoTaskDto;
import com.tausif.todoz.service.TotoTaskServiceImpl;

@RestController
public class TodoTaskControllerImpl implements TodoTaskController{
	
	@Autowired
	TotoTaskServiceImpl totoTaskService;
	
    @Override
    public void createTodoTask(@RequestBody TodoTaskDto todoTask) {
    	totoTaskService.createTodoTask(todoTask);
    }
    
    @Override
    public void deleteTodoTask(@PathVariable("id") long id) {
    	totoTaskService.deleteTodoTask(id);
    }
	
    @Override
	public TodoTask getTodoTask(@PathVariable("id") long id) {
    	return totoTaskService.getTodoTask(id);
    }
	
    @Override
	public List<TodoTask> getTodoTask(){
		return totoTaskService.getTodoTask();
    }
}
