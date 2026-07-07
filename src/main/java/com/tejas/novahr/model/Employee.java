package com.tejas.novahr.model;

public class Employee {

    private String employeeId;
    private String name;
    private String department;
    private double basicSalary;

    public Employee() {
    }

    public Employee(String employeeId, String name, String department, double basicSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.basicSalary = basicSalary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    @Override
    public String toString() {
        return "Employee ID : " + employeeId +
                "\nName        : " + name +
                "\nDepartment  : " + department +
                "\nSalary      : ₹" + basicSalary;
    }
}