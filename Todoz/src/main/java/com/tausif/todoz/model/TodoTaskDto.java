package com.tausif.todoz.model;

import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.tausif.todoz.entity.User;

public class TodoTaskDto {
	
	private long id;
	private String detail;
    private int priority;
    private Date taskStartTime;
    private Date taskEndTime;
    private int notifyBeforeMinute;
    private TodoTaskStatus todoTaskStatus;
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public Date getTaskStartTime() {
		return taskStartTime;
	}
	public void setTaskStartTime(Date taskStartTime) {
		this.taskStartTime = taskStartTime;
	}
	public Date getTaskEndTime() {
		return taskEndTime;
	}
	public void setTaskEndTime(Date taskEndTime) {
		this.taskEndTime = taskEndTime;
	}
	public int getNotifyBeforeMinute() {
		return notifyBeforeMinute;
	}
	public void setNotifyBeforeMinute(int notifyBeforeMinute) {
		this.notifyBeforeMinute = notifyBeforeMinute;
	}
	public TodoTaskStatus getTodoTaskStatus() {
		return todoTaskStatus;
	}
	public void setTodoTaskStatus(TodoTaskStatus todoTaskStatus) {
		this.todoTaskStatus = todoTaskStatus;
	}
    
    
}
