package com.c7.workshopmongo.repositories;

import com.c7.workshopmongo.domain.Post;
import com.c7.workshopmongo.dto.AuthorDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {
    public List<Post> findByTitleContainingIgnoreCase(String text);
    public List<Post> findByAuthor(AuthorDTO author);

    @Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    public List<Post> fullSearch(String text, Instant minDate, Instant maxDate);
}
