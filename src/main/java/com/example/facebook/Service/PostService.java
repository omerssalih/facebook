package com.example.facebook.Service;

import com.example.facebook.Dto.SubmitPostDto;
import com.example.facebook.Entity.Post;
import com.example.facebook.Entity.User;
import com.example.facebook.Repository.PostRepository;
import com.example.facebook.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    public void submitPost(SubmitPostDto submitPostDto) {
        Optional<User> userOptional = userRepository.findByUserName(
                submitPostDto.getUserName());
        if (userOptional.isPresent()) {
            Post post = modelMapper.map(submitPostDto, Post.class);
            postRepository.save(post);
        } else {
            throw new IllegalStateException("Böyle bir kullanıcı yoktur");
        }
    }

    public ArrayList<Post> getAllPostFromDB(){
        ArrayList<Post> result = (ArrayList<Post>) postRepository.findAll();
        return result;
    }

    public ArrayList<Post> deletePostFromDB(Long postId){
        postRepository.deleteById(postId);
        ArrayList<Post> result = getAllPostFromDB();
        return result;
    }
}
