import java.util.Scanner;

public class vendor {
    public static void main(String[] args){
        final double hotDogPrice = 3.50;
        final double drinkPrice = 1.00;

        Scanner input = new Scanner(System.in);

        System.out.println("How many Hot Dogs and or Drinks would you like to buy?");

        System.out.print("Hot Dogs ($3.50 Each): ");
        int hotDogs = input.nextInt();
        System.out.print("Drinks ($1.00 Each): ");
        int drinks = input.nextInt();

        double total = hotDogs * hotDogPrice + drinks * drinkPrice;
        double tax = total * 0.12;
        double totalAfterTax = total + tax;

        System.out.println("Total before tax: $" + Math.round(total* 100) / 100D);
        System.out.println("Taxed (12%): $"+ Math.round(tax* 100) / 100D);
        System.out.println("Total after tax: $" + Math.round(totalAfterTax * 100) / 100D);
    }
}
