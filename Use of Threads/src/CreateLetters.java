public class CreateLetters implements Runnable {

   
   private char letter;// Declare variables
   private int quantity;

   
   public CreateLetters(char letter, int quantity) {//Constructor to determine letter and quantity
       this.letter = letter;
       this.quantity = quantity;
   }

   
   public void run() { //Run method to print letters

       for (int i = 0; i < quantity; i++) {
           System.out.print(letter);
       }
   }
}