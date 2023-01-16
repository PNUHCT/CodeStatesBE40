package com.codestates.seb.DeployServer.Data;

import com.codestates.seb.DeployServer.Domain.UserDTO;

import java.util.ArrayList;

public class UserData {
  private static final UserData instance = new UserData();
  public ArrayList<UserDTO> UserList = new ArrayList<>();

  public static UserData getInstance() {
    return instance;
  }

  private UserData() {
    UserList.add(UserDTO.builder()
        .id("김코딩")
        .password("1234")
        .build());
  }
}