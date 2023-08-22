package com.example.TodoListBack.repositories;


import com.example.TodoListBack.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
