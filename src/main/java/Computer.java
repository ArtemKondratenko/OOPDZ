

public class Computer extends  Device implements Home{

    static int countComp;


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


}
