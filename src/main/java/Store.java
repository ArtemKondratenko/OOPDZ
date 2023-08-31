package main.java;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;


public class Store {

    private  int balance;
    ArrayList<Device> devices = new ArrayList<>();

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void saleDevices(Person person) throws IOException, SQLException, ClassNotFoundException {
        if(person.getMoney() >= devices.get(0).getSumma()) {
            person.comp = devices.get(0);
            balance += person.getMoney();
            person.setMoney(person.getMoney() - devices.get(0).getSumma());
            devices.remove(0);
            check(devices.get(0).toString());
            checkInDB(devices.get(0).toString());
        } else {
            System.out.println("Недостаточно средств на счёте");
        }
    }

    public  void  check(String text) throws IOException {
        File file = new File("C:\\Users\\Артем\\OOPDZ\\Check.txt");
        file.createNewFile();
        try (FileWriter writer = new FileWriter("Check.txt", false)) {
            // запись всей строки

            writer.write(text);
            // запись по символам
//            writer.append('\n');
//            writer.append('E');

            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void checkInDB(String text) throws IOException, SQLException, ClassNotFoundException {
//        Class.forName("org.h2.Driver");
        String url = "jdbc:mysql://localhost:3306/storage";
        String user = "root";
        String password = "A4510908687k!";
//        Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        Connection conn = DriverManager.getConnection(url, user, password);


        try {

            String sql = "INSERT INTO chec (info) VALUES (?)";
            try (PreparedStatement insertStmt = conn.prepareStatement(sql)) {
                insertStmt.setString(1, text);
                insertStmt.executeUpdate();
            }

            sql = "SELECT * FROM chec";
            try (PreparedStatement selectStmt = conn.prepareStatement(sql)) {
                ResultSet rs = selectStmt.executeQuery();

                // Вывод содержимого таблицы на экран
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("info");
                    System.out.println("id: " + id + ", chec: " + name);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Закрытие подключения
            conn.close();
        }
    }
}
