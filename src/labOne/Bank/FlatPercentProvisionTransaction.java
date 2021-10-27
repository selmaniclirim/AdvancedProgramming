package labOne.Bank;

public class FlatPercentProvisionTransaction extends Transaction {
    private final int flatPercent;

    public FlatPercentProvisionTransaction(long fromId, long toId, String amount, int centsPerDollar) {
        super(fromId, toId, "FlatPercent", amount);
        this.flatPercent = centsPerDollar;
    }

    public boolean equals(Object o) {
        return this == o;
    }

    @Override
    public double getProvision() {
        double amount =  Double.parseDouble(getAmount().replace("$","")) / 100;
        return flatPercent * amount;
    }
}

