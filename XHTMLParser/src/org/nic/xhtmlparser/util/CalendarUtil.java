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

import java.util.Calendar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.nic.xhtmlparser.model.WeekCellData;


/**
 * 
 * 
 * 
 * 
 * @author N.Ballmann
 *
 */
public class CalendarUtil {
	
	private static int actualMonth; 
	
	public static Calendar getFirstCalendarDay(Calendar refCal) {
		
		Calendar cal = (Calendar)refCal.clone();
		
		int actualDay = cal.get(Calendar.DAY_OF_MONTH);
		
		cal.add(Calendar.DATE, -actualDay+1);
		
		actualMonth = cal.get(Calendar.MONTH);
		
		return cal;
	}
	
	public static ObservableList<WeekCellData> populateCalendar(Calendar cal) {
		
		ObservableList<WeekCellData> cellDataList = FXCollections.observableArrayList();
		
		if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.MONDAY)
			cal.add(Calendar.DATE, -7);
		else if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)
			cal.add(Calendar.DATE, -6);
		else if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY)
			cal.add(Calendar.DATE, -5);
		else if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.FRIDAY)
			cal.add(Calendar.DATE, -4);
		else if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.THURSDAY)
			cal.add(Calendar.DATE, -3);
		else if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.WEDNESDAY)
			cal.add(Calendar.DATE, -2);
		else if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.TUESDAY)
			cal.add(Calendar.DATE, -1);

		
		for(int i = 0; i < 6; i++) {
			
			Integer[] weekDays = new Integer[7];
			boolean[] isDayOfMonth = new boolean[7];
			
			for(int j=0;j<7;j++) {
				
				weekDays[j] = cal.get(Calendar.DATE);
				
				if(cal.get(Calendar.MONTH) == actualMonth)
					isDayOfMonth[j] = true;
				
				cal.add(Calendar.DATE, 1);
				
			}
			
			cellDataList.add(new WeekCellData(weekDays, isDayOfMonth));
			
		}
		
		return cellDataList;
	}

}
