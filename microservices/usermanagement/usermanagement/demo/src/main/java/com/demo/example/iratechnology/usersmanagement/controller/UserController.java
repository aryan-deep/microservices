package com.demo.example.iratechnology.usersmanagement.controller;

import java.util.List;

import com.demo.example.iratechnology.usersmanagement.dto.UserDto;
import com.demo.example.iratechnology.usersmanagement.dto.TaskDto;
import com.demo.example.iratechnology.usersmanagement.service.UserService;
import com.demo.example.iratechnology.usersmanagement.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping ("api/user")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private UserService userService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired(required = true)
    private TaskDto taskDto;

    // this is beiing called by taskmanagement
    @PostMapping("/checkuserpswd")
    public boolean checkUserValidation(@RequestBody TaskDto responseFromTask) {
        boolean verify = false;
        verify = userServiceImpl.checkUserHasSamePswd(responseFromTask);
        if (verify) {
            verify = true;
            return verify;
        }

        return verify;
    }

    @GetMapping("/hi")
    public String hey() {
        return "Welcome guys";
    }

    @GetMapping("/userlist")
    public ResponseEntity<List<UserDto>> getStatus() {
        try {

            List<UserDto> users = userService.getAllUsers();
            if (users.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(users, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping(value = "/userregistration")
    public ResponseEntity<?> registration(@RequestBody UserDto userDto) {

        try {
            boolean verify = userServiceImpl.checkCodeandUserExists(userDto);
            boolean againverify = userServiceImpl.checkManagerCodeExists(userDto);

            if (verify) {
                UserDto response = userService.registration(userDto);
                userServiceImpl.setEmpId(response);

                if (response != null) {
                    return new ResponseEntity<>(response, HttpStatus.CREATED);
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Not a valid user");
                }
            } else if (againverify) {
                UserDto response = userService.registration(userDto);
                userServiceImpl.setEmpId(response);
                if (response != null) {
                    return new ResponseEntity<>(response, HttpStatus.CREATED);
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Not a valid user");
                }

            }
            return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body("User exists or invalid access code");

        }

        catch (Exception e) {

            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("exception occured");
        }

    }

    @PutMapping(value = "/updateuser")
    public ResponseEntity<?> Update(@RequestBody UserDto userDto) {
        try {
            if (userDto.getId() != 0) {
                UserDto response = userService.Update(userDto);
                if (response != null)
                    return new ResponseEntity<>(response, HttpStatus.MOVED_PERMANENTLY);
                else
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                            .body("Response cannot be processed as Data doesnt exists");
            } else
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldnt fetch the ID");

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
