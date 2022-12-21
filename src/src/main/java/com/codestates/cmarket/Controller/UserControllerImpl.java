package com.codestates.cmarket.Controller;

import com.codestates.cmarket.user.User;
import com.codestates.cmarket.user.UserGrade;
import com.codestates.cmarket.user.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerImpl implements UserController{

  private final UserService userService;

  public UserControllerImpl(UserService userService) {
    this.userService = userService;
  }

  @Override
  @RequestMapping(value = "/user", method = RequestMethod.GET)
  public String signupUser() {
    User user = new User(0L, "Kimcoding", UserGrade.GRADE_1);
    userService.signup(user);
    return user.getName();
  }
}
