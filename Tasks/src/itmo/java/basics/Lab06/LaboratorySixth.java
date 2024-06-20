package itmo.java.basics.Lab06;

public class LaboratorySixth {
    public static void main(String[] args) {

        BankEmployee employee = new BankEmployee("Mike", "Buch", "SomeBank");
        employee.getAllInfoHuman();

        employee.setName( "Tom", HumanName.FIRST_NAME );
        employee.setName( "Duglas", HumanName.LAST_NAME );
        employee.getAllInfoHuman();

        Client client = new Client("Jerry", "Claim", "SomeBank");
        System.out.println("Клиент: ");
        client.getAllInfoHuman();

        Banking user1 = new BankEmployee("John", "Smith", "SecondBank");
        Banking user2 = new Client("Lisa", "Brook", "SecondBank");

        System.out.println( user1.isOutSide() );
        System.out.println( user2.isOutSide() );

        Truck truck = new Truck(5500, "Volvo", 'W', 120.0f, 6, 10200);
        truck.outPut();
        System.out.printf("Новое количество колес = ");
        truck.newWhells( 10);

        System.out.println("==================================");
        System.out.println("Пункт 4");
        Child example = new Child();
        example.printParentNumber();
        System.out.println("После задания числа:");
        example.setNumber(578);
        example.printParentNumber();

        System.out.println("==================================");
        System.out.println("Пункт 5");
        Basic test = new Basic();
        test.setInfo();
        test.printSomeInfo();

        Heir who = new Heir();
        who.setInfo();
        who.printSomeInfo();
    }
}
