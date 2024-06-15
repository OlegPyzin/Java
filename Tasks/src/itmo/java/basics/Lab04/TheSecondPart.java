package itmo.java.basics.Lab04;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class TheSecondPart {

    public boolean sorted( Integer array[] ) {
        int i;
        int length;

        length = array.length - 1;

        for( i=0 ; i < length; i++ ) {
            if( array[i] > array[i+1] ) {
                return false;
            }
        }

        return true;
    }

    public Integer[] initializeArray( int value ) {
        int i;

        Scanner getHuman = new Scanner(System.in);
        System.out.println("Input array length: ");
        value = getHuman.nextInt();

        Integer array[] = new Integer[value];

        System.out.println("Numbers of array:");
        for (i = 0; i < value; i++) {
            array[i] = getHuman.nextInt();
        }
        return array;
    }

    public Integer[] changeFirstLast( Integer array[] ) {
        int value;

        value = array[0];
        array[0] = array[ array.length -1 ];
        array[ array.length -1 ] = value;

        return array;
    }

    public int findUnique( Integer array[] ) {
        int unique = -1; // если не найдено уникальное число в массиве возвращаем отрицательное число
        int i;
        int j;
        int length = array.length;

        for( i=0; i < length; i++ ) {
            for( j=0; j < length; j++ ) {
                if( array[i] == array[j] && i != j ) {
                    break;
                }
            }
            if( j == length ) {
                unique = i;
                break;
            }
        }
        return unique;
    }

    public int[] fillRandom( int size, int range ) {

        int[] array = new int[size];
        Random random = new Random();
        int i;

        for( i=0; i < size; i++ ) {
            array[i] = random.nextInt( range );
        }
        return array;
    }

    // Сортировка массива
    private static void bubbleSort(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length; j++) {
                if (ints[i] < ints[j]) {
                    int aj = ints[j];
                    int ai = ints[i];

                    ints[j] = ai;
                    ints[i] = aj;
                }
            }
        }
    }

    public int[] mergeSort(int[] ints) {

        if (ints.length < 2) {
            return ints;
        }

        int mid = ints.length / 2;

        int[] left = new int[mid];

        int[] right;

        if (ints.length % 2 == 0) {
            right = new int[mid];
        } else {
            right = new int[mid + 1];
        }

        for (int i = 0; i < left.length; i++) {
            left[i] = ints[i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = ints[mid + i];
        }

        left = mergeSort(left);
        right = mergeSort(right);

        return mergeParts(left, right);
    }

    private static int[] mergeParts(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int leftPointer = 0;
        int rightPointer = 0;
        int resultPointer = 0;

        while (leftPointer < left.length || rightPointer < right.length) {
            if (leftPointer < left.length && rightPointer < right.length) {
                if (left[leftPointer] < right[rightPointer]) {
                    result[resultPointer++] = left[leftPointer++];
                } else {
                    result[resultPointer++] = right[rightPointer++];
                }
            } else if (leftPointer < left.length) {
                result[resultPointer++] = left[leftPointer++];
            } else {
                result[resultPointer++] = right[rightPointer++];
            }
        }

        return result;
    }
}
