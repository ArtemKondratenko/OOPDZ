package main.java;

public class Masterskay {

    Master master;
    public void work(Device device)  {
        try {
            master.fixComp(device);
        } catch (Exception ex) {
            System.out.println("Упало!");
            ex.getStackTrace();
        }
    }
}
