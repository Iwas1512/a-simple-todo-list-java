package org.example;

public class Task {
    private String description;
    private boolean isComplete;

    public Task(String description) {
        this.description = description;
        this.isComplete = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void complete() {
        this.isComplete = true;
    }

    @Override
    public String toString() {
        return (isComplete ? "[Complete] " : "[Incomplete] ") + description;
    }
}
