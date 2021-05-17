package com.szp.scrummer.database.meeting;

import com.szp.scrummer.database.meetinParticipation.MeetingParticipation;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column(name = "cycle_type")
    private String cycleType;

    @Column(name = "start_time")
    private Timestamp startTime;

    @Column(name = "end_time")
    private Timestamp endTime;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "meeting")
    private List<MeetingParticipation> meetingParticipations;

    public Meeting() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getCycleType() {
        return cycleType;
    }

    public void setCycleType(String cycleType) {
        this.cycleType = cycleType;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public List<MeetingParticipation> getMeetingParticipations() {
        return meetingParticipations;
    }

    public void setMeetingParticipations(List<MeetingParticipation> meetingParticipations) {
        this.meetingParticipations = meetingParticipations;
    }
}
