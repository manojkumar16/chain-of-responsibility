package com.mk.labs.framework;

import java.util.List;

/**
 * Contract that requires Implementator to follow when building and executing list of tasks based on
 * chain of responsibility design pattern
 * 
 * @author mk
 *
 */
public interface Handler {

    void buildChain(List<Task<TaskContext>> tasks);

    void performTask(TaskContext ctx);
}
