package com.demo.example.iratechnology.usersmanagement.service;

import java.util.List;

import com.demo.example.iratechnology.usersmanagement.dto.UserDto;

public interface UserService {

    List<UserDto> getAllUsers();

    UserDto registration(UserDto userDto);

    UserDto Update(UserDto userDto);
    // boolean checkUserHasSamePswd(UserDto userDto);

}
