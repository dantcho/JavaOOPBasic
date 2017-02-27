package _04_CompanyRoster;

import java.math.BigDecimal;

class Employee {
    private String name;
    private BigDecimal salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public Employee(String name, BigDecimal salary, String position, String department, String email) {
        this(name, salary, position, department, email, -1);
    }

    public Employee(String name, BigDecimal salary, String position, String department, int age) {
        this(name, salary, position, department, "n/a", age);
    }

    public Employee(String name, BigDecimal salary, String position, String department) {
        this(name, salary, position, department, "n/a", -1);
    }

    public Employee(String name, BigDecimal salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public BigDecimal getSalary() {
        return this.salary;
    }

    public String getDepartment() {
        return this.department;
    }
    @Override
    public String toString() {

        return this.name + " " + String.format("%.2f", this.salary) + " " + this.email + " " + this.age;
    }

}
