package com.codestates.hello_oauth2.home;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 인증된 Authentication 조회 3
 */
//@Controller
public class HelloHomeControllerV4 {
    @GetMapping("/hello-oauth2")
    public String home(@AuthenticationPrincipal OAuth2User oAuth2User) {
        System.out.println(oAuth2User);
        System.out.println("User's email in Google: " + oAuth2User.getAttributes().get("email"));

        return "hello-oauth2";
    }
}
