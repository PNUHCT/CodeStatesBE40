package com.codestates.seb.DeployServer.Repository;

import com.codestates.seb.DeployServer.Domain.LoginStates;

public interface LoginStatesRepository {
  public void InitializeLoginStates(boolean isLogin, boolean isConnectedToDatabase);
  public LoginStates GetLoginStates();
}
