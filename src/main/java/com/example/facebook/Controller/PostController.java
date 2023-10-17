package com.example.facebook.Controller;

import com.example.facebook.Dto.SubmitPostDto;
import com.example.facebook.Entity.Post;
import com.example.facebook.Service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "post")
public class PostController {


    private final PostService postService;


    @PostMapping
    public void submitPost(@RequestBody SubmitPostDto post) {
        postService.submitPost(post);
    }


    @GetMapping
    public ArrayList<Post> getAllPost() {
        ArrayList<Post> result = postService.getAllPostFromDB();
        return result;
    }

    @DeleteMapping("{postId}")
    public ArrayList<Post> deletePost(@PathVariable("postId") Long postId) {
        ArrayList<Post> result = postService.deletePostFromDB(postId);
        return result;
    }

}
