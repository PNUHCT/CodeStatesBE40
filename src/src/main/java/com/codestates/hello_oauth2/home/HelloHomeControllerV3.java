package com.codestates.hello_oauth2.home;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 인증된 Authentication 조회 2
 */
//@Controller
public class HelloHomeControllerV3 {
    @GetMapping("/hello-oauth2")
    public String home(Authentication authentication) {
        var oAuth2User = (OAuth2User)authentication.getPrincipal();
        System.out.println(oAuth2User);
        System.out.println("User's email in Google: " + oAuth2User.getAttributes().get("email"));

        return "hello-oauth2";
    }
}
