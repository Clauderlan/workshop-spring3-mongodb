package com.c7.workshopmongo.resources;

import com.c7.workshopmongo.domain.User;
import com.c7.workshopmongo.dto.LoginDTO;
import com.c7.workshopmongo.services.token.TokenService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Resource
@RestController
public class HomeResource {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @GetMapping("/")
    public String home(){
        return "<h1>HELLO</h1>";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO login){
        UsernamePasswordAuthenticationToken authenticationToken = new
                UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword());
        Authentication token = this.authenticationManager.authenticate(authenticationToken);
        return tokenService.createJWT((User) token.getPrincipal());
    }
}
