package org.nic.xhtmlparser.controller;

import java.util.Calendar;
import java.util.Locale;

import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import org.nic.xhtmlparser.XHTMLParser;
import org.nic.xhtmlparser.model.WeekCellData;
import org.nic.xhtmlparser.util.CalendarUtil;
import org.nic.xhtmlparser.util.ControllerInterface;

public class CalendarController implements ControllerInterface {
	
	@SuppressWarnings("unused")
	private XHTMLParser mainView;
	
	@SuppressWarnings("unused")
	private enum WeekDays {
		
		MO, TU, WE, TH, FR, SA, SU
		
	}
	
	private ObjectProperty<Calendar> calendarProperty = new SimpleObjectProperty<Calendar>();
	private ObjectProperty<Locale> localeProperty = new SimpleObjectProperty<Locale>();
	
	private ObservableList<WeekCellData> cellDataList = FXCollections.observableArrayList();
		
	@FXML TableView<WeekCellData> calendarTableView;
	@FXML
	private TableColumn<WeekCellData, Integer> moTableColumn;
	@FXML
	private TableColumn<WeekCellData, Integer> tuTableColumn;
	@FXML
	private TableColumn<WeekCellData, Integer> weTableColumn;
	@FXML
	private TableColumn<WeekCellData, Integer> thTableColumn;
	@FXML
	private TableColumn<WeekCellData, Integer> frTableColumn;
	@FXML
	private TableColumn<WeekCellData, Integer> saTableColumn;
	@FXML
	private TableColumn<WeekCellData, Integer> suTableColumn;
	
	public CalendarController() {
		
		localeProperty.set(Locale.GERMANY);
		calendarProperty.set(Calendar.getInstance(localeProperty.get()));
		
		Platform.runLater(new Runnable() {

			@Override
			public void run() {

				cellDataList = CalendarUtil.populateCalendar(CalendarUtil.getFirstCalendarDay(calendarProperty.get()));
				
				calendarTableView.setItems(cellDataList);
				
				moTableColumn.setCellValueFactory(new PropertyValueFactory<WeekCellData, Integer>("monday"));
				tuTableColumn.setCellValueFactory(new PropertyValueFactory<WeekCellData, Integer>("tuesday"));
				weTableColumn.setCellValueFactory(new PropertyValueFactory<WeekCellData, Integer>("wednesday"));
				thTableColumn.setCellValueFactory(new PropertyValueFactory<WeekCellData, Integer>("thursday"));
				frTableColumn.setCellValueFactory(new PropertyValueFactory<WeekCellData, Integer>("friday"));
				saTableColumn.setCellValueFactory(new PropertyValueFactory<WeekCellData, Integer>("saturday"));
				suTableColumn.setCellValueFactory(new PropertyValueFactory<WeekCellData, Integer>("sunday"));
				
			}		
			
		});
			
	}
	
	@FXML
	public void initialize()
	{
		
		calendarTableView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				// TODO

				e.get
				
			}
			
			
		});
		
	}
	

	@Override
	public void setMainView(XHTMLParser mainView) {

		this.mainView = mainView;
		
	}
	
}
