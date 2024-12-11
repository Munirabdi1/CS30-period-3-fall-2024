package masters;

// Base Account class
class Account {
    protected double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}

// PersonalAcct class inheriting from Account
class PersonalAcct extends Account {
    private final double minimumBalance = 100;

    public PersonalAcct(double balance) {
        super(balance);
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        if (balance < minimumBalance) {
            balance -= 2; // $2 penalty
        }
    }
}

// BusinessAcct class inheriting from Account
class BusinessAcct extends Account {
    private final double minimumBalance = 500;

    public BusinessAcct(double balance) {
        super(balance);
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        if (balance < minimumBalance) {
            balance -= 10; // $10 penalty
        }
    }
}

// Main class for testing the accounts
public class AccountPersonalAcctBusinessAcct {
    public static void main(String[] args) {
        // Create Personal Account with initial balance
        PersonalAcct personal = new PersonalAcct(150);

        // Create Business Account with initial balance
        BusinessAcct business = new BusinessAcct(600);

        // Perform withdrawals
        personal.withdraw(60); // Withdraw $60 from Personal Account
        business.withdraw(200); // Withdraw $200 from Business Account

        // Print updated balances
        System.out.println("Personal Account Balance: $" + personal.getBalance());
        System.out.println("Business Account Balance: $" + business.getBalance());
    }
}
