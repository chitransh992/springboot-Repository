package com.xebia.BloggingApplication.controller;

import com.xebia.BloggingApplication.entites.User;
import com.xebia.BloggingApplication.payloads.ApiResponse;
import com.xebia.BloggingApplication.payloads.UserDto;
import com.xebia.BloggingApplication.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.config.RepositoryConfigurationSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    //post
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
       UserDto createUserDto = this.userService.createUser(userDto);
       return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

    //update

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto,@PathVariable int userId){
        UserDto updatedUser = this.userService.updateUser(userDto,userId);
        return  ResponseEntity.ok(updatedUser);
    }

    //delete

    @DeleteMapping("/{userId}")
    public ResponseEntity<UserDto> deleteUsers(@PathVariable int userId){
        this.userService.deleteUser(userId);
        return new ResponseEntity(new ApiResponse("User Deleted Successfully",true),HttpStatus.OK);
    }
    //get user

    @GetMapping("/{userid}")
    public ResponseEntity<UserDto> getUserById(@PathVariable int userid){
        return ResponseEntity.ok(this.userService.getUserById(userid));

    }

    //getAll
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return ResponseEntity.ok(this.userService.getAllUsers());
    }
}
