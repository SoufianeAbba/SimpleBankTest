
public abstract class Account implements AccountInterface {
	private AccountHolder accountHolder;
	private long accountNumber;
	private int pin;
	private double balance;
	
	protected Account(AccountHolder accountHolder, long accountNumber, int pin, double startingDeposit) {
		this.accountHolder = accountHolder;
		this.accountNumber = accountNumber;
		this.pin = pin;
		this.balance = startingDeposit;
	}

	@Override
	public AccountHolder getAccountHolder() {
		return accountHolder;
	}

	@Override
	public boolean validatePin(int attemptedPin) {
		return (attemptedPin == pin);
	}

	@Override
	public double getBalance() {
		return balance;
	}

	@Override
	public long getAccountNumber() {
		return accountNumber;
	}

	@Override
	public void creditAccount(double amount) {
		balance = balance + amount;
	}

	@Override
	public boolean debitAccount(double amount) {	
		if (balance - amount < 0) return false;
		
		balance = balance - amount;
		
		return true;
	}
	
}
