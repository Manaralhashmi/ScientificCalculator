// This is the main class for the scientific calculator
import java.util.Scanner; // Import Scanner to get user input
import java.lang.Math;    // Import Math class for mathematical functions

public class ScientificCalculator1 {

    // Main method – this is where the program starts
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create Scanner object to read input
        int choice; // This will store the user's menu choice

        do {
            // Display calculator options
            System.out.println("\n=== Scientific Calculator ===");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Power (x^y)");
            System.out.println("6. Square root");
            System.out.println("7. Sine (sin(x))");
            System.out.println("8. Cosine (cos(x))");
            System.out.println("9. Tangent (tan(x))");
            System.out.println("10. Natural Log (ln(x))");
            System.out.println("11. Log Base 10 (log10(x))");
            System.out.println("12. Absolute Value");
            System.out.println("13. Round");
            System.out.println("14. Ceiling");
            System.out.println("15. Floor");
            System.out.println("16. Minimum of two numbers");
            System.out.println("17. Maximum of two numbers");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt(); // Read the user's choice

            double x, y; // For user input values
            switch (choice) {
                case 1: // Addition
                    System.out.print("Enter first number: ");
                    x = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    y = scanner.nextDouble();
                    System.out.println("Result: " + (x + y));
                    break;

                case 2: // Subtraction
                    System.out.print("Enter first number: ");
                    x = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    y = scanner.nextDouble();
                    System.out.println("Result: " + (x - y));
                    break;

                case 3: // Multiplication
                    System.out.print("Enter first number: ");
                    x = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    y = scanner.nextDouble();
                    System.out.println("Result: " + (x * y));
                    break;

                case 4: // Division
                    System.out.print("Enter numerator: ");
                    x = scanner.nextDouble();
                    System.out.print("Enter denominator: ");
                    y = scanner.nextDouble();
                    if (y != 0)
                        System.out.println("Result: " + (x / y));
                    else
                        System.out.println("Cannot divide by zero.");
                    break;

                case 5: // Power
                    System.out.print("Enter base: ");
                    x = scanner.nextDouble();
                    System.out.print("Enter exponent: ");
                    y = scanner.nextDouble();
                    System.out.println("Result: " + Math.pow(x, y));
                    break;

                case 6: // Square root
                    System.out.print("Enter a number: ");
                    x = scanner.nextDouble();
                    if (x >= 0)
                        System.out.println("Result: " + Math.sqrt(x));
                    else
                        System.out.println("Cannot take square root of negative number.");
                    break;

                case 7: // Sine
                    System.out.print("Enter angle in radians: ");
                    x = scanner.nextDouble();
                    System.out.println("Result: " + Math.sin(x));
                    break;

                case 8: // Cosine
                    System.out.print("Enter angle in radians: ");
                    x = scanner.nextDouble();
                    System.out.println("Result: " + Math.cos(x));
                    break;

                case 9: // Tangent
                    System.out.print("Enter angle in radians: ");
                    x = scanner.nextDouble();
                    System.out.println("Result: " + Math.tan(x));
                    break;

                case 10: // Natural Logarithm
                    System.out.print("Enter a number: ");
                    x = scanner.nextDouble();
                    if (x > 0)
                        System.out.println("Result: " + Math.log(x));
                    else
                        System.out.println("Input must be greater than 0.");
                    break;

                case 11: // Log Base 10
                    System.out.print("Enter a number: ");
                    x = scanner.nextDouble();
                    if (x > 0)
                        System.out.println("Result: " + Math.log10(x));
                    else
                        System.out.println("Input must be greater than 0.");
                    break;

                case 12: // Absolute Value
                    System.out.print("Enter a number: ");
                    x = scanner.nextDouble();
                    System.out.println("Result: " + Math.abs(x));
                    break;

                case 13: // Round
                    System.out.print("Enter a number: ");
                    x = scanner.nextDouble();
                    System.out.println("Result: " + Math.round(x));
                    break;

                case 14: // Ceiling
                    System.out.print("Enter a number: ");
                    x = scanner.nextDouble();
                    System.out.println("Result: " + Math.ceil(x));
                    break;

                case 15: // Floor
                    System.out.print("Enter a number: ");
                    x = scanner.nextDouble();
                    System.out.println("Result: " + Math.floor(x));
                    break;

                case 16: // Minimum
                    System.out.print("Enter first number: ");
                    x = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    y = scanner.nextDouble();
                    System.out.println("Result: " + Math.min(x, y));
                    break;

                case 17: // Maximum
                    System.out.print("Enter first number: ");
                    x = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    y = scanner.nextDouble();
                    System.out.println("Result: " + Math.max(x, y));
                    break;

                case 0:
                    System.out.println("Exiting calculator. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please choose a valid option.");
            }
        } while (choice != 0); // Keep looping until user chooses 0 (Exit)

        scanner.close(); // Close the scanner
    }
}
