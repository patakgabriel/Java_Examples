import javax.swing.JOptionPane;

public class Test {

	public static void main(String[] args) {
		Player user[] = new Player[50];
		SlotMachine machine[] = new SlotMachine[3];

		machine[0] = new SlotMachine("Lucky 777", 5000.00, 10000, 5000.00, 10,
				5.00);
		machine[1] = new SlotMachine("Lucky Lotto", 55000.00, 100000, 75000.00,
				50, 25.00);
		machine[2] = new SlotMachine("Purple People Eater", 1000.00, 50, 40.00,
				5, 2.00);

		String menu = ("1. Play\n" + "2. Create Player\n" + "3. View Player\n"
				+ "0. Exit Program"); // Menu message
		String machineMenu = "Every machine costs $1.00 to play!" + "\n\n1) "
				+ machine[0].getPublicInfo() + "\n\n2) "
				+ machine[1].getPublicInfo() + "\n\n3) "
				+ machine[2].getPublicInfo();
		String firstName, middleInitial, lastName,  suffix, currentPlayers = "";
		

		int selection, playerNum, machineSelection, month, day, year;

		for (int i = 0; i < 50; ++i) {
			user[i] = new Player();
		}

		do {

			selection = Integer.parseInt(JOptionPane.showInputDialog(menu));
																			

			switch (selection) {

			case 1:
				String initialAmount, endingAmount, specialMessage = "";
				double prize = 0;

				for (int i = 0; i < 50; ++i) {
					if (user[i].getName() != "") {
						currentPlayers += (i + 1) + ") " + user[i].getName()
								+ "\n";
					}
				}

				playerNum = Integer.parseInt(JOptionPane
						.showInputDialog(currentPlayers
								+ "Enter player number:"));
				machineSelection = Integer.parseInt(JOptionPane
						.showInputDialog(machineMenu));

				initialAmount = Double.toString(user[playerNum - 1]
						.getMoneyBalance());

				if (machine[machineSelection - 1].randomJackpotWinNum() == 1) {
					prize = machine[machineSelection - 1].getJackpotPayout();
					specialMessage = "\nYOU WON THE JACKPOT: $"
							+ Double.toString(prize);

				} else if (machine[machineSelection - 1].randomRegularWinNum() == 1) {
					prize = machine[machineSelection - 1].getRegularPayout();
					specialMessage = "\nYou won the regular payout: $"
							+ Double.toString(prize);
				}
				user[playerNum - 1].setMoneyBalance(user[playerNum - 1]
						.getMoneyBalance() - 1.00 + prize);
				endingAmount = Double.toString(user[playerNum - 1]
						.getMoneyBalance());

				String result = "Beginning Balance: $" + initialAmount
						+ "\nEnding Balance: $" + endingAmount + specialMessage;

				JOptionPane.showMessageDialog(null, result);

				break;

			case 2:
				playerNum = Integer.parseInt(JOptionPane
						.showInputDialog("Enter player number:"));

				firstName = JOptionPane
						.showInputDialog("Please, introduce first name:");
				middleInitial = JOptionPane
						.showInputDialog("Please, introduce middle initial:");
				lastName = JOptionPane
						.showInputDialog("Please, introduce last name:");
				suffix = JOptionPane
						.showInputDialog("Please, introduce suffix:");
				
				user[playerNum - 1].setName(firstName, middleInitial, lastName, suffix);
				user[playerNum - 1].setMoneyBalance(Double.parseDouble(JOptionPane
								.showInputDialog("Please, introduce initial money:")));
				
				month = Integer.parseInt(JOptionPane
						.showInputDialog("Please, introduce month:"));
				day = Integer.parseInt(JOptionPane
						.showInputDialog("Please, introduce day:"));
				year = Integer.parseInt(JOptionPane
						.showInputDialog("Please, introduce year:"));
				
				user[playerNum - 1].setDateBirth(month,day,year);
				break;

			case 3:
				for (int i = 0; i < 50; ++i) {
					if (user[i].getName() != "") {
						currentPlayers += (i + 1) + ") " + user[i].getName()
								+ "\n";
					}
				}
				JOptionPane.showMessageDialog(null,
						currentPlayers);
				break;

			case 0:
				break;

			default:
				JOptionPane.showMessageDialog(null,
						"Please select a valid option", "Error",
						JOptionPane.ERROR_MESSAGE);
				break;
			}

		} while (selection != 0);

	}

}
