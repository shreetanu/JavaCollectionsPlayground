package my.practice.datastructures.streams;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    String name;
    int age;

    public Employee(String name,int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        List<Employee> l1 = new ArrayList<>();
        l1.add(new Employee("TANU",24));
        l1.add(new Employee("VAID",23));
        l1.add(new Employee("J",22));

        //Intermediate function - map
        //Terminal function toList()
        List<String> names = l1.stream().map(employee ->  {
            return employee.name.toUpperCase();
        }).toList();

        for(String n: names) {
            System.out.println(n);
        }
    }
}
