package com.example.facebook.Service;

import com.example.facebook.Dto.SubmitPostDto;
import com.example.facebook.Entity.Post;
import com.example.facebook.Entity.User;
import com.example.facebook.Exception.PostNotFoundException;
import com.example.facebook.Exception.UserNotFoundException;
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
    private final UserService userService;
    


    public void submitPost(SubmitPostDto submitPostDto) {
        Optional<User> userOptional = userRepository.findByUserName(
                submitPostDto.getUserName());
        if (userOptional.isPresent()) {
            Post post = modelMapper.map(submitPostDto, Post.class);
            User user = userOptional.get();
            user.getAssignedPosts().add(post);
            postRepository.save(post);
        } else {
            throw new IllegalStateException("Böyle bir kullanıcı yoktur");
        }
    }

    public ArrayList<Post> getAllPostFromDB(){
        ArrayList<Post> result = (ArrayList<Post>) postRepository.findAll();
        return result;
    }

    public ArrayList<Post> deletePostFromDB(Long postId, String userName){
        Post post = postRepository.findById(postId).orElseThrow(() ->
                new PostNotFoundException(
                        "post not found with this id: " + postId));
        User user = userService.getUserByName(userName);
        user.getAssignedPosts().remove(post);
        postRepository.deleteById(postId);
        ArrayList<Post> result = getAllPostFromDB();
        return result;
    }
}
