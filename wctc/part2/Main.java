package edu.wctc.part2;

import java.time.LocalDate;
import java.time.temporal.TemporalAmount;

public class Main {
    public static void main(String[] args){
        Employee employee = new Employee("Bob","McBob","000000000");
        employee.setOrientationDate(LocalDate.now().plusMonths(1));
        employee.onboardNewEmployee("A23");
    }
}
