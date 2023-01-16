package com.codestates.seb.DeployServer.Data;

import com.codestates.seb.DeployServer.Domain.LoginStates;

public class LoginData {
  private static final LoginData instance = new LoginData();
  public LoginStates LoginList = new LoginStates();

  public static LoginData getInstance() {
    return instance;
  }
}
