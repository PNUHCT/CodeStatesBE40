package com.codestates.chapter2.di.psa;

public class DbClient {
    public static void main(String[] args) {
        // Spring DI로 대체 가능
        JdbcConnector connector = new SQLiteJdbcConnector(); // (1)

        // Spring DI로 대체 가능
        DataProcessor processor = new DataProcessor(connector); // (2)
        processor.insert();
    }
}