public class PCMaster extends  Master {

    public void fixComp(Device computer) throws DeviceIncorrectType {
        if (computer instanceof Home) {
            computer.inclusionComp();
        } else {
            throw new DeviceIncorrectType("Компьютер не является переносным дивайсом , а является классом Домашний!");}
    }
}
