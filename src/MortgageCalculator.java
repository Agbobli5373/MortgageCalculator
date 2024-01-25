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


