package org.nic.xhtmlparser.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

import org.nic.xhtmlparser.model.CalendarDayEntryPane;
import org.nic.xhtmlparser.model.WeekCellData;

public class WeekRowBuilder {
	
	private static final WeekRowBuilder INSTANCE = new WeekRowBuilder();
	
	public static final String[] WEEKDAYS_GER = {"MO", "TU", "WE", "TH", "FR", "SA", "SU"};
	public static final String[] WEEKDAYS_US = {"SU", "MO", "TU", "WE", "TH", "FR", "SA"};
	
	
	private WeekRowBuilder() {
		
	}
	
	public static WeekRowBuilder getInstance() {
		
		return INSTANCE;
		
	}
	
	public ObservableMap<String, ObservableList<CalendarDayEntryPane>> getWeekRows(final ObservableList<WeekCellData> weekCellDataList) {
		
		ObservableMap<String, ObservableList<CalendarDayEntryPane>> weekRowsMap = FXCollections.observableHashMap();
		ObservableList<CalendarDayEntryPane> weekRow;
		
		int count = 1;
		
		for(WeekCellData wcd : weekCellDataList) {
			
			weekRow = FXCollections.observableArrayList();
			
			weekRow.add(new CalendarDayEntryPane(wcd.getMonday().toString()));
			weekRow.add(new CalendarDayEntryPane(wcd.getTuesday().toString()));
			weekRow.add(new CalendarDayEntryPane(wcd.getWednesday().toString()));
			weekRow.add(new CalendarDayEntryPane(wcd.getThursday().toString()));
			weekRow.add(new CalendarDayEntryPane(wcd.getFriday().toString()));
			weekRow.add(new CalendarDayEntryPane(wcd.getSaturday().toString()));
			weekRow.add(new CalendarDayEntryPane(wcd.getSunday().toString()));
			
			weekRowsMap.put(("week" + count), weekRow);
			
			count++;
		}
		
		return weekRowsMap;
		
	}
	
	public CalendarDayEntryPane[] getColumTitleList(final String[] localStringList) {
		
		CalendarDayEntryPane[] titlePaneList = new CalendarDayEntryPane[7];
		
		for(int i = 0; i < 7; i++) {
			
			titlePaneList[i] = new CalendarDayEntryPane(localStringList[i]); 
			
		}
		
		return titlePaneList;
	}
	
	

}
