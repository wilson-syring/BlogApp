package com.codeup.blogapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class PostController {
    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    @ResponseBody
    public String viewPost() {
        return "This be tha place for posts";
    }
    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String postId(@PathVariable int id) {
        return "This be tha place for post id" + id;
    }
    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
    @ResponseBody
    public String createPost() {
        return "This be tha place for creating posts";
    }
    @PostMapping(path="/posts/create")
    @ResponseBody
    public String viewCreateRequest(){
        return "This be the post request for /create post";
    }
}
