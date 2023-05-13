package com.c7.workshopmongo.resources;

import com.c7.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping 
    public ResponseEntity<List<User>> findAll(){
        User maria = new User("1","Vasco","Vasco@gmail.com");
        User vasco = new User("2","Vasco","Vasco@gmail.com");
        return ResponseEntity.ok().body(Arrays.asList(maria, vasco));
    }

}
