package org.nic.xhtmlparser;

import java.io.IOException;
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

public class XHTMLParser extends Application {
	
	private static final String APP_VERSION = "0.1A";
	private static final String APP_TITLE = "Diabetes App Ver: " + APP_VERSION;
	
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
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
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
			// TODO: handle exception
		}
		
	}
	
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
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public void initNewEntryPane() {
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/CalendarView.fxml"));
			FlowPane fPane = (FlowPane) loader.load();
			
			calendarController = loader.getController();
			calendarController.setMainView(this);
			
			mainViewController.addScreen("CalendarPane", fPane);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void initStatisticsPane() {
		
		// TODO implement PaneLoader
		
	}

	public void initOptionsPane() {
		
		// TODO implement PaneLoader
		
	}
	
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
