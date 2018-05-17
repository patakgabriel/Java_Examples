
public class WorkingThreads {
	  
	   public static void main(String[] args) {

	       // Create tasks
	       Runnable task1 = new CreateLetters('a', 100);
	       Runnable task2 = new CreateLetters('b', 100);
	       Runnable task3 = new CreateNumbers(100);

	       // Create threads
	       Thread thread1 = new Thread(task1);
	       Thread thread2 = new Thread(task2);
	       Thread thread3 = new Thread(task3);

	       // Start threads
	       thread1.start();
	       thread2.start();
	       thread3.start();
	   }
	}
