package com.hoops9.myheadlines;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hoops9.myheadlines.business.RSSFeedReader;
import com.hoops9.myheadlines.dao.HeadlineItem;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.SimpleAdapter;

public class MainActivity extends ListActivity {
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Create the item mapping
	    String[] from = new String[] { "time", "headline" };
	    int[] to = new int[] { R.id.time, R.id.headline };
		
		List<HashMap<String, Object>> fillMaps = new ArrayList<HashMap<String,Object>>();
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<HeadlineItem> headlines = RSSFeedReader.getHeadlines();
		
		for (HeadlineItem item : headlines) {
			map.put("time", item.getTime());
			map.put("headline", item.getHeadline());
			fillMaps.add(map);
			map = new HashMap<String, Object>();
		}
		SimpleAdapter adapter = new SimpleAdapter(this, fillMaps, R.layout.row, from, to);
		setListAdapter(adapter);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
