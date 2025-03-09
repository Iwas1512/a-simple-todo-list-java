package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExtendedTodoListTest {
    
    @Test
    public void testRejectBlankTask() {
        TodoList todoList = new TodoList();
        boolean result = todoList.add("");
        
        assertFalse(result);
        assertEquals(0, todoList.size());
    }
    
    @Test
    public void testRejectDuplicateIncompleteTasks() {
        TodoList todoList = new TodoList();
        
       
        boolean result1 = todoList.add("Test task");
        assertTrue(result1);
        assertEquals(1, todoList.size());
        
        
        boolean result2 = todoList.add("Test task");
        assertFalse(result2);
        assertEquals(1, todoList.size());
    }
    
    @Test
    public void testAllowDuplicateAfterCompletion() {
        TodoList todoList = new TodoList();
        
        
        todoList.add("Test task");
        todoList.complete("Test task");
        assertTrue(todoList.isTaskComplete("Test task"));
        
    
        boolean result = todoList.add("Test task");
        assertTrue(result);
        assertEquals(2, todoList.size());
    }
    
    @Test
    public void testAddingAndFilteringByTag() {
        TodoList todoList = new TodoList();
        
        todoList.add("Work meeting");
        todoList.add("Buy groceries");
        
        todoList.addTag("Work meeting", "work");
        todoList.addTag("Work meeting", "important");
        todoList.addTag("Buy groceries", "personal");
        
        
        assertTrue(todoList.getTaskTags("Work meeting").contains("work"));
        assertTrue(todoList.getTaskTags("Work meeting").contains("important"));
        assertTrue(todoList.getTaskTags("Buy groceries").contains("personal"));
        assertEquals(2, todoList.getTaskTags("Work meeting").size());
        assertEquals(1, todoList.getTaskTags("Buy groceries").size());
    }
}