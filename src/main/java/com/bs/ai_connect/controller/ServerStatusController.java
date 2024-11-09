package com.bs.ai_connect.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/")
public class ServerStatusController {

    @GetMapping("")
    public String serverStatus() {
        return "Server is running";
    }
    
}
