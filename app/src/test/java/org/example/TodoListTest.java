package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TodoListTest {
    @Test
    public void testAddTask() {
        TodoList todoList = new TodoList();
        todoList.add("Test task");
        assertTrue(todoList.hasTask("Test task"));
        assertEquals(1, todoList.size());
    }

    @Test
    public void testCompleteTask() {
        TodoList todoList = new TodoList();
        todoList.add("Test task");
        todoList.complete("Test task");
        assertTrue(todoList.isTaskComplete("Test task"));
    }

    @Test
    public void testCompleteNonExistentTask() {
        TodoList todoList = new TodoList();
        assertFalse(todoList.hasTask("Nonexistent task"));
        assertEquals(0, todoList.size());
    }

    @Test
    public void testClearList() {
        TodoList todoList = new TodoList();
        todoList.add("Task 1");
        todoList.add("Task 2");
        assertEquals(2, todoList.size());
        
        todoList.clear();
        assertTrue(todoList.isEmpty());
        assertEquals(0, todoList.size());
    }

    @Test
    public void testMultipleTasks() {
        TodoList todoList = new TodoList();
        todoList.add("Task 1");
        todoList.add("Task 2");
        todoList.complete("Task 1");
        
        assertTrue(todoList.isTaskComplete("Task 1"));
        assertFalse(todoList.isTaskComplete("Task 2"));
        assertEquals(2, todoList.size());
    }

    @Test
    public void testIncompleteTasksList() {
        TodoList todoList = new TodoList();
        todoList.add("Task 1");
        todoList.add("Task 2");
        todoList.complete("Task 1");
        
        assertTrue(todoList.hasTask("Task 2"));
        assertFalse(todoList.isTaskComplete("Task 2"));
    }

    @Test
    public void testCompletedTasksList() {
        TodoList todoList = new TodoList();
        todoList.add("Task 1");
        todoList.add("Task 2");
        todoList.complete("Task 1");
        
        assertTrue(todoList.hasTask("Task 1"));
        assertTrue(todoList.isTaskComplete("Task 1"));
    }

    @Test
    public void testAllTasksList() {
        TodoList todoList = new TodoList();
        todoList.add("Task 1");
        todoList.add("Task 2");
        
        assertEquals(2, todoList.size());
        assertTrue(todoList.hasTask("Task 1"));
        assertTrue(todoList.hasTask("Task 2"));
    }

    @Test
    public void testNewListIsEmpty() {
        TodoList todoList = new TodoList();
        assertTrue(todoList.isEmpty());
        assertEquals(0, todoList.size());
    }

    @Test
    public void testCompletingAllTasks() {
        TodoList todoList = new TodoList();
        todoList.add("Task 1");
        todoList.add("Task 2");
        
        todoList.complete("Task 1");
        todoList.complete("Task 2");
        
        assertTrue(todoList.isTaskComplete("Task 1"));
        assertTrue(todoList.isTaskComplete("Task 2"));
    }
}