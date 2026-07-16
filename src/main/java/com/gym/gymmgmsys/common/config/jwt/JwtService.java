package com.gym.gymmgmsys.common.config.jwt;
import com.gym.gymmgmsys.common.config.JwtProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class JwtService {

    private final JwtProperties jwtProperties;

    /**
     * Secret Key
     */
    private SecretKey getSigningKey() {

        return Keys.hmacShaKeyFor(
                jwtProperties
                        .getSecret()
                        .getBytes(StandardCharsets.UTF_8)
        );

    }

    /**
     * Generate Access Token
     */
    public String generateToken(UserDetails userDetails){

        return Jwts.builder()

                .subject(userDetails.getUsername())

                .issuedAt(new Date())

                .expiration(
                        new Date(
                                System.currentTimeMillis()
                                        + jwtProperties.getAccessTokenExpiration()
                        )
                )

                .signWith(getSigningKey())

                .compact();

    }

    /**
     * Generate Refresh Token
     */
    public String generateRefreshToken(UserDetails userDetails){

        return Jwts.builder()

                .subject(userDetails.getUsername())

                .issuedAt(new Date())

                .expiration(
                        new Date(
                                System.currentTimeMillis()
                                        + jwtProperties.getRefreshTokenExpiration()
                        )
                )

                .signWith(getSigningKey())

                .compact();

    }

    /**
     * Extract Username
     */
    public String extractUsername(String token){

        return extractClaim(token, Claims::getSubject);

    }

    /**
     * Extract Expiration
     */
    public Date extractExpiration(String token){

        return extractClaim(token, Claims::getExpiration);

    }

    /**
     * Generic Claim Extractor
     */
    public <T> T extractClaim(String token,
                              Function<Claims,T> resolver){

        Claims claims = extractAllClaims(token);

        return resolver.apply(claims);

    }

    /**
     * Parse Token
     */
    private Claims extractAllClaims(String token){

        return Jwts.parser()

                .verifyWith(getSigningKey())

                .build()

                .parseSignedClaims(token)

                .getPayload();

    }

    /**
     * Validate Token
     */
    public boolean isTokenValid(String token,
                                UserDetails userDetails){

        String username = extractUsername(token);

        return username.equals(userDetails.getUsername())
                && !isTokenExpired(token);

    }

    /**
     * Expiry Check
     */
    private boolean isTokenExpired(String token){

        return extractExpiration(token)
                .before(new Date());

    }

}