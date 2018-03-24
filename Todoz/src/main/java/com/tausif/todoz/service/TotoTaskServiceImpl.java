package com.tausif.todoz.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tausif.todoz.dao.TodoTaskRepository;
import com.tausif.todoz.entity.TodoTask;
import com.tausif.todoz.entity.User;
import com.tausif.todoz.model.TodoTaskDto;

@Service
public class TotoTaskServiceImpl implements TotoTaskService{
	@Autowired
    private TodoTaskRepository todoTaskRepository;
	
	@Autowired
	private HttpServletRequest request;
    
	@Override
	public TodoTask createTodoTask(TodoTaskDto todoTaskDto) {
		TodoTask todoTask=null;
		if(todoTaskDto.getId() != 0l)
		{
			todoTask = todoTaskRepository.findOne(todoTaskDto.getId());
		}
		
		if(todoTask==null)
		{
			todoTask=new TodoTask();
		}
		
		
		todoTask.setDetail(todoTaskDto.getDetail());
		todoTask.setPriority(todoTaskDto.getPriority());
		todoTask.setTaskStartTime(todoTaskDto.getTaskStartTime());
		todoTask.setTaskEndTime(todoTaskDto.getTaskEndTime());
		todoTask.setNotifyBeforeMinute(todoTaskDto.getNotifyBeforeMinute());
		todoTask.setTodoTaskStatus(todoTaskDto.getTodoTaskStatus());
		
    	return todoTaskRepository.save(todoTask);
    }
	
	@Override
	public void deleteTodoTask(long id) {
    	todoTaskRepository.delete(id);
    }
	
	@Override
	public TodoTask getTodoTask(long id) {
    	return todoTaskRepository.findOne(id);
    }
	
	@Override
	public List<TodoTask> getTodoTask(){
		try
		{
			String username = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
	    	return todoTaskRepository.getTodoTaskByUserName(username);	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
    }
	
	
}
