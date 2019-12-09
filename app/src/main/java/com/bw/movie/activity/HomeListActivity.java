package com.bw.movie.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.frag.homelist.ListJiJiang;
import com.bw.movie.frag.homelist.ListReMen;
import com.bw.movie.frag.homelist.ListReYing;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @describe(描述)：HomeListActivity
 * @data（日期）: 2019/11/19
 * @time（时间）: 16:54
 * @author（作者）: 胡明明
 **/
public class HomeListActivity extends BaseActivity {

    @BindView(R.id.home_list_tab)
    TabLayout homeListTab;
    @BindView(R.id.home_list_vp)
    ViewPager homeListVp;
    @BindView(R.id.simple_img)
    SimpleDraweeView simpleImg;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_home_list;
    }

    @Override
    protected void initData() {
        super.initData();

        ArrayList<String> list = new ArrayList<>();
        list.add("正在热映");
        list.add("即将上映");
        list.add("热门电影");
        ArrayList<Fragment> fragment = new ArrayList<>();
        fragment.add(new ListReYing());
        fragment.add(new ListJiJiang());
        fragment.add(new ListReMen());
        homeListVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragment.get(position);
            }

            @Override
            public int getCount() {
                return fragment.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }
        });
        homeListTab.setupWithViewPager(homeListVp);
        homeListVp.setOffscreenPageLimit(3);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.simple_img)
    public void onViewClicked() {
        finish();
    }
}
