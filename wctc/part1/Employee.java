package edu.wctc.part1;

import java.time.LocalDate;
import java.time.temporal.TemporalField;

/**
 * Fix the code in this class to do PROPERTY encapsulation correctly. Also
 * consider if any of the properties should be mandatory and use a constructor
 * to enforce that. Review the tips in the document Encapsulation Checklist if
 * needed.
 */
public class Employee {
    public static final int SSN_LENGTH = 9;
    public static final int CID_LENGTH = 3;


    private String firstName;
    private String lastName;
    private String ssn;
    private boolean metWithHr = false;
    private boolean metDeptStaff = false;
    private boolean reviewedDeptPolicies = false;
    private boolean movedIn = false;
    private String cubeId;
    private LocalDate orientationDate;

    public Employee(String firstName, String lastName, String ssn, String cubeId, LocalDate orientationDate){
        if(firstName.length() == 0){
            System.out.println("Invalid Name");
            System.exit(1);
        }
        this.firstName = firstName;
        if(lastName.length() == 0){
            System.out.println("Invalid Name");
            System.exit(1);
        }
        this.lastName = lastName;
        if(ssn.length() != SSN_LENGTH){
            System.out.println("SSN of "+ssn+" is not "+SSN_LENGTH+" digits");
            System.exit(1);
        }
        this.ssn = ssn;
        if(cubeId.length() != CID_LENGTH){
            System.out.println("Invalid Cube ID, needs to be "+CID_LENGTH+" characters");
            System.exit(1);
        }
        this.cubeId = cubeId;
        if(orientationDate.isBefore(LocalDate.now())){
            System.out.println("Day has to be later than now");
            System.exit(1);
        }
        this.orientationDate = orientationDate;
    }

    public LocalDate getOrientationDate() {
        return orientationDate;
    }

    public String getCubeId() {
        return cubeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public boolean didMetDeptStaff() {
        return metDeptStaff;
    }

    public boolean didMeetWithHr() {
        return metWithHr;
    }

    public boolean didMoveIn() {
        return movedIn;
    }

    public boolean didReviewDeptPolicies() {
        return reviewedDeptPolicies;
    }

    public void setFirstName(String firstName) {
        if(firstName.length() == 0){
            System.out.println("Invalid Name");
            return;
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if(lastName.length() == 0){
            System.out.println("Invalid Name");
            return;
        }
        this.lastName = lastName;
    }

    public void setCubeId(String cubeId) {
        if(cubeId.length() != CID_LENGTH){
            System.out.println("Invalid Cube ID, needs to be "+CID_LENGTH+" characters");
            return;
        }
        this.cubeId = cubeId;
    }

    public void setOrientationDate(LocalDate orientationDate) {
        if(orientationDate.isBefore(LocalDate.now())){
            System.out.println("Day has to be later than now");
            return;
        }
        this.orientationDate = orientationDate;
    }

    public void setSsn(String ssn) {
        if(ssn.length() != SSN_LENGTH){
            System.out.println("SSN of "+ssn+" is not "+SSN_LENGTH+" digits");
            return;
        }
        this.ssn = ssn;
    }

    public void metDeptStaff(boolean metDeptStaff) {
        this.metDeptStaff = true;
    }

    public void metWithHr(boolean metWithHr) {
        this.metWithHr = true;
    }

    public void movedIn(boolean movedIn) {
        this.movedIn = true;
    }

    public void reviewedDeptPolicies(boolean reviewedDeptPolicies) {
        this.reviewedDeptPolicies = true;
    }
}
