package com.hoops9.myheadlines.tab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.ListFragment;

import com.hoops9.myheadlines.R;
import com.hoops9.myheadlines.adapter.IconicAdapter;
import com.hoops9.myheadlines.dao.HeadlineItem;
import com.hoops9.myheadlines.task.RSSFeedReader;

@SuppressLint("NewApi")
public class TabFragment1 extends ListFragment {
	
	List<HeadlineItem> headlines;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		new RSSFeedReader(this).execute();
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
		
		IconicAdapter adapter = new IconicAdapter(getActivity(), fillMaps, R.layout.row, from, to);
		setListAdapter(adapter);
	}
}
