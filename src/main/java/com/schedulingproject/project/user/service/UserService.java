package com.schedulingproject.project.user.service;

import com.schedulingproject.project.user.dto.UserDTO;
import com.schedulingproject.project.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    User saveOne(UserDTO userDTO);

    Optional<User> findOneById(Long id);
}
