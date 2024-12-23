package com.TodoApp.todoApplication.controller;

import com.TodoApp.todoApplication.model.Task;
import com.TodoApp.todoApplication.service.TaskService;
import jakarta.persistence.Table;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "http://localhost:5173")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasks(){
        return taskService.findAllTasks();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        Task savedTask = taskService.addTask(task);
        System.out.println("Saved Task: " + savedTask);
        return savedTask;
    }


    @DeleteMapping("{task_id}/delete")
    public List<Task> deleteTask(@PathVariable Long task_id ){
        taskService.removeTask(task_id);
        return taskService.findAllTasks();
    }

    @PutMapping("{task_id}/update")
    public List<Task> updateTask(@PathVariable Long task_id , @RequestBody String title){
        taskService.changeTask(task_id,title);
        return taskService.findAllTasks();
    }

    @PutMapping("{task_id}/toggle")
    public List<Task> toggleTask(@PathVariable Long task_id){
        taskService.alterTask(task_id);
        return taskService.findAllTasks();
    }

}
