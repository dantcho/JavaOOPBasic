package _04_CompanyRoster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.valueOf(reader.readLine());
        HashSet<Employee> persons = new HashSet<>();
        for (int i = 0; i < num; i++) {
            String[] token = reader.readLine().split("\\s+");
            String name = token[0];
            BigDecimal salary = new BigDecimal(token[1]);
            String position = token[2];
            String department = token[3];
            if (token.length == 6) {
                String email = token[4];
                int age = Integer.parseInt(token[5]);
                persons.add(new Employee(name, salary, position, department, email, age));
            } else if (token.length == 5) {

                String obj = token[4];
                if (isStringInt(obj)) {
                    persons.add(new Employee(name, salary, position, department, Integer.parseInt(obj)));

                } else
                    persons.add(new Employee(name, salary, position, department, obj));
            } else {
                persons.add(new Employee(name, salary, position, department));

            }
        }
        Map<String, List<Employee>> collect = persons.stream().collect(Collectors.groupingBy(x -> x.getDepartment()));
        Map.Entry<String, List<Employee>> departmentWithHighestSalary = collect.entrySet().stream().max((o1, o2) -> {
            double asDoubleO1 = o1.getValue().stream().mapToDouble(e -> e.getSalary().doubleValue()).average().getAsDouble();
            double asDoubleO2 = o2.getValue().stream().mapToDouble(e -> e.getSalary().doubleValue()).average().getAsDouble();
            return Double.compare(asDoubleO1, asDoubleO2);
        }).get();
        System.out.println("Highest Average Salary: " + departmentWithHighestSalary.getKey());
        departmentWithHighestSalary.getValue().sort((o1, o2) -> o2.getSalary().compareTo(o1.getSalary()));
        departmentWithHighestSalary.getValue().forEach(employee -> System.out.println(employee));
    }

    public static boolean isStringInt(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}