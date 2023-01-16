package com.codestates.seb.DeployServer.Repository;

import com.codestates.seb.DeployServer.Data.UserData;
import com.codestates.seb.DeployServer.Domain.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserLoginRepositoryImpl implements UserLoginRepository {
  public UserLoginRepositoryImpl() {
  }

  @Override
  public Boolean FindByUserInfo(String id, String password) {
    Optional<UserDTO> userData = UserData.getInstance().UserList.stream().filter(data -> data.getId().equals(id))
        .filter(data -> data.getPassword().equals(password)).findFirst();
    return userData.isPresent();
  }
}