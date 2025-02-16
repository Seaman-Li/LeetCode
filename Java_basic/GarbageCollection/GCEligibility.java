package Java_basic.GarbageCollection;

public class GCEligibility {
    static class Example {
        int id;

        Example(int id) {
            this.id = id;
        }

        @Override
        protected void finalize() throws Throwable {
            System.out.println("Object " + id + " is garbage collected");
        }
    }

    public static void main(String[] args) {
        Example obj1 = new Example(1);
        Example obj2 = new Example(2);

        // Making obj1 eligible for garbage collection
        obj1 = null;

        // Making obj2 eligible for garbage collection via reassignment
        obj2 = new Example(3);

        // Explicitly requesting garbage collection
        System.gc();

        // Adding delay for better visualization
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("End of main");
    }
}

