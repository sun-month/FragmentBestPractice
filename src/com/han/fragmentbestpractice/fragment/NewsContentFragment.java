package com.han.fragmentbestpractice.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.han.fragmentbestpractice.R;

public class NewsContentFragment extends Fragment {
	private View view;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.news_content_frag, container, false);
		return view;
	}

	public void refresh(String newsTitle, String newsContent) {
		View visibilityLayout = view.findViewById(R.id.visibility_layout);
		TextView newsTitleTextView = (TextView) view
				.findViewById(R.id.news_title);
		TextView newsContentTextView = (TextView) view
				.findViewById(R.id.news_content);
		visibilityLayout.setVisibility(View.VISIBLE);
		newsTitleTextView.setText(newsTitle);
		newsContentTextView.setText(newsContent);
	}

}
