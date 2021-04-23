package com.schedulingproject.project.user.service.serviceimpl;

import com.schedulingproject.project.user.dto.UserDTO;
import com.schedulingproject.project.user.model.User;
import com.schedulingproject.project.user.repository.UserRepository;
import com.schedulingproject.project.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveOne(UserDTO userDTO) {
        User user = new User().of(userDTO);
        return userRepository.saveAndFlush(user);
    }

    @Override
    public Optional<User> findOneById(Long id) {
        return userRepository.findById(id);
    }

}
