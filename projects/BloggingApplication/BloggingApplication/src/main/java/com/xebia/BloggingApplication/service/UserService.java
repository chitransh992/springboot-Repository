package com.xebia.BloggingApplication.service;

import com.xebia.BloggingApplication.entites.User;
import com.xebia.BloggingApplication.payloads.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user,int userId);
    UserDto getUserById(int userId);
    List<UserDto> getAllUsers();
    void deleteUser(int userId);



}
