package org.nic.xhtmlparser.controller;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import org.nic.xhtmlparser.XHTMLParser;
import org.nic.xhtmlparser.model.NewsFeed;
import org.nic.xhtmlparser.util.ControllerInterface;

public class NewsFeedPaneController implements ControllerInterface {

	@SuppressWarnings("unused")
	private XHTMLParser mainView;
	
	@FXML private Label title1Text;
	@FXML private Label teaser1Text;
	@FXML private Label date1Text;
	@FXML private Label title2Text;
	@FXML private Label teaser2Text;
	@FXML private Label date2Text;
	@FXML private Label title3Text;
	@FXML private Label teaser3Text;
	@FXML private Label date3Text;
	@FXML private Label title4Text;
	@FXML private Label teaser4Text;
	@FXML private Label date4Text;
	
	@FXML private VBox news1VBox;
	@FXML private VBox news2VBox;
	@FXML private VBox news3VBox;
	@FXML private VBox news4VBox;
	
	
	@Override
	public void setMainView(XHTMLParser mainView) {

		this.mainView = mainView;
		
	}
	
	@FXML
	public void initialize() {
		
	
	}
	
	public void populateNewsFields(ArrayList<NewsFeed> newsFeeds) {
		
		if(newsFeeds!=null) {
			
			title1Text.setText(newsFeeds.get(0).getTitle());
			date1Text.setText(newsFeeds.get(0).getDate());
			teaser1Text.setText(newsFeeds.get(0).getDescription());

			title2Text.setText(newsFeeds.get(1).getTitle());
			date2Text.setText(newsFeeds.get(1).getDate());
			teaser2Text.setText(newsFeeds.get(1).getDescription());

			title3Text.setText(newsFeeds.get(2).getTitle());
			date3Text.setText(newsFeeds.get(2).getDate());
			teaser3Text.setText(newsFeeds.get(2).getDescription());

			title4Text.setText(newsFeeds.get(3).getTitle());
			date4Text.setText(newsFeeds.get(3).getDate());
			teaser4Text.setText(newsFeeds.get(3).getDescription());
		
		}
		
	}
	
	

}
