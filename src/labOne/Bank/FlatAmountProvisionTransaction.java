package labOne.Bank;

public class FlatAmountProvisionTransaction extends Transaction {
    private final String flatAmount;

    public FlatAmountProvisionTransaction(long fromId, long toId, String amount, String flatProvision) {
        super(fromId, toId, "FlatAmount", amount);
        this.flatAmount = flatProvision;
    }

    public boolean equals(Object o) {
        return this == o;
    }

    @Override
    public double getProvision() {
        return Double.parseDouble(flatAmount.replace("$",""));
    }

}