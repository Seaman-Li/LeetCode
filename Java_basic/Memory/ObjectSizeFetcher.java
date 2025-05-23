package Java_basic.Memory;

import java.lang.instrument.Instrumentation;

public class ObjectSizeFetcher {
    private static Instrumentation instrumentation;

    public static void premain(String args, Instrumentation inst) {
        instrumentation = inst;
    }

    public static long getObjectSize(Object o) {
        if (instrumentation == null) {
            throw new IllegalStateException("Instrumentation is not initialized");
        }
        return instrumentation.getObjectSize(o);
    }

    public static void main(String[] args) {
        EmptyClass obj = new EmptyClass();
        System.out.println("Size of an empty object: " + ObjectSizeFetcher.getObjectSize(obj) + " bytes");
    }
}


//Empty Class
//An empty class itself, defined in Java, doesn't occupy instance memory per se beyond what the JVM allocates for its class metadata (class structure, method area).
//This metadata includes information about the class type, methods, variables, and other information necessary for the JVM to manage instances of the class.
//The size of this metadata isn't usually accessed directly in Java and can vary significantly between different JVM implementations.
//
//Empty Object
//The size of an instance of an empty class (an empty object) mainly consists of the object header,
//which the JVM uses to store metadata about the object instance,
//such as the runtime type information and garbage collection information. In most JVMs,
//especially those based on the HotSpot JVM from Oracle,
//the object header typically consumes 12 to 16 bytes on a 32-Java_basic.MultiThread.bit JVM and 16 to 24 bytes on a 64-Java_basic.MultiThread.bit JVM.
//This size can increase if the object is used in a synchronized context (i.e., if a lock is acquired on the object),
//as additional space may be needed to store lock information.