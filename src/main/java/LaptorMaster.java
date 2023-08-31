package main.java;

public class LaptorMaster{

    public void fixComp(Device computer) throws DeviceIncorrectType {
        if (computer instanceof Marching) {
            computer.inclusionComp();
        } else {
            throw new DeviceIncorrectType("Компьютер не является переносным дивайсом , а является классом Домашний!");}
    }
}
