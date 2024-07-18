package itmo.java.basics.threads;
import java.util.Random;

class Counter {
    int count = 0;

    public void increment() {
        count = count + 1;
    }
    public int getCount() {
        return count;
    }
}

class JobThread3 extends Thread {
    Thread jobThread3;
    Counter cnt;

    JobThread3(Thread th, Counter cnt) {
        this.jobThread3 = th;
        this.cnt = cnt;
    }

    @Override
    public void run() {
        for(int i=0; i<1000; i++) {
            // Для тестирования пусть нить немного поспит
            try {
                Thread.sleep(new Random(0).nextLong(200));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (cnt) {
                cnt.increment();
            }
        }
    }
}

public class TheThird {
    public static void main(String[] args) {

        Thread mainThread = Thread.currentThread();
        System.out.println("Главная НИТЬ : " + mainThread.getName());
        System.out.println("Состояние нити [" + mainThread.getName() + "] " + mainThread.getState() );
        Counter cnt = new Counter();

        JobThread3[] jobs = new JobThread3[100];


        System.out.println("Счетчик = " + cnt.getCount() );

        for(int i=0; i<jobs.length; i++) {
            jobs[i] = new JobThread3(Thread.currentThread(), cnt);
        }

        // Стартуем нити
        for(int i=0; i<jobs.length; i++) {
            jobs[i].start();
        }

        // Main нить ждет завершения всех других нитей
        for(int i=0; i<jobs.length; i++) {
            try{
                jobs[i].join();
            } catch(InterruptedException ie) {
                throw new RuntimeException(ie);
            }
        }

        System.out.println("Счетчик = " + cnt.getCount() );
    }
}
