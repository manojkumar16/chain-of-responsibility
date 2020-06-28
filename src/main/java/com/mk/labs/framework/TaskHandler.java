package com.mk.labs.framework;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author mk
 *
 */
@Slf4j
public class TaskHandler implements Handler {

    private List<Task<TaskContext>> tasks;

    public TaskHandler(List<Task<TaskContext>> tasks) {
        buildChain(tasks);
    }

    @Override
    public void buildChain(List<Task<TaskContext>> tasks) {
        if (tasks == null || tasks.isEmpty()) {
            log.info("Chain can not be built.");
            return;
        }

        // build chain
        for (int i = 0; i < tasks.size() - 1; i++) {
            tasks.get(i).setNextTask(tasks.get(i + 1));
        }

        this.tasks = tasks;
        log.info("Chain is built successfully {}", this.tasks);
    }

    @Override
    public void performTask(TaskContext ctx) {
        try {
            if (tasks != null && tasks.size() > 0) {
                tasks.get(0).performTask(ctx);
            }
        } catch (Exception e) {
            ctx.setState(TaskState.FAILED);// task execution failed.
            e.printStackTrace();
        }
    }

}
