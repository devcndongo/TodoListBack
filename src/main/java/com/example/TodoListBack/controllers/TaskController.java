package com.example.TodoListBack.controllers;


import com.example.TodoListBack.entities.Task;
import com.example.TodoListBack.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Task>> getAllTasks(@PathVariable Long id) {
        List<Task> tasks = taskService.getAllTasks(id);
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {

        Optional<Task> task = taskService.getTaskById(id);
        return task.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        try{
            Task savedTask = taskService.saveTask(task);

            return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
        }catch (Exception e ){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        if (!taskService.getTaskById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        task.setId(id);
        Task updatedTask = taskService.saveTask(task);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        if (!taskService.getTaskById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
