import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

    public void saleDevices(Person person) throws IOException {
        if(person.getMoney() >= devices.get(0).getSumma()) {
            person.comp = devices.get(0);
            balance += person.getMoney();
            person.setMoney(person.getMoney() - devices.get(0).getSumma());
            devices.remove(0);
            check(devices.get(0).toString());
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
}
