package com.healthcorporation.healthservice.security;


import com.healthcorporation.healthservice.domain.AuthUser;


import java.util.Map;

public interface GenerateJWTToken {
Map<String, String> generateJWTToken(AuthUser authUser);
}
