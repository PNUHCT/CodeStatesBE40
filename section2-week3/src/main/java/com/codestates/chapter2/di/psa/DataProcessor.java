package com.codestates.chapter2.di.psa;

import java.sql.Connection;

public class DataProcessor {
    private Connection connection;

    public DataProcessor(JdbcConnector connector) {
        this.connection = connector.getConnection();
    }

    public void insert() {
        // 실제로는 connection 객체를 이용해서 데이터를 insert 할 수 있다.
        System.out.println("inserted data");
    }
}