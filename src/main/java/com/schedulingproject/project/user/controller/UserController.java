package com.schedulingproject.project.user.controller;

import com.schedulingproject.project.exception.error.HomeNotFoundException;
import com.schedulingproject.project.user.dto.UserDTO;
import com.schedulingproject.project.user.model.User;
import com.schedulingproject.project.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "Returns a list of all users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns a list of all users"),
            @ApiResponse(code = 404, message = "Returns a empty list")
    })
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) {
            throw new HomeNotFoundException("No users founded: ");
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @ApiOperation(value = "Save and returns the saved user")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Save and returns the saved user")
    })
    @PostMapping
    public ResponseEntity<User> insertUser(@RequestBody UserDTO userDTO){
        User user = userService.saveOne(userDTO);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Find and return a user searching by id")
    @ApiResponses(value  = {
            @ApiResponse(code = 200, message = "Find and return a user searching by id"),
            @ApiResponse(code = 404, message = "User not found")
    })
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        Optional<User> user = userService.findOneById(id);
        if (!user.isPresent()) {
            throw new HomeNotFoundException("User not found with id: " + id);
        }
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }
}
