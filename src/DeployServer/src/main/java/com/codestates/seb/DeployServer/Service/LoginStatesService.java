package com.codestates.seb.DeployServer.Service;

import com.codestates.seb.DeployServer.Domain.LoginStates;

public interface LoginStatesService {
  public void InitializeStates(boolean isLogin, boolean isConnectedToDatabase);
  public LoginStates GetStates();
}