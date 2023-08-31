package main.java;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws DeviceIncorrectType, IOException, SQLException, ClassNotFoundException {
        Computer comp = new Computer();
        Person person = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        Person person4 = new Person();
        PCMaster pcMaster = new PCMaster();
        NoteBook noteBook = new NoteBook();
        Device comp2 = new Computer(600, "WD", 6);
        Device comp3 = new Computer(700, "Mac", 9);
        Device comp4 = new Computer("Linux",4);
        Device comp5 = new Computer("WB",7);
        Store store = new Store();



//        person2.setMoney(1500);
//        comp.setSumma(1000);
//
//        store.devices.add(comp);
//        store.devices.add(comp2);
//        store.devices.add(comp3);
//        store.devices.add(comp4);
//        store.saleDevices(person2);
//
//
//
//
////        Masterskay masterskay = new Masterskay();
////        masterskay.master = pcMaster;
//
//        Person[] arrayListPerson = {person, person2, person3, person4};
//        person.setMoney(10);
//        person2.setMoney(10);
//        person3.setMoney(10);
//        person4.setMoney(10);
//
//        Device computer = new NetBook();
//
//
//        person.comp = comp2;
//        person2.comp = comp3;
//        person3.comp = comp4;
//        person4.comp = noteBook;
//
////        System.out.println((comp2 instanceof  Computer) + " стр 35");
////        System.out.println((person4.comp instanceof  Marching) + " стр 36");
//
//        person.namePerson = "Наташа";
//        person2.namePerson = "Иван";
//        person3.namePerson = "Ольга";
//        person4.namePerson = "Петя";
//
//        HashMap<String,Device> nameOper = new HashMap<>();
//        nameOper.put(person.namePerson,person.comp);
//        nameOper.put(person2.namePerson,person2.comp);
//        nameOper.put(person3.namePerson,person3.comp);
//        nameOper.put(person4.namePerson,person4.comp);
////        System.out.println(nameOper.toString());
//
//        int countHome = 0;
//        int countMarch = 0;
//        for (Map.Entry<String, Device> entry: nameOper.entrySet()){
//            if(entry.getValue() instanceof Home) {
//                countHome++;
//            } else {countMarch++;}
//        }
//        System.out.println("Количество домашних девайсов = "+countHome);
//        System.out.println("Количество переносных девайсов = "+countMarch);
//
//
//        Set<String> personSet = new HashSet<>();
//
//
//
//
//       Device[] deviceArrayList = new Device[arrayListPerson.length];
//        //Вывод суммых денег всех людей
//        int sum = 0;
//        for (int i = 0; i < arrayListPerson.length; i++) {
//            personSet.add(arrayListPerson[i].namePerson);
//            sum += arrayListPerson[i].getMoney();
//            System.out.println(arrayListPerson[i].comp);
//        }
//        System.out.println(sum);
//
//        for (String s: personSet) {
//            System.out.println(s);
//        }
//
////        pcMaster.fixComp(noteBook);
////        pcMaster.fixComp(comp);
//
//
//        comp.setSsdSize(500);
//        comp.setOperationSystemName("Linux");
//        comp.setOzuSize(8);
//
//
//        comp.inclusionComp();
//        comp2.inclusionComp();
//        comp3.inclusionComp();
//        comp4.inclusionComp();
//        comp5.inclusionComp();
//
//        person.comp = comp2;
//        person2.comp = comp3;
//        person3.comp = comp4;
//        person4.comp = comp5;
//
//        System.out.println(comp.inclusion);
//        System.out.println(comp2.inclusion);
//        System.out.println(comp3.inclusion);
//        System.out.println(comp4.inclusion);
//        System.out.println(comp5.inclusion);
//
//        comp.inclusionComp();
//        comp2.inclusionComp();
//        comp3.inclusionComp();
//        comp4.inclusionComp();
//        comp5.inclusionComp();

//        pcMaster.fixComp(noteBook);
    }
}
