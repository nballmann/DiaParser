package org.nic.xhtmlparser.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class WeekCellData {
	
	private IntegerProperty monday;
	private IntegerProperty tuesday;
	private IntegerProperty wednesday;
	private IntegerProperty thursday;
	private IntegerProperty friday;
	private IntegerProperty saturday;
	private IntegerProperty sunday;

	public Integer getMonday() {
		return monday.get();
	}

	public void setMonday(Integer monday) {
		this.monday.set(monday);
	}
	
	public IntegerProperty mondayProperty() { return monday; }

	public Integer getTuesday() {
		return tuesday.get();
	}

	public void setTuesday(Integer tuesday) {
		this.tuesday.set(tuesday);
	}
	
	public IntegerProperty tuesdayProperty() { return tuesday; }

	public Integer getWednesday() {
		return wednesday.get();
	}

	public void setWednesday(Integer wednesday) {
		this.wednesday.set(wednesday);
	}
	
	public IntegerProperty wednesdayProperty() { return wednesday; }

	public Integer getThursday() {
		return thursday.get();
	}

	public void setThursday(Integer thursday) {
		this.thursday.set(thursday);
	}
	
	public IntegerProperty thursdayProperty() { return thursday; }

	public Integer getFriday() {
		return friday.get();
	}

	public void setFriday(Integer friday) {
		this.friday.set(friday);
	}
	
	public IntegerProperty fridayProperty() { return friday; }

	public Integer getSaturday() {
		return saturday.get();
	}

	public void setSaturday(Integer saturday) {
		this.saturday.set(saturday);
	}
	
	public IntegerProperty saturdayProperty() { return saturday; }

	public Integer getSunday() {
		return sunday.get();
	}

	public void setSunday(Integer sunday) {
		this.sunday.set(sunday);
	}
	
	public IntegerProperty sundayProperty() { return sunday; }
	
	public WeekCellData() {
		
		monday = new SimpleIntegerProperty();
		tuesday = new SimpleIntegerProperty();
		wednesday = new SimpleIntegerProperty();
		thursday = new SimpleIntegerProperty();
		friday = new SimpleIntegerProperty();
		saturday = new SimpleIntegerProperty();
		sunday = new SimpleIntegerProperty();
		
	}

	public WeekCellData(Integer monday,Integer tuesday, Integer wednesday, 
			Integer thursday, Integer friday, Integer saturday, Integer sunday) {
		this();
		this.monday.set(monday);
		this.tuesday.set(tuesday);
		this.wednesday.set(wednesday);
		this.thursday.set(thursday);
		this.friday.set(friday);
		this.saturday.set(saturday);
		this.sunday.set(sunday);
		
	}

	

}
