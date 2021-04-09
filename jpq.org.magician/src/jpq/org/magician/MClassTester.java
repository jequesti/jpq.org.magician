package jpq.org.magician;

public class MClassTester {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MClass test0 = new MClass.MClassBuilder("Crusader").setInterfaces(new String[] { "Fighterable" }).build();

        System.out.println(test0.toJava());
        System.out.println("----------------------------------------------------------------------------");
        System.out.println(test0.toCsharp());

        MClass test1 = new MClass.MClassBuilder("Crusader")
                .setInterfaces(new String[] { "Fighterable", "Cargoable", "Sortable" }).build();

        System.out.println(test1.toJava());
        System.out.println("----------------------------------------------------------------------------");
        System.out.println(test1.toCsharp());

        MClass test2 = new MClass.MClassBuilder("Crusader").setParentClass("SpaceShip")
               .setInterfaces(new String[] { "Fighterable", "Cargoable", "Sortable" }).build();

        System.out.println(test2.toJava());
        System.out.println("----------------------------------------------------------------------------");
        System.out.println(test2.toCsharp());

    }
}
