package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class StarterController {

    @GetMapping("/hello")
    public String Hello(){
        return "Hello";
    }

    @PostMapping("/hello")
    public String helloPost(@RequestBody String name){
        return "hello "+name+"!";
    }
}
