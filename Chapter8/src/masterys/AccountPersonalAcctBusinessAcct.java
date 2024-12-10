package masterys;

public class AccountPersonalAcctBusinessAcct 
{

	
	public class Account {
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

	public class PersonalAcct extends Account {
	    private static final double MINIMUM_BALANCE = 100;
	    private static final double PENALTY = 2.0;

	    public PersonalAcct(int accountNumber, double balance) {
	        super(accountNumber, balance);
	    }

	    @Override
	    public void withdraw(double amount) {
	        super.withdraw(amount);
	        if (getBalance() < MINIMUM_BALANCE) {
	            System.out.println("Minimum balance not maintained. $2.00 penalty charged.");
	            super.withdraw(PENALTY);
	        }
	    }
	}

	public class BusinessAcct extends Account {
	    private static final double MINIMUM_BALANCE = 500;
	    private static final double PENALTY = 10.0;

	    public BusinessAcct(int accountNumber, double balance) {
	        super(accountNumber, balance);
	    }

	    @Override
	    public void withdraw(double amount) {
	        super.withdraw(amount);
	        if (getBalance() < MINIMUM_BALANCE) {
	            System.out.println("Minimum balance not maintained. $10.00 penalty charged.");
	            super.withdraw(PENALTY);
	        }
	    }
	}

	public class Main 
	{
	    public static void main(String[] args)
	    {
	        // Create a Personal Account
	        PersonalAcct personalAccount = new PersonalAcct(12345, 50);

	        // Deposit
	        personalAccount.deposit(150);
	        System.out.println("Personal Account Balance: " + personalAccount.getBalance());

	        // Withdraw
	        personalAccount.withdraw(100);
	        System.out.println("Personal Account Balance: " + personalAccount.getBalance());

	        // Withdraw below minimum balance
	        personalAccount.withdraw(50);
	        System.out.println("Personal Account Balance: " + personalAccount.getBalance());

	        // Create a Business Account
	        BusinessAcct businessAccount = new BusinessAcct(67890, 200);

	        // Deposit
	        businessAccount.deposit(500);
	        System.out.println("Business Account Balance: " + businessAccount.getBalance());

	        // Withdraw
	        businessAccount.withdraw(200);
	        System.out.println("Business Account Balance: " + businessAccount.getBalance());

	        // Withdraw below minimum balance
	        businessAccount.withdraw(400);
	        System.out.println("Business Account Balance: " + businessAccount.getBalance());
	    }
	

	}
