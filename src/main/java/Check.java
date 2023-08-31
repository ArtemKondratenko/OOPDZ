package main.java;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Check {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Артем\\OOPDZ\\Check.txt");
        file.createNewFile();
        try(FileWriter writer = new FileWriter("Check.txt", false))
        {
            // запись всей строки
            String text = "Hello Gold!";
            writer.write(text);
            // запись по символам
//            writer.append('\n');
//            writer.append('E');

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
