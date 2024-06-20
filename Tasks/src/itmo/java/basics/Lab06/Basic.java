package itmo.java.basics.Lab06;

import java.util.Scanner;

public class Basic {
    private Float age;
    protected String someInfo;
    protected Scanner getHuman = new Scanner(System.in);

    public void printSomeInfo() {
        System.out.println(this.age);
    }

    public void setInfo() {
        System.out.println("Введите возраст:");
        age = getHuman.nextFloat();
    }
}
