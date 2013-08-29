package org.nic.xhtmlparser;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.nic.xhtmlparser.util.CalendarUtil;


public class EveryCalendarUtilShould {

	@Before
	public void intit() {
		
		
	}
	
	
	@Test
	public void ReturnALogicalWeekDay() {
		
		assertTrue(CalendarUtil.getFirstCalendarDay(Calendar.getInstance(Locale.GERMANY)).get(Calendar.DAY_OF_WEEK) <= 7);
		
	}
	
}
