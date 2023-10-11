package com.xebia.BloggingApplication.service;

import com.xebia.BloggingApplication.entites.Role;
import com.xebia.BloggingApplication.payloads.RoleDto;
import com.xebia.BloggingApplication.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface RoleService {

    Role createRole(RoleDto roleDto);

}
