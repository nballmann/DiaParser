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

/**
 * <i>public class NewsFeed</i>
 * <br><br>
 * represents a single NewsFeed object with fields:<br>
 * <i>title</i><br>
 * <i>url</i><br>
 * <i>date</i><br>
 * <i>description</i>
 * 
 * @author N.Ballmann
 *
 */
public class NewsFeed {
	
	private String title;
	private String url;
	private String date;
	private String description;

	public NewsFeed(String title, String url, String date, String description) {
		this.title = title;
		this.url = url;
		this.date = date;
		this.description = description;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		
		return title + " " + url + " " + date + " " + description;
		
	}

}
