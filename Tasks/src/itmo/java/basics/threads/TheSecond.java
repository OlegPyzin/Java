package itmo.java.basics.threads;

class JobThread2 extends Thread {

    Thread jobThread2;

    JobThread2(Thread th) {
        this.jobThread2 = th;
    }

    @Override
    public void run() {
        // Нить спать 10 сек
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Вывод состояние нити во время выполнения
        for(int i=0; i<=100; i++) {
            if(i==50) {
                System.out.println(Thread.currentThread().getName() + " State = " + Thread.currentThread().getState());
            }
        }
    }
}


public class TheSecond {
    public static void main(String[] args) {

        Thread mainThread = Thread.currentThread();
        System.out.println("Главная НИТЬ : " + mainThread.getName());
        System.out.println("Состояние нити [" + mainThread.getName() + "] " + mainThread.getState() );

        JobThread2[] jobs = new JobThread2[10];

        // Инициализируем нити без их запуска
        for(int i=0; i<jobs.length; i++) {
            jobs[i] = new JobThread2(Thread.currentThread());
        }
        // Выводим состояние нитей перед их стартом
        for(int i=0; i<jobs.length; i++) {
            System.out.println("Состояние нити [" + jobs[i].getName() + "] " + jobs[i].getState() );
        }
        // Стартуем нити
        for(int i=0; i<jobs.length; i++) {
            jobs[i].start();
        }

        // Главная нить - спать 2 сек чтобы все нити стартанули
        System.out.println("Главная НИТЬ спать 2 сек.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Выводим состояние нитей после их старта пока они "спят"
        for(int i=0; i<jobs.length; i++) {
            System.out.println("Состояние нити [" + jobs[i].getName() + "] " + jobs[i].getState() );
        }
    }
}
