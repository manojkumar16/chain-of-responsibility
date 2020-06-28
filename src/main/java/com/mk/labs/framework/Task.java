package com.mk.labs.framework;

/**
 * An activity unit in a chain of responsibility pattern. The
 * handler(Task) builds chain by connecting provided number of
 * Task nodes.
 * 
 * A chain is practically a singly linked list where execution starts from head
 * and stops at tail.
 * 
 * Ex. A->B->C->D->E->F where A,B,C,D,E,F are Tasks.
 * 
 * @author mk
 *
 * @param <T>
 */
public interface Task<T> {

    /**
     * Execute task on current node
     * 
     */
    void performTask(T taskContext) throws Exception;

    void setNextTask(Task<T> next);

    Task<T> getNextTask();

    Task<T> withTaskName(String TaskName);

    String getTaskName();

    /**
     * Is execution on current node required?  
     * 
     */
    boolean isRequired(T taskContext);
}
