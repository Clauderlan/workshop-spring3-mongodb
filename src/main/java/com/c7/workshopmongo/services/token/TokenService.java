package com.c7.workshopmongo.services.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import com.c7.workshopmongo.domain.User;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TokenService {
    public String createJWT(User user){
        return JWT.create()
                .withIssuer("c7")
                .withSubject(user.getName())
                .withClaim("id", user.getId())
                .withExpiresAt(
                        Instant.now().plusMillis(60 * 60000)
                )
                .sign(Algorithm.HMAC256("secret"));
    }

    public String getSubject(String jwt){
        Verification jwtWithSecret = JWT.require(Algorithm.HMAC256("secret"));
        DecodedJWT decodedJWT = jwtWithSecret.withIssuer("c7").build().verify(jwt);
        return decodedJWT.getSubject();
    }
}
