package itmo.java.basics.Lab06;

public class Truck extends Car {
    int wheels;
    int maxWeight;

    public void newWhells(int newWheel) {
        this.wheels = newWheel;
        System.out.println(this.wheels);
    }

    public Truck(int w, String m, char c, float s, int n, int max) {
        super(w, m, c, s);
        this.wheels = n;
        this.maxWeight = max;
    }
}

