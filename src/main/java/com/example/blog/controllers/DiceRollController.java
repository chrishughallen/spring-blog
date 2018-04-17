package com.example.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

@Controller
public class DiceRollController {

    @GetMapping("/roll-dice/{guess}")
    public String diceRoll(@PathVariable int guess, Model model){
        model.addAttribute("guess", guess);
        Random num = new Random();
        int n = num.nextInt(6)+1;
        model.addAttribute("n", String.valueOf(n));
        return "diceRoll";
    }

    @GetMapping("/roll-dice")
    public String dice(){
        return "diceRoll";
    }
}
