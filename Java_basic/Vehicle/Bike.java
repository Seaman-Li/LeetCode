package Java_basic.Vehicle;
//Vehicle vehicle; 声明：这里，vehicle 是一个类型为 Vehicle 的引用变量。在运行时，这个变量可以引用任何 Vehicle 的实现，无论是 Car、Bike 或其他任何实现了 Vehicle 接口的类。
//依赖注入：在 TransportService 的构造器中，我们传递一个 Vehicle 类型的对象。这样，TransportService 就不需要知道具体的车辆类型，只需要知道它可以启动和停止，并且可以获取速度。这种方式大大增强了代码的灵活性和可扩展性。
public class Bike implements Vehicle {
    private int speed;

    @Override
    public void start() {
        System.out.println("Bike is starting");
        speed = 5;
    }

    @Override
    public void stop() {
        System.out.println("Bike is stopping");
        speed = 0;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

//    创建了一个 TransportService 类的对象，然后使用这个服务对象来调用传入的 Bike 类的方法。这是一个典型的依赖注入实现，
//    其中 TransportService 依赖于 Vehicle 接口，而具体的实现类（在这个例子中是 Bike）在运行时被注入。这样做的目的是增加代码的灵活性和可维护性。
    public static void main(String[] args) {
        Vehicle myBike = new Bike();
        TransportService service = new TransportService(myBike);
        service.startTransport();
    }
}
//使用封装在 TransportService 中的对象实例
//通过 TransportService 来调用 Vehicle 接口的方法体现了依赖注入和面向接口编程的设计原则，这种方式有几个明显的优点：
//
//解耦：TransportService 不依赖于任何具体的 Vehicle 实现。这使得 TransportService 的代码更加通用和可重用，也使得替换不同的 Vehicle 实现变得简单，不需要修改 TransportService 的内部代码。
//
//易于扩展和维护：如果你的应用将来需要支持不同种类的 Vehicle，或者需要在不同的运行时环境中使用不同的 Vehicle 配置，使用 TransportService 可以很容易地通过配置文件或运行时逻辑更改依赖，而不需要修改到具体的业务逻辑代码。
//
//便于测试：当使用 TransportService 时，测试变得更简单。你可以注入模拟的 Vehicle 对象到 TransportService 中，从而只测试 TransportService 的逻辑而不是 Vehicle 的实现逻辑。这有助于编写单元测试，确保测试的是业务逻辑而非实现细节。
