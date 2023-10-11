package com.xebia.BloggingApplication.service.Impl;

import com.xebia.BloggingApplication.entites.User;
import com.xebia.BloggingApplication.exceptions.ResouceNotFoundException;
import com.xebia.BloggingApplication.payloads.UserDto;
import com.xebia.BloggingApplication.repositories.UserRepository;
import com.xebia.BloggingApplication.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userdto) {
        User user = this.dtoToUser(userdto);
        User savedUser = userRepository.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, int userId) {
        User user = this.userRepository.findById(userId).orElseThrow(()->new ResouceNotFoundException("User","Id",userId));
        user.setName(userDto.getName());
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());
        User updatedUser =this.userRepository.save(user);
        UserDto userDto1 =this.userToDto(updatedUser);
        return userDto1;

    }

    @Override
    public UserDto getUserById(int userId) {
        User user = this.userRepository.findById(userId).orElseThrow(()->new ResouceNotFoundException("User","Id",userId));
        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepository.findAll();
        List<UserDto> userDtos = users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUser(int userId) {
        User user = this.userRepository.findById(userId).orElseThrow(()->new ResouceNotFoundException("Users","Id",userId));
        this.userRepository.delete(user);
    }

    private User dtoToUser(UserDto userDto){
        User user = this.modelMapper.map(userDto,User.class);
//        User user = ModelMapper(userDto,);
//        user.setId(userDto.getId());
//        user.setName(userDto.getName());
//        user.setEmail(userDto.getEmail());
//        user.setAbout(userDto.getAbout());
//        user.setPassword(userDto.getPassword());
        return user;
    }

    public UserDto userToDto(User user){
        UserDto userDto = this.modelMapper.map(user,UserDto.class);
//        userDto.setId(user.getId());
//        userDto.setName(user.getName());
//        userDto.setEmail(user.getEmail());
//        userDto.setPassword(user.getPassword());
//        userDto.setAbout(user.getAbout());
        return userDto;
    }

}
