package labOne.Bank;

public class FlatPercentProvisionTransaction extends Transaction {
    private final int flatPercent;

    public FlatPercentProvisionTransaction(long fromId, long toId, String amount, int centsPerDollar) {
        super(fromId, toId, "FlatPercent", amount);
        this.flatPercent = centsPerDollar;
    }

    public int getFlatPercent() {
        return flatPercent;
    }

    public boolean equals(Object o) {
        return this == o;
    }
}

