import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        System.out.print("Input radius of circle: ");
        Scanner sc=new Scanner(System.in);
        double rad = sc.nextDouble();

        Circle circle = new Circle();

        circle.setRadius(rad);

        System.out.println("area "+ circle.getArea());
        System.out.println("circumference "+ circle.getCircumference());
        System.out.println("radius "+ circle.getRadius());
    }
}
