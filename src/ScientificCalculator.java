import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ScientificCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        while (keepRunning) {
            displayMenu();
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // clear wrong input
                continue;
            }

            switch (choice) {
                case 1 -> performAddition(scanner);
                case 2 -> performSubtraction(scanner);
                case 3 -> performMultiplication(scanner);
                case 4 -> performDivision(scanner);
                case 5 -> performSquareRoot(scanner);
                case 6 -> performPower(scanner);
                case 7 -> performSine(scanner);
                case 8 -> performCosine(scanner);
                case 9 -> performTangent(scanner);
                case 10 -> performNaturalLog(scanner);
                case 11 -> performLogBase10(scanner);
                case 12 -> performAbsoluteValue(scanner);
                case 13 -> performRounding(scanner);
                case 14 -> performCeiling(scanner);
                case 15 -> performFloor(scanner);
                case 16 -> performMin(scanner);
                case 17 -> performMax(scanner);
                case 0 -> {
                    keepRunning = false;
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("\n=== Scientific Calculator ===");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Square Root");
        System.out.println("6. Power (x^y)");
        System.out.println("7. Sine");
        System.out.println("8. Cosine");
        System.out.println("9. Tangent");
        System.out.println("10. Natural Log (ln)");
        System.out.println("11. Log base 10");
        System.out.println("12. Absolute Value");
        System.out.println("13. Round to Nearest Integer");
        System.out.println("14. Ceiling (round up)");
        System.out.println("15. Floor (round down)");
        System.out.println("16. Minimum of Two Numbers");
        System.out.println("17. Maximum of Two Numbers");
        System.out.println("0. Exit");
    }

    // --- Basic Math ---
    public static double add(double a, double b) { return a + b; }
    public static double subtract(double a, double b) { return a - b; }
    public static double multiply(double a, double b) { return a * b; }
    public static double divide(double a, double b) {
        if (b == 0) throw new ArithmeticException("Cannot divide by zero.");
        return a / b;
    }

    // --- Scientific Functions ---
    public static double calculateSquareRoot(double a) {
        if (a < 0) throw new ArithmeticException("Cannot take square root of a negative number.");
        return Math.sqrt(a);
    }

    public static double calculatePower(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    public static double calculateSine(double degrees) {
        return Math.sin(Math.toRadians(degrees));
    }

    public static double calculateCosine(double degrees) {
        return Math.cos(Math.toRadians(degrees));
    }

    public static double calculateTangent(double degrees) {
        double radians = Math.toRadians(degrees);
        if (Math.abs(Math.cos(radians)) < 1e-10) {
            throw new ArithmeticException("Tangent is undefined at " + degrees + " degrees.");
        }
        return Math.tan(radians);
    }

    public static double calculateNaturalLog(double a) {
        if (a <= 0) throw new ArithmeticException("Input must be greater than 0 for ln.");
        return Math.log(a);
    }

    public static double calculateLogBase10(double a) {
        if (a <= 0) throw new ArithmeticException("Input must be greater than 0 for log10.");
        return Math.log10(a);
    }

    public static double calculateAbsoluteValue(double a) {
        return Math.abs(a);
    }

    public static long roundNumber(double a) {
        return Math.round(a);
    }

    public static double ceilingNumber(double a) {
        return Math.ceil(a);
    }

    public static double floorNumber(double a) {
        return Math.floor(a);
    }

    public static double findMin(double a, double b) {
        return Math.min(a, b);
    }

    public static double findMax(double a, double b) {
        return Math.max(a, b);
    }

    // --- Operation Executors ---
    private static void performBinaryOperation(Scanner scanner, String label, BiFunction<Double, Double, Double> operation) {
        try {
            System.out.print("Enter first number: ");
            double a = scanner.nextDouble();
            System.out.print("Enter second number: ");
            double b = scanner.nextDouble();
            double result = operation.apply(a, b);
            System.out.println(label + ": " + result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine(); // clear input
        }
    }

    private static void performUnaryOperation(Scanner scanner, String label, Function<Double, ?> operation) {
        try {
            System.out.print("Enter number: ");
            double a = scanner.nextDouble();
            Object result = operation.apply(a);
            System.out.println(label + ": " + result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            scanner.nextLine(); // clear input
        }
    }

    // --- Individual Function Callers ---
    private static void performAddition(Scanner scanner) { performBinaryOperation(scanner, "Sum", ScientificCalculator::add); }
    private static void performSubtraction(Scanner scanner) { performBinaryOperation(scanner, "Difference", ScientificCalculator::subtract); }
    private static void performMultiplication(Scanner scanner) { performBinaryOperation(scanner, "Product", ScientificCalculator::multiply); }
    private static void performDivision(Scanner scanner) { performBinaryOperation(scanner, "Quotient", ScientificCalculator::divide); }

    private static void performSquareRoot(Scanner scanner) { performUnaryOperation(scanner, "Square Root", ScientificCalculator::calculateSquareRoot); }
    private static void performPower(Scanner scanner) { performBinaryOperation(scanner, "Power", ScientificCalculator::calculatePower); }

    private static void performSine(Scanner scanner) { performUnaryOperation(scanner, "Sine", ScientificCalculator::calculateSine); }
    private static void performCosine(Scanner scanner) { performUnaryOperation(scanner, "Cosine", ScientificCalculator::calculateCosine); }
    private static void performTangent(Scanner scanner) { performUnaryOperation(scanner, "Tangent", ScientificCalculator::calculateTangent); }

    private static void performNaturalLog(Scanner scanner) { performUnaryOperation(scanner, "Natural Logarithm", ScientificCalculator::calculateNaturalLog); }
    private static void performLogBase10(Scanner scanner) { performUnaryOperation(scanner, "Log Base 10", ScientificCalculator::calculateLogBase10); }
    private static void performAbsoluteValue(Scanner scanner) { performUnaryOperation(scanner, "Absolute Value", ScientificCalculator::calculateAbsoluteValue); }
    private static void performRounding(Scanner scanner) { performUnaryOperation(scanner, "Rounded", ScientificCalculator::roundNumber); }
    private static void performCeiling(Scanner scanner) { performUnaryOperation(scanner, "Ceiling", ScientificCalculator::ceilingNumber); }
    private static void performFloor(Scanner scanner) { performUnaryOperation(scanner, "Floor", ScientificCalculator::floorNumber); }

    private static void performMin(Scanner scanner) { performBinaryOperation(scanner, "Minimum", ScientificCalculator::findMin); }
    private static void performMax(Scanner scanner) { performBinaryOperation(scanner, "Maximum", ScientificCalculator::findMax); }
}
