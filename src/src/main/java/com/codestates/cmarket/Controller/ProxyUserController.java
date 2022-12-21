package com.codestates.cmarket.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Primary
@RestController
public class ProxyUserController implements UserController{

  @Autowired
  UserControllerImpl userControllerImpl;

  @Override
  @RequestMapping(value = "/user", method = RequestMethod.GET)
  public String signupUser() {
    long startTime = System.currentTimeMillis();
    String result = userControllerImpl.signupUser();
    long endTime = System.currentTimeMillis();
    long callTime = endTime - startTime;
    System.out.println(callTime);
    return result;
  }
}
