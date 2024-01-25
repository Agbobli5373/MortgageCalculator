import java.text.NumberFormat;

class MortgagePrinter {
    public void printMortgage(double mortgage) {
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage:" + mortgageFormatted);
    }
}