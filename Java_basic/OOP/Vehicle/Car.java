package Java_basic.OOP.Vehicle;
//当一个类实现一个接口时，它必须提供接口中所有抽象方法的具体实现，除非该类本身也被声明为抽象类。
public class Car implements Vehicle {
    private int speed;

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void stop(){
        System.out.println("Car is stopping");
        speed = 0;
    }

    @Override
    public void start() {
        System.out.println("Car is starting");
        speed = 10;
    }
}
