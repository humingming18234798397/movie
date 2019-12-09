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
import com.bw.movie.frag.guanzhu.GuanzhuMovieFrag;
import com.bw.movie.frag.guanzhu.GuanzhuYingYuanFrag;
import com.bw.movie.frag.wodepinglun.MovieFragment;
import com.bw.movie.frag.wodepinglun.YingYuanPingLunFragment;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GuanZhuActivity extends BaseActivity {

    @BindView(R.id.guanzhu_fanhui)
    SimpleDraweeView guanzhuFanhui;
    @BindView(R.id.guanzhu_tab)
    TabLayout guanzhuTab;
    @BindView(R.id.guanzhu_vp)
    ViewPager guanzhuVp;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_guan_zhu;
    }

    @Override
    protected void initData() {
        super.initData();
        ArrayList<String> list = new ArrayList<>();
        list.add("电影");
        list.add("影院");
        ArrayList<Fragment> fragment = new ArrayList<>();
        fragment.add(new GuanzhuMovieFrag());
        fragment.add(new GuanzhuYingYuanFrag());
        guanzhuVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
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
        guanzhuTab.setupWithViewPager(guanzhuVp);
        guanzhuVp.setOffscreenPageLimit(2);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.guanzhu_fanhui)
    public void onViewClicked() {
        finish();
    }
}
