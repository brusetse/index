package com.bruse.activiti;

import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyRestController {

    @Autowired
    private MyService myService;

    @RequestMapping("/process")
    public void startProcessInstance(String process) {
        myService.startProcess(process);
    }

    @RequestMapping("/tasks")
    public Object getTasks(String assignee) {
        List<Task> tasks = myService.getTasks(assignee);
        List<TaskRepresentation> dtos = new ArrayList<>();
        for (Task task : tasks) {
            dtos.add(new TaskRepresentation(task.getId(), task.getName()));
        }
        return dtos;
    }

    @RequestMapping("/complete")
    public void completeTask(String taskId) {
        myService.completeTask(taskId);
    }

    @RequestMapping("/processInstance")
    public Object getProcessInstance(String processInstanceId) {
        ProcessInstance processInstance = myService.getProcessInstance(processInstanceId);
        return processInstance == null;
    }

    static class TaskRepresentation {

        private String id;
        private String name;

        TaskRepresentation(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

    }
}
