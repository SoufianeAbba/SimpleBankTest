
public class Transaction implements TransactionInterface {
	private long accountNumber;
	private Bank bank;
	
	public Transaction(Bank bank, long accountNumber, int attemptedPin) {
		this.bank = bank;
		this.accountNumber = accountNumber;
	}

	@Override
	public double getBalance() {
		return bank.getBalance(accountNumber);
	}

	@Override
	public void credit(double amount) {
		bank.credit(accountNumber, amount);

	}

	@Override
	public boolean debit(double amount) {		
		return bank.debit(accountNumber, amount);
	}

}
