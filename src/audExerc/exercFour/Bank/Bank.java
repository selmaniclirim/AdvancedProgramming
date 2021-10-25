package audExerc.exercFour.Bank;

import java.util.Arrays;

public class Bank {
    private Account[] accounts;
    private int totalAccounts;
    private int max;

    public Bank(int max) {
        this.max = max;
        this.totalAccounts = 0;
        accounts = new Account[max];
    }

    public void addAccount(Account account) {
        if(this.accounts.length == totalAccounts) {
            this.accounts = Arrays.copyOf(accounts, max * 2);
        }
        this.accounts[totalAccounts++] = account;
    }

    public double totalAssets() {
        double totalAssets = 0.0;
        for(Account account : accounts) {
            totalAssets += account.getCurrentBal();
        }
        return totalAssets;
    }

    public void addInterest(double amount) {
        for(Account account :  accounts) {
            if(account instanceof InterestBearingAccount) {
                InterestBearingAccount iba = (InterestBearingAccount) account;
                iba.addInterest();
            }
        }
    }

    @Override
    public String toString() {
        return "Bank{" +
                "accounts=" + Arrays.toString(accounts) +
                ", totalAccounts=" + totalAccounts +
                ", max=" + max +
                '}';
    }
}
