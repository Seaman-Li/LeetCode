package Java_basic.OOP.Vehicle;

//接口（Interface）
//接口是一种完全抽象的类，它只能包含抽象方法和常量字段（在 Java 8 之后，接口可以包含默认方法和静态方法）。接口是定义一组方法规范，强制实现类遵循这些规范。
//
//特点
//所有方法默认是公开和抽象的，但可以包含默认方法和静态方法。
//不能包含实例字段，只能包含静态和终态的常量。
//实现类使用 implements 关键字实现接口，并必须实现其所有抽象方法。
//一个类可以实现多个接口。
public interface Vehicle {
    void start();
    void stop();
    int getSpeed();
}


//抽象类（Abstract Class）
//抽象类是不能被实例化的类，它可以包含实现细节（即方法体）。抽象类主要用于为子类提供一个共有的模板或蓝图，子类可以继承抽象类并实现或重写其方法。
//
//特点
//可以包含具体方法（即有实现的方法）和抽象方法（即没有实现体的方法）。
//可以有构造器。
//可以包含字段（变量）。
//子类使用 extends 关键字继承抽象类，并必须实现所有抽象方法，除非子类也是抽象类。

//public abstract class Vehicle {
//    private int speed;
//
//    public abstract void start();
//
//    public abstract void stop();
//
//    public void setSpeed(int speed) {
//        this.speed = speed;
//    }
//
//    public int getSpeed() {
//        return speed;
//    }
//}



//特性	          抽象类	                             接口
//实现	    可以提供一些方法的实现	           不能提供实现（除非是默认方法或静态方法）
//构造函数	    可以有	                            不能有
//实例变量	    可以有实例变量	                只能有静态和终态变量（常量）
//继承/实现	    类可以继承一个抽象类	            类可以实现多个接口
//方法体	    方法可以有或没有方法体	        Java 8 之前只能没有方法体，Java 8 之后可以有默认方法和静态方法
//多重继承	    不支持	                         支持通过实现多个接口