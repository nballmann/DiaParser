package org.nic.xhtmlparser.model;

import javafx.beans.property.IntegerProperty;

public class DateCell {
	
	private IntegerProperty dayOfMonth;
	private IntegerProperty dayOfWeek;
	
	public IntegerProperty getDayOfMonthProperty() { return dayOfMonth; }
	
	public void setDayOfMonth(int value) { dayOfMonth.set(value); }
		
	public int getDayOfMonth() { return dayOfMonth.get(); }
	
	public IntegerProperty getDayOfWeekProperty() { return dayOfWeek; }
	
	public void setDayOfWeek(int value) { dayOfWeek.set(value); }
	
	public int getDayOfWeek() { return dayOfWeek.get(); }

	

}
