package com.szp.scrummer.database.project;

import com.szp.scrummer.database.sprint.Sprint;
import com.szp.scrummer.database.task.Task;

import javax.persistence.*;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "working_in_pairs_support")
    private boolean workingInPairsSupport;

    @Column(name = "check_testing_support")
    private boolean checkTestingSupport;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private List<Sprint> sprints;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private List<Task> productBacklog;

    public Project() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isWorkingInPairsSupport() {
        return workingInPairsSupport;
    }

    public void setWorkingInPairsSupport(boolean workingInPairsSupport) {
        this.workingInPairsSupport = workingInPairsSupport;
    }

    public boolean isCheckTestingSupport() {
        return checkTestingSupport;
    }

    public void setCheckTestingSupport(boolean checkTestingSupport) {
        this.checkTestingSupport = checkTestingSupport;
    }

    public List<Sprint> getSprints() {
        return sprints;
    }

    public void setSprints(List<Sprint> sprints) {
        this.sprints = sprints;
    }

    public List<Task> getProductBacklog() {
        return productBacklog;
    }

    public void setProductBacklog(List<Task> productBacklog) {
        this.productBacklog = productBacklog;
    }
}
