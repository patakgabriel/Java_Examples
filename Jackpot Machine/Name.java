public class Name {

	private String firstName, middleInitial, lastName, suffix;

	public Name() {
		firstName = "";
		middleInitial = "";
		lastName = "";
		suffix = "";
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleInitial() {
		return middleInitial;
	}

	public String getLastName() {
		return lastName;
	}

	public String getSuffix() {
		return suffix;
	}

	public String toString() {
		return "First Name: " + getFirstName() + "\nMiddle Initial: "
				+ getMiddleInitial() + "\nLast Name: " + getLastName()
				+ "\nSuffix: " + getSuffix();
	}

	public String formattedName() {
		if(firstName != null && !firstName.isEmpty()){
		return getFirstName() + " " + getMiddleInitial() + ". " + getLastName()
				+ " " + getSuffix();
		}else{
			return "";
		}
	}

}
