package com.mk.labs.framework;

import java.util.HashMap;
import java.util.Map;

/**
 * Context attached to business unit
 * 
 * @author mk
 *
 */
public class TaskContext {

    private String name;

    private TaskState state;

    private Map<String, Object> contextProperties = new HashMap<String, Object>();

    public TaskContext(String name, TaskState state) {
        super();
        this.name = name;
        this.state = state;
    }

    public TaskState getState() {
        return state;
    }

    public void setState(TaskState state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public Map<String, Object> getContextProperties() {
        return contextProperties;
    }
    
}
