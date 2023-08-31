package main.java;

public abstract class Device {
    protected   int ssdSize;
    protected String operationSystemName;
    protected   int ozuSize;
    boolean inclusion = false;
    private   int summa;


    public int getSumma() {
        return summa;
    }

    public void setSumma(int summa) {
        this.summa = summa;
    }

    public int getSsdSize() {
        return ssdSize;
    }

    public void setSsdSize(int ssdSize) {
        this.ssdSize = ssdSize;
    }

    public String getOperationSystemName() {
        return operationSystemName;
    }

    public void setOperationSystemName(String operationSystemName) {
        this.operationSystemName = operationSystemName;
    }

    public int getOzuSize() {
        return ozuSize;
    }

    public void setOzuSize(int ozuSize) {
        this.ozuSize = ozuSize;
    }

    public void inclusionComp(){
        inclusion = !inclusion;
        if(inclusion){
            System.out.println("компюьер включен");
        }else{
            System.out.println("копьютер выключен");
        }
    }



    @Override
    public String toString() {
        return "Device{" +
                "ssdSize=" + ssdSize +
                ", operationSystemName='" + operationSystemName + '\'' +
                ", ozuSize=" + ozuSize +
                ", inclusion=" + inclusion +
                ", summa=" + summa +
                '}';
    }
}
