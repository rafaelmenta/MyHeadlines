package com.hoops9.myheadlines.task;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;

import com.hoops9.myheadlines.bean.DrawableBean;
import com.hoops9.myheadlines.interfaces.LazyLoading;

public class ImageLoader extends AsyncTask<String, Void, DrawableBean>{
	
	private LazyLoading loadingObject;
	
	public ImageLoader(LazyLoading loadingObject) {
		this.loadingObject = loadingObject;
	}
	
	public DrawableBean loadFavicon(String url, String imageId) {
		Drawable drawable = null;
		try {
			URL faviconUrl = new URL(url);
			InputStream inputStream = (InputStream) faviconUrl.getContent();
			drawable = Drawable.createFromStream(inputStream, null);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new DrawableBean(drawable, imageId);
	}

	@Override
	protected DrawableBean doInBackground(String... params) {
		return this.loadFavicon(params[0], params[1]);
	}
	
	@Override
	protected void onPostExecute(DrawableBean result) {
		loadingObject.setImage(result.getDrawable(), result.getImageId());
	}
	
}
