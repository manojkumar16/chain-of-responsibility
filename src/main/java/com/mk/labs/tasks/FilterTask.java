package com.mk.labs.tasks;

import com.mk.labs.framework.GenericTask;
import com.mk.labs.framework.TaskContext;
import com.mk.labs.framework.TaskState;

/**
 * Filter unwanted data
 * 
 * @author mk
 *
 */
public class FilterTask extends GenericTask<TaskContext> {

    @Override
    protected TaskState execute(TaskContext taskContext) throws Exception {
        // Execute task to filter your data
        // ...
        // ...
        return TaskState.CONTINUE;
    }

    @Override
    public boolean isRequired(TaskContext ctx) {
        // Add your conditional logic to check if this task requires execution
        // Intentionally I have decided to not execute this task
        return false;
    }
}
