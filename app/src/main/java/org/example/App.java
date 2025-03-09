package org.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        TodoList list = new TodoList();
        Scanner scanner = new Scanner(System.in);
        
        // Enable auto-flush for System.out
        System.out.println("Todo List Application Started");
        
        while (true) {
            System.out.println("\nTodo List Menu:");
            System.out.println("1. Add task");
            System.out.println("2. Complete task");
            System.out.println("3. View all tasks");
            System.out.println("4. View incomplete tasks");
            System.out.println("5. View completed tasks");
            System.out.println("6. Clear list");
            System.out.println("7. Add tag to a task");
            System.out.println("8. Filter tasks by tag");
            System.out.println("9. Exit");
            
            System.out.print("Enter your choice (1-9): ");
            System.out.flush(); 
            String choice = "";
            try {
                choice = scanner.nextLine().trim();
            } catch (Exception e) {
                System.err.println("Error reading input: " + e.getMessage());
                return; // Exit if it can't read input
            }
            
            switch (choice) {
                case "1":
                    System.out.print("Enter task description: ");
                    System.out.flush();
                    String taskDescription = "";
                    try {
                        taskDescription = scanner.nextLine().trim();
                    } catch (Exception e) {
                        System.err.println("Error reading input: " + e.getMessage());
                        continue;
                    }
                    
                    if (taskDescription.isEmpty()) {
                        System.out.println("Error: Task description cannot be empty.");
                    } else if (taskDescription.matches(".*\\d+.*")) {
                        System.out.println("Error: Task description should not contain numbers.");
                    } else if (taskDescription.length() < 3) {
                        System.out.println("Error: Task description must be at least 3 characters long.");
                    } else {
                        if (list.add(taskDescription)) {
                            System.out.println("Task added successfully!");
                            
                          
                            System.out.print("Would you like to add tags to this task? (yes/no): ");
                            String addTags = scanner.nextLine().trim().toLowerCase();
                            
                            if (addTags.equals("yes")) {
                                System.out.print("Enter tags (separated by commas): ");
                                String tagsInput = scanner.nextLine().trim();
                                String[] tags = tagsInput.split(",");
                                
                                for (String tag : tags) {
                                    list.addTag(taskDescription, tag);
                                }
                                System.out.println("Tags added successfully!");
                            }
                        }
                    }
                    break;
                
                case "2":
                    if (list.isEmpty()) {
                        System.out.println("No tasks to complete!");
                        break;
                    }
                    System.out.println("Current incomplete tasks:");
                    list.incomplete();
                    System.out.print("Enter task description to complete: ");
                    String taskToComplete = scanner.nextLine().trim();
                    if (taskToComplete.isEmpty()) {
                        System.out.println("Error: Please enter a valid task description.");
                    } else {
                        list.complete(taskToComplete);
                    }
                    break;
                
                case "3":
                    System.out.println("\nAll tasks:");
                    list.all();
                    break;
                
                case "4":
                    System.out.println("\nIncomplete tasks:");
                    list.incomplete();
                    break;
                
                case "5":
                    System.out.println("\nCompleted tasks:");
                    list.complete();
                    break;
                
                case "6":
                    if (list.isEmpty()) {
                        System.out.println("List is already empty!");
                    } else {
                        System.out.print("Are you sure you want to clear the list? (yes/no): ");
                        String confirmation = scanner.nextLine().trim().toLowerCase();
                        if (confirmation.equals("yes")) {
                            list.clear();
                        } else {
                            System.out.println("Clear operation cancelled.");
                        }
                    }
                    break;
                
                case "7":
                    if (list.isEmpty()) {
                        System.out.println("No tasks to tag!");
                        break;
                    }
                    
                    System.out.println("Current tasks:");
                    list.all();
                    
                    System.out.print("Enter task description to tag: ");
                    String taskToTag = scanner.nextLine().trim();
                    
                    if (taskToTag.isEmpty()) {
                        System.out.println("Error: Please enter a valid task description.");
                    } else if (!list.hasTask(taskToTag)) {
                        System.out.println("Task was not found: " + taskToTag);
                    } else {
                        System.out.print("Enter tag to add: ");
                        String tagToAdd = scanner.nextLine().trim();
                        
                        if (tagToAdd.isEmpty()) {
                            System.out.println("Error: Tag cannot be empty.");
                        } else {
                            list.addTag(taskToTag, tagToAdd);
                            System.out.println("Tag added successfully!");
                        }
                    }
                    break;
                
                case "8":
                    System.out.print("Enter tag to filter by: ");
                    String tagFilter = scanner.nextLine().trim();
                    
                    if (tagFilter.isEmpty()) {
                        System.out.println("Error: Please enter a valid tag.");
                    } else {
                        System.out.println("\nTasks with tag '" + tagFilter + "':");
                        list.filterByTag(tagFilter);
                    }
                    break;
                
                case "9":
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 9.");
            }
        }
    }
}