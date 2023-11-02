package edu.wctc.part4;

public class HR {
    private String firstName;
    private String lastName;

    public HR(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void hireEmployee(Employee employee, String cubeID){
        employee.doFirstTimeOrientation(cubeID);
    }

    public void printReport(Employee employee){
        employee.printReport();
    }
}
