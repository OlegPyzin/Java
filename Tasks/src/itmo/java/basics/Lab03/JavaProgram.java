package itmo.java.basics.Lab03;

public class JavaProgram {
    public static void main(String[] args) {
        Study cource = new Study( "Изучение Java - это просто!" );

        System.out.println( cource.printCourse() );

        Car toyota = new Car("Black", 1680d );
        toyota.setBrand( "Toyota" );
        System.out.println( toyota.getAllInfo() );


        Car lexus = new Car( "White");
        lexus.setBrand("Lexus");
        lexus.setWeight( 1920d );
        System.out.println( lexus.getAllInfo() );

        House kolobov = new House();
        System.out.println( kolobov );
        kolobov.setAllInfo("Дом купцов Колобовых", 1908, 5 );
        System.out.println( kolobov.getAllInfo() );
        System.out.println( kolobov.howOld(2024 ) );

        House specialist = new House();
        specialist.setAllInfo( "Дом Специалистов", 1938, 5 );
        System.out.println( specialist.getAllInfo() );
        System.out.println( specialist.howOld(2024 ) );

        Tree oak = new Tree();
        Tree birch = new Tree( 42, "Береза" );
        Tree pine = new Tree( 82, "Сосна", true );
        System.out.println( oak );
        System.out.println( birch );
        System.out.println( pine );
    }
}
