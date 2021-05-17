package com.szp.mobilescrummer.data.database.task;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "task")
public class Task {
    @PrimaryKey(autoGenerate = false)
    private int id;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "effort_hours")
    private long effortHours;

    public Task(int id, String title, String description, long effortHours) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.effortHours = effortHours;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getEffortHours() {
        return effortHours;
    }

    public void setEffortHours(long effortHours) {
        this.effortHours = effortHours;
    }
}

