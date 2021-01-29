/*
Name: Duc, Le Quang
Email: lequangduc91@gmail.com | duclqfx01480@funix.edu.vn
Phone: +84 934 500 520
 */

import management.HRManagement;

import java.util.Scanner;

public class Main {

    // Scanner to get user's input
    private static Scanner sc = new Scanner(System.in);

    // Main
    public static void main(String[] args){
        // Welcome message
        welcome();

        // Instantiate an instance of HRManagement for managing staffs and departments
        HRManagement hrManagement = new HRManagement();

        // Loop these until user selects to exit program
        while(true) {

            // Get the choice of user
            int action = getChoice();

            switch(action) {
                // 1. Display list of all staffs
                case 1:
                    hrManagement.showListOfAllStaffs();
                    break;

                // 2. Display list of all departments
                case 2:
                    hrManagement.showListOfAllDepartments();
                    break;

                // 3. Display list of staff by department
                case 3:
                    hrManagement.showStaffByDepartment();
                    break;

                // 4. Add new staff
                case 4:
                    int typeOfStaffToAdd = 0;
                    do{
                        System.out.println("\t1. Add new employee");
                        System.out.println("\t2. Add new manager");
                        System.out.print("Your choice: ");
                        typeOfStaffToAdd = sc.nextInt();
                    }
                    while(typeOfStaffToAdd!=1 && typeOfStaffToAdd!=2);

                    // - Add new Employee
                    if(typeOfStaffToAdd==1){
                        hrManagement.addEmployee();
                    }
                    // - Add new Manager
                    else{
                        hrManagement.addManager();
                    }
                    break;

                // 5. Search staff by name or id
                case 5:
                    int searchBy = 0;
                    do{
                        System.out.println("\t1. Search staff by name");
                        System.out.println("\t2. Search staff by staff ID");
                        System.out.print("\tYour choice: ");
                        searchBy = sc.nextInt();
                    }
                    while(searchBy!=1 && searchBy!=2);

                    if(searchBy==1){
                        hrManagement.searchStaffBy("name");
                    }
                    else{
                        hrManagement.searchStaffBy("id");
                    }
                    break;

                // 6. Display salary sheet
                case 6:
                    hrManagement.printSalarySheet();
                    break;

                // 7. Display salary sheet in ascending order
                case 7:
                    hrManagement.printSalarySheetAscending();
                    break;

                // 8. Display salary sheet in descending order
                case 8:
                    hrManagement.printSalarySheetDescending();
                    break;

                // 9. Exit program
                case 9:
                    // Close scanner before exiting
                    sc.close();
                    hrManagement.exit();
            }
        }
    }

    // Display welcome message
    private static void welcome(){
        System.out.println("Welcome to Human Resources Management Application");
    }

    // Show menu and get choice of user
    private static int getChoice(){
        int choice;
        System.out.println("\n------------------PLEASE SELECT YOUR OPTION------------------");
        System.out.println("1. Display list of staffs");
        System.out.println("2. Display list of departments");
        System.out.println("3. Display staffs by department");
        System.out.println("4. Add new staff");
        System.out.println("5. Search staff by name or id");
        System.out.println("6. Display salary sheet");
        System.out.println("7. Display salary sheet in ascending order");
        System.out.println("8. Display salary sheet in descending order");
        System.out.println("9. Exit");

        System.out.print("Your choice: ");
        choice = sc.nextInt();

        while(choice<1 || choice>9){
            System.out.print("Please enter number from 1 to 9:  ");
            choice = sc.nextInt();
        }
        return choice;
    }

}
