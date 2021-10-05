package ru.gb.db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static final String DB_PATH = "src/resources/db/users.db";

    public static Connection getConnection() {
        var dbFile = new File(DB_PATH);
        try {
            return DriverManager.getConnection(
                    String.format("jdbc:sqlite:%s", dbFile.getAbsoluteFile()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void rollback(Connection connection) {
        try {
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}