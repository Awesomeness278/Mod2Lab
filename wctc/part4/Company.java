package edu.wctc.part4;

import java.util.ArrayList;

public class Company {
    public HR hr;
    public ArrayList<Employee> employees = new ArrayList<>();

    public Company(HR hr){
        this.hr = hr;
    }

    public void hireEmployee(Employee employee, String cubeID){
        hr.hireEmployee(employee, cubeID);
        employees.add(employee);
    }

    public void reportOnEmployees(){
        for(Employee employee : employees){
            employee.printReport();
        }
    }
}
