package management;

import department.Department;
import department.DepartmentList;
import people.Employee;
import people.Manager;
import people.Staff;
import people.StaffList;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;

import utils.Constants;

public class HRManagement {
    private StaffList staffList;
    private DepartmentList departmentList;

    // Constructor- Initialize staffList and departmentList
    public HRManagement(){
        staffList = new StaffList();
        departmentList = new DepartmentList();
    }

    // Display list of staffs
    public void showListOfAllStaffs(){
        staffList.showListOfAllStaffs();
        // Once printing is done
        // Prompt enter to continue
        promptEnter();
    }

    // Display list of departments
    public void showListOfAllDepartments(){
        departmentList.showListOfAllDepartments();
        promptEnter();
    }

    // Display staffs by department
    public void showStaffByDepartment(){
        if(!departmentList.getDepartmentList().isEmpty()){
            System.out.println("\n* Staff by Department");
            for(Department aDepartment : departmentList.getDepartmentList()){
                System.out.println("** Department: " + aDepartment.getDepartmentName());
                searchStaffByDepartmentName(aDepartment.getDepartmentName());
            }
            System.out.println();
        }
        else{
            System.out.println("-> Sorry, there is no department created yet");
        }
        promptEnter();
    }

    // Add new Staff
    //  - Add new Employee
    public void addEmployee(){
        Scanner sc = new Scanner(System.in);

        String id, name, joiningDate, department;
        int age, salaryGrade, numOfAnnualLeaveDays, numOfOvertimeHours;

        System.out.println("Please enter information of new employee:");

        System.out.print("Employee ID: ");
        id = sc.nextLine().toUpperCase();
        // Validate ID
        while(!isStaffIDValid(id)){
            System.out.print("ID existed. Please enter another ID: ");
            id = sc.nextLine().toUpperCase();
        }

        System.out.print("Employee Name: ");
        name = sc.nextLine();

        System.out.print("Age: ");
        age = sc.nextInt();

        System.out.print("Salary grade: ");
        salaryGrade = sc.nextInt();
        sc.nextLine();

        System.out.print("Joining date: ");
        joiningDate = sc.nextLine();

        System.out.print("Department: ");
        department = sc.nextLine();

        System.out.print("Number of day of annual leave: ");
        numOfAnnualLeaveDays = sc.nextInt();

        System.out.print("Number of Overtime hours: ");
        numOfOvertimeHours = sc.nextInt();
        sc.nextLine();

        Employee newEmployee = new Employee(id, name, age, salaryGrade, joiningDate, department, numOfAnnualLeaveDays, numOfOvertimeHours);
        staffList.addStaff(newEmployee);

        // Create temporary department to check if that department is existed or not
        Department tempDepartment = new Department("temp", department);
        // If not (department is not existed), create the new one
        // and adjust the total staff number (increase by 1)
        if(!departmentList.getDepartmentList().contains(tempDepartment)){
            System.out.print("The " + department + " department has not been created, please enter department ID to create it: ");
            String departmentID = sc.nextLine().toUpperCase();
            Department newDepartment = new Department(departmentID, department);
            newDepartment.setNumOfStaff(newDepartment.getNumOfStaff() + 1);
            departmentList.addDepartment(newDepartment);
        }
        // If department has been created, increase the total staff number by 1
        else{
            int pos = departmentList.getDepartmentList().indexOf(tempDepartment);
            Department currentDepartment = departmentList.getDepartmentList().get(pos);
            currentDepartment.setNumOfStaff(currentDepartment.getNumOfStaff() + 1);
        }
        System.out.println("New Employee has been added");
        promptEnter();
    }

