package com.xebia.BloggingApplication.controller;

import com.xebia.BloggingApplication.entites.Role;
import com.xebia.BloggingApplication.payloads.ApiResponse;
import com.xebia.BloggingApplication.payloads.RoleDto;
import com.xebia.BloggingApplication.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping("/")
    public ResponseEntity<ApiResponse> createRole(@RequestBody RoleDto roleDto){
        Role savedRole = this.roleService.createRole(roleDto);
        return new ResponseEntity(new ApiResponse("Role created Successfully",true), HttpStatus.CREATED);
    }

}
