package itmo.java.basics.threads;

class JobThread extends Thread {

    Thread jobThread;

    JobThread(Thread th) {
        this.jobThread = th;
    }

    @Override
    public void run() {
        for(int i=0; i<=100; i++) {
            System.out.println(Thread.currentThread().getName() + " Count = " + i);
            // Подобрано время "сна нити" чтобы вывод был перемешанным
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}


public class TheFirst {
    public static void main(String[] args) {

        Thread mainThread = Thread.currentThread();
        System.out.println("Главная НИТЬ : " + mainThread.getName());
        System.out.println("Состояние нити [" + mainThread.getName() + "] " + mainThread.getState() );

        JobThread[] jobs = new JobThread[10];

        for(int i=0; i<jobs.length; i++) {
            jobs[i] = new JobThread(Thread.currentThread());
            jobs[i].start();
        }
    }
}
