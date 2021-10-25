package audExerc.exercFour.Bank;

public class InterestCheckingAccount extends Account implements InterestBearingAccount{
    public static final double INTEREST_RATE = 0.03;

    public InterestCheckingAccount(String name, double currentBal) {
        super(name, currentBal);
    }

    @Override
    public void addInterest() {
        depositToBalance(getCurrentBal() * INTEREST_RATE);
    }
}
