package department;

import utils.Constants;

public class Department {
    private String departmentID;
    private String departmentName;
    private int numOfStaff = 0;

    public Department(String departmentID, String departmentName){
        this.departmentID = departmentID;
        this.departmentName = departmentName;
    }

    // getDepartmentName
    public String getDepartmentName(){
        return departmentName;
    }

    // Get current staff number of department
    public int getNumOfStaff(){
        return numOfStaff;
    }

    // Set current staff number of department
    public void setNumOfStaff(int numOfStaff){
        this.numOfStaff = numOfStaff;
    }

    @Override
    public String toString() {
        return String.format(Constants.SFDEPARTMENTDETAIL, departmentID, departmentName, numOfStaff);
    }

    // Overriding equals method to use in comparison methods
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Department){
            Department department = (Department) obj;
            return departmentName.toLowerCase().equals(department.departmentName.toLowerCase());
        }
        return super.equals(obj);
    }
}
