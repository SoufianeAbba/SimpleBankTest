import java.util.Date;
import java.util.LinkedHashMap;

public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts;
	
	public Bank() {
		accounts = new LinkedHashMap<>();	
	}
	
	private Account getAccount(long accountNumber) {
		return accounts.get(accountNumber);
	}
	
	public long openCommercialAccount(Company company, int pin, double startingDeposit) {
		CommercialAccount commercialAccount = new CommercialAccount(company, new Date().getTime(), pin, startingDeposit);
		accounts.put(commercialAccount.getAccountNumber(), commercialAccount);
		return commercialAccount.getAccountNumber();
	}
	
	public long openConsumerAccount(Person person, int pin, double startingDeposit) {
		ConsumerAccount consumerAccount = new ConsumerAccount(person, new Date().getTime(), pin, startingDeposit);
		accounts.put(consumerAccount.getAccountNumber(), consumerAccount);
		return consumerAccount.getAccountNumber();
	}

	public boolean authenticateUser(long accountNumber, int pin) {
		return getAccount(accountNumber).validatePin(pin);
	}

	public double getBalance(long accountNumber) {
		return getAccount(accountNumber).getBalance();
	}

	public void credit(long accountNumber, double amount) {
		getAccount(accountNumber).creditAccount(amount);
	}

	public boolean debit(long accountNumber, double amount) {
		return getAccount(accountNumber).debitAccount(amount);
	}

}
