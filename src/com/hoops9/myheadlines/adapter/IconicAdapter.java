package com.hoops9.myheadlines.adapter;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.hoops9.myheadlines.R;
import com.hoops9.myheadlines.activity.HeadlineItemActivity;
import com.hoops9.myheadlines.task.FaviconLoader;

public class IconicAdapter extends SimpleAdapter {
	
	Context context;
	List<? extends Map<String, ?>> data;
	
	public IconicAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
		super(context, data, resource, from, to);
		this.context = context;
		this.data = data;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = super.getView(position, convertView, parent);
		new FaviconLoader(this, row).execute();
		
		Map<String, ?> dataMap = data.get(position);

		final TextView headline = (TextView) row.findViewById(R.id.headline);
		final String headlineString = (String) dataMap.get(HeadlineItemActivity.HEADLINE);
		final String contentString = (String) dataMap.get(HeadlineItemActivity.CONTENT);
		
		headline.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(context, HeadlineItemActivity.class);
				intent.putExtra(HeadlineItemActivity.HEADLINE, headlineString);
				intent.putExtra(HeadlineItemActivity.CONTENT, contentString);
				context.startActivity(intent);
				((Activity) context).overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_out);
			}
		});

		return row;
	}
	
	public void setFavicon(Drawable favicon, View view) {
		ImageView icon = (ImageView) view.findViewById(R.id.favicon);
		icon.setImageDrawable(favicon);
	}
	
}
