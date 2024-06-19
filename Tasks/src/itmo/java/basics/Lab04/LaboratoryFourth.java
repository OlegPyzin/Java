package itmo.java.basics.Lab04;

import java.util.Scanner;

public class LaboratoryFourth {
    public static void main(String[] args) {
        // Part 01
        TheFirstPart partOne = new TheFirstPart();

        System.out.println( "Выводим нечетные числа" );
        partOne.printEven( 100 );

        System.out.println( "====================================================================" );
        System.out.println( "Выводим числа которые делятся на 3, на 5 и одновременно и на 3 и на 5" );
        partOne.printTreeFive( 100 );

        System.out.println( "====================================================================" );
        System.out.println( "Пункт 3 части первой задания" );
        Scanner getHuman = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        int intHumanFirst = getHuman.nextInt();
        System.out.println("Введите второе число: ");
        int intHumanSecond = getHuman.nextInt();
        System.out.println("Введите третье число: ");
        int intHumanThird = getHuman.nextInt();
        System.out.println( "Результат: " + partOne.printBooleanSum(intHumanFirst, intHumanSecond, intHumanThird) );

        System.out.println( "====================================================================" );
        System.out.println( "Пункт 4 части первой задания" );
        System.out.println("Введите первое число: ");
        intHumanFirst = getHuman.nextInt();
        System.out.println("Введите второе число: ");
        intHumanSecond = getHuman.nextInt();
        System.out.println("Введите третье число: ");
        intHumanThird = getHuman.nextInt();

        System.out.println( "Результат: " + partOne.printBooleanCompare(intHumanFirst, intHumanSecond, intHumanThird) );

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

        System.out.println( "===================================================================" );
        System.out.println( "Пункт 1 части второй задания" );
        System.out.println( partTwo.sorted( intArray01 ) ? "OK" : "Please, try again");

        Integer intArray04[] = new Integer[] {1, 3, 6, 9, 12, 19, 100, 200};
        System.out.println( partTwo.sorted( intArray04 ) ? "OK" : "Please, try again");

        System.out.println( "===================================================================" );
        System.out.println( "Пункт 2 части второй задания" );
        intArray02 = partTwo.initializeArray();

        System.out.print( "Result: [" );
        int i;
        int length = intArray02.length;

        for (i = 0; i < length; i++) {
            if (i < (length - 1)) {
                System.out.printf("%d, ", intArray02[i]);
            } else {
                System.out.printf("%d]\n", intArray02[i]);
            }
        }

        System.out.println( "===================================================================" );
        System.out.println( "Пункт 3 части второй задания" );
        System.out.print( "Array 1: [" );
        length = intArray02.length;

        for (i = 0; i < length; i++) {
            if (i < (length - 1)) {
                System.out.printf("%d, ", intArray02[i]);
            } else {
                System.out.printf("%d]\n", intArray02[i]);
            }
        }

        intArray01 = partTwo.changeFirstLast( intArray02 );
        System.out.print( "Array 2: [" );
        length = intArray01.length;

        for (i = 0; i < length; i++) {
            if (i < (length - 1)) {
                System.out.printf("%d, ", intArray01[i]);
            } else {
                System.out.printf("%d]\n", intArray01[i]);
            }
        }

        System.out.println( "===================================================================" );
        System.out.println( "Пункт 4 части второй задания" );

        Integer intArray[] = new Integer[] { 1, 2, 3, 1, 2, 4 };
        System.out.println( "Уникальное число: " + partTwo.findUnique( intArray ) );

        Integer intArray1[] = new Integer[] { 1, 3, 2, 1, 3, 2, 8, 8 };
        System.out.println( "Уникальное число: " + partTwo.findUnique( intArray1 ) );


        System.out.println( "===================================================================" );
        System.out.println( "Пункт 5 части второй задания" );
        int sizeOfArray = 50;
        int[] intArraySort;
        intArraySort = partTwo.fillRandom( sizeOfArray, 500 );

        length = intArraySort.length;
        for (i = 0; i < length; i++) {
            if ((i + 1) % 10 != 0) {
                System.out.printf("%4d ", intArraySort[i]);
            } else {
                System.out.printf("%4d\n", intArraySort[i]);
            }
        }

        System.out.println( "\n\nСортируем массив ...");

        int[] sort = partTwo.mergeSort( intArraySort );

        length = sort.length;
        for (i = 0; i < length; i++) {
            if ((i + 1) % 10 != 0) {
                System.out.printf("%4d ", sort[i]);
            } else {
                System.out.printf("%4d\n", sort[i]);
            }
        }
    }
}
