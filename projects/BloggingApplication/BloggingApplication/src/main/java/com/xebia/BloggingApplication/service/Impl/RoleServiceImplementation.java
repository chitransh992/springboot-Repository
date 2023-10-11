package com.xebia.BloggingApplication.service.Impl;

import com.xebia.BloggingApplication.entites.Role;
import com.xebia.BloggingApplication.payloads.RoleDto;
import com.xebia.BloggingApplication.repositories.RoleRepository;
import com.xebia.BloggingApplication.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImplementation implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private
    ModelMapper modelMapper;
    @Override
    public Role createRole(RoleDto roleDto) {
        Role role = this.modelMapper.map(roleDto,Role.class);
        Role savedRole = this.roleRepository.save(role);
        return savedRole;
    }
}
