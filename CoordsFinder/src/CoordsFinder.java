import java.util.Scanner;

public class CoordsFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x, y;

        System.out.print("Enter X Coordinates: ");
        x = sc.nextInt();
        System.out.print("Enter Y Coordinates: ");
        y = sc.nextInt();
        System.out.print("This is ");

        if (x < 0 && y > 0) {
            System.out.println("Quadrant #1");
        } else if (x > 0 && y > 0) {
            System.out.println("Quadrant #2");
        } else if (x < 0 && y < 0) {
            System.out.println("Quadrant #3");
        } if (x > 0 && y < 0) {
            System.out.println("Quadrant #4");
        } else if (x > 0 && y == 0) {
            System.out.println("+X axis");
        } else if (x < 0 && y == 0) {
            System.out.println("-X axis");
        } else if (x == 0 && y > 0) {
            System.out.println("+Y axis");
        } else if (x == 0 && y < 0) {
            System.out.println("-Y axis");
        } else {
            System.out.println("Center");
        }
    }
}
