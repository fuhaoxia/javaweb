package com.xfh;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    @Test
    public void testGenerateJwt(){
        Map<String,Object> claim= new HashMap<>();
        claim.put("id",1);
        claim.put("username","xia");
        String compact = Jwts.builder().signWith(SignatureAlgorithm.HS256, "123456")
                .addClaims(claim)
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
                .compact();
        System.out.println(compact);
    }
}
