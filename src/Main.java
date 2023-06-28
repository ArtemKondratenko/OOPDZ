public class Main {
    public static void main(String[] args) {
        Computer comp = new Computer();
        comp.setSsdSize(500);
        comp.setOperationSystemName("Linux");
        comp.setOzuSize(8);

        Computer comp2 = new Computer(600, "WD", 6);
        Computer comp3 = new Computer(700, "Mac", 9);
        Computer comp4 = new Computer("Linux",4);
        Computer comp5 = new Computer("WB",7);
        comp.inclusionComp();
        comp2.inclusionComp();
        comp3.inclusionComp();
        comp4.inclusionComp();
        comp5.inclusionComp();


        System.out.println(comp.inclusion);
        System.out.println(comp2.inclusion);
        System.out.println(comp3.inclusion);
        System.out.println(comp4.inclusion);
        System.out.println(comp5.inclusion);

        comp.inclusionComp();
        comp2.inclusionComp();
        comp3.inclusionComp();
        comp4.inclusionComp();
        comp5.inclusionComp();



    }
}
