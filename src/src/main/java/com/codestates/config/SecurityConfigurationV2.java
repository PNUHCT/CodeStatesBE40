package com.codestates.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 데이터베이스 연동을 통한 Spring Security 학습용
 */
@Configuration
//@EnableWebSecurity(debug = true)
public class SecurityConfigurationV2 {
    @Bean
    public SecurityFilterChain filterChainV3(HttpSecurity http) throws Exception {
        http
            .headers().frameOptions().sameOrigin() // 설정 추가된 부분
            .and()
            .csrf().disable()
            .formLogin()
            .loginPage("/auths/login-form")
            .loginProcessingUrl("/process_login")
            .failureUrl("/auths/login-form?error")
            .and()
            .logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/")
            .and()
            .exceptionHandling().accessDeniedPage("/auths/access-denied")
            .and()
            .authorizeHttpRequests(authorize -> authorize
                    .antMatchers("/orders/**").hasRole("ADMIN")
                    .antMatchers("/members/my-page").hasRole("USER")
                    .antMatchers("/**").permitAll()
            );
        return http.build();
    }

    // InMemory User와 관련된 설정이 제거 됨.

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
