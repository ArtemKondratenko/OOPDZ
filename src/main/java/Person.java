package main.java;

public class Person {
    Device comp;
    private int money;
    String namePerson;

//    public void sellComp(Person person, int money){
//        if(comp != null )  {
//            if(person.money >= money) {
//                this.money += money;
//                person.money -= money;
//                comp = null;
//                person.comp = comp;
//            }else {
//                System.out.println("Денег не хватило!");
//            }
//        }else {
//            System.out.println("Комьютера нет!");
//        }
//    }
    public void sellComp(Person person, int money){
        if(comp != null && person.money >= money)  {
            this.money += money;
            person.money -= money;
            comp = null;
            person.comp = comp;
        }else {
            System.out.println("Сделка не состоялась!");
        }
    }



    public int getMoney() {
        return money;
    }

    public Person setMoney(int money) {
        this.money = money;
        return null;
    }
}
