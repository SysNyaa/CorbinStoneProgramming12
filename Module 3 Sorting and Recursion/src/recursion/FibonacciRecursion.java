package recursion;
import java.util.Scanner;

public class FibonacciRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");

        int n = sc.nextInt();
        int result = fibonacci(n);

        System.out.println("The " + getSuffix(n) + " number of the Fibonacci Sequence is: " + result);
    }

    public static int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static String getSuffix (int number) {
        if (number >= 11 && number <= 13) {
            return number + "th";
        } else {
            return switch (number % 10) {
                case 1 -> number + "st";
                case 2 -> number + "nd";
                case 3 -> number + "rd";
                default -> number + "th";
            };
        }
    }
}
