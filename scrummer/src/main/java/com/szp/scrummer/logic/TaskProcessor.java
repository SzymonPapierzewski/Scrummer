package com.szp.scrummer.logic;

import com.szp.scrummer.comminication.dto.TaskAddDTO;
import com.szp.scrummer.database.task.Task;
import com.szp.scrummer.database.task.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class TaskProcessor {

    @Autowired
    TaskRepository taskRepository;

    public Task addTask(TaskAddDTO taskAddDTO) {
        Task taskToAdd = new Task(taskAddDTO);
        return taskRepository.save(taskToAdd);
    }

    public List<Task> getTasks() {
        LinkedList<Task> result = new LinkedList<>();
        taskRepository.findAll().forEach(result::add);

        return result;
    }

    public List<Task> getAssignedTasks(String login) {
        LinkedList<Task> result = new LinkedList<>();
//        taskRepository.findAllByLogin().forEach(result::add);

        return result;
    }
}
