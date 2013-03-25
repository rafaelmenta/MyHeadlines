package com.hoops9.myheadlines.task;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.View;

import com.hoops9.myheadlines.adapter.IconicAdapter;

public class FaviconLoader extends AsyncTask<String, Void, Drawable>{
	
	private IconicAdapter adapter;
	private View currentView;
	
	public FaviconLoader(IconicAdapter adapter, View currentView) {
		this.adapter = adapter;
		this.currentView = currentView;
	}
	
	public Drawable loadFavicon() {
		Drawable drawable = null;
		try {
			URL faviconUrl = new URL("http://www.google.com/s2/u/0/favicons?domain_url=http://www.draftbrasil.net/blog/sacramento-apresenta-projeto-de-nova-arena-para-o-kings/");
			InputStream inputStream = (InputStream) faviconUrl.getContent();
			drawable = Drawable.createFromStream(inputStream, null);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return drawable;
	}

	@Override
	protected Drawable doInBackground(String... params) {
		return this.loadFavicon();
	}
	
	@Override
	protected void onPostExecute(Drawable result) {
		this.adapter.setFavicon(result, this.currentView);
	}
	
}
