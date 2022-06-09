package com.demo.example.iratechnology.usersmanagement.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "user")
public class UserEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private long id;
    @Column(name="creation_code", nullable = false, length = 30)
    private String creationcode;
    @Column(name="user_fname", nullable = false, length = 30)
    private String fname;
    @Column(name="user_lname",nullable = false, length = 30)
    private String lname;
    @Column(name="user_email",nullable=false, length=50)
    private String email;
    @Column(name="user_pswd",nullable=false, length=20)
    private String pswd;
    @Column(name="employee_code")
    private String employeecode;
    @Column(name="User_designation")
    private String userrole;
    @Column(name="user_active_status")
    private Boolean active;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles;

    public UserEntity() {
    }

    public UserEntity(long id, String creationcode, String fname, String lname, String email, String pswd,
            String employeecode, String userrole, Boolean active, Set<RoleEntity> roles) {
        this.id = id;
        this.creationcode = creationcode;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.pswd = pswd;
        this.employeecode = employeecode;
        this.userrole = userrole;
        this.active = active;
        this.roles = roles;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
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

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }

    

    
}
