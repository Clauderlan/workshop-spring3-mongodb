package com.c7.workshopmongo.config;

import com.c7.workshopmongo.domain.Post;
import com.c7.workshopmongo.domain.User;
import com.c7.workshopmongo.dto.AuthorDTO;
import com.c7.workshopmongo.dto.CommentDTO;
import com.c7.workshopmongo.repositories.PostRepository;
import com.c7.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown","9999", "maria@gmail.com","ADMIN");
        User alex = new User(null, "Alex Green", "9999", "alex@gmail.com", "ADMIN");
        User bob = new User(null, "Bob Grey", "9999", "bob@gmail.com", "ADMIN");

        userRepository.saveAll(Arrays.asList(maria,bob,alex));

        Post post1 = new Post(null, Instant.parse("2018-11-18T18:35:24.00Z"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, Instant.parse("2018-11-21T18:35:24.00Z"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

        postRepository.saveAll(Arrays.asList(post1,post2));

        maria.getPosts().add(post1);
        maria.getPosts().add(post2);
        userRepository.save(maria);

        CommentDTO commentDTO1 = new CommentDTO("Você acha que o Vasco sobe ?", Instant.now(), new AuthorDTO(alex));
        CommentDTO commentDTO2 = new CommentDTO("Você tem certeza disso ?", Instant.now(), new AuthorDTO(bob));

        post1.getComments().addAll(Arrays.asList(commentDTO1,commentDTO2));
        postRepository.save(post1);

    }
}
