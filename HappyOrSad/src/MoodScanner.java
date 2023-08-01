import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class MoodScanner {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.print("Input happyorsad.txt filepath: ");
        String filePath = input.nextLine();
        File happyOrSadTxt = new File(filePath);
        Scanner hossc = new Scanner((happyOrSadTxt));

        int happyCount = 0;
        int sadCount = 0;

        while (hossc.hasNext()) {
            String s = hossc.next();
            if (s.equals(":-)")) {
                happyCount += 1;
            } else if (s.equals(":-(")) {
                sadCount += 1;
            }
        }

        if (happyCount > sadCount) {
            System.out.println("Happy :-)");
        } else if (sadCount > happyCount) {
            System.out.println("Sad :-(");
        } else if (happyCount == 0) {
            System.out.println("None");
        } else {
            System.out.println("Unsure");
        }
    }
}