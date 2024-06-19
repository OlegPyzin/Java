package itmo.java.basics.Lab06;

public class Heir extends Basic {

    @Override
    public void printSomeInfo() {
        System.out.println(super.someInfo);
    }

    @Override
    public void setInfo() {
        System.out.println("Введите имя пользователя:");
        super.someInfo = getHuman.nextLine();
    }
}
