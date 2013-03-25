package com.hoops9.myheadlines.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import com.hoops9.myheadlines.R;

@SuppressLint("NewApi")
public class HeadlineItemActivity extends Activity {
	
	public static final String HEADLINE = "headline";
	public static final String CONTENT = "content";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_headline_item);

		// Make sure we're running on Honeycomb or higher to use ActionBar APIs
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			// Show the Up button in the action bar.
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
		
		Intent intent = getIntent();
		String headline = intent.getStringExtra(HeadlineItemActivity.HEADLINE);
		String content = intent.getStringExtra(HeadlineItemActivity.CONTENT);
		
		TextView textView = (TextView) findViewById(R.id.headline);
		textView.setText(headline);
		
		TextView contentView = (TextView) findViewById(R.id.content);
		contentView.setTextAppearance(this, android.R.attr.textAppearanceLarge);
		contentView.setText(content);
	}
	
}
