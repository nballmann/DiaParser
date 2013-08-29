package org.nic.xhtmlparser.controller;

import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.nic.xhtmlparser.XHTMLParser;
import org.nic.xhtmlparser.model.DateCell;
import org.nic.xhtmlparser.util.ControllerInterface;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class CalendarController implements ControllerInterface {
	
	@SuppressWarnings("unused")
	private XHTMLParser mainView;
	
	private enum WeekDays {
		
		SU, MO, TU, WE, TH, FR, SA
		
	}
	
	private ObjectProperty<Calendar> calendarProperty = new SimpleObjectProperty<Calendar>();
	private ObjectProperty<Locale> localeProperty = new SimpleObjectProperty<Locale>();
		
	
	@FXML
	private TableColumn<DateCell, Integer> moTableColumn;
	@FXML
	private TableColumn<DateCell, Integer> tuTableColumn;
	@FXML
	private TableColumn<DateCell, Integer> weTableColumn;
	@FXML
	private TableColumn<DateCell, Integer> thTableColumn;
	@FXML
	private TableColumn<DateCell, Integer> frTableColumn;
	@FXML
	private TableColumn<DateCell, Integer> saTableColumn;
	@FXML
	private TableColumn<DateCell, Integer> suTableColumn;
	
	public CalendarController() {
		
//		moTableColumn.setCellValueFactory(new PropertyValueFactory<DateCell, Integer>("dayOfMonth"));
//		tuTableColumn.setCellValueFactory(new PropertyValueFactory<DateCell, Integer>("dayOfMonth"));
//		weTableColumn.setCellValueFactory(new PropertyValueFactory<DateCell, Integer>("dayOfMonth"));
//		thTableColumn.setCellValueFactory(new PropertyValueFactory<DateCell, Integer>("dayOfMonth"));
//		frTableColumn.setCellValueFactory(new PropertyValueFactory<DateCell, Integer>("dayOfMonth"));
//		saTableColumn.setCellValueFactory(new PropertyValueFactory<DateCell, Integer>("dayOfMonth"));
//		suTableColumn.setCellValueFactory(new PropertyValueFactory<DateCell, Integer>("dayOfMonth"));
		
		Calendar cal = Calendar.getInstance(Locale.GERMANY);
		Date date = cal.getTime();
		
	}

	@Override
	public void setMainView(XHTMLParser mainView) {

		this.mainView = mainView;
		
	}
	
}
