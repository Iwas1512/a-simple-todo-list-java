package org.example;

import java.util.HashSet;
import java.util.Set;

public class Task {
    private String description;
    private boolean isComplete;
    private Set<String> tags;

    public Task(String description) {
        this.description = description;
        this.isComplete = false;
        this.tags = new HashSet<>();
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
    
    public void addTag(String tag) {
        if (tag != null && !tag.trim().isEmpty()) {
            tags.add(tag.trim().toLowerCase());
        }
    }
    
    public boolean hasTag(String tag) {
        return tag != null && tags.contains(tag.trim().toLowerCase());
    }
    
    public Set<String> getTags() {
        return new HashSet<>(tags);  
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(isComplete ? "[Complete] " : "[Incomplete] ");
        sb.append(description);
        
        if (!tags.isEmpty()) {
            sb.append(" Tags: ");
            boolean first = true;
            for (String tag : tags) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append(tag);
                first = false;
            }
        }
        
        return sb.toString();
    }
}