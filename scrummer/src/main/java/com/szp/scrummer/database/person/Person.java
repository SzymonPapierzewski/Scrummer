package com.szp.scrummer.database.person;

import com.szp.scrummer.database.meetinParticipation.MeetingParticipation;
import com.szp.scrummer.database.skill.Skill;
import com.szp.scrummer.database.task.Task;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String login;

    @Column
    private String password;

    @Column
    private String role;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<Task> assignedTasks;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<MeetingParticipation> meetingParticipations;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private List<Skill> skills;

    public Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Task> getAssignedTasks() {
        return assignedTasks;
    }

    public void setAssignedTasks(List<Task> assignedTasks) {
        this.assignedTasks = assignedTasks;
    }

    public List<MeetingParticipation> getMeetingParticipations() {
        return meetingParticipations;
    }

    public void setMeetingParticipations(List<MeetingParticipation> meetingParticipations) {
        this.meetingParticipations = meetingParticipations;
    }
}
