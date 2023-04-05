package com.project.todolist.service;

import com.project.todolist.entity.Task;
import com.project.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TaskService {

    List<Task> getAllTasks();

    Task saveTask(Task task);

    Task updateTask(Task task);

    Task getTaskById(Long id);

    void finishTask(Long id);

}
