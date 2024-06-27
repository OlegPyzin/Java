/* Пункт 4 задания № 9 реализован в
 * Class Program, там же создан метод main для запуска программы.
 */
package itmo.java.basics.Lab09;

import java.util.*;
import java.util.Random;
import java.util.TreeSet;
import static java.lang.System.currentTimeMillis;

public class LaboratoryNinth {
    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(123, 45, 453, 22, 45, 123);
        System.out.println(ints);
        Set<Integer> uniqueInt = makeUnique(ints);
        System.out.println(uniqueInt);
        List<String> str = Arrays.asList("Mike", "Nike", "John", "Oleg", "Mike", "Buch", "Nike");
        System.out.println(str);
        Set<String> uniqueStr = makeUnique(str);
        System.out.println(uniqueStr);

        List<Short> newShortArrayList = fillArrayList(1000000);
        List<Short> newShortLinkedList = fillLinkedList(1000000);
        System.out.println("Размер списка на основе ArrayList: " + newShortArrayList.size());
        System.out.println("Размер списка на основе LinkedList: " + newShortLinkedList.size());


        System.out.println("Выбор \"наугад\" 100 000 раз элемент из массива основе ArrayList.");
        System.out.println("Начало: " + currentTimeMillis());
        randomAccess(newShortArrayList, 100000);
        System.out.println("Конец:  " + currentTimeMillis());

        System.out.println("Выбор \"наугад\" 100 000 раз элемент из массива основе LinkedList.");
        System.out.println("Начало: " + currentTimeMillis());
        randomAccess(newShortLinkedList, 100000);
        System.out.println("Конец:  " + currentTimeMillis());
    }

    public static <T> Set makeUnique(List<T> collection) {
        Set<T> unique = new TreeSet<>(collection);
        return unique;
    }

    public static List<Short> fillArrayList(int numberElements) {
        Random random = new Random();
        List<Short> retVal = new ArrayList<>();
        Integer tmpValue;

        for(int i=0; i<numberElements; i++) {
            tmpValue = random.nextInt(32767);
            retVal.add(tmpValue.shortValue());
        }
        return retVal;
    }

    public static List<Short> fillLinkedList(int numberElements) {
        Random random = new Random();
        List<Short> retVal = new LinkedList<>();
        Integer tmpValue;

        for(int i=0; i<numberElements; i++) {
            tmpValue = random.nextInt(32767);
            retVal.add(tmpValue.shortValue());
        }
        return retVal;
    }

    public static <T> void randomAccess(List<T> array, int number) {
        Random random = new Random();
        int lenArray = array.size() - 1;

        for(int i=0, index; i<number; i++) {
            index = random.nextInt(lenArray);
            array.get(index);
        }
    }
}
