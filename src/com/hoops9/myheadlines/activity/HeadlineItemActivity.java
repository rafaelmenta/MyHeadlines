package com.hoops9.myheadlines.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.widget.TextView;

import com.hoops9.myheadlines.R;

@SuppressLint({ "NewApi", "SetJavaScriptEnabled" })
public class HeadlineItemActivity extends Activity  {
	
	public static final String LINK = "link";
	public static final String HEADLINE = "headline";
	public static final String CONTENT = "content";
	public static final String TITLE = "title";

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
		String title = intent.getStringExtra(HeadlineItemActivity.TITLE);
		
		setTitle(title);
		
		TextView textView = (TextView) findViewById(R.id.headline);
		textView.setText(headline);
		
		WebView contentView = (WebView) findViewById(R.id.content);
		
		WebSettings webSettings = contentView.getSettings();
		webSettings.setDefaultTextEncodingName("utf-8");
		webSettings.setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
		webSettings.setJavaScriptEnabled(true);
		webSettings.setPluginState(PluginState.ON);
		contentView.setWebChromeClient(new WebChromeClient());
		
		contentView.loadData(content, "text/html; charset=utf-8", "utf-8");
	}
	
}
