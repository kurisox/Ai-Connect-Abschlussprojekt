package com.bs.ai_connect.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/simple-answer")
public class SimpleAnswerController {


    @GetMapping("/")
    public String postAnswer(){
        return "Hello World";
    }

}
