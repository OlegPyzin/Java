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


        System.out.println("Деление:");
        doubleResult = operate.division( intB, intA );
        System.out.println("Integer = " + doubleResult);
        doubleResult = operate.division( longB, longA );
        System.out.println("Long = " + doubleResult);
        doubleResult = operate.division( doubleB, doubleA );
        System.out.println("Double = " + doubleResult);

        PersonnelComputer pc = new PersonnelComputer();
        System.out.println(pc);

        PersonnelComputer apple = new PersonnelComputer("Apple", "MacOS", "Intel i7", "SSD", 512000000000L, 16L,"1920x1080", 115900L);
        System.out.println(apple);

        System.out.println("У меня есть компьютер");
        System.out.println("Производитель PC -> " + apple.getBrand() );
        System.out.println("Операционная система -> " + apple.getTypeOperatingSystem() );
        System.out.println("Процессор -> " + apple.getCpu() );
        System.out.println("Объем ОЗУ в Гб -> " + apple.getRam() );
        System.out.println("Тип диска -> " + apple.getTypeOfDisk() );
        System.out.println("Размер диска в Гб    -> " + apple.getSizeOfDisk() );
        System.out.println("Размер диска в Гб IT -> " + apple.getSizeOfDiskIt() );
        System.out.println("Разрешение экрана -> " + apple.getScreen() );
        System.out.println("Купил я его за " + apple.getPrice() + "рублей" );

        System.out.println("\nПокупаем второй компьютер Dell за 98000 рубдей");
        pc.setPrice( 98000L );
        pc.setBrand( "Dell" );
        pc.setCpu( "Intel i5" );
        pc.setRam( 8L );
        pc.setScreen( "1920 x 1080" );
        pc.setTypeOfDisk( "HDD" );
        pc.setSizeOfDiskIt( 256L );

        System.out.println("Устанавливаем операционную систему Ubuntu 22.04");
        pc.setTypeOperatingSystem( "Ubuntu 22.04 LTS");

        System.out.println("Теперь у меня есть 2-ой компьютер");
        System.out.println("Производитель PC -> " + pc.getBrand() );
        System.out.println("Операционная система -> " + pc.getTypeOperatingSystem() );
        System.out.println("Процессор -> " + pc.getCpu() );
        System.out.println("Объем ОЗУ в Гб -> " + pc.getRam() );
        System.out.println("Тип диска -> " + pc.getTypeOfDisk() );
        System.out.println("Размер диска в Гб    -> " + pc.getSizeOfDisk() );
        System.out.println("Размер диска в Гб IT -> " + pc.getSizeOfDiskIt() );
        System.out.println("Разрешение экрана -> " + pc.getScreen() );
        System.out.println("Купил я его за " + pc.getPrice() + "рублей" );

    }
}
