package org.nic.xhtmlparser.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;

import nu.validator.htmlparser.dom.HtmlDocumentBuilder;

import org.nic.xhtmlparser.model.NewsFeed;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public final class NewsParser {

	private static ArrayList<NewsFeed> newsFeedList = new ArrayList<NewsFeed>();

	public static ArrayList<NewsFeed> parseURL(String url) {

		HttpURLConnection con = ConnectionHelper.getURLConnection(url);


		try {

			InputStream in = con.getInputStream();

			InputSource inputSource = new InputSource(in);

			HtmlDocumentBuilder hdb = new HtmlDocumentBuilder();

			Document doc = hdb.parse(inputSource);


			if(doc.hasChildNodes()) {

				getNewsFeeds(doc.getChildNodes());

//				for(NewsFeed newsFeed : newsFeedList) {
//
//					System.out.println(newsFeed.toString());
//
//				}
			}	

		}

		catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}

		return newsFeedList;
		
	}

	private static void getNewsFeeds(final NodeList nodeList) {


		for (int count = 0; count < nodeList.getLength(); count++) {

			Node tempNode = nodeList.item(count);

			// make sure it's element node. (div id="rss")
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) { 

				if(tempNode.hasAttributes()) {

					if(tempNode.getAttributes().item(0).getNodeValue().equals("rss")) {

						if(tempNode.hasChildNodes()) {

							NodeList nl = tempNode.getChildNodes();

							String title = "";
							String url = "";
							String date = "";
							String description = ""; 

							for(int i = 0; i < nl.getLength(); i++) {

								Node subNode = nl.item(i);

								if(subNode.hasAttributes()) {

									if(subNode.getAttributes().item(0).getNodeValue().equals("_blank")) {

										url = subNode.getAttributes().item(1).getNodeValue();
										title = subNode.getAttributes().item(2).getNodeValue();

									} else if(subNode.getAttributes().item(0).getNodeValue().equals("rss_date")) {

										date = subNode.getTextContent();

									} else if(subNode.getAttributes().item(0).getNodeValue().equals("rss_descr")) {

										description = subNode.getTextContent();

										newsFeedList.add(new NewsFeed(title, url, date, description));

									}

								} 
								else if(subNode.hasChildNodes()) {

									NodeList subNodeList = subNode.getChildNodes();

									for(int k = 0; k < subNodeList.getLength(); k++) {

										Node subSubNode = subNodeList.item(k);

										if(subSubNode.hasAttributes()) {

											if(subSubNode.getAttributes().item(0).getNodeValue().equals("rss")) {

												url = subSubNode.getAttributes().item(1).getNodeValue();
												title = subSubNode.getAttributes().item(3).getNodeValue();

											}	
											
										}

									}
									
								}

							}

						}

					}

				}

				if (tempNode.hasChildNodes()) {

					// loop again if has child nodes
					getNewsFeeds(tempNode.getChildNodes());

				}

			}

		}

	}

}
