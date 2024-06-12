package itmo.java.basics.Lab01;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String theFirst = "Я";
        String theSecond = "хорошо";
        String theThird = "знаю";
        String theFourth = "Java";

        System.out.println(theFirst);
        System.out.println(theSecond);
        System.out.println(theThird);
        System.out.println(theFourth);

        double resultFirst;

        resultFirst = (46 + 10) * ((double)10 / 3);
        System.out.println(resultFirst);

        int number = 10500;
        double result;

        result = ( (double)number/ 10) / 10;
        System.out.println(result);

        double varFirst = 3.6;
        double varSecond = 4.1;
        double varThird = 5.9;
        double resultSecond;

        resultSecond = varFirst * varSecond * varThird;
        System.out.println(resultSecond);

        Scanner getHuman = new Scanner(System.in);
        int intHumanFirst;
        int intHumanSecond;
        int intHumanThird;

        System.out.println("Input a Number:");
        intHumanFirst = getHuman.nextInt();
        System.out.println("Input a Number:");
        intHumanSecond = getHuman.nextInt();
        System.out.println("Input a Number:");
        intHumanThird = getHuman.nextInt();
        System.out.println(intHumanFirst);
        System.out.println(intHumanSecond);
        System.out.println(intHumanThird);

        int b;

        System.out.println("Input a Number:");
        b = getHuman.nextInt();

        if ( b%2 == 1 ) {
            System.out.println("Нечетное");
        } else if ( b > 100) {
            System.out.println("Выход за пределы диапазона.");
        } else {
            System.out.println("Четное");
        }

    }
}
