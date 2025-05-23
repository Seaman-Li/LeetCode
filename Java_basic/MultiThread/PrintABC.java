package Java_basic.MultiThread;

public class PrintABC {

    public static int print_NUM = 10;
    public Object lock = new Object();
    public int order = 0;

    public void printA(){
        for (int i = 0; i < print_NUM; i++) {
            synchronized (lock) {
                while (order %3 != 0) {
                    try {
                        lock.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                System.out.println("A");
                order++;
                lock.notifyAll();
            }
        }
    }
    public void printB(){
        for (int i = 0; i < print_NUM; i++) {
            synchronized (lock) {
                while (order %3 != 1) {
                    try {
                        lock.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                System.out.println("B");
                order++;
                lock.notifyAll();
            }
        }
    }
    public void printC(){
        for (int i = 0; i < print_NUM; i++) {
            synchronized (lock) {
                while (order %3 != 2) {
                    try {
                        lock.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                System.out.println("C");
                order++;
                lock.notifyAll();
            }
        }
    }


    public static void main(String[] args) {

        PrintABC b = new PrintABC();
        Thread threadA = new Thread(b::printA);
        Thread threadB = new Thread(b::printB);
        Thread threadC = new Thread(b::printC);

        threadA.start();
        threadB.start();
        threadC.start();


    }

}


