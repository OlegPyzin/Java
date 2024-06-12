package itmo.java.basics.Lab02;

public class Calculator {
    public static void main(String[] args) {
        int intA = 4;
        int intB = 6;
        int intResult;

        long longA = 1000L;
        long longB = 5000L;
        long longResult;

        double doubleA = 123.45;
        double doubleB = 456.55;
        double doubleResult;

        Operate operate = new Operate();

        intResult = operate.summation( intA, intB );
        longResult = operate.summation( longA, longB );
        doubleResult = operate.summation( doubleA, doubleB );

        System.out.println("Суммирование:");
        System.out.println("Integer = " + intResult);
        System.out.println("Long = " + longResult);
        System.out.println("Double = " + doubleResult);

        intResult = operate.subtraction( intB, intA );
        longResult = operate.subtraction( longB, longA );
        doubleResult = operate.subtraction( doubleB, doubleA );

        System.out.println("Вычитание:");
        System.out.println("Integer = " + intResult);
        System.out.println("Long = " + longResult);
        System.out.println("Double = " + doubleResult);

        intResult = operate.multiplication( intB, intA );
        longResult = operate.multiplication( longB, longA );
        doubleResult = operate.multiplication( doubleB, doubleA );

        System.out.println("Умножение:");
        System.out.println("Integer = " + intResult);
        System.out.println("Long = " + longResult);
        System.out.println("Double = " + doubleResult);

        intResult = operate.division( intB, intA );
        longResult = operate.division( longB, longA );
        doubleResult = operate.division( doubleB, doubleA );

        System.out.println("Деление:");
        System.out.println("Integer = " + intResult);
        System.out.println("Long = " + longResult);
        System.out.println("Double = " + doubleResult);

        PersonnelComputer pc = new PersonnelComputer();
        System.out.println(pc);

        PersonnelComputer apple = new PersonnelComputer("Apple", "MacOS", "Intel i7", "SSD", 512000000000L, 16000000000L,"1920x1080", 115900L);
        System.out.println(apple);
    }
}
