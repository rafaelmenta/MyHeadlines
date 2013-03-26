package com.hoops9.myheadlines.task;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import android.os.AsyncTask;

import com.hoops9.myheadlines.business.RSSHandler;
import com.hoops9.myheadlines.dao.HeadlineItem;
import com.hoops9.myheadlines.tab.TabFragment1;

public class RSSFeedReader extends AsyncTask<String, Void, List<HeadlineItem>>{
	
	private TabFragment1 activity;
	
	public RSSFeedReader(TabFragment1 activity) {
		this.activity = activity;
	}
	
	public List<HeadlineItem> getHeadlines() {
		
		URL feedUrl;
		
		try {
			feedUrl = new URL("http://boingboing.net/feed");
		} catch (MalformedURLException e) {
			throw new RuntimeException("URL inválida", e);
		}
		
		InputStream rssStream;
		try {
			rssStream = feedUrl.openConnection().getInputStream();
		} catch (Exception e) {
			throw new RuntimeException("Erro ao conectar", e);
		}
		
		try {
			RSSHandler handler = new RSSHandler(rssStream);
			return handler.parse();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected List<HeadlineItem> doInBackground(String... params) {
		return this.getHeadlines();
	}
	
	@Override
	protected void onPostExecute(List<HeadlineItem> result) {
		this.activity.renderHeadLines(result);
	}
	
}
