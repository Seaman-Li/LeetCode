package Java_basic.OOP.Vehicle;

public class TestVehicle {
    public static void main(String[] args) {
        Vehicle myCar = new Car();
        myCar.start();
        System.out.println("Speed: " + myCar.getSpeed());
        myCar.stop();
    }
}
