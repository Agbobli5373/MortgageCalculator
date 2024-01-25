Here is the `InputReader` class:

```java
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
```
Here is the `Mortgage` Calculator:

```java
import java.text.NumberFormat;

class MortgageCalculator {
    private static final byte MONTHS_IN_YEAR = 12;
    private static final byte PERCENT = 100;

    private final int principal;
    private final float annualInterestRate;
    private final byte years;

    public MortgageCalculator(int principal, float annualInterestRate, byte years) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.years = years;
    }

    public double calculateMortgage() {
        float monthlyInterest = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        int numberOfPayments = years * MONTHS_IN_YEAR;
        return principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
    }
}
```

Here is the `MortgagePrinter` class

```java
import java.text.NumberFormat;

class MortgagePrinter {
    public void printMortgage(double mortgage) {
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage:" + mortgageFormatted);
    }
}
```

Here is the `Main` class:

```java
public class Main {
    public static void main(String... args) {
        InputReader reader = new InputReader();
        int principal = reader.readInt("Principal:", 1000, 1_000_000);
        float annualInterestRate = reader.readFloat("Annual Interest Rate:", 0);
        byte years = (byte) reader.readInt("Period (Years):", 1, 100);

        MortgageCalculator calculator = new MortgageCalculator(principal, annualInterestRate, years);
        double mortgage = calculator.calculateMortgage();

        MortgagePrinter printer = new MortgagePrinter();
        printer.printMortgage(mortgage);
    }
}
```