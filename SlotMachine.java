import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;


public class SlotMachine {
	private String machineName;
	private double machineBalance, jackpotPayout, regularPayout;
	private int jackpotOdds, jackpotWins = 0, regularOdds, regularWins = 0;
	
	DecimalFormat moneyFormat = new DecimalFormat("#,###,###,##0.00");
	
	public SlotMachine(String machineName, double machineBalance, int jackpotOdds,
			double jackpotPayout, int regularOdds, double regularPayout){
		this.machineName = machineName;
		this.machineBalance = machineBalance;
		this.jackpotOdds = jackpotOdds;
		this.jackpotPayout = jackpotPayout;
		this.regularOdds = regularOdds;
		this.regularPayout = regularPayout;
	}
	
	public void setName(String name){
		machineName = name;
	}
	
	public String getName(){
		return machineName;
	}
	
	public void setMachineBalance(double money){
		machineBalance = money;
	}
	
	public double getMachineBalance(){
		
		return machineBalance;
	}
	
	public void setJackpotWinOdds(int odds){
		jackpotOdds = odds; 
	}
	
	public int getJackpotWinOdds(){
		return jackpotOdds;
	}
	
	public void setRegularWinOdds(int odds){
		regularOdds = odds ;
	}
	
	public int getRegularWinOdds(){
		return regularOdds;
	}
	
	public void numJackpotWins(){
		jackpotWins += 1;
	}
	
	public int getNumJackpotWins(){
		return jackpotWins;
	}
	
	public void numRegularWins(){
		regularWins += 1;
	}
	
	public int getNumRegularWins(){
		return regularWins;
	}

	public void setJackpotPayout(double prize){
		jackpotPayout = prize;
	}
	
	public double getJackpotPayout(){
		return jackpotPayout;
	}
	
	public void setRegularPayout(double prize){
		regularPayout = prize;
	}
	
	public double getRegularPayout(){
		return regularPayout;
	}

	public String toString(){
		return "Machine Name: " + getName() + "\nMachine Balance: " + getMachineBalance() + 
				"\nJackpot Payout: " + getJackpotPayout() + "\nJackpot Win Odds: " + getJackpotWinOdds() +
				"\nRegular Payout: " + getRegularPayout() + "\nRegular Win Odds: " + getRegularWinOdds();
	}
	
	public String getPublicInfo(){
		return getName() + " - Jackpot Payout: $" + moneyFormat.format(getJackpotPayout()) +  
				" - Regular Payout: $" + moneyFormat.format(getRegularPayout());
	}

	public int randomJackpotWinNum(){
		return ThreadLocalRandom.current().nextInt(1, jackpotOdds + 1);
	}
	public int randomRegularWinNum(){
		return ThreadLocalRandom.current().nextInt(1, regularOdds + 1);
	}
	
}
