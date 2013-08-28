package org.nic.xhtmlparser.controller;

import java.util.HashMap;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import org.nic.xhtmlparser.XHTMLParser;
import org.nic.xhtmlparser.util.ControllerInterface;

public class MainViewController implements ControllerInterface {
	
	@SuppressWarnings("unused")
	private XHTMLParser mainView;
	
	private HashMap<String, Node> screens = new HashMap<>();
	
	@FXML
	private Text main_text;
	
	@FXML
	private StackPane mainStackPane;
	
	
	public void setMainView(XHTMLParser mainView) {
		
		this.mainView = mainView;
		
	}
	
	public void addScreen(String name, Node screen) {
		
		screens.put(name, screen);
		
	}
	
	public void setScreen(Node node) {
		
		mainStackPane.getChildren().add(0, node);
		
	}
	
	public void setActualView(final String name) {
		
		if(screens.get(name) != null) {
			
			if(!mainStackPane.getChildren().isEmpty()) {
				
				mainStackPane.getChildren().remove(0);
				
				setScreen(screens.get(name));

			} else {

				setScreen(screens.get(name));
				
			}

		}
		
	}
	
	public void setText(String newText) {
		
		main_text.setText(newText);
		
	}
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void handleMainMenu() {

		setActualView("MainMenu");
		
	}
	
	@FXML
	private void handleClose() {
		
		System.exit(0);
		
	}
	
	
	
	
	

}
