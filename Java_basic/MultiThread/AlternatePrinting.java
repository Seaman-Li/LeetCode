package Java_basic.MultiThread;

class PrintNumber {
    private int number = 1;
    private final int MAX = 10;
    private boolean isThreadA = true;

    public synchronized void printEven() {
        while (number <= MAX) {
            while (!isThreadA) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (number > MAX) return;
            System.out.println(Thread.currentThread().getName() + ": " + number++);
            isThreadA = false;
            notify();
        }
    }

    public synchronized void printOdd() {
        while (number <= MAX) {
            while (isThreadA) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (number > MAX) return;
            System.out.println(Thread.currentThread().getName() + ": " + number++);
            isThreadA = true;
            notify();
        }
    }
}

public class AlternatePrinting {
    public static void main(String[] args) {
        PrintNumber printNumber = new PrintNumber();

        Thread thread1 = new Thread(printNumber::printEven, "Thread-A");
        Thread thread2 = new Thread(printNumber::printOdd, "Thread-B");

        thread1.start();
        thread2.start();
    }
}
