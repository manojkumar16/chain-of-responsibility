package com.mk.labs.tasks;

import com.mk.labs.framework.GenericTask;
import com.mk.labs.framework.TaskContext;
import com.mk.labs.framework.TaskState;

/**
 * Do something with result of executing your business logic
 * 
 * Override of isRequired() function is not required if assumption is to execute this task always...
 * 
 * @author mk
 *
 */
public class ResultTask extends GenericTask<TaskContext> {

    @Override
    protected TaskState execute(TaskContext taskContext) throws Exception {
        // Execute task to store/render/send/etc... result of executing your business logic
        // ...
        // ...

        // Return task's final state(SUCCESS/FAIL), assuming this is last task to execute in the
        // chain
        taskContext.setState(TaskState.SUCCESS);
        return TaskState.SUCCESS;
    }
}
