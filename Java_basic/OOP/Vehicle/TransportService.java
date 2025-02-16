package Java_basic.OOP.Vehicle;

//依赖注入和接口
//接口是实现依赖注入（DI）的理想选择。使用接口作为依赖的引用，可以在运行时动态地提供具体的实现，增加了代码的模块化和灵活性。
//在这个例子中，TransportService 不需要知道传入的 Vehicle 的具体类型，只需要知道它实现了 Vehicle 接口。
//依赖注入（DI）是一种设计模式，用于实现控制反转（IoC）。在这种模式中，对象的依赖（即它需要的资源，比如服务、数据访问对象等）不是由对象本身创建，而是由外部容器或框架注入。
// 在 Java 中，依赖注入通常通过构造器注入、设值注入（setter 方法）或接口注入实现。
//在提到的 TransportService 类中使用接口的好处之一是，我们可以在不改变 TransportService 类的内部代码的情况下，灵活地更改它使用的 Vehicle 类型。
// 这是因为 TransportService 类不依赖于任何特定的 Vehicle 实现，只依赖于 Vehicle 接口。
public class TransportService {
    private Vehicle vehicle;

    public TransportService(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void startTransport() {
        vehicle.start();
        System.out.println("Transporting at speed: " + vehicle.getSpeed());
    }
}
