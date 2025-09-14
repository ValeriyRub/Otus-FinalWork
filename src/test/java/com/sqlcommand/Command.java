package com.sqlcommand;

import java.sql.*;

public class Command {

    // Получение wish из базы
    public static boolean checkWishlistTitleExists(String title) {
        String url = ConnectionConfig.getUrl();
        String username = ConnectionConfig.getUsername();
        String password = ConnectionConfig.getPassword();

        String sqlQuery = "SELECT title FROM wishlists WHERE title = ?";

        try (Connection con = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = con.prepareStatement(sqlQuery)) {

            statement.setString(1, title);
            ResultSet result = statement.executeQuery();

            return result.next(); // Если есть результат - запись существует

        } catch (SQLException ex) {
            System.out.println("Ошибка при подключении к базе: " + ex.getMessage());
            return false;
        }
    }}