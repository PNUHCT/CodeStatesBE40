package com.codestates.seb.DeployServer.Controller;

import com.codestates.seb.DeployServer.Domain.LoginStates;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

public interface UserLoginController {
  public String MainTitle();
  public ResponseEntity<String> UserLogin(@RequestBody(required = true) Map<String, String> userInfo);
  public ResponseEntity<LoginStates> StatusLogin(@RequestHeader(required = false) Map<String, Object> requestHeader);
}
