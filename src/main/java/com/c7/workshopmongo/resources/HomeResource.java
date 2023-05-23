package com.c7.workshopmongo.resources;

import com.c7.workshopmongo.dto.LoginDTO;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Resource
@RestController
public class HomeResource {

    @GetMapping("/")
    public String home(){
        return "<h1>HELLO</h1>";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO login){

        return login.getPassword();
    }
}
