package org.example;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private ArrayList<Task> tasks;

    public TodoList() {
        tasks = new ArrayList<>();
    }

  
    public boolean add(String taskDescription) {
        // we reject blank tasks here
        if (taskDescription == null || taskDescription.trim().isEmpty()) {
            System.out.println("Error: Task description cannot be empty.");
            return false;
        }
        
        //we reject duplicate tasks that are incomplete here
        for (Task task : tasks) {
            if (task.getDescription().equals(taskDescription) && !task.isComplete()) {
                System.out.println("Error: An incomplete task with this description already exists.");
                return false;
            }
        }
        
        tasks.add(new Task(taskDescription));
        return true;
    }
    
  
    public boolean addTag(String taskDescription, String tag) {
        if (tag == null || tag.trim().isEmpty()) {
            System.out.println("Error: Tag cannot be empty.");
            return false;
        }
        
        for (Task task : tasks) {
            if (task.getDescription().equals(taskDescription)) {
                task.addTag(tag);
                return true;
            }
        }
        
        System.out.println("Task was not found: " + taskDescription);
        return false;
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
    
    
     //Filter tasks by tag 
    
    public void filterByTag(String tag) {
        if (tag == null || tag.trim().isEmpty()) {
            System.out.println("Error: Tag cannot be empty.");
            return;
        }
        
        boolean found = false;
        for (Task task : tasks) {
            if (task.hasTag(tag.trim().toLowerCase())) {
                System.out.println(task);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No tasks found with tag: " + tag);
        }
    }

    public void clear() {
        tasks.clear();
        System.out.println("The todo list is cleared now.");
    }

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
    
    //tags 
    public List<String> getTaskTags(String description) {
        for (Task task : tasks) {
            if (task.getDescription().equals(description)) {
                return new ArrayList<>(task.getTags());
            }
        }
        return new ArrayList<>();
    }
}