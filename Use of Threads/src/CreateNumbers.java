class CreateNumbers implements Runnable {

   
   private int maxNumber; // Declare variables

   
   public CreateNumbers(int maxNumber) { //Constructor to determine until what number to print
       this.maxNumber = maxNumber;
   }

   
   public void run() {//Run method to print integers from 1 to maxNumber
       for (int i = 1; i <= maxNumber; i++) {
           System.out.print(" " + i);
       }
   }
}