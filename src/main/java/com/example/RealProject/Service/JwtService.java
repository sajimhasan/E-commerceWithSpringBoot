package com.example.RealProject.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.websocket.Decoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.function.Function;

@Service
public class JwtService {

    String secretKey= "";


    public JwtService(){
       try{
           KeyGenerator keygen= KeyGenerator.getInstance("HmacSHA256");
           SecretKey sk= keygen.generateKey();
           secretKey= Base64.getEncoder().encodeToString(sk.getEncoded());
       }catch (NoSuchAlgorithmException e){
           System.out.println(e);
           throw new RuntimeException(e);
       }
    }


    private SecretKey getKey(){
        byte[] keyByte = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyByte);
    }


    public String genareteToken(String username){
        Map<String , Object> cliams= new HashMap<>();
        return Jwts.builder()
                .claims()
                .add(cliams)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 5))
                .and()
                .signWith(getKey())
                .compact();
    }


    public String extractUsername(String token){
        return extractClaim(token , Claims::getSubject);
    }


    private <T> T extractClaim(String token , Function<Claims ,T > claimsTFunction){
        final Claims claims= extratAllClaim(token);
        return claimsTFunction.apply(claims);
    }


    public Claims extratAllClaim(String token) {
      return   Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }



   private Date extractExpirations(String token){
        return extractClaim(token , Claims::getExpiration);
   }


    private boolean isTokenExpired(String token){
        return extractExpirations(token).before(new Date());
    }

    public boolean vaildtoken(String token , UserDetails userDetails){
        final String username= extractUsername(token);
        return (username.equals(userDetails.getUsername())&& !isTokenExpired(token));
    }


}
