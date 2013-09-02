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
