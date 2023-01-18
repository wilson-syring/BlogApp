package com.codeup.blogapp.controllers;

import com.codeup.blogapp.models.Post;
import com.codeup.blogapp.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class PostController {

    private final PostRepository postDao;
    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }
    @GetMapping(path="/posts")
    public String getPost(Model model) {
        List<Post> posts= postDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/show";
    }
    @GetMapping("/posts/{id}")
    public String getIndividualPost(@PathVariable long id,Model model) {
        Post currentPost = postDao.getReferenceById(1L);
        model.addAttribute("post", currentPost);
        return "posts/post";
    }
    @GetMapping(path = "/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }
    @PostMapping(path = "/posts/create")
    public String create(@ModelAttribute Post post) {
        postDao.save(post);
        return "redirect:/posts";
    }

}
