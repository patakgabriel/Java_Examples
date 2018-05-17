import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class Exercise09c extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextArea jtaServer = new JTextArea();// Text area for displaying server text
													 
	private JTextArea jtaClient = new JTextArea();// Text area for entering client text 
													
	private PrintWriter toServer;// Saves text to send it to chat

	public Exercise09c() {
		setLayout(new GridLayout(2, 1, 5, 5));// Creates layout for the chat
												// window
		jtaServer.setWrapStyleWord(true);
		jtaServer.setWrapStyleWord(true);
		jtaClient.setLineWrap(true);
		jtaClient.setLineWrap(true);
		jtaServer.setEditable(false);
		JScrollPane jsp1 = new JScrollPane(jtaServer);
		JScrollPane jsp2 = new JScrollPane(jtaClient);
		jsp1.setBorder(new TitledBorder("Server"));
		jsp2.setBorder(new TitledBorder("Client"));
		add(jsp1);
		add(jsp2);
		setTitle("Assigment5Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 500);
		setLocationRelativeTo(null);
		setVisible(true);

		jtaClient.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {//Receives the key that you pressed
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {//Confirms that Enter was pressed and shows updated text
					try {
						toServer.print(jtaClient.getText().split("\n")[jtaClient //prints text 
								.getLineCount() - 1] + "\n");					//and makes sure line is in correct position
						toServer.flush();
					} catch (ArrayIndexOutOfBoundsException e2) { //if array causes error notify
					}
				}
			}
		});

		try {
			Socket socket = new Socket("localhost", 8000); // Creates a server socket 
			toServer = new PrintWriter(socket.getOutputStream());
			new ReceiveMessage(socket);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	class ReceiveMessage implements Runnable {//Updates text constantly
		private Socket socket;

		public ReceiveMessage(Socket socket) {
			this.socket = socket;
			Thread thread = new Thread(this);
			thread.start();
		}

		public void run() {
			try {
				@SuppressWarnings("resource")
				Scanner fromServer = new Scanner(socket.getInputStream());
				while (true) {
					String text = fromServer.nextLine();
					jtaServer.append(text + "\n");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new Exercise09c();
	}
}