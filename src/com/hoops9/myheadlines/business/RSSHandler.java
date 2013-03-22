package com.hoops9.myheadlines.business;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.hoops9.myheadlines.dao.HeadlineItem;

public class RSSHandler extends DefaultHandler {

	static final String PUB_DATE = "pubDate";
	static final String DESCRIPTION = "description";
	static final String LINK = "link";
	static final String TITLE = "title";
	static final String ITEM = "item";

	private List<HeadlineItem> headlines;
	private HeadlineItem currentItem;
	private StringBuilder builder;

	public List<HeadlineItem> getHeadlines() {
		return this.headlines;
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		super.characters(ch, start, length);
		builder.append(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String name) throws SAXException {
		super.endElement(uri, localName, name);
		if (this.currentItem != null) {
			if (localName.equalsIgnoreCase(TITLE)) {
				currentItem.setHeadline(builder.toString());
			} else if (localName.equalsIgnoreCase(LINK)) {
				// currentItem.setLink(builder.toString());
			} else if (localName.equalsIgnoreCase(DESCRIPTION)) {
				// currentItem.setDescription(builder.toString());
			} else if (localName.equalsIgnoreCase(PUB_DATE)) {
				currentItem.setTime(builder.toString());
			} else if (localName.equalsIgnoreCase(ITEM)) {
				headlines.add(currentItem);
			}
			builder.setLength(0);
		}
	}

	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		headlines = new ArrayList<HeadlineItem>();
		builder = new StringBuilder();
	}

	public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
		super.startElement(uri, localName, name, attributes);
		if (localName.equalsIgnoreCase(ITEM)) {
			this.currentItem = new HeadlineItem();
		}
	}

}
