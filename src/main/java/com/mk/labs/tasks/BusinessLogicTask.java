package com.mk.labs.tasks;

import com.mk.labs.framework.GenericTask;
import com.mk.labs.framework.Task;
import com.mk.labs.framework.TaskContext;
import com.mk.labs.framework.TaskState;

/**
 * Add your business logic here
 * @author mk
 *
 */
public class BusinessLogicTask extends GenericTask<TaskContext> implements Task<TaskContext> {

    @Override
    protected TaskState execute(TaskContext ctx) throws Exception {
        // Execute your business logic here
        // ...
        // ...

        ctx.setState(TaskState.CONTINUE);
        return TaskState.CONTINUE;
    }
    
    @Override
    public boolean isRequired(TaskContext taskContext) {
        // Add your conditional logic to check if this task requires execution
        // ...
        return true;
    }

}
