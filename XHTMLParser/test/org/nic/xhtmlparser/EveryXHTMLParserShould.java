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

package org.nic.xhtmlparser;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EveryXHTMLParserShould {
	
	XHTMLParser xhtmlParser;
	
	
	@Before
	public void init() {
		
		xhtmlParser = new XHTMLParser();
		
	}
	
	@Test
	public void LoadMainMenuController() {
		
		Class<?> c = xhtmlParser.getClass();
		Field mainMenuController;
		try {
			mainMenuController = c.getDeclaredField("mainMenuController");
			mainMenuController.setAccessible(true);
			
			assertTrue(mainMenuController!=null);
		} catch (NoSuchFieldException | SecurityException e) {

			e.printStackTrace();
		}
		
	}
	
	@Test
	public void LoadMainViewController() {
		
		Class<?> c = xhtmlParser.getClass();
		Field mainViewController;
		try {
			mainViewController = c.getDeclaredField("mainViewController");
			mainViewController.setAccessible(true);
			
			assertTrue(mainViewController!=null);
		} catch (NoSuchFieldException | SecurityException e) {

			e.printStackTrace();
		}
		
	}
	
	@Test
	public void LoadNewsFeedController() {
		
		Class<?> c = xhtmlParser.getClass();
		Field newsFeedController;
		try {
			newsFeedController = c.getDeclaredField("newsFeedController");
			newsFeedController.setAccessible(true);
			
			assertTrue(newsFeedController!=null);
		} catch (NoSuchFieldException | SecurityException e) {

			e.printStackTrace();
		}
		
	}
	
	@Test
	public void LoadCalendarController() {
		
		Class<?> c = xhtmlParser.getClass();
		Field calendarController;
		try {
			calendarController = c.getDeclaredField("calendarController");
			calendarController.setAccessible(true);
			
			assertTrue(calendarController!=null);
		} catch (NoSuchFieldException | SecurityException e) {

			e.printStackTrace();
		}
		
	}
	
	
	@After
	public void cleanUp() {
		
		xhtmlParser = null;
		
	}

}
