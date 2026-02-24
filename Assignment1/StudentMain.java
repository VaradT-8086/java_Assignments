import java.util.Scanner;

class Student {
    private String name;
    private int rollNo;
    private int[] marks;

    // Constructor
    public Student(String name, int rollNo, int[] marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    public double calculatePercentage() {
        int total = 0;
        for (int m : marks) {
            total += m;
        }
        return total / 5.0;
    }

    public void displayResult() {
        double percentage = calculatePercentage();
        System.out.println("\nName: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Percentage: " + percentage);

        if (percentage >= 75)
            System.out.println("Grade: A");
        else if (percentage >= 50)
            System.out.println("Grade: B");
        else
            System.out.println("Grade: C");
    }
}

public class StudentMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();

        int[] marks = new int[5];
        System.out.println("Enter marks for 5 subjects:");
        for (int i = 0; i < 5; i++) {
            marks[i] = sc.nextInt();
        }

        Student s = new Student(name, roll, marks);
        s.displayResult();
    }
}
