package com.mk.labs.tasks;

import com.mk.labs.framework.GenericTask;
import com.mk.labs.framework.TaskContext;
import com.mk.labs.framework.TaskState;

/**
 * Validate input data
 * 
 * @author mk
 *
 */
public class InputValidationTask extends GenericTask<TaskContext> {

    @Override
    protected TaskState execute(TaskContext taskContext) throws Exception {
        // Validate your input data
        // ...
        // ...

        taskContext.setState(TaskState.CONTINUE);
        return TaskState.CONTINUE;
    }

    @Override
    public boolean isRequired(TaskContext taskContext) {
        // Add your conditional logic to check if this task requires execution
        return true;
    }

}
