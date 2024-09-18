package itmo.java.basics.threads;

class ExampleNames {
    private int whoIs = 0;

    public synchronized void printNameOne() {
        while (true) {
            while (whoIs != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
            whoIs = 1;
            System.out.println(Thread.currentThread().getName());
            notify();
        }
    }

    public synchronized void printNameTwo() {
        while (true) {
            while (whoIs != 1) {
                try {
                    wait();
                } catch (InterruptedException e) {
                }
            }
            whoIs = 0;
            System.out.println(Thread.currentThread().getName());
            notify();
        }
    }
}


public class TheFouth {
    public static void main(String[] args) {
        ExampleNames names = new ExampleNames();

        new Thread() {
            @Override public void run() { names.printNameOne(); }
        }.start();

        new Thread() {
            @Override public void run() { names.printNameTwo(); }
        }.start();
    }
}
