package com.mk.labs.main;

import java.util.ArrayList;
import java.util.List;

import com.mk.labs.framework.Task;
import com.mk.labs.framework.TaskContext;
import com.mk.labs.framework.TaskHandler;
import com.mk.labs.framework.TaskState;
import com.mk.labs.tasks.BusinessLogicTask;
import com.mk.labs.tasks.FilterTask;
import com.mk.labs.tasks.InputValidationTask;
import com.mk.labs.tasks.ResultTask;

import lombok.extern.slf4j.Slf4j;

/**
 * Entry point of business unit that requires set of tasks to be completed to make
 * execution completed as a whole.
 * 
 * @author mk
 *
 */
@Slf4j
public class BusinessEntryPoint {

    public static void main(String[] args) {

        // We receive a task that needs to be executed
        Object taskObject = new Object();

        //Object ctx = new Object();

        List<Task<TaskContext>> tasks = new ArrayList<>();

        // Add all tasks...
        tasks.add(new InputValidationTask().withTaskName("InputValidation"));
        tasks.add(new FilterTask().withTaskName("Filter"));
        tasks.add(new BusinessLogicTask().withTaskName("BusinessLogic"));
        tasks.add(new ResultTask().withTaskName("Result"));

        // Link all tasks...
        TaskHandler handler = new TaskHandler(tasks);
        
        // Build context object to hold configuration, properties etc.
        // Initial context config may update as we go along in the change
        TaskContext ctx = new TaskContext("businessUnit-123", TaskState.CONTINUE);

        // Initial task object and it's state will update as we go along in the change
        ctx.getContextProperties().put("taskObject", taskObject);

        log.info("Starting business [{}]", ctx.getName());
        handler.performTask(ctx);
        log.info("Business [{}] executed with state - {}", ctx.getName(), ctx.getState());
    }
}
