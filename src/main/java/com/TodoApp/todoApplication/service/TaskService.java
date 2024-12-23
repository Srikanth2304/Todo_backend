package com.TodoApp.todoApplication.service;

import com.TodoApp.todoApplication.model.Task;
import com.TodoApp.todoApplication.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public void removeTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

    public void changeTask(Long taskId, String title) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + taskId));
        task.setTitle(title);
        taskRepository.save(task);
    }

    public void alterTask(Long task_id) {
        Task task = taskRepository.findById(task_id).orElseThrow(() -> new RuntimeException("Task not found with id: " + task_id));
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }
}
