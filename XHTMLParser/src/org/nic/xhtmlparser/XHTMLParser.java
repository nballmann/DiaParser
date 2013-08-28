package org.nic.xhtmlparser;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import org.nic.xhtmlparser.controller.MainViewController;
import org.nic.xhtmlparser.controller.NewsFeedPaneController;
import org.nic.xhtmlparser.model.NewsFeed;
import org.nic.xhtmlparser.util.ConnectionHelper;
import org.nic.xhtmlparser.util.NewsParser;

public class XHTMLParser extends Application {
	
	private MainViewController mainViewController;
	private NewsFeedPaneController newsFeedController;
	

	@Override
	public void start(Stage primaryStage) {
		
		
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("view/MainView.fxml"));
			
			BorderPane bPane = (BorderPane) loader.load();
			
			FXMLLoader loader2 = new FXMLLoader(getClass().getResource("view/NewsFeedLayoutPane.fxml"));
			
			AnchorPane aPane = (AnchorPane) loader2.load();
					
			mainViewController = loader.getController();	
			mainViewController.setMainView(this);
			
			newsFeedController = loader2.getController();
			newsFeedController.setMainView(this);
			
			bPane.setCenter(aPane);
			
			Scene scene = new Scene(bPane);
			
			primaryStage.setScene(scene);
			
			primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {

				@Override
				public void handle(WindowEvent arg0) {

					System.exit(0);
					
				}
	
			});

			
			Platform.runLater(new Runnable() {

				@Override
				public void run() {
		
					ArrayList<NewsFeed> newsFeeds = NewsParser.parseURL(ConnectionHelper.PARSE_URL);
					
					newsFeedController.populateNewsFields(newsFeeds);
					
					try {
						Thread.sleep(350);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			});
			
			primaryStage.setResizable(true);
			primaryStage.show();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
	

	public static void main(String[] args) {
		launch(args);
	}
}
