package main.java;

import java.sql.*;
import java.util.Scanner;

public class GoodsH2 {
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:tcp://localhost/~/goods";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";
    static Connection conn;

    static {
        try {
            conn = DriverManager.getConnection("jdbc:h2:~/goods", "sa", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static Statement stmt;

    static {
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public GoodsH2() throws SQLException {
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        run();


////        addProduct("Хлеб",100,connection);
////        getPriceProduct("Макароны",connection);
////        getProduct(connection);
//        getProductSum(300,connection);
    }
    public static void run() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");


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

    public static void addTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS goods (id INT AUTO_INCREMENT PRIMARY KEY, productName VARCHAR(255), priceName VARCHAR(255))";
        stmt.execute(sql);
    }


    public static void addProduct(String product, Integer priceGoods) throws SQLException {

        try {
//            String sql2 = "INSERT INTO goods (productName, priceName) VALUES (" + product +","+priceGoods+")";
            String sql3 = String.format("INSERT INTO goods (productName, priceName) VALUES ('%s', %d)", product, priceGoods);
//            String sql3 = String.format("INSERT INTO goods (productName, priceName) VALUES (%s,%d)",product,priceGoods);
            stmt.execute(sql3);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static   void getPriceProduct(String product) throws SQLException {

        try {
            String sql = "SELECT productName,priceName FROM goods";
            ResultSet rs = stmt.executeQuery(sql);
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

    public static   void getProduct() throws SQLException {
        try {
            String sql = "SELECT * FROM goods";
            ResultSet rs = stmt.executeQuery(sql);
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

    public static   void getProductFinder(String product) throws SQLException {
        try {
            String sql = "SELECT productName FROM goods";
            ResultSet rs = stmt.executeQuery(sql);
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

    public static   void getProductSum(int price) throws SQLException {
        try {
            String sql = "SELECT productName,priceName FROM goods";
            ResultSet rs = stmt.executeQuery(sql);
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

