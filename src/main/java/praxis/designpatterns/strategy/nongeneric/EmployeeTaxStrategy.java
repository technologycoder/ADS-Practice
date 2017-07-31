package praxis.designpatterns.strategy.nongeneric;

public class EmployeeTaxStrategy implements TaxStrategy {
    private static final double RATE = 0.45;

    @Override
    public double extortCash(double income) {
        return income * RATE;
    }
}
