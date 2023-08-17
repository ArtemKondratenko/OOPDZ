package main.java;

import java.sql.*;
import java.util.Scanner;

public class Goods {
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:tcp://localhost/~/goods";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:~/goods", "sa", "");
        Statement stmt = conn.createStatement();
        Scanner sc = new Scanner(System.in);

        boolean flag = true;
        while (flag){
            String action = sc.next();
            if(action.equals("Выход")) {
                flag = false;
            }else if(action.equals("Вставить в таблицу товар")) {
                String product1 = sc.next();
                int price1 = sc.nextInt();
                addProduct(product1,price1,stmt);
            }else if(action.equals("Сколько стоит продукт")) {
                String product2 = sc.next();

                getPriceProduct(product2, stmt);
            }else if(action.equals("Посмотреть все продукты")) {
                getProduct();
            }else if(action.equals("Вывести продукты которые стоят")) {
                int price2 = sc.nextInt();
                getProductSum(price2);
            }else if(action.equals("Есть ли продукт")){
                String product3 = sc.next();
                getProductFinder(product3);
            }
        }

////        addProduct("Хлеб",100,connection);
////        getPriceProduct("Макароны",connection);
////        getProduct(connection);
//        getProductSum(300,connection);
    }


    public static void addProduct(String product, Integer priceGoods, Statement stmt) throws SQLException {

        try {
            String sql = "CREATE TABLE IF NOT EXISTS goods (id INT AUTO_INCREMENT PRIMARY KEY, productName VARCHAR(255), priceName VARCHAR(255)";
            stmt.executeUpdate(sql);
            String sql2 = "INSERT INTO goods (productName, priceName) VALUES (product,priceGoods)";
            stmt.executeUpdate(sql2);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getPriceProduct(String product, Connection connection, stmt) throws SQLException {

        try {
            String sql = "SELECT productName,priceName FROM goods";
            try (PreparedStatement selectStmt = connection.prepareStatement(sql)) {
                ResultSet rs = selectStmt.executeQuery();
                while (rs.next()) {
//                    int id = rs.getInt("id");
                    String name = rs.getString("productName");
                    int prices = rs.getInt("priceName");
                    if (name.equals(product)) {
                        System.out.println(prices);
                        break;
                    }
//                    System.out.println(prices + name);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public static void getProduct(Connection connection) throws SQLException {
        try {
            String sql = "SELECT productName FROM goods";
            try (PreparedStatement selectStmt = connection.prepareStatement(sql)) {
                ResultSet rs = selectStmt.executeQuery();
                while (rs.next()) {
//                    int id = rs.getInt("id");
                    String name = rs.getString("productName");
//                    int prices = rs.getInt("priceName");
                    System.out.println(name);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public static void getProductFinder(String product, Connection connection) throws SQLException {
        try {
            String sql = "SELECT productName FROM goods";
            try (PreparedStatement selectStmt = connection.prepareStatement(sql)) {
                ResultSet rs = selectStmt.executeQuery();
                while (rs.next()) {
//                    int id = rs.getInt("id");
                    String name = rs.getString("productName");
                    if(name.equals(product)) {
                        System.out.println("Есть");
                    }
//                    int prices = rs.getInt("priceName");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }

    public static void getProductSum(int price, Connection connection) throws SQLException {
        try {
            String sql = "SELECT productName,priceName FROM goods";
            try (PreparedStatement selectStmt = connection.prepareStatement(sql)) {
                ResultSet rs = selectStmt.executeQuery();
                while (rs.next()) {
//                    int id = rs.getInt("id");
                    String name = rs.getString("productName");
                    int prices = rs.getInt("priceName");
                    if (prices == price) {
                        System.out.println(name);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
}

