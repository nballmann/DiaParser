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

package org.nic.xhtmlparser;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import org.nic.xhtmlparser.controller.CalendarController;
import org.nic.xhtmlparser.controller.MainMenuController;
import org.nic.xhtmlparser.controller.MainViewController;
import org.nic.xhtmlparser.controller.NewsFeedPaneController;
import org.nic.xhtmlparser.model.NewsFeed;
import org.nic.xhtmlparser.util.ConnectionHelper;
import org.nic.xhtmlparser.util.NewsParser;

/**
 * 
 * This class extends {@link Application} and acts as the base entry point 
 * for the whole JavaFX 2.2 Application
 * 
 * @author N.Ballmann
 *
 */
public class XHTMLParser extends Application {
	
	private static final String APP_VERSION = "0.1A";
	private static final String APP_TITLE = "Diabetes App Ver: " + APP_VERSION;
	
	/*
	 * 
	 * Panel Controller
	 * 
	 */
	private MainViewController mainViewController;
	private NewsFeedPaneController newsFeedController;
	private MainMenuController mainMenuController;
	private CalendarController calendarController;

	
	@Override
	public void start(Stage primaryStage) {
		
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/MainView.fxml"));
			
			BorderPane bPane = (BorderPane) loader.load();
			
			mainViewController = loader.getController();	
			mainViewController.setMainView(this);
			
			initMainMenuPane();
			
			Scene scene = new Scene(bPane);
			
			primaryStage.setScene(scene);
			
			primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {

				@Override
				public void handle(WindowEvent arg0) {

					System.exit(0);
					
				}
	
			});
			
			primaryStage.setTitle(APP_TITLE);
			primaryStage.setResizable(false);
			primaryStage.show();
			
			initNewEntryPane();
			initNewsFeedPane();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	/**
	 * 
	 * initializes the Main Menu and loads the corresponding controller
	 * {@link MainMenuController}
	 * adds the controller to the controller list
	 * and sets the pane as first item to show
	 * 
	 */
	public void initMainMenuPane() {
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/MainMenuPane.fxml"));
			
			FlowPane fPane = (FlowPane) loader.load();
			
			mainMenuController = loader.getController();
			mainMenuController.setMainView(this);
			mainMenuController.setMainController(mainViewController);
			
			mainViewController.addScreen("MainMenu", fPane);
			mainViewController.setScreen(fPane);
			
		} catch (Exception e) {

			e.printStackTrace();
			
		}
		
	}
	
	/**
	 * 
	 * initializes the News Pane and loads the corresponding controller
	 * {@link NewsFeedController}
	 * adds the controller to the controller list
	 * and populates the News Feeds via background parsing 
	 * 
	 */
	public void initNewsFeedPane() {
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/NewsFeedLayoutPane.fxml"));
			
			AnchorPane aPane = (AnchorPane) loader.load();
			
			newsFeedController = loader.getController();
			newsFeedController.setMainView(this);
		
			NewsFeedService service = new NewsFeedService();
			service.setOnSucceeded(new EventHandler<WorkerStateEvent>() {

				@SuppressWarnings("unchecked")
				@Override
				public void handle(WorkerStateEvent arg) {

					ArrayList<NewsFeed> newsFeeds = (ArrayList<NewsFeed>) arg.getSource().getValue();//NewsParser.parseURL(ConnectionHelper.PARSE_URL);
					
					newsFeedController.populateNewsFields(newsFeeds);
					
					mainMenuController.changeButtonStatus();
					
				}
				
			});
			service.start();

			mainViewController.addScreen("NewsPane", aPane);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	/**
	 * 
	 * initializes the Calendar Pane and loads the corresponding controller
	 * {@link CalendarControllerr}
	 * adds the controller to the controller list
	 * 
	 */
	public void initNewEntryPane() {
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/CalendarView.fxml"));
			FlowPane fPane = (FlowPane) loader.load();
			
			calendarController = loader.getController();
			calendarController.setMainView(this);
			
			mainViewController.addScreen("CalendarPane", fPane);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void initStatisticsPane() {
		
		// TODO implement PaneLoader
		
	}

	public void initOptionsPane() {
		
		// TODO implement PaneLoader
		
	}
	
	/**
	 * nested class NewsFeedService extends {@link Service}
	 * 
	 * for background parsing and populating of the NewsFeedPane
	 * allows for restricting access to the corresponding pane 
	 * until the {@link EventHandler}<{@link WorkerStateEvent}> 
	 * fires and the Task state transitions to the SUCCEEDED state.
	 * 
	 */
	private static class NewsFeedService extends Service<ArrayList<NewsFeed>> {

		@Override
		protected Task<ArrayList<NewsFeed>> createTask() {

			return new Task<ArrayList<NewsFeed>>() {

				@Override
				protected ArrayList<NewsFeed> call() throws Exception {

					return NewsParser.parseURL(ConnectionHelper.PARSE_URL);
				}
	
			};
		}	
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
