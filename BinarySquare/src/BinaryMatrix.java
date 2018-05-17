import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class BinaryMatrix extends Application {
	
	//Sets dimensions of the square
    private static int HEIGHT = 300;
    private static int WIDTH = 300;
    
    public void start(Stage primaryStage) {


        GridPane pane = new GridPane();
        
        for (int i = 0; i < 10; i++) {//Nested loop to fill the matrix
            for (int j = 0; j < 10; j++) {
                TextField text = new TextField();
                text.setText(Integer.toString((int)(Math.random() * 2)));//Generates a random number (0-1)
                //Size of individual boxes
                text.setMinWidth(WIDTH / 10.0);
                text.setMaxWidth(WIDTH / 10.0);
                text.setMinHeight(HEIGHT / 10.0);
                text.setMaxHeight(HEIGHT / 10.0);
                pane.add(text, j, i);
            }
        }
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(WIDTH);
        primaryStage.setMinHeight(HEIGHT);
        primaryStage.setTitle("Square Matrix");
        primaryStage.show();
    }

    public static void main(String[] args) {

        Application.launch(args);
    }
}