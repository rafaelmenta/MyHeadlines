package com.hoops9.myheadlines.dao;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.annotation.SuppressLint;

public class HeadlineItem implements Comparable<HeadlineItem>, Serializable {

	private static final long serialVersionUID = 1L;
	@SuppressLint("SimpleDateFormat")
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
	private Date pubDate;
	private String headline;
	private URL link;
	private String descriprion;

	public Date getPubDate() {
		return pubDate;
	}

	public String getFormattedPubDate() {
		return this.pubDate != null ? DATE_FORMAT.format(this.pubDate)
				: DATE_FORMAT.format(new Date());
	}

	public void setTime(Date time) {
		this.pubDate = time;
	}

	@SuppressLint("NewApi")
	public void setTime(String pubDate, String dateFormat) {

		if (pubDate == null || pubDate.isEmpty()) {
			this.pubDate = new Date();
			return;
		}

		try {
			pubDate.trim();
			DateFormat formatter = new SimpleDateFormat(dateFormat,
					Locale.getDefault());
			this.pubDate = formatter.parse(pubDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public URL getLink() {
		return link;
	}

	public void setLink(String link) {
		try {
			this.link = new URL(link);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}

	public String getDescription() {
		return descriprion;
	}

	public void setDescription(String descriprion) {
		this.descriprion = descriprion;
	}

	@Override
	public int compareTo(HeadlineItem another) {
		if (another == null) {
			return 1;
		}
		return another.pubDate.compareTo(this.pubDate);
	}

	public Object copy() {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream(4096);
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(this);
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			Object deepCopy = ois.readObject();
			return deepCopy;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
