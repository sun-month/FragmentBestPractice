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
		news1.setTitle("�Ʊ����һ����60��");
		news1.setContent("����ʱ��4��13�գ�����ӭ�����������һ��������Ҳ����˵���ǿƱȵ����һ������������ӭս��ʿ���ڱ��������У��Ʊȴ󱬷���Ӳ�����ذ����һ��ʤ����");
		newsList.add(news1);
		News news2 = new News();
		news2.setTitle("����51���¾��Ʊ�");
		news2.setContent("����ʱ��4��13�գ���ʿ����ӭս���ܣ�һ��ʼ������ָл��ȣ����м������֣��ָб���Ŀ���һֱ���֣����ڴ򿨾��Ѿ�����51���ˡ�");
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
