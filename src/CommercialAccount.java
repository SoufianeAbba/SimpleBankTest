import java.util.ArrayList;
import java.util.List;

public class CommercialAccount extends Account {
	private List<Person> authorizedUsers;
	
	public CommercialAccount(Company company, long accountNumber, int pin, double startingDeposit) {
		super(company, accountNumber, pin, startingDeposit);
		
		this.authorizedUsers = new ArrayList<>();
	}
	
	protected void addAuthorizedUser(Person person) {
		authorizedUsers.add(person);
	}
	
	public boolean isAuthorizedUser(Person person) {
		for (Person p : authorizedUsers) {
			if (p.getFirstName().equals(person.getFirstName()) 
					&& p.getLastName().equals(person.getLastName()) ) {
				return true;
			}
		}
		
		return false;
	}

}
