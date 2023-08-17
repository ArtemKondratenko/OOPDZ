package main.java;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.sql.*;


public class WorkingBd {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/testbd";
        String user = "root";
        String password = "A4510908687k!";
        Connection connection = DriverManager.getConnection(url, user, password);
        String sql = "SELECT * FROM books";
        try{
            try(PreparedStatement statement = connection.prepareStatement(sql)){
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("idBooks");
                    String name = rs.getString("NameBooks");
                    System.out.println("id" + id + " " + "Название книги" + name);
                    }
                }
            }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public static   void insertion(Connection connection) throws SQLException {
        try{
            String sql = "INSERT INTO books (NameBooks) VALUES (\"Пушкин\")";
            try (PreparedStatement insertStmt = connection.prepareStatement(sql)) {
                insertStmt.executeUpdate();
            }
            Statement lastIdStmt = connection.createStatement();
            ResultSet lastIdResult = lastIdStmt.executeQuery("SELECT LAST_INSERT_ID()");
            if (lastIdResult.next()) {
                int lastId = lastIdResult.getInt(1);
                System.out.println("Последний индекс последней строки: " + lastId);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            connection.close();
        }
    }
}
