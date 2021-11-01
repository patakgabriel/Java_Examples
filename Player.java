import javax.swing.JOptionPane;


public class Player {
	
	private Name name = new Name();
	private DateBirth dateBirth = new DateBirth();
	private double moneyBalance;

	public void setName(String firstName, String middleInitial, String lastName, String suffix) {

		name.setFirstName(firstName);
		name.setMiddleInitial(middleInitial);
		name.setLastName(lastName);
		name.setSuffix(suffix);
	}
	
	public void setDateBirth(int month, int day, int year){
		

		if (!dateBirth.validateDate(month, day, year)){
			JOptionPane.showMessageDialog(null, "Please enter a valid date", "Error", JOptionPane.ERROR_MESSAGE);
		}else{
			dateBirth.setMonth(month);
			dateBirth.setDay(day);
			dateBirth.setYear(year);
		}
	
	}

	public void setMoneyBalance(double money){
	    moneyBalance = money;
	}
	
	public String getName() {
		
		return name.formattedName();
	}
	
	public String getDateBirth() {
		return dateBirth.toString();
	}
	
	public double getMoneyBalance(){
		
		
		return moneyBalance;
	}
	
	public String toString(){
		return "Player Name: " + getName() + "\nDate of Birth: " + getDateBirth() + "\nMoney Balance " + getMoneyBalance();
	}
	
	
}
