package com.tausif.todoz.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;

import com.tausif.todoz.model.TodoTaskStatus;

@Entity
@Table(name = "td_todotask")
public class TodoTask extends BaseEntity<String>
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@OneToOne
    @JoinColumn(name="user_id")
	private User user;
	
    private String detail;
    private int priority;
    private Date taskStartTime;
    private Date taskEndTime;
    private int notifyBeforeMinute;
    
    @Enumerated(EnumType.STRING)
    private TodoTaskStatus todoTaskStatus;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
