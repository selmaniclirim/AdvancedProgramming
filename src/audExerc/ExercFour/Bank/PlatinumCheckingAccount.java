package audExerc.ExercFour.Bank;

public class PlatinumCheckingAccount extends InterestCheckingAccount{
    public PlatinumCheckingAccount(String name, double currentBal) {
        super(name, currentBal);
    }

    @Override
    public void addInterest() {
        depositToBalance(getCurrentBal() * (INTEREST_RATE * 2));
    }
}
