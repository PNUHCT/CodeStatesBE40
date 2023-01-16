package com.codestates.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * InMemory User 학습용
 */
//@Configuration
public class SecurityConfigurationV1 {
    // 유어 클래스 코드 4-8 설정
    @Order(3)
    @Bean
    public SecurityFilterChain filterChainV1(HttpSecurity http) throws Exception {
        http
            .csrf().disable()                 // (1)
            .formLogin()                      // (2)
            .loginPage("/auths/login-form")   // (3)
            .loginProcessingUrl("/process_login")    // (4)
            .failureUrl("/auths/login-form?error")   // (5)
            .and()                                   // (6)
            .authorizeHttpRequests()                     // (7)
            .anyRequest()                            // (8)
            .permitAll();                            // (9)

        return http.build();
    }

    // 유어 클래스 코드 4-11 설정
    @Order(2)
    @Bean
    public SecurityFilterChain filterChainV2(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .formLogin()
            .loginPage("/auths/login-form")
            .loginProcessingUrl("/process_login")
            .failureUrl("/auths/login-form?error")
            .and()
            .exceptionHandling().accessDeniedPage("/auths/access-denied")   // (1)
            .and()
            .authorizeHttpRequests(authorize -> authorize                  // (2)
                    .antMatchers("/orders/**").hasRole("ADMIN")        // (2-1)
                    .antMatchers("/members/my-page").hasRole("USER")   // (2-2)
                    .antMatchers("/**").permitAll()                    // (2-3)
            );
        return http.build();
    }

    // 유어 클래스 코드 4-14 설정
    @Order(1)
    @Bean
    public SecurityFilterChain filterChainV3(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .formLogin()
            .loginPage("/auths/login-form")
            .loginProcessingUrl("/process_login")
            .failureUrl("/auths/login-form?error")
            .and()
            .logout()                        // (1)
            .logoutUrl("/logout")            // (2)
            .logoutSuccessUrl("/")  // (3)
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

    @Bean
    public UserDetailsManager userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("kevin@gmail.com")
                        .password("1111")
                        .roles("USER")
                        .build();

        UserDetails admin =
                User.withDefaultPasswordEncoder()
                        .username("admin@gmail.com")
                        .password("2222")
                        .roles("ADMIN")
                        .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