    // - Add new Manager
    public void addManager(){
        Scanner sc = new Scanner(System.in);

        String id, name, joiningDate, department, jobTitle;
        int age, salaryGrade, numOfAnnualLeaveDays;

        System.out.println("Please enter information of new manager:");

        System.out.print("Manager ID: ");
        id = sc.nextLine().toUpperCase();

        // Validate ID
        while(!isStaffIDValid(id)){
            System.out.print("ID existed. Please enter another ID: ");
            id = sc.nextLine().toUpperCase();
        }

        System.out.print("Manager Name: ");
        name = sc.nextLine();

        System.out.print("Job title: ");
        jobTitle = sc.nextLine();

        System.out.print("Age: ");
        age = sc.nextInt();

        System.out.print("Salary grade: ");
        salaryGrade = sc.nextInt();
        sc.nextLine();

        System.out.print("Joining date: ");
        joiningDate = sc.nextLine();

        System.out.print("Department: ");
        department = sc.nextLine();

        System.out.print("Number of day of annual leave: ");
        numOfAnnualLeaveDays = sc.nextInt();
        sc.nextLine();

        Manager newManager = new Manager(id, name, age, salaryGrade, joiningDate, department, numOfAnnualLeaveDays, jobTitle);
        staffList.addStaff(newManager);

        // Create temporary department to check if that department is existed or not
        Department tempDepartment = new Department("temp", department);
        // If not (department is not existed), create the new one
        // and adjust the total staff number (increase by 1)
        if(!departmentList.getDepartmentList().contains(tempDepartment)){
            System.out.print("The " + department + " department has not been created, please enter department ID to create it: ");
            String departmentID = sc.nextLine().toUpperCase();
            Department newDepartment = new Department(departmentID, department);
            newDepartment.setNumOfStaff(newDepartment.getNumOfStaff() + 1);
            departmentList.addDepartment(newDepartment);
        }
        // If department has been created, increase the total staff number by 1
        else{
            int pos = departmentList.getDepartmentList().indexOf(tempDepartment);
            Department currentDepartment = departmentList.getDepartmentList().get(pos);
            currentDepartment.setNumOfStaff(currentDepartment.getNumOfStaff() + 1);
        }
        System.out.println("New Manager has been added");
        promptEnter();
    }

    // Search staff by name or id
    // searchType gets one out of two values:
    // "name" - search staff by name
    // "id" - search staff by id
    public void searchStaffBy(String searchType){
        staffList.searchStaffBy(searchType);
        promptEnter();
    }

    // Display salary sheet (of all staffs)
    public void printSalarySheet(){
        staffList.printSalarySheet();
        promptEnter();
    }

    // Display salary sheet of all staffs in ascending order
    public void printSalarySheetAscending(){
        // Copy staffList into the new one
        StaffList copiedStaffList = new StaffList();
        copiedStaffList.getStaffList().addAll(staffList.getStaffList());

        // Sort copied staff list with ascending comparator
        // (sortStaffAscendingBySalary comparator)
        copiedStaffList.getStaffList().sort(sortStaffAscendingBySalary);

        copiedStaffList.printSalarySheet();
        promptEnter();
    }

    // Display salary sheet of all staffs in descending order
    public void printSalarySheetDescending(){
        StaffList copiedStaffList = new StaffList();
        copiedStaffList.getStaffList().addAll(staffList.getStaffList());
        copiedStaffList.getStaffList().sort(sortStaffDescendingBySalary);

        copiedStaffList.printSalarySheet();
        promptEnter();
    }

    // exit program
    public void exit(){
        System.out.println("Thank you for using. Good bye!");
        System.exit(0);
    }

    // -------------------------------------------------------------------------
    // Supporting functions

    // Search staff by department name
    private void searchStaffByDepartmentName(String departmentName){
        ArrayList<Staff> staffFound = new ArrayList<>();
        for(Staff aStaff : staffList.getStaffList()) {
            if(aStaff.getDepartment().toLowerCase().equals(departmentName.toLowerCase())){
                staffFound.add(aStaff);
            }
        }
        // If there is no staff in the department
        // Then inform to the user
        if(staffFound.isEmpty()){
            System.out.println("-> No staff is found");
        }
        // otherwise, print out staff's information
        else{
            System.out.println(String.format(Constants.SFSTAFFHEADER, "ID", "Name", "Title", "Age", "Salary Grade", "Joining date", "Department", "Annual leave", "OT hours"));
            for(Staff aStaff : staffFound){
                System.out.println(aStaff.toString());
            }
        }
    }


    // Validate Staff ID
    private boolean isStaffIDValid(String id){
        for(Staff aStaff : staffList.getStaffList()){
            if(aStaff.getId().equals(id)){
                return false;
            }
        }
        return true;
    }

    // Prompt press Enter to continue
    private void promptEnter(){
        System.out.print("Press Enter to continue...");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

    // Define Comparator for sorting in ascending order by staff's salary
    private Comparator<Staff> sortStaffAscendingBySalary = new Comparator<Staff>() {
        @Override
        public int compare(Staff staff1, Staff staff2) {
            return staff1.getSalary() - staff2.getSalary();
        }
    };

    // Define Comparator for sorting in descending order by staff's salary
    private Comparator<Staff> sortStaffDescendingBySalary = new Comparator<Staff>() {
        @Override
        public int compare(Staff staff1, Staff staff2) {
            return staff2.getSalary() - staff1.getSalary();
        }
    };

}
