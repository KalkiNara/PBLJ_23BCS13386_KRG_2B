import java.util.*;
import java.util.stream.*;

class Employee {
    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String toString() {
        return name + " - ₹" + salary;
    }
}

public class StreamEmployeeFilter {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
            new Employee("Vaibhav", 201, 45000),
            new Employee("Riya", 202, 60000),
            new Employee("Arjun", 203, 52000),
            new Employee("Mehak", 204, 70000),
            new Employee("Karan", 205, 48000)
        );

        System.out.println("Employees earning above ₹50,000:");

        List<String> topEarners = employees.stream()
            .filter(e -> e.salary > 50000)
            .sorted((e1, e2) -> Double.compare(e2.salary, e1.salary))
            .map(e -> e.name)
            .collect(Collectors.toList());

        topEarners.forEach(System.out::println);
    }
}
