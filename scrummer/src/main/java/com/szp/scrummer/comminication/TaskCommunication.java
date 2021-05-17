package com.szp.scrummer.comminication;

import com.szp.scrummer.comminication.dto.TaskAddDTO;
import com.szp.scrummer.database.task.Task;
import com.szp.scrummer.logic.TaskProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskCommunication {

    @Autowired
    private TaskProcessor taskProcessor;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
    public List<Task> getAll() {
        return taskProcessor.getTasks();
    }

    @RequestMapping(value = "/getAssignedTasks", method = RequestMethod.GET, produces = "application/json")
    public List<Task> getAssignedTasks(@RequestParam(value = "login") String login) {
        return taskProcessor.getAssignedTasks(login);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public Task add(@RequestBody TaskAddDTO taskAddDTO) {
        return taskProcessor.addTask(taskAddDTO);
    }
}
