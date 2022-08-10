package com.codestates.chapter2.di.psa;

import java.sql.Connection;

public interface JdbcConnector {
    Connection getConnection();
}