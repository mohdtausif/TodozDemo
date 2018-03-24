package com.tausif.todoz.dao;

import com.tausif.todoz.entity.TodoTask;
import com.tausif.todoz.entity.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoTaskRepository extends JpaRepository<TodoTask, Long> {
	@Query("SELECT t FROM TodoTask as t WHERE t.user.username=:username")
	public List<TodoTask> getTodoTaskByUserName(@Param("username") String username);
}
