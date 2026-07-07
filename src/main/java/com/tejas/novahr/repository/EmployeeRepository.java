package com.tejas.novahr.repository;

import com.tejas.novahr.model.Employee;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EmployeeRepository {
    public void saveEmployeesToCSV() {

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter("employees.csv"));

            for (Employee employee : employeeList) {

                writer.write(
                        employee.getEmployeeId() + "," +
                                employee.getName() + "," +
                                employee.getDepartment() + "," +
                                employee.getBasicSalary()
                );

                writer.newLine();
            }

            writer.close();

            System.out.println("\nEmployees saved successfully to employees.csv");

        } catch (IOException e) {

            System.out.println("Error saving file.");

        }
    }
    private ArrayList<Employee> employeeList = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public ArrayList<Employee> getAllEmployees() {
        return employeeList;
    }
    public void displayEmployees() {

        if (employeeList.isEmpty()) {
            System.out.println("\nNo Employees Found.");
            return;
        }

        System.out.println("\n=================================================================================");
        System.out.printf("%-10s %-20s %-20s %-15s%n",
                "ID", "NAME", "DEPARTMENT", "SALARY");
        System.out.println("=================================================================================");

        for (Employee employee : employeeList) {

            System.out.printf("%-10s %-20s %-20s ₹%-15.2f%n",
                    employee.getEmployeeId(),
                    employee.getName(),
                    employee.getDepartment(),
                    employee.getBasicSalary());
        }

        System.out.println("=================================================================================");
    }

    public Employee searchEmployee(String employeeId) {

        for (Employee employee : employeeList) {
            if (employee.getEmployeeId().equalsIgnoreCase(employeeId)) {
                return employee;
            }
        }

        return null;
    }

    public boolean deleteEmployee(String employeeId) {

        Employee employee = searchEmployee(employeeId);

        if (employee != null) {
            employeeList.remove(employee);
            return true;
        }

        return false;
    }
}