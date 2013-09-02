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

package org.nic.xhtmlparser.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

import org.nic.xhtmlparser.model.CalendarDayEntryPane;
import org.nic.xhtmlparser.model.WeekCellData;

public class WeekRowBuilder {
	
	private static final WeekRowBuilder INSTANCE = new WeekRowBuilder();
	
	public static final String[] WEEKDAYS_GER = {"Mo", "Tu", "We", "Th", "Fr", "Sa", "Su"};
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
			
			for(int i=0;i<7;i++) {
				
				weekRow.add(new CalendarDayEntryPane(
						wcd.getWeekdays()[i].toString(), 
						wcd.getIsDayOfActualMonth()[i], 
						false));
				
			}
			
			weekRowsMap.put(("week" + count), weekRow);
			
			count++;
		}
		
		return weekRowsMap;
		
	}
	
	public CalendarDayEntryPane[] getColumTitleList(final String[] localStringList) {
		
		CalendarDayEntryPane[] titlePaneList = new CalendarDayEntryPane[7];
		
		for(int i = 0; i < 7; i++) {
			
			titlePaneList[i] = new CalendarDayEntryPane(localStringList[i], false, true); 
			
		}
		
		return titlePaneList;
	}
	
	

}
