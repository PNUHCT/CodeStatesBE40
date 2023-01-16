package com.codestates.seb.DeployServer.Controller;

import com.codestates.seb.DeployServer.Domain.LoginStates;
import com.codestates.seb.DeployServer.Service.DatabaseService;
import com.codestates.seb.DeployServer.Service.LoginStatesService;
import com.codestates.seb.DeployServer.Service.TokenService;
import com.codestates.seb.DeployServer.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserLoginControllerImpl implements UserLoginController {
  private final UserService userService;
  private final TokenService tokenService;
  private final LoginStatesService loginStatesService;
  private final DatabaseService databaseService;

  @Autowired
  public UserLoginControllerImpl(UserService userService, TokenService tokenService, LoginStatesService loginStatesService, DatabaseService databaseService) {
    this.userService = userService;
    this.tokenService = tokenService;
    this.loginStatesService = loginStatesService;
    this.databaseService = databaseService;
  }

  @Value("${spring.datasource.url}")
  private String url;
  @Value("${spring.datasource.username}")
  private String username;
  @Value("${spring.datasource.password}")
  private String password;

  @GetMapping(value = "/")
  public String MainTitle() {
    return "Hello Spring World!";
  }

  @PostMapping(value = "/signin")
  public ResponseEntity<String> UserLogin(@RequestBody(required = true) Map<String, String> userInfo) {
    if (userService.UserSelectionByInfo(userInfo.get("username"), userInfo.get("password"))) {
      return ResponseEntity.ok().body(tokenService.CreateAccessToken(userInfo.get("username"), userInfo.get("password")));
    } else {
      return ResponseEntity.status(401).body("");
    }
  }

  @GetMapping(value = "/status")
  public ResponseEntity<LoginStates> StatusLogin(@RequestHeader(required = false) Map<String, Object> requestHeader) {
    Object authorization = requestHeader.get("authorization");
    if (authorization.toString().length() > 11) {
      loginStatesService.InitializeStates(true, databaseService.testConnect(url, username, password));
    } else {
      loginStatesService.InitializeStates(false, false);
    }
    LoginStates loginStates = loginStatesService.GetStates();
    return ResponseEntity.status(loginStates.isLogin() ? 200 : 401).body(loginStates);
  }
}
