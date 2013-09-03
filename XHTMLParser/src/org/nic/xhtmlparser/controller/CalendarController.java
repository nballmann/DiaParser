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

import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import org.nic.xhtmlparser.XHTMLParser;
import org.nic.xhtmlparser.model.CalendarDayEntryPane;
import org.nic.xhtmlparser.util.CalendarUtil;
import org.nic.xhtmlparser.util.ControllerInterface;
import org.nic.xhtmlparser.util.WeekRowBuilder;

public class CalendarController implements ControllerInterface {
	
	@SuppressWarnings("unused")
	private XHTMLParser mainView;
	
	private IntegerProperty actualMonth;
	private IntegerProperty actualYear;
	
	private ObjectProperty<Calendar> calendar = new SimpleObjectProperty<Calendar>();
	private ObjectProperty<Locale> locale = new SimpleObjectProperty<Locale>();
	
	private ObservableMap<String, ObservableList<CalendarDayEntryPane>> weekRowsMap;
	
	private WeekRowBuilder wrb;
	
	@FXML private GridPane weekDayGridPane;
	@FXML private GridPane calendarGridPane;
	@FXML private Label monthAndYearLabel;
	
	private static final HashMap<Integer, String> MONTHS = new HashMap<>();
	
	private static CalendarDayEntryPane actualDayPane;
	
	/**
	 * @return the actualDayPane
	 */
	public static CalendarDayEntryPane getActualDayPane() {
		return actualDayPane;
	}

	/**
	 * @param actualDayPane the actualDayPane to set
	 */
	public static void setActualDayPane(CalendarDayEntryPane actualDayPane) {
		CalendarController.actualDayPane = actualDayPane;
	}

	@Override
	public void setMainView(XHTMLParser mainView) {

		this.mainView = mainView;
		
	}
	
	public void setCalendar(Calendar cal)   { calendar.set(cal); }
	public Calendar getCalendar() 				{ return calendar.get(); }
	public ObjectProperty<Calendar> getCalendarProperty() { return calendar; }
	
	public void setLocale(Locale loc) 	{ locale.set(loc); }	
	public Locale getLocale()				{ return locale.get(); }
	public ObjectProperty<Locale> getLocaleProperty() { return locale; }
	
	
	public CalendarController() {
		
		MONTHS.put(Calendar.JANUARY, "January");
		MONTHS.put(Calendar.FEBRUARY, "February");
		MONTHS.put(Calendar.MARCH, "March");
		MONTHS.put(Calendar.APRIL, "April");
		MONTHS.put(Calendar.MAY, "May");
		MONTHS.put(Calendar.JUNE, "June");
		MONTHS.put(Calendar.JULY, "July");
		MONTHS.put(Calendar.AUGUST, "August");
		MONTHS.put(Calendar.SEPTEMBER, "September");
		MONTHS.put(Calendar.OCTOBER, "October");
		MONTHS.put(Calendar.NOVEMBER, "November");
		MONTHS.put(Calendar.DECEMBER, "December");
		
		locale.set(Locale.GERMANY);
		calendar.set(Calendar.getInstance(locale.get()));
			
		actualYear = new SimpleIntegerProperty(calendar.get().get(Calendar.YEAR));
		actualMonth = new SimpleIntegerProperty(getCalendar().get(Calendar.MONTH));
		
		wrb = WeekRowBuilder.getInstance();
		
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				
				monthAndYearLabel.setText(MONTHS.get(actualMonth.get()).toString() + ", " + actualYear.get());
				
				weekDayGridPane.addRow(0, wrb.getColumTitleList(WeekRowBuilder.WEEKDAYS_GER));
				
				actualYear.addListener(new ChangeListener<Number>() {
					
					@Override
					public void changed(ObservableValue<? extends Number> observable,
							Number oldValue, Number newValue) {
						
						monthAndYearLabel.setText(MONTHS.get(actualMonth.get()) + ", " + actualYear.get());
						
					}
					
				});
				
				actualMonth.addListener(new ChangeListener<Number>() {

					@Override
					public void changed(ObservableValue<? extends Number> arg0,
							Number arg1, Number arg2) {

						monthAndYearLabel.setText(MONTHS.get(actualMonth.get()) + ", " + actualYear.get());
						
					}
					
				});	
				
			}
			
		});
		
		generateActualCalendarView();
		
	}
	
	private void generateActualCalendarView() {
		
		Platform.runLater(new Runnable() {

			@Override
			public void run() {

				weekRowsMap = wrb.getWeekRows(CalendarUtil.populateCalendar(CalendarUtil.getFirstCalendarDay(getCalendar())));
				
				if(calendarGridPane.getChildrenUnmodifiable()!=null)
					calendarGridPane.getChildren().clear();
				
				for(int i = 0; i < 6; i++) {
					
					for(int j = 0; j < 7; j++) {
						
						calendarGridPane.add(weekRowsMap.get(("week" + (i+1))).get(j), j, i);
						
					}
					
				}
	
			}
			
		});
		
	}
	
	@FXML private void handleLastMonth() {

		getCalendar().add(Calendar.MONTH, -1);
		actualMonth.set(calendar.get().get(Calendar.MONTH));
		actualYear.set(calendar.get().get(Calendar.YEAR));
		generateActualCalendarView();
		
		System.out.println("clicked" + calendar.get().get(Calendar.MONTH));
	}

	@FXML private void handleNextMonth() {

		getCalendar().add(Calendar.MONTH, 1);
		actualYear.set(calendar.get().get(Calendar.YEAR));
		actualMonth.set(calendar.get().get(Calendar.MONTH));
		generateActualCalendarView();
		
		
		System.out.println("clicked " + calendar.get().get(Calendar.MONTH));
	}

	
	
	
}
