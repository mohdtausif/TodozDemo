package com.tausif.todoz.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tausif.todoz.entity.TodoTask;
import com.tausif.todoz.model.TodoTaskDto;

@Service
public interface TotoTaskService {
	public TodoTask createTodoTask(TodoTaskDto todoTaskDto);
	public void deleteTodoTask(long id);
	public TodoTask getTodoTask(long id);
	public List<TodoTask> getTodoTask();
}
