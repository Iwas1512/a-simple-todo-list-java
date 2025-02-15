package org.example;

import java.util.ArrayList;

public class TodoList {
    private ArrayList<Task> tasks;

    public TodoList() {
        tasks = new ArrayList<>();
    }

    public void add(String taskDescription) {
        tasks.add(new Task(taskDescription));
    }

    public void complete(String taskDescription) {
        for (Task task : tasks) {
            if (task.getDescription().equals(taskDescription)) {
                task.complete();
                return;
            }
        }
        System.out.println("Task was not found: " + taskDescription);
    }

    public void all() {
        if (tasks.isEmpty()) {
            System.out.println("Our to do list list is empty, all done :) .");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    public void complete() {
        boolean found = false;
        for (Task task : tasks) {
            if (task.isComplete()) {
                System.out.println(task);
                found = true;
            }
        }
        if (!found) {
            System.out.println("None of the tasks are complete.");
        }
    }

    public void incomplete() {
        boolean found = false;
        for (Task task : tasks) {
            if (!task.isComplete()) {
                System.out.println(task);
                found = true;
            }
        }
        if (!found) {
            System.out.println("None of the tasks are incomplete.");
        }
    }

    public void clear() {
        tasks.clear();
        System.out.println("The todo list is cleared now.");
    }

    //further helper methods for easier testing 
    public boolean isEmpty() {
        return tasks.isEmpty();
    }

    public int size() {
        return tasks.size();
    }

    public boolean hasTask(String description) {
        for (Task task : tasks) {
            if (task.getDescription().equals(description)) {
                return true;
            }
        }
        return false;
    }

    public boolean isTaskComplete(String description) {
        for (Task task : tasks) {
            if (task.getDescription().equals(description)) {
                return task.isComplete();
            }
        }
        return false;
    }
}