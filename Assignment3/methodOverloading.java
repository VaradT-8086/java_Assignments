
import java.util.Scanner;

class Shapes {

    
    void area(int side) {
        System.out.println("Area of Square: " + (side * side));
    }

    
    void area(int length, int breadth) {
        System.out.println("Area of Rectangle: " + (length * breadth));
    }

    void area(double radius) {
        System.out.println("Area of Circle: " + (Math.PI * radius * radius));
    }
}

public class methodOverloading {

  
    public static void main(String[] args) {
              
        Scanner sc = new Scanner(System.in);
        Shapes s = new Shapes();

        System.out.println("Choose Shape:");
        System.out.println("1. Square");
        System.out.println("2. Rectangle");
        System.out.println("3. Circle");

        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                System.out.print("Enter side: ");
                int side = sc.nextInt();
                s.area(side);
                break;

            case 2:
                System.out.print("Enter length: ");
                int l = sc.nextInt();
                System.out.print("Enter breadth: ");
                int b = sc.nextInt();
                s.area(l, b);
                break;

            case 3:
                System.out.print("Enter radius: ");
                double r = sc.nextDouble();
                s.area(r);
                break;

            default:
                System.out.println("Invalid choice");
        }
         
       
        
        }


}
