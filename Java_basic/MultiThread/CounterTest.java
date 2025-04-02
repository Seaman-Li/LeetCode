package Java_basic.MultiThread;

import java.util.concurrent.atomic.AtomicInteger;

//increment a counter 1000 times from 10 threads.
//We’ll do this once using synchronized, and once using AtomicInteger.

//an example without any concurrency protection to show what goes wrong due to race conditions.
class UnsafeCounter {
    private int count = 0;

    public void increment() {
        count++; // Not thread-safe!
    }

    public int getCount() {
        return count;
    }
}

class SyncCounter {
    private int count = 0;

    public synchronized void increment() {
        count++; // Critical section
    }

    public int getCount() {
        return count;
    }
}

class AtomicCounter {
    private AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet(); // Atomic operation
    }

    public int getCount() {
        return count.get();
    }
}



public class CounterTest {

    //✅ With both synchronized and AtomicInteger.
    //BUT:
    //AtomicInteger will be faster, especially under heavy concurrency.
    //synchronized lets you protect multiple variables or blocks, which atomic classes can't do alone.
    public static void main(String[] args) throws InterruptedException {
        // Choose one of the below:
//         SyncCounter counter = new SyncCounter();
         UnsafeCounter counter = new UnsafeCounter();
//        AtomicCounter counter = new AtomicCounter();

        Thread[] threads = new Thread[10];

        // Each thread increments the counter 1000 times
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }

        // Wait for all threads to finish
        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }

        // Final count should be 10,000
        System.out.println("Final count: " + counter.getCount());
    }
}
