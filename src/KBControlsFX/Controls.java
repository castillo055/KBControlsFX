package KBControlsFX;

import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

import java.util.HashMap;

public class Controls {
	private static HashMap<KeyCode, ControlEntry> controls = new HashMap<>();
	private static HashMap<String, ControlEntry> actionMap = new HashMap<>();


	public static void init(Pane ROOT){
		if(ROOT.getScene() == null) {
			ROOT.sceneProperty().addListener((observableValue, scene, t1) -> {
				t1.setOnKeyPressed(keyEvent -> {
					if (controls.containsKey(keyEvent.getCode())) {
						controls.get(keyEvent.getCode()).action.action();
					}
				});
			});
		}else{
			ROOT.getScene().setOnKeyPressed(keyEvent -> {
				if (controls.containsKey(keyEvent.getCode())) {
					controls.get(keyEvent.getCode()).action.action();
				}
			});
		}
	}
	public static void addActionAndBind(KeyCode keyCode, String actionName, ControlAction action){
		ControlEntry c = new ControlEntry(actionName, action);
		actionMap.put(actionName, c);
		controls.put(keyCode, c);
	}

	public static void addAction(String actionName, ControlAction action){
		ControlEntry c = new ControlEntry(actionName, action);
		actionMap.put(actionName, c);
	}

	public static void bindAction(String actionName, KeyCode keyCode){
		ControlEntry c = actionMap.get(actionName);
		controls.put(keyCode, c);
	}
}

