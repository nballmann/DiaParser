package org.nic.xhtmlparser.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import org.nic.xhtmlparser.XHTMLParser;
import org.nic.xhtmlparser.util.ControllerInterface;

public class MainMenuController implements ControllerInterface {

	@SuppressWarnings("unused")
	private XHTMLParser mainView;
	
	private MainViewController mainController;
	
	@FXML
	private Button diabetesNewsButton;
	
	
	@FXML
	public void initialize() {
		
		diabetesNewsButton.setDisable(true);
		
	}
	
	public void changeButtonStatus() {
		
		diabetesNewsButton.setDisable(false);
		
	}
	
	
	@Override
	public void setMainView(XHTMLParser mainView) {

		this.mainView = mainView;
		
	}
	
	public void setMainController(MainViewController mainController) {
		
		this.mainController = mainController;
		
	}
	
	@FXML
	private void handleNewEntry() {
		
		mainController.setActualView("CalendarPane");
		
	}
	
	@FXML
	private void handleStatistics() {
		
		
		
	}
	
	@FXML
	private void handleDiabetesNews() {
		
		mainController.setActualView("NewsPane");
		
	}
	
	@FXML
	private void handleOptions() {
		
		
		
	}
	
	@FXML
	private void handleExit() {
		
		System.exit(0);
		
	}

}
