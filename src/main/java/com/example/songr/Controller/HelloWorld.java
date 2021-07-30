package com.example.songr.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Controller
public class HelloWorld {

@Autowired
    @GetMapping("/")
    public String helloWorld() {
        return "homePage";
    }

    @GetMapping("/hello")
    public String helloWorld(@RequestParam(name = "word", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("word", name);
        return "helloWorld";

    }

    @GetMapping("/capitalize/{text}")
    public String capitalize(@PathVariable String text, Model model) {
        model.addAttribute("text", text.toUpperCase(Locale.ROOT));
        return "capitalize";
    }



}
