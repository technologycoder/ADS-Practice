package praxis.designpatterns.strategy;

public class TaxPayer {
    public static final int COMPANY = 0;

    public static final int EMPLOYEE = 1;

    public static final int TRUST = 2;

    private static final double COMPANY_RATE = 0.30;

    private static final double EMPLOYEE_RATE = 0.45;

    private static final double TRUST_RATE = 0.35;

    private final int type;

    private double income;

    public TaxPayer(int type, double income) {

        this.type = type;
        this.income = income;
    }

    public static void main(String[] args) {

        TaxPayer heinz = new TaxPayer(TaxPayer.EMPLOYEE, 50000);
        TaxPayer maxsol = new TaxPayer(TaxPayer.COMPANY, 100000);
        TaxPayer family = new TaxPayer(TaxPayer.TRUST, 30000);
        System.out.println(heinz.extortCash());
        System.out.println(maxsol.extortCash());
        System.out.println(family.extortCash());
    }

    public double getIncome() {

        return income;
    }

    public double extortCash() {

        switch (type) {
            case COMPANY:
                return income * COMPANY_RATE;
            case EMPLOYEE:
                return income * EMPLOYEE_RATE;
            case TRUST:
                return income * TRUST_RATE;
            default:
                throw new IllegalArgumentException();
        }
    }

}
