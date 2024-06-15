package itmo.java.basics.Lab04;

public class LaboratoryFourth {
    public static void main(String[] args) {
        // Part 01
        TheFirstPart partOne = new TheFirstPart();

        System.out.println( "Выводим нечетные числа" );
        partOne.printEven( 100 );

        System.out.println( "Выводим числа которые делятся на 3, на 5 и одновременно на 3 и на 5" );
        System.out.println( "===================================================================" );
        partOne.printTreeFive( 100 );

        System.out.println( "Пункт 3 части первой задания" );
        System.out.println( "===================================================================" );
        System.out.println( "Результат: " + partOne.printBooleanSum() );

        System.out.println( "Пункт 4 части первой задания" );
        System.out.println( "===================================================================" );
        System.out.println( "Результат: " + partOne.printBooleanCompare() );

        System.out.println( "Пункт 5 части первой задания" );
        System.out.println( "===================================================================" );
        Integer intArray01[] = new Integer[] { 3, 1, -6, 102, 32, 65, 1000, 3 };
        System.out.println( "Результат: " + partOne.checkFirstLast( intArray01, 3 ) );

        Integer intArray02[] = new Integer[] { 3, 1, -6, 102, 32, 65, 1000, 1200, 768, 4 };
        System.out.println( "Результат: " + partOne.checkFirstLast( intArray02, 3 ) );

        Integer intArray03[] = new Integer[] { 17, 267, -200, 102, 32, 65, 1000, 1200, 768, 4 };
        System.out.println( "Результат: " + partOne.checkFirstLast( intArray03, 3 ) );

        System.out.println( "Пункт 6 части первой задания" );
        System.out.println( "===================================================================" );
        System.out.println( partOne.isInclude( intArray01, 3, 1 ) ? "Одно из чисел в массиве." : "Нет ни одного.");
        System.out.println( partOne.isInclude( intArray02, 5, 12 ) ? "Одно из чисел в массиве." : "Нет ни одного.");
        System.out.println( partOne.isInclude( intArray03, 3, 1 ) ? "Одно из чисел в массиве." : "Нет ни одного.");

        ////////////////////////////////////////////
        // Part 2
        TheSecondPart partTwo = new TheSecondPart();

        System.out.println( "Пункт 1 части второй задания" );
        System.out.println( "===================================================================" );
        System.out.println( partTwo.sorted( intArray01 ) ? "OK" : "Please, try again");

        Integer intArray04[] = new Integer[] {1, 3, 6, 9, 12, 19, 100, 200};
        System.out.println( partTwo.sorted( intArray04 ) ? "OK" : "Please, try again");

        System.out.println( "Пункт 2 части второй задания" );
        System.out.println( "===================================================================" );
        intArray02 = partTwo.initializeArray( 5 );

        System.out.print( "Result: [" );
        int i;
        int length = intArray02.length;

        for( i=0 ; i < length; i++ ) {
            if( i < (length - 1) ) {
                System.out.printf("%d, ", intArray02[i]);
            } else {
                System.out.printf("%d]\n", intArray02[i]);
            }
        }

        System.out.println( "Пункт 3 части второй задания" );
        System.out.println( "===================================================================" );
        System.out.print( "Array 1: [" );
        length = intArray02.length;

        for( i=0 ; i < length; i++ ) {
            if( i < (length - 1) ) {
                System.out.printf("%d, ", intArray02[i]);
            } else {
                System.out.printf("%d]\n", intArray02[i]);
            }
        }

        intArray01 = partTwo.changeFirstLast( intArray02 );
        System.out.print( "Array 2: [" );
        length = intArray01.length;

        for( i=0 ; i < length; i++ ) {
            if( i < (length - 1) ) {
                System.out.printf("%d, ", intArray01[i]);
            } else {
                System.out.printf("%d]\n", intArray01[i]);
            }
        }

        System.out.println( "Пункт 4 части второй задания" );
        System.out.println( "===================================================================" );

        Integer intArray[] = new Integer[] { 1, 2, 3, 1, 2, 4 };
        int index = partTwo.findUnique( intArray );
        System.out.println( index >= 0 ? intArray[index] : "Нет уникального числа." );

        Integer intArray1[] = new Integer[] { 1, 3, 2, 1, 3, 2, 8, 8 };
        index = partTwo.findUnique( intArray1 );
        System.out.println( index >= 0 ? intArray1[index] : "Нет уникального числа." );


        System.out.println( "Пункт 5 части второй задания" );
        System.out.println( "===================================================================" );
        int sizeOfArray = 50;
        int[] intArraySort;
        intArraySort = partTwo.fillRandom( sizeOfArray, 500 );

        length = intArraySort.length;
        for( i=0; i< length; i++ ) {
            if( (i+1) % 10 != 0 ) {
                System.out.printf("%4d ", intArraySort[i]);
            } else {
                System.out.printf("%4d\n", intArraySort[i]);
            }
        }

        System.out.println( "\n\nСортируем массив ...");

        int[] sort = partTwo.mergeSort( intArraySort );

        length = sort.length;
        for( i=0; i< length; i++ ) {
            if( (i+1) % 10 != 0 ) {
                System.out.printf("%4d ", sort[i]);
            } else {
                System.out.printf("%4d\n", sort[i]);
            }
        }
    }
}
