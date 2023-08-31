package main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ResponseBD {
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:tcp://localhost/~/goods";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";

    public Connection connectionBd() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:~/goods", "sa", "");
        Statement stmt = conn.createStatement();

//        Нижний скрипт это вид подключения через БД MySQL
//        String url = "jdbc:mysql://localhost:3306/goods";
//        String user = "root";
//        String password = "A4510908687k!";
//        Connection connection = DriverManager.getConnection(url, user, password);
        return conn;
    }
}
