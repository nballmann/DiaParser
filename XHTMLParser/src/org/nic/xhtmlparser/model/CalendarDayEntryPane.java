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

package org.nic.xhtmlparser.model;

import java.util.Date;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

/**
 * class CalenderDayEntryPane extends {@link FlowPane}
 * 
 * represents a single day object pane for usage
 * in the Calendar View  
 * 
 * @author N.Ballmann
 *
 */
public class CalendarDayEntryPane extends FlowPane {
	
	private BooleanProperty isDayOfActualMonth;
	private StringProperty entryValue;
	private ObjectProperty<Date> date;
	
	private boolean actualDate = false;
	
	private Label label;
		
	public boolean getIsDayOfActualMonth()	{ return isDayOfActualMonth.get(); }
	public void setIsDayOfActualMonth(final boolean value)	{ this.isDayOfActualMonth.set(value); }
	public BooleanProperty isDayOfActualMonthProperty() { return isDayOfActualMonth; }
	
	public String getEntryValue()	{ return entryValue.get(); }
	public void setEntryValue(final String value)	{ entryValue.set(value); }
	public StringProperty entryValueProperty()	{ return entryValue; }
	
	public Date getDate()	{ return date.get(); }
	public void setdate(final Date date) { this.date.set(date); }
	public ObjectProperty<Date> dateProperty() { return date; }
	
	/**
	 * @return the actualDate
	 */
	public boolean isActualDate() {
		return actualDate;
	}
	/**
	 * @param actualDate the actualDate to set
	 */
	public void setActualDate(boolean actualDate) {
		this.actualDate = actualDate;
	}
	/**
	 * <i>CalendarDayEntryPane</i> constructor
	 * 
	 * @param day the numerical expression of the corresponding day in the calendar view
	 * @param isDayOfMonth true if day is a day of the actual month 
	 * @param isColumnTitle true if pane does represent a column title (week day string) 
	 * 		  and not a day of the month
	 */
	public CalendarDayEntryPane(final String day, final Date date, final boolean isDayOfMonth, final boolean isColumnTitle) {
		
		isDayOfActualMonth = new SimpleBooleanProperty(isDayOfMonth);
		entryValue = new SimpleStringProperty();
		this.date = new SimpleObjectProperty<Date>(date);
		
		this.entryValue.set(day);
		this.setAlignment(Pos.CENTER);
		this.setOrientation(Orientation.VERTICAL);
		this.setColumnHalignment(HPos.CENTER);
		this.setPadding(new Insets(2.0, 2.0, 2.0, 2.0));
		this.setPrefSize(49, 49);
		
		label = new Label();
		
		if(isDayOfMonth)
			label.getStyleClass().add("label-dayofmonth");
		
		if(isColumnTitle)
			label.getStyleClass().add("label-weekday-title");
			
		label.setText(entryValue.get());		
		label.setAlignment(Pos.CENTER);
		label.setContentDisplay(ContentDisplay.CENTER);
		
		this.getChildren().add(label);
		
	}
	
}
