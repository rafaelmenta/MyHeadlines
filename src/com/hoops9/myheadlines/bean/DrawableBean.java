package com.hoops9.myheadlines.bean;

import android.graphics.drawable.Drawable;

public class DrawableBean {
	private Drawable drawable;
	private String imageId;
	
	public DrawableBean (Drawable drawable, String imageId) {
		this.setDrawable(drawable);
		this.setImageId(imageId);
	}

	public Drawable getDrawable() {
		return drawable;
	}

	public void setDrawable(Drawable drawable) {
		this.drawable = drawable;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
}