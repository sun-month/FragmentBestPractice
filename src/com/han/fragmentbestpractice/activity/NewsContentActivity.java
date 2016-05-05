package com.han.fragmentbestpractice.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.han.fragmentbestpractice.R;
import com.han.fragmentbestpractice.fragment.NewsContentFragment;

public class NewsContentActivity extends Activity {

	private static final String NEWS_CONTENT = "news_content";
	private static final String NEWS_TITLE = "news_title";

	public static void actionStart(Context context, String newsTitle,
			String newsContent) {
		Intent intent = new Intent(context, NewsContentActivity.class);
		intent.putExtra(NEWS_TITLE, newsTitle);
		intent.putExtra(NEWS_CONTENT, newsContent);
		context.startActivity(intent);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.news_content);
		String newsTitle = getIntent().getStringExtra(NEWS_TITLE);
		String newsContent = getIntent().getStringExtra(NEWS_CONTENT);
		NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager().findFragmentById(R.id.news_content_fragment);
		newsContentFragment.refresh(newsTitle, newsContent);
		
	}
}
