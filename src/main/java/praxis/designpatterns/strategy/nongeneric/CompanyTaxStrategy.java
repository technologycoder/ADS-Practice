package praxis.designpatterns.strategy.nongeneric;

public class CompanyTaxStrategy implements TaxStrategy {
    private static final double RATE = 0.30;

    @Override
    public double extortCash(double income) {

        return income * RATE;
    }
}
