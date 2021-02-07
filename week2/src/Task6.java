/*
 * 6. 编写一个 Java 应用程序，设计一个汽车类 Vehicle，包含的属性有车轮个数 wheels 和车重 weight。
 * 小车类 Car 是 Vehicle 的子类，其中包含的属性有载人数 loader。
 * 卡车类 Truck 也是 Vehicle 的子类，其中包含的属性有载人数 loader 和载重量 payload。
 * 每个类都有构造方法和 输出相关数据的方法。
 * 最后，写一个测试类来测试这些类的功能。
 */

import java.util.Scanner;

public class Task6
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        // 小车测试
        System.out.print("要上车的人数：");
        int n = in.nextInt();
        Car car = new Car(n);
        System.out.printf("车轮的个数：%d  车重：%.1f", car.getWheels(), car.getWeight());
        System.out.printf("\n这是一辆小车，能载%d人，实载%d人", car.getMaxLoader(), car.getLoader());
        if (car.getLoader() > car.getMaxLoader())
        {
            System.out.println("，你超载了!!!");
        }

        // 卡车测试
        System.out.print("\n要上车的人数：");
        n = in.nextInt();
        System.out.print("货物重量：");
        double w = in.nextDouble();
        Truck truck = new Truck(n, w);
        System.out.printf("车轮的个数：%d  车重：%.1f", truck.getWheels(), truck.getWeight());
        System.out.printf("\n这是一辆卡车，能载%d人，实载%d人", truck.getMaxLoader(), truck.getLoader());
        if (truck.getLoader() > truck.getMaxLoader())
        {
            System.out.print("，你超载了!!!");
        }
        System.out.printf("\n这是一辆卡车，荷载%.1fkg，你已装载%.1fkg", truck.getMaxPayload(), truck.getPayload());
        if (truck.getPayload() > truck.getMaxPayload())
        {
            System.out.print("，你超载了!!!");
        }
    }
}

class Vehicle
{
    private int wheels;
    private double weight;

    public Vehicle(int wheels, double weight)
    {
        this.wheels = wheels;
        this.weight = weight;
    }

    public Vehicle(){}

    public int getWheels()
    {
        return wheels;
    }

    public double getWeight()
    {
        return weight;
    }
}

class Car extends Vehicle
{
    private final int maxLoader = 5;
    private int loader;

    public Car(int loader)
    {
        super(4, 1150.0);
        this.loader = loader;
    }

    public int getLoader() {
        return loader;
    }

    public int getMaxLoader() {
        return maxLoader;
    }
}

class Truck extends Vehicle
{
    private final int maxLoader = 3;
    private final double maxPayload = 5000;
    private int loader;
    private double payload;

    public Truck(int loader, double payload) {
        super(6, 15000.0);
        this.loader = loader;
        this.payload = payload;
    }

    public int getLoader() {
        return loader;
    }

    public double getPayload() {
        return payload;
    }

    public int getMaxLoader() {
        return maxLoader;
    }

    public double getMaxPayload() {
        return maxPayload;
    }
}