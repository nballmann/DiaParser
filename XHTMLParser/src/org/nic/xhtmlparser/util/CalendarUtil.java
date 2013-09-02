package org.nic.xhtmlparser.util;

import java.util.Calendar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.nic.xhtmlparser.model.WeekCellData;

public class CalendarUtil {
	
	public static Calendar getFirstCalendarDay(final Calendar cal) {
		
		int actualDay = cal.get(Calendar.DAY_OF_MONTH);
		
		cal.add(Calendar.DATE, -actualDay+1);
		cal.add(Calendar.DATE, -(Calendar.DAY_OF_WEEK-4));
		
		return cal;
	}
	
	public static ObservableList<WeekCellData> populateCalendar(Calendar cal) {
		
		ObservableList<WeekCellData> cellDataList = FXCollections.observableArrayList();
		
		for(int i = 0;i < 6; i++) {
			
			WeekCellData tempData = new WeekCellData();
			
			tempData.setMonday(cal.get(Calendar.DATE));
			cal.roll(Calendar.DATE, true);
			tempData.setTuesday(cal.get(Calendar.DATE));
			cal.roll(Calendar.DATE, true);
			tempData.setWednesday(cal.get(Calendar.DATE));
			cal.roll(Calendar.DATE, true);
			tempData.setThursday(cal.get(Calendar.DATE));
			cal.roll(Calendar.DATE, true);
			tempData.setFriday(cal.get(Calendar.DATE));
			cal.roll(Calendar.DATE, true);
			tempData.setSaturday(cal.get(Calendar.DATE));
			cal.roll(Calendar.DATE, true);
			tempData.setSunday(cal.get(Calendar.DATE));
			cal.roll(Calendar.DATE, true);
			
			cellDataList.add(tempData);
		}
		
		
		return cellDataList;
	}

}
