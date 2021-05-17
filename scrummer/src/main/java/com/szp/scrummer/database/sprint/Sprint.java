package com.szp.scrummer.database.sprint;

import com.szp.scrummer.database.project.Project;
import com.szp.scrummer.database.task.Task;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Sprint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "begin_date")
    private Timestamp beginDate;

    @Column(name = "end_date")
    private Timestamp endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sprint")
    private List<Task> sprintBacklog;

    public Sprint() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Timestamp beginDate) {
        this.beginDate = beginDate;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Task> getSprintBacklog() {
        return sprintBacklog;
    }

    public void setSprintBacklog(List<Task> sprintBacklog) {
        this.sprintBacklog = sprintBacklog;
    }
}
