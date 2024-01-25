import java.util.InputMismatchException;
import java.util.Scanner;

class InputReader {
    private final Scanner scanner = new Scanner(System.in);

    public int readInt(String prompt, int min, int max) {
        int value;
        while (true) {
            try {
                System.out.println(prompt);
                value = scanner.nextInt();
                if (value >= min && value <= max)
                    break;
                System.out.println("Enter A Value Between " + min + " and " + max);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();  // discard the invalid input
            }
        }
        return value;
    }

    public float readFloat(String prompt, float min) {
        float value;
        while (true) {
            try {
                System.out.println(prompt);
                value = scanner.nextFloat();
                if (value > min)
                    break;
                System.out.println("Enter a value greater than " + min);
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();  // discard the invalid input
            }
        }
        return value;
    }
}