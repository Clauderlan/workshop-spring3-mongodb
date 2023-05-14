package com.c7.workshopmongo.services;

import com.c7.workshopmongo.domain.Post;
import com.c7.workshopmongo.repositories.PostRepository;
import com.c7.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id){
        return postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
    }

}
