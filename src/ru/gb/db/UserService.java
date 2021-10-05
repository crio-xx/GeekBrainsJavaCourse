package ru.gb.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {

    public static List<User> findAll() {
        Connection connection = DbConnection.getConnection();
        List<User> users = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                users.add(
                        new User(
                                rs.getString("name"),
                                rs.getString("login"),
                                rs.getString("password")
                        )
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DbConnection.close(connection);
        }
        return users;
    }


    public static Optional<User> findByLogin(String login) {
        Connection connection = DbConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE login = ?");
            statement.setString(1, login);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return Optional.of(
                        new User(
                                rs.getString("name"),
                                rs.getString("login"),
                                rs.getString("password")
                        )
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DbConnection.close(connection);
        }

        return Optional.empty();
    }

    public static void save(User user) {
        Connection connection = DbConnection.getConnection();

        try {
            connection.setAutoCommit(false);

            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO users (name, login, password) VALUES (?, ?, ?)");
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());

            statement.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            DbConnection.rollback(connection);
            throw new RuntimeException(e);
        } finally {
            DbConnection.close(connection);
        }
    }

    public static void delete(User user) {
        Connection connection = DbConnection.getConnection();

        try {
            connection.setAutoCommit(false);

            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM users WHERE " +
                            "name = ? AND " +
                            "login = ?");
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            DbConnection.rollback(connection);
            throw new RuntimeException(e);
        } finally {
            DbConnection.close(connection);
        }
    }
}
