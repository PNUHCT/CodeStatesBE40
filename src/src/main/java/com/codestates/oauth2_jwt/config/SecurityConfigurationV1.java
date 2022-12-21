package com.codestates.oauth2_jwt.config;

import com.codestates.member.service.MemberService;
import com.codestates.oauth2_jwt.jwt.JwtTokenizer;
import com.codestates.oauth2_jwt.auth.handler.OAuth2MemberSuccessHandler;
import com.codestates.oauth2_jwt.utils.CustomAuthorityUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * OAuth 2 로그인 인증 및 Frondend로 Redirect
 */
//@Configuration
//@EnableWebSecurity(debug = true)
public class SecurityConfigurationV1 {
    private final JwtTokenizer jwtTokenizer;
    private final CustomAuthorityUtils authorityUtils;
    private final MemberService memberService;             // V1에서는 아직 사용하지 않습니다.

    public SecurityConfigurationV1(JwtTokenizer jwtTokenizer,
                                   CustomAuthorityUtils authorityUtils,
                                   MemberService memberService) {
        this.jwtTokenizer = jwtTokenizer;
        this.authorityUtils = authorityUtils;
        this.memberService = memberService;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .headers().frameOptions().sameOrigin()
            .and()
            .csrf().disable()
            .cors(withDefaults())
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .formLogin().disable()
            .httpBasic().disable()
            .authorizeHttpRequests(authorize -> authorize
                    .anyRequest().authenticated()
            )
            .oauth2Login(oauth2 -> oauth2
                    .successHandler(new OAuth2MemberSuccessHandler(jwtTokenizer, authorityUtils, memberService)) // V1에서는 memberService를 아직 사용하지 않습니다.
            );

        return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST", "PATCH", "DELETE"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
