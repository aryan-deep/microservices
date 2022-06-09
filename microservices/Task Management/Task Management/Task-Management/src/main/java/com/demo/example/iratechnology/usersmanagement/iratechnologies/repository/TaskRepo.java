package com.demo.example.iratechnology.usersmanagement.iratechnologies.repository;

//import com.demo.example.iratechnology.usersmanagement.iratechnologies.dto.TaskDto;
import com.demo.example.iratechnology.usersmanagement.iratechnologies.entity.TaskEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends JpaRepository<TaskEntity, Integer> {

  //  public TaskDto getByCreatorId(String creatorid);// delete it aftrr mapping entity

    //public TaskDto check(Integer id);

}
