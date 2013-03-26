package com.hoops9.myheadlines.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;

import com.hoops9.myheadlines.R;
import com.hoops9.myheadlines.adapter.IconicAdapter;
import com.hoops9.myheadlines.dao.HeadlineItem;
import com.hoops9.myheadlines.task.RSSFeedReader;

public class MainActivity extends ListActivity {
	List<HeadlineItem> headlines;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		new RSSFeedReader(this).execute();
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void renderHeadLines(List<HeadlineItem> headlines) {
		// Create the item mapping
		String[] from = new String[] { "time", "headline", "content", "title" };
		int[] to = new int[] { R.id.time, R.id.headline, R.id.content, R.id.title };
		
		List<HashMap<String, Object>> fillMaps = new ArrayList<HashMap<String,Object>>();
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		this.headlines = headlines;
		for (HeadlineItem item : headlines) {
			map.put("time", item.getFormattedPubDate());
			map.put("headline", item.getHeadline());
			map.put("content", item.getContent());
			map.put("title", item.getOwner());
			map.put("link", item.getLink().toString());
			fillMaps.add(map);
			map = new HashMap<String, Object>();
		}
		IconicAdapter adapter = new IconicAdapter(this, fillMaps, R.layout.row, from, to);
		setListAdapter(adapter);
	}
}
