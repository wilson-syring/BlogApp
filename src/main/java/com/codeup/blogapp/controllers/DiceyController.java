package com.codeup.blogapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DiceyController {
    @GetMapping("/roll-dice")
    public String rollDice() {
        return "roll-dice";
    }
    @GetMapping("/roll-dice/{guess}")
    public String rollDice(@PathVariable int guess, Model model) {
        int dice = (int) Math.floor(Math.random() * 6) + 1;
        model.addAttribute("dice", dice);
        model.addAttribute("guess", guess);
        if (dice == guess) {
            model.addAttribute("result", "You guessed correctly!");
        } else {
            model.addAttribute("result", "You guessed incorrectly!");
        }
        return "roll-dice";
    }
}
