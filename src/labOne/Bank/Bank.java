package labOne.Bank;

import java.util.Arrays;

public class Bank {
    private final String name;
    private final Account[] accounts;

    public Bank(String name, Account[] accounts) {
        this.name = name;
        this.accounts = accounts;
    }

    //TODO
    public boolean makeTransaction(Transaction t) {
        return true;
    }

    public String totalTransfers() {
        return "totalTransfers Method";
    }

    public String totalProvision() {
        return "totalProvision Method";
    }

    public String toString() {
        StringBuilder result = new StringBuilder () ;
        result.append("Name: ");
        result.append(name);
        result.append("\n\n");
        Arrays.stream(accounts).forEach(each -> result.append(each.toString()));
        return result.toString();
    }

    public Account[] getAccounts() {
        return accounts;
    }
}
