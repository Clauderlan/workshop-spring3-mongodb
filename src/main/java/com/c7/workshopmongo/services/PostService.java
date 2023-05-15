package com.c7.workshopmongo.services;

import com.c7.workshopmongo.domain.Post;
import com.c7.workshopmongo.dto.AuthorDTO;
import com.c7.workshopmongo.repositories.PostRepository;
import com.c7.workshopmongo.repositories.UserRepository;
import com.c7.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;
    public Post findById(String id){
        return postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
    }
    public List<Post> findByTitle(String text){
        return postRepository.findByTitleContainingIgnoreCase(text);
    }

    public List<Post> findByAuthor(String text){
        System.out.println(text);
        AuthorDTO authorDTO = new AuthorDTO(userRepository.findByName(text));
        return postRepository.findByAuthor(authorDTO);
    }
}
