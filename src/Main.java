import KBControlsFX.Controls;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Main extends Application {
	public static void main(String[] args){
		launch(args);
	}

	@Override
	public void start (Stage stage) throws Exception {
		Pane root = new Pane();
		Label l = new Label("Press Any Key");
		l.setFont(new Font(35));
		root.getChildren().add(l);

		Controls c = new Controls(root);
		c.setAction(KeyCode.A, "A", () -> l.setText("A"));
		c.setAction(KeyCode.W, "W", () -> l.setText("W"));
		c.setAction(KeyCode.S, "S", () -> l.setText("S"));
		c.setAction(KeyCode.D, "D", () -> l.setText("D"));

		stage.setScene(new Scene(root));
		stage.show();
	}
}