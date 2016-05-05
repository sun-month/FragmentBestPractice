package com.han.fragmentbestpractice.fragment;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.han.fragmentbestpractice.activity.NewsContentActivity;
import com.han.fragmentbestpractice.R;
import com.han.fragmentbestpractice.adapter.NewsAdapter;
import com.han.fragmentbestpractice.pojo.News;

public class NewsTitleFragment extends Fragment implements OnItemClickListener {

	private List<News> newsList;
	private NewsAdapter adapter;
	private ListView newsTitleListView;
	private boolean isTwoPane;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		newsList = getNews();
		adapter = new NewsAdapter(activity, R.layout.news_item, newsList);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater
				.inflate(R.layout.news_title_frag, container, false);
		newsTitleListView = (ListView) view
				.findViewById(R.id.news_title_list_view);
		newsTitleListView.setAdapter(adapter);
		newsTitleListView.setOnItemClickListener(this);
		return view;
	}

	private List<News> getNews() {
		List<News> newsList = new ArrayList<News>();
		News news1 = new News();
		news1.setTitle("科比最后一场狂砍60分");
		news1.setContent("北京时间4月13日，湖人迎来常规赛最后一场比赛，也就是说这是科比的最后一场比赛，主场迎战爵士，在本场比赛中，科比大爆发，硬生生地扳回了一场胜利。");
		newsList.add(news1);
		News news2 = new News();
		news2.setTitle("库里51分致敬科比");
		news2.setContent("北京时间4月13日，勇士主场迎战灰熊，一开始库里就手感火热，连中几记三分，手感爆棚的库里一直砍分，三节打卡就已经砍下51分了。");
		newsList.add(news2);
		return newsList;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		isTwoPane = getActivity().findViewById(R.id.news_content_layout) != null;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		News news = newsList.get(position);
		if (isTwoPane) {
			NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager()
					.findFragmentById(R.id.news_content_fragment);
			newsContentFragment.refresh(news.getTitle(), news.getContent());
		} else {
			NewsContentActivity.actionStart(getActivity(), news.getTitle(),
					news.getContent());
		}
	}

}
