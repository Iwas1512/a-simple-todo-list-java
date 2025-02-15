package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void testTaskCreation() {
        Task task = new Task("Test Task");
        assertNotNull(task);
        assertEquals("Test Task", task.getDescription());
        assertFalse(task.isComplete());
    }

    @Test
    void testCompleteTask() {
        Task task = new Task("Test Task");
        task.complete();
        assertTrue(task.isComplete());
    }

    @Test
    void testToString() {
        Task task = new Task("Test Task");
        assertEquals("[Incomplete] Test Task", task.toString());

        task.complete();
        assertEquals("[Complete] Test Task", task.toString());
    }
}
