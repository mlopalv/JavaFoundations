package codeacademy.learnintermediatejava.threading.synchronize;

public class Counter {
    private int c = 0;

    public int getCount() {
        return this.c;
    };

    public void setCount(int c) {
        this.c = c;
    };

    /**
     * The synchronized keyword allows several threads to access this method in an organized fashion so that
     * shared resources as the setCount method that will act on the c variable, are accessed only by one
     * Thread at a time.
     *
     */
    public synchronized void increment() {
        this.setCount(this.getCount() + 1);
    }

    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();

        Thread a = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                c.increment();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        });

        Thread b = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                c.increment();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        });

        Thread d = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                c.increment();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        });

        // Start both threads here
        a.start();
        b.start();
        d.start();

        // Join both threads here

        b.join();
        d.join();
        a.join();

        System.out.println("Counter: " + c.getCount());
    }
}