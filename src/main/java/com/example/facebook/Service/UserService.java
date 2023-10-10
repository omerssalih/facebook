package com.example.facebook.Service;

import com.example.facebook.Entity.Post;
import com.example.facebook.Entity.User;
import com.example.facebook.Repository.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public ArrayList<User> addUser(User user){
        userRepository.save(user);
        ArrayList<User> result = (ArrayList<User>) getUsers();
        return result;
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
