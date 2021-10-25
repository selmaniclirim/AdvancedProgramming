package labOne.Bank;

public class FlatAmountProvisionTransaction extends Transaction {
    private final String flatAmount;

    public FlatAmountProvisionTransaction(long fromId, long toId, String amount, String flatProvision) {
        super(fromId, toId, "FlatAmount", amount);
        this.flatAmount = flatProvision;
    }

    public String getFlatAmount() {
        return flatAmount;
    }

    public boolean equals(Object o) {
        return this == o;
    }

}