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