package com.Kcas.Library.security.config;

import com.Kcas.Library.dtos.UserDto;
import com.Kcas.Library.services.UserService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.*;

@RequiredArgsConstructor
@Component
public class UserAuthProvider {

    public List<String> JWTtokenBlackList;
    private final UserService userService;

    @Value("${security.jwt.token.secret-key:secret-key}")
    private String secretKey;
    @PostConstruct
    protected void init(){
        this.JWTtokenBlackList = new ArrayList<>();
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(String login){
        Date now = new Date();
        Date validity = new Date(now.getTime() + 3600000); // 1 hour

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        return JWT.create()
                .withIssuer(login)
                .withIssuedAt(now)
                .withExpiresAt(validity)
                .sign(algorithm);
    }

    public Authentication validateToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        JWTVerifier verifier = JWT.require(algorithm)
                .build();

        DecodedJWT decoded = verifier.verify(token);
        if (JWTtokenBlackList.contains(token)){
            return UsernamePasswordAuthenticationToken.unauthenticated(null,null);
        }
        UserDto user = userService.findByLogin(decoded.getIssuer());
        user.setToken(token);
        return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
    }

    public void addTokenToBlackList(String token){
        JWTtokenBlackList.add(token);
    }
}
