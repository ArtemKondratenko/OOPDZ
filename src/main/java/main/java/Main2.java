package main.java;

import java.sql.*;

public class Main2 {
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:tcp://localhost/~/test";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");

        try {
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255))";
            stmt.executeUpdate(sql);
            String sql2 = "INSERT INTO users (name) VALUES ('John')";
            stmt.executeUpdate(sql2);
        // Получение содержимого таблицы

            String sql3 = "SELECT * FROM users";

            ResultSet rs = stmt.executeQuery(sql3);

            // Вывод содержимого таблицы на экран
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                System.out.println("id: " + id + ", name: " + name);
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Закрытие подключения
        conn.close();

    }
}

