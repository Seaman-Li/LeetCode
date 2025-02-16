package Java_basic.GarbageCollection;

public class ManualGCTrigger {
    public static void main(String[] args) {

        ManualGCTrigger obj = new ManualGCTrigger();

        obj = null;
//        System.out.println(obj.toString());
        System.gc();

        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("End");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Garbage collection performed on object");
    }
}
