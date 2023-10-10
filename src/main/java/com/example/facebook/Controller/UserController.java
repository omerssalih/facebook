package com.example.facebook.Controller;

import com.example.facebook.Entity.Post;
import com.example.facebook.Entity.User;
import com.example.facebook.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "user")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }


    @PostMapping
    public ArrayList<User> addUser(@RequestBody User body){
        ArrayList<User> result = userService.addUser(body);
        return result;

    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable ("userId") Long userId){
        userService.deleteUser(userId);
    }
}
