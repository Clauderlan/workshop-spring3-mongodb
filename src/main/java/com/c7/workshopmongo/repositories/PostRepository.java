package com.c7.workshopmongo.repositories;

import com.c7.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {
    public List<Post> findByTitleContainingIgnoreCase(String text);
}
