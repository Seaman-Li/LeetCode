package Java_basic;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ObjectPool<T> {

    public interface ObjectFactory<T> {
        T create();
    }

    private final BlockingQueue<T> pool;
    private final ObjectFactory<T> objectFactory;
    private final int maxSize;

    public ObjectPool(ObjectFactory<T> objectFactory,int minSize, int maxSize) {
        this.objectFactory = objectFactory;
        this.maxSize = maxSize;
        this.pool = new LinkedBlockingQueue<T>(maxSize);
        //initialize pool
        for (int i = 0; i < minSize; i++) {
            pool.add(objectFactory.create());
        }
    }

    public T borrowObject() throws InterruptedException {
        T obj = pool.poll();
        if (obj == null && pool.size() < maxSize) {
            obj = objectFactory.create();//create an obj if no obj in pool and the pool is not at max capacity
        } else if (obj == null) {
            obj = pool.take();//Retrieves and removes the head of the queue, waiting if necessary until an element becomes available.
        }
        return obj;
    }

    public void returnObject(T obj) {
        if(obj != null){
            pool.offer(obj);
        }
    }


    public static class StringObjectFactory implements ObjectFactory<String> {

        private final String content;
        private int counter = 0;

        // Constructor to accept parameters
        public StringObjectFactory(String content) {
            this.content = content;
        }

        @Override
        public String create() {
            // Generate a dynamic string using the prefix and counter
            return content + "——" + counter++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ObjectFactory<String> factory = new StringObjectFactory("Example Obj");
        ObjectPool<String> pool = new ObjectPool<>(factory, 2, 5);

        // Borrow an object from the pool
        String obj1 = pool.borrowObject();
        System.out.println("Borrowed: " + obj1);

        // Return the object to the pool
        pool.returnObject(obj1);
        System.out.println("Returned: " + obj1);

        // Borrow another object
        String obj2 = pool.borrowObject();
        System.out.println("Borrowed again: " + obj2);
    }
}
