package com.mehdi.resetfullprojectspringboot.Controllers;


import com.mehdi.resetfullprojectspringboot.models.User;
import com.mehdi.resetfullprojectspringboot.services.UserService;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController  {
    private UserService userService;
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User saveUser=userService.createUser(user);
        return new ResponseEntity<>(saveUser, HttpStatus.CREATED);

    }
    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users=userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);

    }
    @GetMapping("{id}")
    public  ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
        User user=userService.getUserById(userId);
        return  new ResponseEntity<>(user,HttpStatus.OK);

    }
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId, @RequestBody User user){
        user.setId(userId);
        User updatedUser =  userService.updateUser(user);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);

    }
    // Build Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
}
