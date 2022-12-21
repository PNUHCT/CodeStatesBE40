package com.codestates.chapter2.di.psa;

import java.sql.Connection;

public class OracleJdbcConnector implements JdbcConnector {
    @Override
    public Connection getConnection() {
        return null;
    }
}