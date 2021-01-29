package people;

public abstract class Staff implements ICalculator{

    protected String id, name, joiningDate, department;
    protected int age, salaryGrade, numOfAnnualLeaveDays;
    protected int salary;

    public Staff(){
    }

    public Staff(String id, String name, int age, int salaryGrade, String joiningDate, String department, int numOfAnnualLeaveDays){
        this.id = id;
        this.name = name;
        this.age = age;
        this.salaryGrade = salaryGrade;
        this.joiningDate = joiningDate;
        this.department = department;
        this.numOfAnnualLeaveDays = numOfAnnualLeaveDays;
    }

    public String getId(){
        return id;
    }


    public String getDepartment(){
        return department;
    }

    public int getSalary(){
        return salary;
    }

    public abstract String toString();
}
