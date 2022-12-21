package com.codestates.hello_oauth2.home;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 인증된 Authentication 조회 1
 */
//@Controller
public class HelloHomeControllerV2 {
    @GetMapping("/hello-oauth2")
    public String home() {
        var oAuth2User = (OAuth2User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        System.out.println(oAuth2User);
        System.out.println("User's email in Google: " + oAuth2User.getAttributes().get("email"));
        System.out.println("Authorities in Google: " + oAuth2User.getAuthorities());

        return "hello-oauth2";
    }
}
