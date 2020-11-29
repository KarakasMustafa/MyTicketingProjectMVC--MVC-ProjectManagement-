package com.mustafa.services;

import com.mustafa.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService extends CrudService<UserDTO,String>{

    List<UserDTO> findManagers();
}
