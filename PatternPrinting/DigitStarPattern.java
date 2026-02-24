import java.util.Scanner; 


public class DigitStarPattern {

    // Define ONCE here, accessible by all methods
    static String[][] patterns = {
        {"***", "* *", "* *", "* *", "***"},  // 0
        {" * ", "** ", " * ", " * ", "***"},  // 1
        {"***", "  *", "***", "*  ", "***"},  // 2
        {"***", "  *", "***", "  *", "***"},  // 3
        {"* *", "* *", "***", "  *", "  *"},  // 4
        {"***", "*  ", "***", "  *", "***"},  // 5
        {"***", "*  ", "***", "* *", "***"},  // 6
        {"***", "  *", "  *", "  *", "  *"},  // 7
        {"***", "* *", "***", "* *", "***"},  // 8
        {"***", "* *", "***", "  *", "***"}   // 9
    };

    public static void printDigit(int digit) {
        for (String row : patterns[digit]) {  // uses the shared one
            System.out.println(row);
        }
    }

    public static void printNumber(int number) {
        int d1 = number / 100;
        int d2 = (number / 10) % 10;
        int d3 = number % 10;

        for (int row = 0; row < 5; row++) {
            System.out.println(
                patterns[d1][row] + "   " +
                patterns[d2][row] + "   " +
                patterns[d3][row]
            );
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a 3-digit number: ");
        int number = scanner.nextInt();

        if (number < 100 || number > 999) {
            System.out.println("Please enter a valid 3-digit number.");
        } else {
            printNumber(number);
        }
        scanner.close();
    }
}
