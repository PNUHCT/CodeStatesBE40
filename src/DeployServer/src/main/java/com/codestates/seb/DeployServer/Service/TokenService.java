package com.codestates.seb.DeployServer.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {
  public String CreateAccessToken(String id, String password) {
    if (!id.equals("") || !password.equals("")) {
      return Jwts.builder()
          .setIssuedAt(new Date(System.currentTimeMillis())) // (3)
          .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // (4)
          .claim("id", id) // (5)
          .claim("password", password)
          .signWith(SignatureAlgorithm.HS256, "c3ByaW5nLWJvb3Qtc2VjdXJpdHktand0LXR1dG9yaWFsLWppd29vbi1zcHJpbmctYm9vdC1zZWN1cml0eS1qd3QtdHV0b3JpYWwK") // (6)
          .compact();
    }
    return null;
  }
}
