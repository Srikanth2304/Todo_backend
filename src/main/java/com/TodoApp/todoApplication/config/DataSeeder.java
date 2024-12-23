package com.TodoApp.todoApplication.config;

import com.TodoApp.todoApplication.model.Task;
import com.TodoApp.todoApplication.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {

    private final TaskRepository taskRepository;

    public DataSeeder(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        clear data before running
        taskRepository.deleteAll();
        Task task1 = new Task();
        task1.setTitle("task1");
        task1.setCompleted(true);

        Task task2 = new Task();
        task2.setTitle("task2");
        task2.setCompleted(false);

        Task task3 = new Task();
        task3.setTitle("task3");
        task3.setCompleted(false);

        taskRepository.saveAll(Arrays.asList(task1,task2,task3));
    }
}
