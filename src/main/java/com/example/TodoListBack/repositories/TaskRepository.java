package com.example.TodoListBack.repositories;


import com.example.TodoListBack.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("select t from Task t where t.user.id= ?1")
    List<Task> findByUser(Long id);
}
