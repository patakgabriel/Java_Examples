import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateBirth {

	private int month, day, year;
	
	public DateBirth() {
		month = 0;
		day = 0;
		year = 0;
	}
	
	public void setMonth(int month){
		this.month = month;
	}
	public void setDay(int day){
		this.day = day;
	}
	public void setYear(int year){
		this.year = year;
	}
	
	public int getMonth(){
		return month;
	}
	public int getDay(){
		return day;
	}
	public int getYear(){
		return year;
	}
	
	public String toString(){

		return Integer.toString(month) + "/" + Integer.toString(day) + "/" + Integer.toString(year);
	}
	
	public boolean validateDate(int month, int day, int year){
		String dateBirth = Integer.toString(month) + "/" + Integer.toString(day) + "/" + Integer.toString(year);
		Date today = new Date();
		


		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		sdf.setLenient(false);

		try {
			Date dobDate = sdf.parse(dateBirth);
			
	        if (dobDate.compareTo(today) <= 0 && year >= 1900 ) {

	            return true;
	        }else{
	        	return false;
	        }
		} catch (ParseException e) {

			return false;
		}

		
		
		    


	}
	
	
}
