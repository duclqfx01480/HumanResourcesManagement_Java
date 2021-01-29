package department;

import java.util.ArrayList;
import utils.Constants;

public class DepartmentList {
    private ArrayList<Department> departmentList;

    public DepartmentList(){
        departmentList = new ArrayList<Department>();
    }

    public ArrayList<Department> getDepartmentList(){
        return departmentList;
    }

    // Display list of departments
    public void showListOfAllDepartments(){
        if(!departmentList.isEmpty()){
            System.out.println("\n* Detail of all Departments:");
            System.out.println(String.format(Constants.SFDEPARTMENTHEADER, "Department ID", "Department Name", "Number of staff"));
            for(Department aDepartment : departmentList){
                System.out.println(aDepartment.toString());
            }
            System.out.println();
        }
        else{
            System.out.println("-> Sorry, there is no department");
        }
    }

    // Add new department
    public void addDepartment(Department department){
        departmentList.add(department);
    }
}
