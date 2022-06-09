package com.demo.example.iratechnology.usersmanagement.iratechnologies.controller;

import java.util.Optional;

import com.demo.example.iratechnology.usersmanagement.iratechnologies.dto.TaskDto;
import com.demo.example.iratechnology.usersmanagement.iratechnologies.entity.TaskEntity;
import com.demo.example.iratechnology.usersmanagement.iratechnologies.repository.TaskRepo;
import com.demo.example.iratechnology.usersmanagement.iratechnologies.services.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskRepo taskRepo;

    @Autowired (required=true)
    private TaskService taskService;

    @PutMapping(value = "/creation")
    public ResponseEntity<?> creation(@RequestBody TaskDto taskDto) {
        try {
            TaskDto taskDto2 = taskService.creationOfTask(taskDto);

            if (taskDto2 != null) {
                return new ResponseEntity<>(taskDto2, HttpStatus.CREATED);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Not a valid Task");
            }

        } catch (Exception e) {
            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("exception occured");

        }
    }

   
   
    
    @PostMapping(value="/workerupdation/{id}")
    public ResponseEntity<?> workerUpdation(@PathVariable Integer id){
        try {
            Optional<TaskEntity> taskData = taskRepo.findById(id);
            if (taskData.isPresent()) {
                System.out.println("inside chcek status block");
                TaskEntity taskEntity = taskData.get();
                TaskDto task = taskService.verifyIfTimePresent(taskEntity);
                return new ResponseEntity<>(task, HttpStatus.FOUND);
            } else {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("couldnt find the specified Id");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("exception occured");

        }

    }


    @PostMapping(value = "/updation")
    public ResponseEntity<?> updation(@RequestBody TaskDto taskDto) {
        try {
            TaskDto taskDto2 = taskService.updationOfTask(taskDto);
            if (taskDto2 != null) {
                return new ResponseEntity<>(taskDto2, HttpStatus.CREATED);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Couldnt find the valid Task");
            }

        } catch (Exception e) {
            System.out.print(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("exception occured");

        }
    }

    @GetMapping(value = "/checkstatus/{id}")
    public ResponseEntity<?> checkStatus(@PathVariable Integer id) {
        try {
            Optional<TaskEntity> taskData = taskRepo.findById(id);
            if (taskData.isPresent()) {
                TaskEntity taskEntity = taskData.get();
                TaskDto task = taskService.checkStatusById(taskEntity);
                return new ResponseEntity<>(task, HttpStatus.FOUND);
            } else {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("couldnt find the specified Id");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("exception occured");

        }

    }

}
