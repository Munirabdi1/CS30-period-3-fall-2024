import masterys.ExerciseVehicle.Account;
import masterys.ExerciseVehicle.BusinessAcct;
import masterys.ExerciseVehicle.PersonalAcct;

public class ExerciseVehicle1 {

    // Base Account class
    static class Account {
        private int accountNumber;
        private double balance;

        public Account(int accountNumber, double balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        public int getAccountNumber() {
            return accountNumber;
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            balance += amount;
        }

        public void withdraw(double amount) {
            if (balance >= amount) {
                balance -= amount;
            } else {
                System.out.println("Insufficient funds.");
            }
        }
    }

    // Personal Account subclass
    static class PersonalAcct extends Account {
        private final double MIN_BALANCE = 100;
        private final double CHARGE = 2.00;

        public PersonalAcct(int accountNumber, double balance) {
            super(accountNumber, balance);
        }

        @Override
        public void withdraw(double amount) {
            super.withdraw(amount);
            if (getBalance() < MIN_BALANCE) {
                System.out.println("Minimum balance penalty of $" + CHARGE + " applied.");
                super.withdraw(CHARGE); // Deduct penalty
            }
        }
    }

    // Business Account subclass
    static class BusinessAcct extends Account {
        private final double MIN_BALANCE = 500;
        private final double CHARGE = 10.00;

        public BusinessAcct(int accountNumber, double balance) {
            super(accountNumber, balance);
        }

        @Override
        public void withdraw(double amount) {
            super.withdraw(amount);
            if (getBalance() < MIN_BALANCE) {
                System.out.println("Minimum balance penalty of $" + CHARGE + " applied.");
                super.withdraw(CHARGE); // Deduct penalty
            }
        }
    }

    // Main method to test the accounts
    public static void main(String[] args) {
        // Create a personal account
        PersonalAcct personalAcct = new PersonalAcct(1234, 50);

        // Create a business account
        BusinessAcct businessAcct = new BusinessAcct(5678, 400);

        // Test personal account
        System.out.println("Personal Account:");
        System.out.println("Initial Balance: " + personalAcct.getBalance());
        personalAcct.deposit(100);
        System.out.println("After deposit: " + personalAcct.getBalance());
        personalAcct.withdraw(150);
        System.out.println("After withdrawal: " + personalAcct.getBalance());

        // Test business account
        System.out.println("\nBusiness Account:");
        System.out.println("Initial Balance: " + businessAcct.getBalance());
        businessAcct.deposit(200);
        System.out.println("After deposit: " + businessAcct.getBalance());
        businessAcct.withdraw(600);
        System.out.println("After withdrawal: " + businessAcct.getBalance());
    }
}
