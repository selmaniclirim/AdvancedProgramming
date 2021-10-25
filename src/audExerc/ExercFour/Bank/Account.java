package audExerc.ExercFour.Bank;

public abstract class Account {
    private String name;
    private long accountNum = 0;
    private double currentBal;

    public Account(String name, double currentBal) {
        this.name = name;
        this.currentBal = currentBal;
        this.accountNum++;
    }

    public double getCurrentBal() {
        return currentBal;
    }

    public void depositToBalance(double amount) {
        currentBal+=amount;
    }

    public void withdrawFromBalance(double amount) {
        currentBal-=amount;
    }
}
