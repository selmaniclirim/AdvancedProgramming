package labOne.Bank;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class Bank {
    private final String name;
    private final Account[] accounts;

    private double totalTransfers;
    private double totalProvision;

    public Bank(String name, Account[] accounts) {
        this.name = name;
        this.accounts = Arrays.copyOf(accounts, accounts.length);
        this.totalTransfers = 0.0;
        this.totalProvision = 0.0;

    }

    void updateTotals(double amount, double provision) {
        this.totalTransfers += amount;
        this.totalProvision += provision;
    }



    public boolean makeTransaction(Transaction t) {
        Optional<Account> from = findAccount(t.getFromId());
        Optional<Account> to = findAccount(t.getToId());
        if (from.isPresent() && to.isPresent()) {
            Account fromAccount = from.get();
            Account toAccount = to.get();
            double fromBalance = Double.parseDouble(fromAccount.getBalance().replace("$", ""));
            double toBalance = Double.parseDouble(toAccount.getBalance().replace("$", ""));
            double amount = Double.parseDouble(t.getAmount().replace("$", ""));
            double provision = t.getProvision();
            if (provision + amount <= fromBalance) {
                if (fromAccount.getId() == toAccount.getId()) {
                    fromBalance =
                            toBalance = (fromBalance - provision);
                } else {
                    fromBalance -= provision + amount;
                    toBalance += amount;
                }
                fromAccount.setBalance(String.format("%.2f$", fromBalance));
                toAccount.setBalance(String.format("%.2f$", toBalance));
                updateTotals(amount, provision);
                return true;
            }


        }
        return false;
    }

    Optional<Account> findAccount(long id) {
        return Arrays.stream(accounts)
                .filter(each -> each.getId() == id)
                .findAny();
    }

    public String totalTransfers() {
        return String.format("%.2f$", totalTransfers);
    }

    public String totalProvision() {
        return String.format("%.2f$", totalProvision);
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Name: ");
        result.append(name);
        result.append("\n\n");
        Arrays.stream(accounts).forEach(each -> result.append(each.toString()));
        return result.toString();
    }

    public Account[] getAccounts() {
        return accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bank bank = (Bank) o;
        return Objects.equals(name, bank.name) &&
                Arrays.equals(accounts, bank.accounts) &&
                Objects.equals(totalTransfers, bank.totalTransfers) &&
                Objects.equals(totalProvision, bank.totalProvision);
    }

}
