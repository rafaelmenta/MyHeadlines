package com.hoops9.myheadlines.business;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.helpers.DefaultHandler;

import android.sax.Element;
import android.sax.EndElementListener;
import android.sax.EndTextElementListener;
import android.sax.RootElement;
import android.util.Xml;

import com.hoops9.myheadlines.dao.HeadlineItem;

public class RSSHandler extends DefaultHandler {

	private static final String CHANNEL = "channel";

	public static final String DATE_FORMAT = "EEE, dd MMM yyyy HH:mm:ss zzz";

	static final String PUB_DATE = "pubDate";
	static final String CONTENT = "encoded";
	static final String LINK = "link";
	static final String TITLE = "title";
	static final String ITEM = "item";

	private InputStream inputStream;

	public RSSHandler(InputStream rssStream) {
		this.inputStream = rssStream;
	}

	public List<HeadlineItem> parse() {
		final HeadlineItem currentMessage = new HeadlineItem();
		RootElement root = new RootElement("rss");
		final List<HeadlineItem> messages = new ArrayList<HeadlineItem>();
		Element channel = root.getChild(CHANNEL);
		Element item = channel.getChild(ITEM);
		item.setEndElementListener(new EndElementListener() {
			public void end() {
				messages.add((HeadlineItem) currentMessage.copy());
			}
		});
		item.getChild(TITLE).setEndTextElementListener(
				new EndTextElementListener() {
					public void end(String body) {
						currentMessage.setHeadline(body);
					}
				});
		item.getChild(LINK).setEndTextElementListener(
				new EndTextElementListener() {
					public void end(String body) {
						currentMessage.setLink(body);
					}
				});
		item.getChild(CONTENT).setEndTextElementListener(
				new EndTextElementListener() {
					public void end(String body) {
						currentMessage.setContent(body);
					}
				});
		item.getChild(PUB_DATE).setEndTextElementListener(
				new EndTextElementListener() {
					public void end(String body) {
						currentMessage.setTime(body, DATE_FORMAT);
					}
				});

		try {
			Xml.parse(this.inputStream, Xml.Encoding.UTF_8,
					root.getContentHandler());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return messages;
	}

}
