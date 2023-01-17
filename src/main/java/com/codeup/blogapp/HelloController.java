package com.codeup.blogapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class HelloController {

    @GetMapping("/{name}")
    @ResponseBody
    public String welcome(@PathVariable String name) {
        return "Hello "+name+" welcome to the landing page";
    }
}