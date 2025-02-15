package org.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        TodoList list = new TodoList();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nTodo List Menu:");
            System.out.println("1. Add task");
            System.out.println("2. Complete task");
            System.out.println("3. View all tasks");
            System.out.println("4. View incomplete tasks");
            System.out.println("5. View completed tasks");
            System.out.println("6. Clear list");
            System.out.println("7. Exit");
            
            System.out.print("Enter your choice (1-7): ");
            String choice = scanner.nextLine().trim();
            
            switch (choice) {
                case "1":
                    System.out.print("Enter task description: ");
                    String taskDescription = scanner.nextLine().trim();
                    
                   
                    if (taskDescription.isEmpty()) {
                        System.out.println("Error: Task description cannot be empty.");
                    } else if (taskDescription.matches(".*\\d+.*")) {
                        System.out.println("Error: Task description should not contain numbers.");
                    } else if (taskDescription.length() < 3) {
                        System.out.println("Error: Task description must be at least 3 characters long.");
                    } else {
                        list.add(taskDescription);
                        System.out.println("Task added successfully!");
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
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 7.");
            }
        }
    }
}