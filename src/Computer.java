

public class Computer {
    private  int ssdSize;
    private  String operationSystemName;
    private  int ozuSize;
    static int countComp;
    boolean inclusion = false;

    public Computer(int ssdSize, String operationSystemName, int ozuSize) {
        this.ssdSize = ssdSize;
        this.operationSystemName = operationSystemName;
        this.ozuSize = ozuSize;
        countComp++;

    }

    public  Computer(){countComp++;};

    public  Computer(String operationSystemName, int ozuSize) {
        this.operationSystemName = operationSystemName;
        this.ozuSize = ozuSize;
        countComp++;
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

}
