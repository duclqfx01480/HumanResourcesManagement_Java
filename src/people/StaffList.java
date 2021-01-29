package people;

import java.util.ArrayList;
import java.util.Scanner;
import utils.Constants;

public class StaffList {
    private ArrayList<Staff> staffList;

    public StaffList(){
        staffList = new ArrayList<Staff>();
    }

    public ArrayList<Staff> getStaffList(){
        return staffList;
    }

    // Display list of staffs
    public void showListOfAllStaffs(){
        if(!staffList.isEmpty()){
            System.out.println("\n* Information of all staffs:");
            System.out.println(String.format(Constants.SFSTAFFHEADER, "ID", "Name", "Title", "Age", "Salary Grade", "Joining date", "Department", "Annual leave", "OT hours"));
            for(Staff aStaff : staffList){
                System.out.println(aStaff.toString());
            }
            System.out.println();
        }
        else{
            System.out.println("-> Sorry, there is no staff");
        }
    }

    // Search staff by (by name or by id)
    // searchType gets one out of two values:
    // "name" - search staff by name
    // "id" - search staff by id
    public void searchStaffBy(String searchType){
        ArrayList<Staff> staffFound = new ArrayList<Staff>();
        Scanner sc = new Scanner(System.in);
        String searchKey = "";

        if(searchType.equals("name")){
            System.out.print("Enter the name of staff to search: ");
            searchKey = sc.nextLine();
            for(Staff aStaff : staffList){
                if(aStaff.name.toLowerCase().contains(searchKey.toLowerCase())){
                    staffFound.add(aStaff);
                }
            }
        }
        else if (searchType.equals("id")){
            System.out.print("Enter the staff ID to search: ");
            searchKey = sc.nextLine();
            for(Staff aStaff : staffList){
                if(aStaff.id.toLowerCase().contains(searchKey.toLowerCase())){
                    staffFound.add(aStaff);
                }
            }
        }
        else{
            System.out.println("Please select one out of two search type:  \"name\" or \"id\" ");
        }

        if(staffFound.isEmpty()){
            System.out.println("-> No staff is found");
        }
        else{
            System.out.println("\n* Search result: ");
            System.out.println(String.format(Constants.SFSTAFFHEADER, "ID", "Name", "Title", "Age", "Salary Grade", "Joining date", "Department", "Annual leave", "OT hours"));
            for(Staff aStaff : staffFound){
                System.out.println(aStaff.toString());
            }
            System.out.println();
        }
    }

    // Add new staff
    public void addStaff(Staff staff){
        staffList.add(staff);
    }

    // Print Salary Sheet
    public void printSalarySheet(){
        if(!staffList.isEmpty()){
            System.out.println("\n* Salary Sheet:");
            System.out.println(String.format(Constants.SFSTAFFHEADER + " %10s", "ID", "Name", "Title", "Age", "Salary Grade", "Joining date", "Department", "Annual leave", "OT hours", "Salary"));
            for(Staff aStaff : staffList){
                aStaff.calculateSalary();
                System.out.println(aStaff.toString() + String.format(" %10s", aStaff.getSalary() + ""));
            }
            System.out.println();
        }
        else{
            System.out.println("-> Sorry, there is no staff");
        }
    }
}