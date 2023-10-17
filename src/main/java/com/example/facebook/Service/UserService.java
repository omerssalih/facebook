package com.example.facebook.Service;

import com.example.facebook.Dto.CreateUserDto;
import com.example.facebook.Dto.SubmitPostDto;
import com.example.facebook.Entity.Post;
import com.example.facebook.Entity.User;
import com.example.facebook.Repository.UserRepository;
import com.jayway.jsonpath.JsonPath;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void addUser(CreateUserDto createUserDto){
        Optional<User> userOptional = userRepository.findByUserEmail(
                createUserDto.getUserEmail());
        if(userOptional.isPresent()){
            throw new IllegalStateException("Bu email daha önce kullanılmış");
        }
        else {
            User user = modelMapper.map(createUserDto, User.class);
            userRepository.save(user);
        }
    }


    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
