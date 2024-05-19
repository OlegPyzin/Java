// ===========================================================
// 2024-05-19  Для реализации задания начнем создавать class
//             методы в классе:
//             1 получить длину массива
//             2 инициализация массива числами арифметической прогрессии
//               входные данные для инициализации массива:
//               - первый элемент массива
//               - шаг прогресии (монотонность арифметической прогресии)
//
class IntArray {
    // Вопрос: как инициализировать массив при создании класса
    //         с целочисленными значениями определенного
    //         размера, например 100 эл-тов, 1000 эл-тов и т.д.
    static Integer[] intInsideArray = new Integer[1000];

    // Методы
    public static int length() {
        int length = intInsideArray.length;
        return length;
    }
}

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
        // для арифметической прогрессии
        // Условие: все элементы массива упорядочены по возрастанию/уменьшению
        sumLong = 0;
        sumLong = ((long)(intArray[0] + intArray[intArray.length - 1])*intArray.length)/2;
        System.out.println("2. Сумма всех элементов массива = " + sumLong );

        // Начинаем использовать новый класс
        System.out.println("=========================================");
        System.out.println("Начинаем использование созданного класса.");
        IntArray intArray1 = new IntArray();
        System.out.println("Длина созданного массива = "+intArray1.length());
    }
}
