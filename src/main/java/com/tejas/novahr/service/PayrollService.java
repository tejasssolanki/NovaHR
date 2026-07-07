package com.tejas.novahr.service;

import com.tejas.novahr.model.Employee;

public class PayrollService {

    private static final double TAX_RATE = 0.10;   // 10%
    private static final double PF_RATE = 0.12;    // 12%

    public void generateSalarySlip(Employee employee) {

        double basicSalary = employee.getBasicSalary();

        double tax = basicSalary * TAX_RATE;
        double pf = basicSalary * PF_RATE;
        double netSalary = basicSalary - tax - pf;

        System.out.println("\n========================================");
        System.out.println("           SALARY SLIP");
        System.out.println("========================================");
        System.out.println("Employee ID : " + employee.getEmployeeId());
        System.out.println("Name        : " + employee.getName());
        System.out.println("Department  : " + employee.getDepartment());
        System.out.println("----------------------------------------");
        System.out.printf("Basic Salary : ₹%.2f%n", basicSalary);
        System.out.printf("Tax (10%%)    : ₹%.2f%n", tax);
        System.out.printf("PF (12%%)     : ₹%.2f%n", pf);
        System.out.println("----------------------------------------");
        System.out.printf("Net Salary   : ₹%.2f%n", netSalary);
        System.out.println("========================================");
    }
}