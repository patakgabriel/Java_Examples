import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class Exercise09s extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextArea jtaClient = new JTextArea();// Text area for entering client text
	private JTextArea jtaServer = new JTextArea();// Text area for displaying server text
	private PrintWriter toClient;

	public Exercise09s() {
		setLayout(new GridLayout(2, 1, 5, 5));// Creates layout for the chat
												// window
		jtaClient.setWrapStyleWord(true);
		jtaClient.setWrapStyleWord(true);
		jtaServer.setLineWrap(true);
		jtaServer.setLineWrap(true);
		jtaServer.setEditable(false);
		JScrollPane jsp1 = new JScrollPane(jtaClient);
		JScrollPane jsp2 = new JScrollPane(jtaServer);
		jsp1.setBorder(new TitledBorder("Client"));
		jsp2.setBorder(new TitledBorder("Server"));
		add(jsp2);
		add(jsp1);
		setTitle("Exercise09s");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 500);
		setLocationRelativeTo(null);// Center the frame
		setVisible(true);//Shows frame

		jtaClient.addKeyListener(new KeyAdapter() {//Receives the key that you pressed
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {//Confirms that Enter was pressed and shows updated text
					try {
						toClient.print(jtaClient.getText().split("\n")[jtaClient//prints text 
								.getLineCount() - 1] + "\n");					//and makes sure line is in correct position
						toClient.flush();
					} catch (ArrayIndexOutOfBoundsException e2) {//if array causes error notify
					}

				}
			}
		});

		try {
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(8000);// Create a server socket
			Socket socket = serverSocket.accept();// Listen for a new connection request
			toClient = new PrintWriter(socket.getOutputStream());
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
				Scanner fromClient = new Scanner(socket.getInputStream());
				while (true) {
					String text = fromClient.nextLine();
					jtaServer.append(text + "\n");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new Exercise09s();
	}
}