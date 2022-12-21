package com.codestates.hello_oauth2.home;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Access Token 정보 조회 1
 */
//@Controller
public class HelloHomeControllerV5 {
    private final OAuth2AuthorizedClientService authorizedClientService;


    public HelloHomeControllerV5(OAuth2AuthorizedClientService authorizedClientService) {
        this.authorizedClientService = authorizedClientService;
    }

    @GetMapping("/hello-oauth2")
    public String home(Authentication authentication) {
        var authorizedClient = authorizedClientService.loadAuthorizedClient("google", authentication.getName());

        OAuth2AccessToken accessToken = authorizedClient.getAccessToken();
        System.out.println("Access Token Value: " + accessToken.getTokenValue());
        System.out.println("Access Token Type: " + accessToken.getTokenType().getValue());
//        System.out.println("Access Token Scopes: " + accessToken.getScopes());
        System.out.println("Access Token Issued At: " + accessToken.getIssuedAt());
        System.out.println("Access Token Expires At: " + accessToken.getExpiresAt());

        return "hello-oauth2";
    }
}
