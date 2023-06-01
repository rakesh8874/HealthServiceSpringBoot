package com.healthcorporation.healthservice.security;

import com.healthcorporation.healthservice.domain.AuthUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class GenerateJWTImpl implements GenerateJWTToken{
    @Override
    public Map<String, String> generateJWTToken(AuthUser authUser) {
        Map<String, String> map = new HashMap<>();
        String jwtToken = Jwts.builder().setSubject(authUser.getUserName())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "user-key")
                .compact();
        map.put("token", jwtToken);
        return map;
    }
    }

