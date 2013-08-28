package org.nic.xhtmlparser.controller;

import org.nic.xhtmlparser.XHTMLParser;
import org.nic.xhtmlparser.util.ControllerInterface;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class MainViewController implements ControllerInterface {
	
	@SuppressWarnings("unused")
	private XHTMLParser mainView;
	
	
	@FXML
	private Text main_text;
	
	
	public void setMainView(XHTMLParser mainView) {
		
		this.mainView = mainView;
		
	}
	
	public void setText(String newText) {
		
		main_text.setText(newText);
		
	}
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void handleClose() {
		
		System.exit(0);
		
	}
	
	
	
	
	

}
