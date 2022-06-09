package com.demo.example.iratechnology.usersmanagement.iratechnologies.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task_entity")

public class TaskEntity {

    // private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "creator_id", nullable = false, length = 20)
    private String creatorid;
    @Column(name = "creation_pswd", nullable = false, length = 20)
    private String creatorpswd;
    @Column(name = "task_name", nullable = false, length = 20)
    private String taskname;
    @Column(name = "description", nullable = false, length = 50)
    private String description;
    @Column(name = "creation_time")
    private String creationtime;
    @Column(name = "completion_time")
    private String completiontime;
    @Column(name = "starting_time")
    private String startingtime;
    @Column(name = "assigned_to", nullable = false, length = 20)
    private String assignedto;
    @Column(name = "status")
    private String status;
    @Column(name = "openornot")
    private String openornot;

    public TaskEntity(Integer id, String creatorid, String creatorpswd, String taskname, String description,
            String creationtime, String completiontime, String startingtime, String assignedto, String status,
            String openornot) {
        this.id = id;
        this.creatorid = creatorid;
        this.creatorpswd = creatorpswd;
        this.taskname = taskname;
        this.description = description;
        this.creationtime = creationtime;
        this.completiontime = completiontime;
        this.startingtime = startingtime;
        this.assignedto = assignedto;
        this.status = status;
        this.openornot = openornot;
    }

    public TaskEntity() {
    }

    public String getStartingtime() {
        return startingtime;
    }

    public void setStartingtime(String startingtime) {
        this.startingtime = startingtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreatorid() {
        return creatorid;
    }

    public void setCreatorid(String creatorid) {
        this.creatorid = creatorid;
    }

    public String getCreatorpswd() {
        return creatorpswd;
    }

    public void setCreatorpswd(String creatorpswd) {
        this.creatorpswd = creatorpswd;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(String creationtime) {
        this.creationtime = creationtime;
    }

    public String getCompletiontime() {
        return completiontime;
    }

    public void setCompletiontime(String completiontime) {
        this.completiontime = completiontime;
    }

    public String getAssignedto() {
        return assignedto;
    }

    public void setAssignedto(String assignedto) {
        this.assignedto = assignedto;
    }

    public String getOpenornot() {
        return openornot;
    }

    public void setOpenornot(String openornot) {
        this.openornot = openornot;
    }

}
