package com.xfh.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtil {

    private static final String SIGN_KEY="eGlhZnVoYW96dWlzaHVhaQ==";
    private static final Long EXPIRATION_TIME=12*60*60*1000L;

    public static String generateToken(Map<String,Object> claims){
        return Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256,SIGN_KEY)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .compact();
    }

    public static Claims parseToken(String token){
        return Jwts.parser()
                .setSigningKey(SIGN_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
