package br.com.rpires.dao.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/EXERCICIO_2";

    private static final String USER = "postgres";
    private static final String PASSWORD = "821655";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}