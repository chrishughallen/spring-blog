package com.example.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class StringTransformController {

    @GetMapping("/string/reverse/{string}")
    @ResponseBody
    public String reverse (@PathVariable String string){
        String rev = "";
        for(int i = string.length()-1;i>=0;i--){
            System.out.println(string.charAt(i));
            rev += string.charAt(i);
        }
        return rev;
    }

    @GetMapping("/string/caps/{string}")
    @ResponseBody
    public String caps(@PathVariable String string){
        return string.toUpperCase();
    }

    @GetMapping("/string/both/{string}")
    @ResponseBody
    public String both(@PathVariable String string){
        String caps = caps(string);
        return reverse(caps);
    }
}
