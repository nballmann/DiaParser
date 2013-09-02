/*-**********************************************************************************************
 * 																								*
 * Copyright (c) 2013, N.Ballmann 																*
 * All rights reserved.																			*
 *																								*
 * Redistribution and use in source and binary forms, with or without modification, 			*
 * are permitted provided that the following conditions are met:								*
 * 																								*
 * Redistributions of source code must retain the above copyright notice, this list of 			*
 * conditions and the following disclaimer. 													*
 * Redistributions in binary form must reproduce the above copyright notice, this list 			*
 * of conditions and the following disclaimer in the documentation and/or other materials 		*
 * provided with the distribution.																*
 * 																								*
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY 			*
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES 		*
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT 			*
 * SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, 	*
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT 	*
 * OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) 	*
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR 	*
 * TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, *
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.											*
 * 																								*
 ************************************************************************************************/	

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
