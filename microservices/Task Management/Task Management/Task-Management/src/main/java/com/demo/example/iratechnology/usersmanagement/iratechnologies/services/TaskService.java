package com.demo.example.iratechnology.usersmanagement.iratechnologies.services;

import com.demo.example.iratechnology.usersmanagement.iratechnologies.dto.TaskDto;
import com.demo.example.iratechnology.usersmanagement.iratechnologies.entity.TaskEntity;

public interface TaskService {

    // TaskDto verify =checkCreatorExists(TaskDto taskDto);

    TaskDto creationOfTask(TaskDto taskDto);

    TaskDto updationOfTask(TaskDto taskDto);
    TaskDto checkStatusById(TaskEntity taskEntity);

    TaskDto verifyIfTimePresent(TaskEntity taskEntity);

}
