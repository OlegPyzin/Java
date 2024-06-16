package itmo.java.basics.Lab04;
import java.util.Scanner;

public class TheFirstPart {

    public void printEven(int number) {

        for (int i = 1; i <= number; i++) {
            if (i % 2 == 1) {
                System.out.println(i);
            }
        }
    }

    public void printTreeFive(int number) {

        for (int i = 1; i <= number; i++) {
            if (i % 3 == 0) {
                System.out.println(i + ": Делится на 3");
            }
            if (i % 5 == 0) {
                System.out.println(i + ": Делится на 5");
            }
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println(i + ": Делится на 3 и на 5");
            }
        }
    }

    public boolean printBooleanSum(int intHumanFirst, int intHumanSecond, int intHumanThird) {
        boolean result;

        if ((intHumanFirst + intHumanSecond) == intHumanThird) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }

    public boolean printBooleanCompare(int intHumanFirst, int intHumanSecond, int intHumanThird) {
        boolean result;

        if (intHumanSecond > intHumanFirst && intHumanThird > intHumanSecond) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }

    public boolean checkFirstLast(Integer[] array, int number) {
        int length = array.length;

        System.out.print("Array: ");
        for (int i = 0; i < length; i++) {
            if (i < (length - 1)) {
                System.out.printf("%d, ", array[i]);
            } else {
                System.out.printf("%d\n", array[i]);
            }
        }

        if (array[0] == number || array[length - 1] == number) {
            return true;
        }

        return false;
    }

    public boolean isInclude(Integer[] array, int intOne, int intTwo) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
            if (array[i] == intOne || array[i] == intTwo) {
                return true;
            }
        }

        return false;
    }
}
