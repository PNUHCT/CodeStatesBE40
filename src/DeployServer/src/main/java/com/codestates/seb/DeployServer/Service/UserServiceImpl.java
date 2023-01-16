package com.codestates.seb.DeployServer.Service;

import com.codestates.seb.DeployServer.Data.UserData;
import com.codestates.seb.DeployServer.Domain.UserDTO;
import com.codestates.seb.DeployServer.Repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  private final UserLoginRepository userLoginRepository;

  @Autowired
  public UserServiceImpl(UserLoginRepository userLoginRepository) {
    this.userLoginRepository = userLoginRepository;
  }

  @Override
  public Boolean UserSelectionByInfo(String id, String password) {
    return userLoginRepository.FindByUserInfo(id, password);
  }
}
