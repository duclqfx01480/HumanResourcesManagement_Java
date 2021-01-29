package people;

import utils.Constants;

public class Manager extends Staff{
    private String jobTitle;

    public Manager(String id, String name, int age, int salaryGrade, String joiningDate, String department, int numOfAnnualLeaveDays, String jobTitle){
        super(id, name, age, salaryGrade, joiningDate, department, numOfAnnualLeaveDays);
        this.jobTitle = jobTitle;
    }

    // Method to Calculate salary
    public void calculateSalary(){
        int responsibilitySalary = 0;
        switch (jobTitle.toLowerCase()){
            case "business leader":
                responsibilitySalary = 8000000;
                break;
            case "project leader":
                responsibilitySalary = 5000000;
                break;
            case "technical leader":
                responsibilitySalary = 6000000;
        }
        salary = salaryGrade*5000000 + responsibilitySalary;
    }

    // Overriding toString method
    @Override
    public String toString(){
        return String.format(Constants.SFSTAFFDETAIL, id, name, jobTitle, age, salaryGrade, joiningDate, department, numOfAnnualLeaveDays, 0);
    }

}
