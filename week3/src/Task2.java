/*
 * 2.用 List 来存储下表信息并遍历输出
 * 提示：定义一个类，id、name、salary、managerId 为类中的属性，然后将每一行记录添加 到集合中。
 */

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1,"Joe",70000,"3"));
        list.add(new Employee(2,"Henry",80000,"4"));
        list.add(new Employee(3,"Sam",60000));
        list.add(new Employee(4,"Max",90000));
        System.out.println("Id  Name   Salary  ManagerId");

        //打印
        for(Employee e : list)
        {
            System.out.print(e.getId() + "   " + e.getName());
            for(int i = e.getName().length(); i < 7; i++)
                System.out.print(" ");
            System.out.println(e.getSalary() + "   " + e.getManagerId());
        }
    }
}

class Employee
{
    private  int Id;
    private String Name = null;
    private int Salary;
    private String ManagerId = null;

    public Employee(int id, String name, int salary, String managerId) {
        this.Id = id;
        this.Name = name;
        this.Salary = salary;
        this.ManagerId = managerId;
    }

    public Employee(int id, String name, int salary) {
        this.Id = id;
        this.Name = name;
        this.Salary = salary;
    }

    public Employee(){}


    public  int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public int getSalary() {
        return Salary;
    }

    public String getManagerId() {
        return ManagerId;
    }
}