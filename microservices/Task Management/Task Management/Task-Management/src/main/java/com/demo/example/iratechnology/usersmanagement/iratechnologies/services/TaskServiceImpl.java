package com.demo.example.iratechnology.usersmanagement.iratechnologies.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.demo.example.iratechnology.usersmanagement.iratechnologies.dto.TaskDto;
import com.demo.example.iratechnology.usersmanagement.iratechnologies.entity.TaskEntity;
import com.demo.example.iratechnology.usersmanagement.iratechnologies.repository.TaskRepo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepo taskRepo;
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ModelMapper mapper;

    @Override
    public TaskDto creationOfTask(TaskDto taskDto) {
        String url = "http://ms-usermanagement/api/user/checkuserpswd";
        boolean responseFromUser = restTemplate.postForObject(url, taskDto,Boolean.class);
        try {

            if (responseFromUser) {
                if ((taskDto.getCreatorid() != null) && (!taskDto.getCreatorid().equals(" "))
                        && (taskDto.getCreatorpswd() != null) && (!taskDto.getCreatorpswd().equals(" "))
                        && (taskDto.getTaskname() != null) && (!taskDto.getTaskname().equals(" "))
                        && (taskDto.getDescription() != null) && (!taskDto.getDescription().equals(" "))
                        && (taskDto.getAssignedto() != null) && (!taskDto.getAssignedto().equals(" "))) {
                    TaskDto currentobj = putCreationTime(taskDto);
                    // taskDto.setCreationtime(currentobj.getCreationtime());
                    TaskEntity taskEntity = taskRepo.save(dtotoEntity(currentobj));

                    return (entitytoDto(taskEntity));
                } else {
                    return null;
                }
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    private TaskEntity dtotoEntity(TaskDto taskDto) {

        TaskEntity taskEntity = mapper.map(taskDto, TaskEntity.class);
        return taskEntity;
    }

    private TaskDto entitytoDto(TaskEntity taskEntity) {
        TaskDto taskDto = mapper.map(taskEntity, TaskDto.class);
        return taskDto;

    }

    @Override
    public TaskDto updationOfTask(TaskDto taskDto) {

        Optional<TaskEntity> data = taskRepo.findById(taskDto.getId());
        if (data.isPresent()) {

            System.out.println("if block of updation iof task ");
            TaskEntity taskEntity = data.get();

            if (taskDto.getCreatorid() != null) {
                taskEntity.setCreatorid(taskDto.getCreatorid());
            }

            if (taskDto.getCreatorpswd() != null) {
                taskEntity.setCreatorpswd(taskDto.getCreatorpswd());
            }

            if (taskDto.getTaskname() != null) {
                taskEntity.setTaskname(taskDto.getTaskname());
            }

            if (taskDto.getDescription() != null) {
                taskEntity.setDescription(taskDto.getDescription());
            }

            if (taskDto.getCreationtime() != null) {
                taskEntity.setCreationtime(taskDto.getCreationtime());
            }

            if (taskDto.getCompletiontime() != null) {
                taskEntity.setCompletiontime(taskDto.getCompletiontime());
            }

            if (taskDto.getStartingtime() != null) {
                taskEntity.setStartingtime(taskDto.getStartingtime());
            }

            if (taskDto.getAssignedto() != null) {
                taskEntity.setAssignedto(taskDto.getAssignedto());
            }

            if (taskDto.getStatus() != null) {
                taskEntity.setStatus(taskDto.getStatus());
            }

            if (taskDto.getOpenornot() != null) {
                taskEntity.setOpenornot(taskDto.getOpenornot());
            }

            return entitytoDto(taskRepo.save(taskEntity));

        }

        System.out.println("else block of updation");
        return null;
    }

    private String dateandtimestamp() {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = now.format(formatter);
        return formatDateTime;
    }

    public TaskDto putCreationTime(TaskDto request) {
        String time = dateandtimestamp();
        request.setCreationtime(time);
        // TaskDto response = updationOfTask(request);
        return request;

    }

    public TaskDto putStartingTime(TaskDto request) {
        String time = dateandtimestamp();
        request.setStartingtime(time);
        TaskDto response = updationOfTask(request);
        return response;

    }

    public TaskDto putCompletionTime(TaskDto request) {
        String time = dateandtimestamp();
        request.setCompletiontime(time);
        TaskDto response = updationOfTask(request);
        return response;

    }

    @Override
    public TaskDto verifyIfTimePresent(TaskEntity taskEntity) {
        String check;
        if ((taskEntity.getCreationtime() != null) && (!taskEntity.getCreationtime().equals(" "))
                && (taskEntity.getStartingtime() == null) || (taskEntity.getStartingtime().equals(" "))
                && (taskEntity.getCompletiontime() == null) || (taskEntity.getCompletiontime().equals(" "))) {
            check = "To do";
            System.out.println("inside if block no. 1 creation time");
            taskEntity.setStatus(check);
            taskEntity.setOpenornot("open");
            TaskDto taskDto = entitytoDto(taskEntity);
            TaskDto response = updationOfTask(taskDto);
            System.out.println("response body :: verify task present"+response.getTaskname());
            return response;
        } else if ((taskEntity.getCreationtime() != null) && (!taskEntity.getCreationtime().equals(" "))
                && (taskEntity.getStartingtime() != null) && (!taskEntity.getStartingtime().equals(" "))
                && (taskEntity.getCompletiontime() == null) || (taskEntity.getCompletiontime().equals(" "))) {
            check = "Doing";
            taskEntity.setStatus(check);
            taskEntity.setOpenornot("open");
            TaskDto taskDto = entitytoDto(taskEntity);
            TaskDto response = updationOfTask(taskDto);
            return response;
        } else if ((taskEntity.getCreationtime() != null) && (!taskEntity.getCreationtime().equals(" "))
                && (taskEntity.getStartingtime() != null) && (!taskEntity.getStartingtime().equals(" "))
                && (taskEntity.getCompletiontime() != null) && (!taskEntity.getCompletiontime().equals(" "))) {
            check = "completed";
            taskEntity.setStatus(check);
            taskEntity.setOpenornot("close");
            TaskDto taskDto = entitytoDto(taskEntity);
            TaskDto response = updationOfTask(taskDto);
            return response;
        }
    
        return null;
    }

    @Override
    public TaskDto checkStatusById(TaskEntity taskEntity) {
       return(entitytoDto(taskEntity));

    }

}
