package itmo.java.basics.Lab07;

import java.util.Scanner;

public class LaboratorySeventh {
    public static void main(String[] args) {
        Plane mig25 = new Plane();

        System.out.println("Введите вес крыла для Миг-25:" );
        Scanner getHuman = new Scanner(System.in);
        mig25.setWingsWeight(getHuman.nextDouble());

        System.out.println("Вес крыла для Миг-25: " + mig25.getWingsWeight() );

        Plane su25 = new Plane();

        System.out.println("\nВведите вес крыла для Су-25:" );
        su25.setWingsWeight(getHuman.nextDouble());

        System.out.println("Вес крыла для Су-25: " + su25.getWingsWeight() );
    }
}
