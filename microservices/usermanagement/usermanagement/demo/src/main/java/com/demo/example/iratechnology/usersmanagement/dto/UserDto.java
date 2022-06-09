package com.demo.example.iratechnology.usersmanagement.dto;

import org.springframework.stereotype.Component;

@Component
public class UserDto {

    private long id;
    private String creationcode;
    private String fname;
    private String lname;
    private String email;
    private String pswd;
    private String employeecode;
    private String userrole;
    private Boolean active;


    public UserDto(){

    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public String getCreationcode() {
        return creationcode;
    }


    public void setCreationcode(String creationcode) {
        this.creationcode = creationcode;
    }


    public String getFname() {
        return fname;
    }


    public void setFname(String fname) {
        this.fname = fname;
    }


    public String getLname() {
        return lname;
    }


    public void setLname(String lname) {
        this.lname = lname;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPswd() {
        return pswd;
    }


    public void setPswd(String pswd) {
        this.pswd = pswd;
    }


    public String getEmployeecode() {
        return employeecode;
    }


    public void setEmployeecode(String employeecode) {
        this.employeecode = employeecode;
    }


    public String getUserrole() {
        return userrole;
    }


    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }


    public Boolean getActive() {
        return active;
    }


    public void setActive(Boolean active) {
        this.active = active;
    }

}
