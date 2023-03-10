package com.codeup.blogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @RequestMapping(path = "/add/{number1}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public int plusThem(@PathVariable int number1,@PathVariable int number2) {
        return number1 + number2;
    }

    @RequestMapping(path = "/subtract/{number1}/from/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public int minusThem(@PathVariable int number1,@PathVariable int number2) {
        return number2 - number1;
    }

    @RequestMapping(path = "/multiply/{number1}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public int multiplyThem(@PathVariable int number1,@PathVariable int number2) {
        return number1 * number2;
    }

    @RequestMapping(path = "/divide/{number1}/by/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public int divedThem(@PathVariable int number1,@PathVariable int number2) {
        return number1 / number2;
    }
}
