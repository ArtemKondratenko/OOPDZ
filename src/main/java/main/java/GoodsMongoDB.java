package main.java;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.*;
import org.bson.Document;

import java.sql.SQLException;
import java.util.Scanner;


public class GoodsMongoDB {
    static MongoClient  mongoClient = new MongoClient("localhost", 27017);
    static MongoDatabase database = mongoClient.getDatabase("mydatabase");

    static MongoCollection<Document> collection = database.getCollection("mycollection");



    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        run();
    }

    public static void run() throws  SQLException {

        Scanner sc = new Scanner(System.in);

        boolean flag = true;
        while (flag){
            String action = sc.next();
            if(action.equals("Выход")) {
                mongoClient.close();
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

    public static void addProduct(String product, Integer priceGoods)  {
        Document document = new Document("productName", product)
                .append("priceName", priceGoods);
        try {
            collection.insertOne(document);
            System.out.println("Продукт добавлен в коллекцию.");
        } catch (MongoException e) {
            System.out.println("Ошибка при добавлении продукта: " + e.getMessage());
        }
    }

    public static  void getPriceProduct(String product) {
        try {
            FindIterable<Document> documents = collection.find();
            MongoCursor<Document> cursor = documents.iterator();
            while (cursor.hasNext()) {
                Document document = cursor.next();
                String nameProduct = document.getString("productName");
                int prices = document.getInteger("priceName");
                if (nameProduct.equals(product)) {
                    System.out.println(prices);
                    break;
                }
            }
        } catch (MongoException e) {
            System.out.println("Ошибка при получении продуктов: " + e.getMessage());
        }
    }

    public static  void getProduct() {
        try {
            MongoIterable<String> collectionNames = database.listCollectionNames();
            for (String collectionName : collectionNames) {
                System.out.println(collectionName);
            }
        } catch (MongoException e) {
            System.out.println("Ошибка при получении списка продуктов: " + e.getMessage());
        }
    }

    public static  void getProductFinder(String product)  {
        try {
            FindIterable<Document> documents = collection.find();
            MongoCursor<Document> cursor = documents.iterator();
            while (cursor.hasNext()) {
                Document document = cursor.next();
                String nameProduct = document.getString("productName");
                int prices = document.getInteger("priceName");
                if (nameProduct.equals(product)) {
                    System.out.println("Есть");
                    break;
                }
            }
        } catch (MongoException e) {
            System.out.println("Ошибка при получении продуктов: " + e.getMessage());
        }
    }

    public static   void getProductSum(int price) {
        try {
            FindIterable<Document> documents = collection.find();
            MongoCursor<Document> cursor = documents.iterator();
            while (cursor.hasNext()) {
                Document document = cursor.next();
                String nameProduct = document.getString("productName");
                int prices = document.getInteger("priceName");
                if (prices == price) {
                    System.out.println(nameProduct);
                    break;
                }
            }
        } catch (MongoException e) {
            System.out.println("Ошибка при получении продуктов: " + e.getMessage());
        }
    }
}

