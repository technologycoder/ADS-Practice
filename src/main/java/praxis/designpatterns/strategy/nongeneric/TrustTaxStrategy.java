package praxis.designpatterns.strategy.nongeneric;

public class TrustTaxStrategy implements TaxStrategy {
    private static final double RATE = 0.40;

    @Override
    public double extortCash(double income) {

        return income * RATE;
    }
}
