package com.han.fragmentbestpractice.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.han.fragmentbestpractice.R;
import com.han.fragmentbestpractice.pojo.News;

public class NewsAdapter extends ArrayAdapter<News> {
	
	private int resouceId;
	
	public NewsAdapter(Context context, int textViewResourceId,
			List<News> objects) {
		super(context, textViewResourceId, objects);
		resouceId = textViewResourceId;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView==null) {
			holder = new ViewHolder();
			convertView = LayoutInflater.from(getContext()).inflate(resouceId, null);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.newsTitleText = (TextView) convertView.findViewById(R.id.news_title);
		News news = getItem(position);
		holder.newsTitleText.setText(news.getTitle());
		return convertView;
	}
	static class ViewHolder{
		TextView newsTitleText;
	}
}
