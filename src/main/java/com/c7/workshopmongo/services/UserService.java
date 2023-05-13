package com.c7.workshopmongo.services;

import com.c7.workshopmongo.domain.User;
import com.c7.workshopmongo.repositories.UserRepository;
import com.c7.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User findById(String id){
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
    }
}
