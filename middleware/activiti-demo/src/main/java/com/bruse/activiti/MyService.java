package com.bruse.activiti;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MyService {

    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    /**
     * 启动流程实例
     * @param process
     */
    public void startProcess(String process) {
        runtimeService.startProcessInstanceByKey(process);
    }

    /**
     * 查看个人任务
     * @param assignee
     * @return
     */
    public List<Task> getTasks(String assignee) {
        return taskService.createTaskQuery().taskAssignee(assignee).list();
    }

    /**
     * 办理任务
     * @param taskId
     */
    public void completeTask(String taskId) {
        taskService.complete(taskId);
    }

    /**
     * 查看流程实例
     * @param processInstanceId
     * @return
     */
    public ProcessInstance getProcessInstance(String processInstanceId) {
        return runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
    }
}
