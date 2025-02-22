package Java_basic.MultiThread;

import java.util.concurrent.*;

class SumTask implements Callable<Integer> {
    private final int start;
    private final int end;

    public SumTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        System.out.println(Thread.currentThread().getName() + " calculated sum: " + sum);
        return sum;
    }
}

public class ParallelSum {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<Integer> result1 = executor.submit(new SumTask(1, 50));
        Future<Integer> result2 = executor.submit(new SumTask(51, 100));

        int totalSum = result1.get() + result2.get();
        System.out.println("Total sum: " + totalSum);

        executor.shutdown();
    }
}

