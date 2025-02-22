package Java_basic.MultiThread;

class SharedResource {
    private int counter = 0;

    public synchronized void increment() {
        counter++;
        System.out.println(Thread.currentThread().getName() + " Counter: " + counter);
    }
}

public class SynchronizedLockExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Runnable task = () -> {
            for (int i = 0; i < 3; i++) {
                resource.increment();
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}

