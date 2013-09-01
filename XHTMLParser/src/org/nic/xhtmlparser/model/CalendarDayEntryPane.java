package org.nic.xhtmlparser.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

public class CalendarDayEntryPane extends FlowPane {
	
	private BooleanProperty isDayOfActualMonth;
	private StringProperty entryValue;
	
	private Label label;
		
	public boolean getIsDayOfActualMonth()	{ return isDayOfActualMonth.get(); }
	public void setIsDayOfActualMonth(final boolean value)	{ this.isDayOfActualMonth.set(value); }
	public BooleanProperty isDayOfActualMonthProperty() { return isDayOfActualMonth; }
	
	public String getEntryValue()	{ return entryValue.get(); }
	public void setEntryValue(final String value)	{ entryValue.set(value); }
	public StringProperty entryValueProperty()	{ return entryValue; }
	
	
	public CalendarDayEntryPane(final String day) {
		
		isDayOfActualMonth = new SimpleBooleanProperty(false);
		entryValue = new SimpleStringProperty();
		
		
		this.entryValue.set(day);
		this.setAlignment(Pos.CENTER);
		this.setOrientation(Orientation.VERTICAL);
		this.setColumnHalignment(HPos.CENTER);
		this.setPadding(new Insets(2.0, 2.0, 2.0, 2.0));
		this.setPrefSize(49, 49);
		
		label = new Label();
		label.setText(entryValue.get());
		label.setAlignment(Pos.CENTER);
		label.setContentDisplay(ContentDisplay.CENTER);
		
		this.getChildren().add(label);
		
	}
	
	
	

}
