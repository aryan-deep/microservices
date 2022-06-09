package com.demo.example.iratechnology.usersmanagement.iratechnologies.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.stereotype.Component;

@Component
public class TaskDto {

    private Integer id;
    private String creatorid;
    private String creatorpswd;
    private String taskname;
    private String description;
    private String creationtime;
    private String completiontime;
    private String assignedto;
    private String status;
    private String startingtime;

    private String openornot;

    public TaskDto() {
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

    public void setStatus(String stat) {
        this.status = stat;
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

    @JsonIgnore
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

    /*
     * public String getUniqueid() {
     * return uniqueid;
     * }
     * 
     * public void setUniqueid(String uniqueid) {
     * this.uniqueid = uniqueid;
     * }
     */

    public String getOpenornot() {
        return openornot;
    }

    public void setOpenornot(String openornot) {
        this.openornot = openornot;
    }

}
