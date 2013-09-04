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


/**
 * <i>public class WeekCellData</i><br>
 * <br>
 * A container for a week object to be put into a calendar view
 * ranging from monday to sunday
 * 
 * @author N.Ballmann
 *
 */
public class WeekCellData {
	
	
	private Integer[] weekdays;

	private boolean[] isDayOfActualMonth;
	
	private Date[] dates;
	
	/**
	 * @return the weekdays
	 */
	public Integer[] getWeekdays() {
		return weekdays;
	}

	/**
	 * @param weekdays the weekdays to set
	 */
	public void setWeekdays(Integer[] weekdays) {
		this.weekdays = weekdays;
	}
	
	/**
	 * @return the isDayOfActualMonth
	 */
	public boolean[] getIsDayOfActualMonth() {
		return isDayOfActualMonth;
	}

	/**
	 * @param isDayOfActualMonth the isDayOfActualMonth to set
	 */
	public void setIsDayOfActualMonth(boolean[] isDayOfActualMonth) {
		this.isDayOfActualMonth = isDayOfActualMonth;
	}

	/**
	 * @return the dates
	 */
	public Date[] getDates() {
		return dates;
	}

	/**
	 * @param dates the dates to set
	 */
	public void setDates(Date[] dates) {
		this.dates = dates;
	}

	public WeekCellData() {
		
		weekdays =  new Integer[7];
		isDayOfActualMonth = new boolean[7];
		
	}

	public WeekCellData(Integer[] weekdays) {
		
		this();
		this.weekdays = weekdays;
		
	}

	public WeekCellData(Integer[] weekdays, boolean[] isDayOfMonthArray, Date[] dates) {
		
		this(weekdays);
		this.isDayOfActualMonth = isDayOfMonthArray;
		this.dates = dates;
	}
	

}
