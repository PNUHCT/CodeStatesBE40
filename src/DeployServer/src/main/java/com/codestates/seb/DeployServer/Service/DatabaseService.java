package com.codestates.seb.DeployServer.Service;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;

@Service
public class DatabaseService {
  public boolean testConnect(String url, String username, String password) {
    try {
      Connection conn = DriverManager.getConnection(url, username, password);
      conn.close();
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}

