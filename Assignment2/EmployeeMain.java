package Employee;

import java.util.Scanner;

class Employee {
    protected double salary;

    public Employee(double salary) {
        this.salary = salary;
    }

    public void displaySalary() {
        System.out.println("Salary: " + salary);
    }
}

class FullTimeEmployee extends Employee {

    public FullTimeEmployee(double salary) {
        super(salary);
    }

    public void calculateSalary() {
        double newSalary = salary + (salary * 0.50);
        System.out.println("\nFull Time Employee");
        System.out.println("Before Hike: " + salary);
        System.out.println("After 50% Hike: " + newSalary);
    }
}

class InternEmployee extends Employee {

    public InternEmployee(double salary) {
        super(salary);
    }

    public void calculateSalary() {
        double newSalary = salary + (salary * 0.25);
        System.out.println("\nIntern Employee");
        System.out.println("Before Hike: " + salary);
        System.out.println("After 25% Hike: " + newSalary);
    }
}

public class EmployeeMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        for(int j = 1; j <= n; j++) {

            System.out.println("\nEmployee " + j);

            System.out.print("Enter type (1- FullTime, 2- Intern): ");
            int type = sc.nextInt();

            System.out.print("Enter salary: ");
            double salary = sc.nextDouble();

            if(type == 1) {
                FullTimeEmployee f = new FullTimeEmployee(salary);
                f.calculateSalary();
            }
            else if(type == 2) {
                InternEmployee i = new InternEmployee(salary);
                i.calculateSalary();
            }
            else {
                System.out.println("Invalid type!");
            }
        }

        sc.close();
    }
}
