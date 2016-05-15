package com.xiaoping.test01;

import java.util.ArrayList;

import com.xiaoping.test01.view.AbOnItemClickListener;
import com.xiaoping.test01.view.AbSlidingPlayView;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

	// 首页轮播布局控件
	private AbSlidingPlayView autoPlayViewPager;
	// 轮播页面集合
	private ArrayList<View> viewsList;
	// 轮播资源集合
	private int[] resIDs = { R.drawable.banner01, R.drawable.banner02,R.drawable.banner03};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 初始化轮播界面
		initAutoPlayViewPager();
	}

	private void initAutoPlayViewPager() {
		// 首页轮播视图控件
		autoPlayViewPager = (AbSlidingPlayView) findViewById(R.id.auto_play_view_pager);
		// 设置播放方式为顺序播放
		autoPlayViewPager.setPlayType(1);
		// 设置播放间隔时间
		autoPlayViewPager.setSleepTime(3000);

		viewsList = new ArrayList<View>();

		for (int i = 0; i < resIDs.length; i++) {
			View picView = LayoutInflater.from(MainActivity.this).inflate(R.layout.pic_item, null);
			ImageView iv = (ImageView) picView.findViewById(R.id.pic_iv);
			// iv.setImageResource(resIDs[i]);
			iv.setBackgroundResource(resIDs[i]);
			viewsList.add(picView);
		}

		// 将视图集合传递给轮播控件
		autoPlayViewPager.addViews(viewsList);
		// 开始轮播
		autoPlayViewPager.startPlay();
		// 设置控件子视图点击监听器
		autoPlayViewPager.setOnItemClickListener(new AbOnItemClickListener() {
			@Override
			public void onClick(int position) {
				System.out.println("点击轮播视图" + position);
			}
		});
	}

}
