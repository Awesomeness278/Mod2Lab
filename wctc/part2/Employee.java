package edu.wctc.part2;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * In this lab focus on METHOD encapsulation and fix/add code as necessary.
 * Pay special attention to the following issues:
 *
 * 1. Not all methods need to be public
 *
 * 2. When methods need to be called in a certain order you can do this
 * by creating a parent method that calls the other, helper methods.
 *
 * 3. There is some duplicate code used that violates the D.R.Y. principle.
 * Eliminate that by encapsulating the duplicate code in a new method
 * and then call that method in place of the duplicate code.
 *
 * 4. All method parameters should be validated (except booleans).
 *
 * Review the tips in the document Encapsulation Checklist if needed.
 */
public class Employee {
    public static final int SSN_LENGTH = 9;
    public static final int CID_LENGTH = 3;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yy");

    private String firstName;
    private String lastName;
    private String ssn;
    private boolean metWithHr;
    private boolean metDeptStaff;
    private boolean reviewedDeptPolicies;
    private boolean movedIn;
    private String cubeId;
    private LocalDate orientationDate;
    private String fmtDate;

    public Employee(String firstName, String lastName, String ssn) {
        setFirstName(firstName);
        setLastName(lastName);
        setSsn(ssn);
    }

    // Assume this must be performed first, and assume that an employee
    // would only do this once, upon being hired.
    private void meetWithHrForBenefitAndSalaryInfo() {
        metWithHr = true;
        printAction("met with HR on");
    }

    // Assume this must be performed second, and assume that an employee
    // would only do this once, upon being hired.
    private void meetDepartmentStaff() {
        metDeptStaff = true;
        printAction("met with dept staff");
    }

    // Assume this must be performed third. And assume that because department
    // policies may change that this method may need to be called 
    // independently from other classes.
    public void reviewDeptPolicies() {
        reviewedDeptPolicies = true;
        printAction("reviewed dept policies");
    }

    private void printAction(String action){
        if(action.length() == 0){
            System.out.println("Invalid action");
            return;
        }
        System.out.println(firstName + " " + lastName + " " + action + " on " + fmtDate);
    }

    public void onboardNewEmployee(String cubeId){
        if(cubeId.length() != 3){
            System.out.println("Cube ID needs to be 3 characters");
            return;
        }
        meetWithHrForBenefitAndSalaryInfo();
        meetDepartmentStaff();
        reviewDeptPolicies();
        moveIntoCubicle(cubeId);
    }

    // Assume this must be performed fourth. And assume that because employees
    // sometimes change office locations that this method may need to be called 
    // independently from other classes.
    public void moveIntoCubicle(String cubeId) {
        if(cubeId.length() != 3){
            System.out.println("Cube ID needs to be 3 characters");
            return;
        }
        this.cubeId = cubeId;
        this.movedIn = true;
        printAction("moved into cubicle " + cubeId);
        System.out.println(firstName + " " + lastName + " moved into cubicle "
                + cubeId + " on " + fmtDate);
    }

    public String getFirstName() {
        return firstName;
    }

    // setter methods give the developer the power to control what data is
    // allowed through validation.

    public void setFirstName(String firstName) {
        if(firstName.length() == 0){
            System.out.println("Invalid Name");
            return;
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName.length() == 0){
            System.out.println("Invalid Name");
            return;
        }
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        if(ssn.length() != SSN_LENGTH){
            System.out.println("SSN of "+ssn+" is not "+SSN_LENGTH+" digits");
            return;
        }
        this.ssn = ssn;
    }

    public boolean hasMetWithHr() {
        return metWithHr;
    }

    public boolean hasMetDeptStaff() {
        return metDeptStaff;
    }

    public boolean hasReviewedDeptPolicies() {
        return reviewedDeptPolicies;
    }

    public boolean hasMovedIn() {
        return movedIn;
    }

    public String getCubeId() {
        return cubeId;
    }

    public void setCubeId(String cubeId) {
        if(cubeId.length() != CID_LENGTH){
            System.out.println("Invalid Cube ID, needs to be "+CID_LENGTH+" characters");
            return;
        }
        this.cubeId = cubeId;
    }

    public LocalDate getOrientationDate() {
        return orientationDate;
    }

    public void setOrientationDate(LocalDate orientationDate) {
        if(orientationDate.isBefore(LocalDate.now())){
            System.out.println("Day has to be later than now");
            return;
        }
        this.orientationDate = orientationDate;
        fmtDate = formatter.format(orientationDate);
    }
}
