public class Array01 {
    public static void main(String[] args) {
        Integer[] intArray = new Integer[500000];
        int intConst;                                  // монотонность арифметической прогресии
        int intFirstMember;                            // первый член арифметической прогресии
        int i;                                         // will use for count

        System.out.println("Длина массива = "+ intArray.length + " элементов");
        // Заполнение массива числами арифметической прогрессии
        intFirstMember = 7;
        intConst = 3;
        for( i=0; i<intArray.length; i++) {
            intArray[i] = intFirstMember + i*intConst;
        }
        // контрольный вывод элементов массива
        System.out.println(" 100 элемент массива = "+intArray[99]);
        System.out.println(" 500 элемент массива = "+intArray[499]);
        System.out.println("1000 элемент массива = "+intArray[999]);
        System.out.println("Последний элемент массива = "+intArray[intArray.length-1]);

        //for(i=0; i<10; i++)
        //    System.out.println((i+1)+" элемент массива = "+intArray[i]);
        //==============================================================
        // Посчет суммы элементов массива путем перебора всех элементов
        long sumLong = 0;
        for( i=0; i<intArray.length; i++) {
            sumLong += intArray[i];
        }
        System.out.println("1. Сумма всех элементов массива = " + sumLong );
        // Подсчет суммы элементов массива используя закон математики
        sumLong = 0;
        sumLong = ((long)(intArray[0] + intArray[intArray.length - 1])*intArray.length)/2;
        System.out.println("2. Сумма всех элементов массива = " + sumLong );
    }
}
