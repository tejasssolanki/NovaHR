package com.tejas.novahr.app;

import com.tejas.novahr.model.Employee;
import com.tejas.novahr.repository.EmployeeRepository;
import com.tejas.novahr.service.PayrollService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeRepository repository = new EmployeeRepository();
        PayrollService payrollService = new PayrollService();

        int choice;

        do {

            System.out.println("\n==========================================");
            System.out.println("       NOVA HR MANAGEMENT SYSTEM");
            System.out.println("==========================================");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Generate Salary Slip");
            System.out.println("6. Save Employees to CSV");
            System.out.println("7. Exit");
            System.out.println("==========================================");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Employee ID: ");
                    String id = sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();

                    System.out.print("Enter Basic Salary: ");
                    double salary = sc.nextDouble();
                    sc.nextLine();

                    Employee employee = new Employee(id, name, department, salary);

                    repository.addEmployee(employee);

                    System.out.println("\nEmployee Added Successfully!");
                    break;

                case 2:

                    repository.displayEmployees();
                    break;

                case 3:

                    System.out.print("Enter Employee ID: ");
                    String searchId = sc.nextLine();

                    Employee found = repository.searchEmployee(searchId);

                    if (found != null) {
                        System.out.println("\nEmployee Found");
                        System.out.println(found);
                    } else {
                        System.out.println("Employee Not Found.");
                    }

                    break;

                case 4:

                    System.out.print("Enter Employee ID: ");
                    String deleteId = sc.nextLine();

                    if (repository.deleteEmployee(deleteId)) {
                        System.out.println("Employee Deleted Successfully.");
                    } else {
                        System.out.println("Employee Not Found.");
                    }

                    break;

                case 5:

                    System.out.print("Enter Employee ID: ");
                    String payrollId = sc.nextLine();

                    Employee emp = repository.searchEmployee(payrollId);

                    if (emp != null) {
                        payrollService.generateSalarySlip(emp);
                    } else {
                        System.out.println("Employee Not Found.");
                    }

                    break;
                case 6:

                    repository.saveEmployeesToCSV();

                    break;
                case 7:

                    System.out.println("Thank you for using NovaHR.");
                    break;

                default:

                    System.out.println("Invalid Choice.");
            }

        } while (choice != 7);

        sc.close();
    }
}