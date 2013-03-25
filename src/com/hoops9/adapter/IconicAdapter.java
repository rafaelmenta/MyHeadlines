package com.hoops9.adapter;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import com.hoops9.myheadlines.R;
import com.hoops9.task.FaviconLoader;

public class IconicAdapter extends SimpleAdapter {
	
	View row;

	public IconicAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
		super(context, data, resource, from, to);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		row = super.getView(position, convertView, parent);
		ImageView icon = (ImageView) row.findViewById(R.id.favicon);
		icon.setImageResource(R.drawable.favicon);
		new FaviconLoader(this).execute();
		return row;
	}
	
	public void setFavicon(Drawable favicon) {
		ImageView icon = (ImageView) row.findViewById(R.id.favicon);
		icon.setImageDrawable(favicon);
	}
	
}
