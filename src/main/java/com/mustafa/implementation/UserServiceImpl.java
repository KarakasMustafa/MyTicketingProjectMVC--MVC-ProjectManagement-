package com.mustafa.implementation;

import com.mustafa.dto.UserDTO;
import com.mustafa.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends AbstractMapService<UserDTO,String> implements UserService{
    @Override
    public List<UserDTO> findAll() {
        return super.findAll();
    }

    @Override
    public UserDTO save(UserDTO object) {
        return super.save(object.getUserName(),object);
    }

    @Override
    public UserDTO findById(String id) {
        return super.findById(id);
    }

    @Override
    public void delete(UserDTO object) {
        super.delete(object);
    }

    @Override
    public void deleteById(String id) {
        super.deleteById(id);
    }

    @Override
    public void update(UserDTO object) {
        super.update(object.getUserName(),object);
    }

    @Override
    public List<UserDTO> findManagers() {
        return super.findAll().stream().filter(entry->entry.getRole().getId() == 2).collect(Collectors.toList());
    }
}
