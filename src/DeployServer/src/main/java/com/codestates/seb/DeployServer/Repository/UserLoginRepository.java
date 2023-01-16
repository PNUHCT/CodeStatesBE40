package com.codestates.seb.DeployServer.Repository;

public interface UserLoginRepository {
  public Boolean FindByUserInfo(String id, String password);
}
