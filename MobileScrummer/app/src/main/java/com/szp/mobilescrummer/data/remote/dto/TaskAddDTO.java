package com.szp.mobilescrummer.data.remote.dto;

public class TaskAddDTO {
    public String title;
    public String description;
    public Long effortHours;

    public TaskAddDTO(String title, String description, Long effortHours) {
        this.title = title;
        this.description = description;
        this.effortHours = effortHours;
    }
}
