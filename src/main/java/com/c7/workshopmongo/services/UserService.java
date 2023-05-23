package com.c7.workshopmongo.services;

import com.c7.workshopmongo.domain.User;
import com.c7.workshopmongo.dto.UserDTO;
import com.c7.workshopmongo.repositories.UserRepository;
import com.c7.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    public List<User> findAll(){
        return userRepository.findAll();
    }
    public User findById(String id){
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
    }
    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public User insert(User user){
        return userRepository.insert(user);
    }

    public User update(String id, User user){
        User compare = findById(id);
        updateData(user,compare);
        return userRepository.save(compare);
    }

    private void updateData(User user, User compare) {
        compare.setName(user.getName());
        compare.setEmail(user.getEmail());
    }

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }
    public User fromDTO(UserDTO userDTO){
        return findByEmail(userDTO.getEmail());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByName(username);
    }
}
