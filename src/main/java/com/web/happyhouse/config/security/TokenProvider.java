package com.web.happyhouse.config.security;

import com.web.happyhouse.advice.exception.AuthenticationEntryPointException;
import com.web.happyhouse.advice.exception.NotFoundUserException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.Base64UrlCodec;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class TokenProvider{

    @Value("spring.jwt.secret")
    private String secretKey;
    private String ROLES = "roles";
    private final Long tokenValidMillisecond = 60 * 60 * 1000L; // 1 hour
    private final UserDetailsService userDetailsService;

    @PostConstruct
    protected void init() {
        // 암호화
        secretKey = Base64UrlCodec.BASE64URL.encode(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    // Jwt 생성
    public String createTokenDto(Long userPk, List<String> roles) {

        // Claims 에 user 구분을 위한 User pk 및 authorities 목록 삽입
        Claims claims = Jwts.claims().setSubject(String.valueOf(userPk));
        claims.put(ROLES, roles);

        // 생성날짜, 만료날짜를 위한 Date
        Date now = new Date();

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + tokenValidMillisecond))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // Jwt 로 인증정보를 조회
    public Authentication getAuthentication(String token) {

        // Jwt 에서 claims 추출
        Claims claims = parseClaims(token);

        // 권한 정보가 없음
        if (claims.get(ROLES) == null) {
            throw new AuthenticationEntryPointException("잘못된 접근입니다.");
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(claims.getSubject());
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    // Jwt 토큰 복호화해서 가져오기
    private Claims parseClaims(String token) {
        try {
            return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }

    // jwt 의 유효성 및 만료일자 확인
    public boolean validationToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (SecurityException | MalformedJwtException e) {
            log.error("잘못된 Jwt 서명입니다.");
        } catch (ExpiredJwtException e) {
            log.error("만료된 토큰입니다.");
        } catch (UnsupportedJwtException e) {
            log.error("지원하지 않는 토큰입니다.");
        } catch (IllegalArgumentException e) {
            log.error("잘못된 토큰입니다.");
        } catch (SignatureException e){
            log.error("잘못된 토큰입니다.");
        }
        return false;
    }

}