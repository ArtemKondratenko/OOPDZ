package main.java;

import java.sql.*;
import java.util.Scanner;

public class GoodsMySQL {
    static String url = "jdbc:mysql://localhost:3306/testbd";
    static String user = "root";
    static String password = "A4510908687k!";
    static Connection conn;

    static {
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public GoodsMySQL() throws SQLException {
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        run();
    }

    public static void run() throws  SQLException {

        Scanner sc = new Scanner(System.in);
        addTable();

        boolean flag = true;
        while (flag){
            String action = sc.next();
            if(action.equals("Выход")) {
                conn.close();
                flag = false;
            }else if(action.equals("1")) {
                String product1 = sc.next();
                int price1 = sc.nextInt();
                addProduct(product1,price1);
            }else if(action.equals("Сколько стоит продукт")) {
                String product2 = sc.next();

                getPriceProduct(product2);
            }else if(action.equals("2")) {
                getProduct();
            }else if(action.equals("Вывести продукты которые стоят")) {
                int price2 = sc.nextInt();
                getProductSum(price2);
            }else if(action.equals("Есть ли продукт")){
                String product3 = sc.next();
                getProductFinder(product3);
            }
        }
    }

    public static void addTable()  {
        String sql = "CREATE TABLE IF NOT EXISTS goods (id INT AUTO_INCREMENT PRIMARY KEY, productName VARCHAR(255), priceName VARCHAR(255))";
        try (PreparedStatement selectStmt = conn.prepareStatement(sql)) {
            selectStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static void addProduct(String product, Integer priceGoods)  {
        String sql = "INSERT INTO goods (productName, priceName) VALUES (?, ?)";
        try (PreparedStatement insertStmt = conn.prepareStatement(sql)) {
            insertStmt.setString(1,product);
            insertStmt.setInt(2,priceGoods);
            insertStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static   void getPriceProduct(String product) {
        String sql = "SELECT productName,priceName FROM goods";
        try (PreparedStatement selectStmt = conn.prepareStatement(sql)){
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
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static   void getProduct()  {
        String sql = "SELECT * FROM goods";
        try (PreparedStatement selectStmt = conn.prepareStatement(sql)) {
            ResultSet rs = selectStmt.executeQuery();
            while (rs.next()) {
//                    int id = rs.getInt("id");
                String name = rs.getString("productName");
                int prices = rs.getInt("priceName");
                System.out.println(name + " " + prices);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static   void getProductFinder(String product)  {
        String sql = "SELECT productName FROM goods";
        try (PreparedStatement selectStmt = conn.prepareStatement(sql)){
            ResultSet rs = selectStmt.executeQuery(sql);
            while (rs.next()) {
//                    int id = rs.getInt("id");
                String name = rs.getString("productName");
                if(name.equals(product)) {
                    System.out.println("Есть");
                }
//                    int prices = rs.getInt("priceName");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static   void getProductSum(int price) {
        String sql = "SELECT productName,priceName FROM goods";
        try (PreparedStatement selectStmt = conn.prepareStatement(sql)){
            ResultSet rs = selectStmt.executeQuery(sql);
            while (rs.next()) {
//                    int id = rs.getInt("id");
                String name = rs.getString("productName");
                int prices = rs.getInt("priceName");
                if (prices == price) {
                    System.out.println(name);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

