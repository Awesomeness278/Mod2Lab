package edu.wctc.part4;

/**
 * This class is the startup class for the program. But together with the other
 * classes provided it is not a particularly good simulation of the real world.
 * Employees don't just hire themselves and them tell themselves to go through
 * orientation. There's usually a company and a HR person involved.
 *
 * Refer to the Employee class for further directions.
 */
public class Main {

    public static void main(String[] args) {
        Employee employee = new Employee("Peter", "Piper", "333-33-3333");
        HR hr = new HR("Person", "Human");
        Company company = new Company(hr);
        company.hireEmployee(employee, "A101");
        company.reportOnEmployees();
    }

}
