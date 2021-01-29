package people;

import utils.Constants;

public class Employee extends Staff{
    // number of overtime hours
    private int numOfOvertimeHours;

    public Employee(String id, String name, int age, int salaryGrade, String joiningDate, String department, int numOfAnnualLeaveDays, int numOfOvertimeHours){
        super(id, name, age, salaryGrade, joiningDate, department, numOfAnnualLeaveDays);
        this.numOfOvertimeHours = numOfOvertimeHours;
    }

    // Method to calculate salary
    @Override
    public void calculateSalary(){
        salary = salaryGrade*3000000 + numOfOvertimeHours*200000;
    }

    // Overriding toString method
    @Override
    public String toString(){
        return String.format(Constants.SFSTAFFDETAIL, id, name, "Employee", age, salaryGrade, joiningDate, department, numOfAnnualLeaveDays, numOfOvertimeHours);
    }
}
