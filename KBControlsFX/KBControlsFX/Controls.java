package KBControlsFX;

import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

import java.util.HashMap;

public class Controls {
	private Pane root;
	public HashMap<KeyCode, ControlEntry> controls = new HashMap<>();


	public Controls(Pane root){
		this.root = root;
	}
	public void setAction(KeyCode keyCode, String actionName, ControlAction action){
		ControlEntry c = new ControlEntry(actionName, action);
		controls.put(keyCode, c);

		if(root.getScene() == null) {
			root.sceneProperty().addListener((observableValue, scene, t1) -> {
				t1.setOnKeyPressed(keyEvent -> {
					if (controls.containsKey(keyEvent.getCode())) {
						controls.get(keyEvent.getCode()).action.action();
					}
				});
			});
		}else{
			root.getScene().setOnKeyPressed(keyEvent -> {
				if (controls.containsKey(keyEvent.getCode())) {
					controls.get(keyEvent.getCode()).action.action();
				}
			});
		}
	}
}

