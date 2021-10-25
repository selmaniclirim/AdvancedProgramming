package audExerc.exercFour.Bank;

public class BankTester {
    public static void main(String[] args) {
        // Creating Bank object works
        Bank bank = new Bank(5);

        // Creating Account object works
        InterestCheckingAccount icaOne = new InterestCheckingAccount("Clirim", 1000.00);
        PlatinumCheckingAccount pcaOne = new PlatinumCheckingAccount("Selmani", 1500.00);

        // Bank addAccount method works
        bank.addAccount(icaOne);
        System.out.println(icaOne.getCurrentBal());

        // Account withdraw method works
        icaOne.withdrawFromBalance(500);
        System.out.println(icaOne.getCurrentBal());

        // Account deposit method works
        icaOne.depositToBalance(600);
        System.out.println(icaOne.getCurrentBal());

        // Interface addInterest method works
        icaOne.addInterest();
        System.out.println(icaOne.getCurrentBal());

        // Interface addInterest method works
        pcaOne.addInterest();
        System.out.println(pcaOne.getCurrentBal());
    }
}
