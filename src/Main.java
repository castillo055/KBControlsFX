import KBControlsFX.ControlAction;
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

		Controls.init(root);
		Controls.addActionAndBind(KeyCode.A, "A", () -> l.setText("A"));
		Controls.addActionAndBind(KeyCode.W, "W", () -> l.setText("W"));
		Controls.addActionAndBind(KeyCode.S, "S", () -> l.setText("S"));
		Controls.addActionAndBind(KeyCode.D, "D", () -> l.setText("D"));


		stage.setScene(new Scene(root));
		stage.show();
	}
}