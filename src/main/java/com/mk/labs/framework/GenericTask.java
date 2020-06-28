package com.mk.labs.framework;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * Pick up next task and trigger its execution if all criteria are met
 * 
 * @author mk
 *
 * @param <T>
 */
@Data
@Slf4j
public abstract class GenericTask<T> implements Task<T> {
    private Task<T> next;
    protected String taskName;

    @Override
    public void performTask(T taskContext) throws Exception {

        if (isRequired(taskContext)) {
            log.info("Executing task -> {}", this.taskName);
            execute(taskContext);
            log.info("Executed task -> {}", this.taskName);
        } else {
            log.info("Skipped task -> {}", this.taskName);
        }

        /**
         * Trigger next node if there exist one in chain
         */
        if (next != null) {
            next.performTask(taskContext);
        }
    }

    protected abstract TaskState execute(T taskContext) throws Exception;

    @Override
    public void setNextTask(Task<T> next) {
        this.next = next;
    }

    @Override
    public Task<T> getNextTask() {
        return this.next;
    }

    @Override
    public Task<T> withTaskName(String name) {
        this.taskName = name;
        return this;
    }

    @Override
    public String getTaskName() {
        return this.taskName;
    }

    @Override
    public boolean isRequired(T taskContext) {
        return taskContext != null;
    }

    @Override
    public String toString() {
        return this.taskName;
    }
}
