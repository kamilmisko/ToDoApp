package com.project.todolist.controller;

import com.project.todolist.entity.Task;
import com.project.todolist.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        super();
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public String taskList(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "tasks";
    }

    @GetMapping("/tasks/new")
    public String createTask(Model model) {
        Task task = new Task();
        model.addAttribute("task", task);
        return "create_task";
    }

    @PostMapping("/tasks")
    public String saveTask(@ModelAttribute("task") Task task) {
        taskService.saveTask(task);
        return "redirect:/tasks";
    }
    @GetMapping("/tasks/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        model.addAttribute("task", taskService.getTaskById(id));
        return "edit_task";
    }

    @PostMapping("/tasks/{id}")
    public String updateTask(@PathVariable Long id,
                             @ModelAttribute("task") Task task,
                             Model model) {

        Task exsistingTask = taskService.getTaskById(id);
        exsistingTask.setId(id);
        exsistingTask.setTaskName(task.getTaskName());
        exsistingTask.setTaskDescription(task.getTaskDescription());
        exsistingTask.setDate(task.getDate());

        taskService.updateTask(exsistingTask);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.finishTask(id);
        return "redirect:/tasks";
    }
}
