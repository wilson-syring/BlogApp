package com.codeup.blogapp.controllers;

import com.codeup.blogapp.models.Post;
import com.codeup.blogapp.models.User;
import com.codeup.blogapp.repositories.PostRepository;
import com.codeup.blogapp.repositories.UserRepository;
import com.codeup.blogapp.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailService;
    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }

    @GetMapping(path = "/posts")
    public String getPost(Model model) {
        List<Post> posts = postDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/show";
    }
    @GetMapping("/posts/{id}")
    public String getIndividualPost(@PathVariable long id, Model model) {
        Post currentPost = postDao.getReferenceById(1L);
        model.addAttribute("post", currentPost);
        return "posts/show";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable long id, Model model) {
        Post currentPost = postDao.getReferenceById(id);
        System.out.println("currentPost = " + currentPost);
        model.addAttribute("post", currentPost);
        return "posts/edit";
    }
    @PostMapping("/posts/edit")
    public String editPost(@ModelAttribute Post post) {
        User user = userDao.findAll().get(0);
        post.setUser(user);
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping(path = "/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping(path = "/posts/create")
    public String create(@ModelAttribute Post post) {
        User user = userDao.getReferenceById(1L);
        post.setUser(user);
        emailService.prepareAndSend(post, "New Post Created", "A new post has been created");
        postDao.save(post);
        return "redirect:/posts";
    }
}