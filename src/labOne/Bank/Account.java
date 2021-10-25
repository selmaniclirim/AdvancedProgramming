package labOne.Bank;

import java.util.Objects;
import java.util.Random;

public class Account {
    Random random = new Random();
    private final String name;
    private final long idNumber;
    private String balance;

    public Account(String name, String balance) {
        this.name = name;
        this.idNumber = random.nextLong();
        this.balance = balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return idNumber;
    }

    public String getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nBalance: %s\n", name, balance);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(idNumber, account.idNumber);
    }
}
