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
import com.bw.movie.frag.goupiaojilu.DaiFuKuanFragment;
import com.bw.movie.frag.goupiaojilu.YiFuKuanFragment;
import com.bw.movie.frag.wodepinglun.MovieFragment;
import com.bw.movie.frag.wodepinglun.YingYuanPingLunFragment;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChaXunPingLunActivity extends BaseActivity {


    @BindView(R.id.goupiaojilu_fanhui)
    SimpleDraweeView goupiaojiluFanhui;
    @BindView(R.id.goupiaojilu_tab)
    TabLayout goupiaojiluTab;
    @BindView(R.id.goupiaojilu_vp)
    ViewPager goupiaojiluVp;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_cha_xun_ping_lun;
    }

    @Override
    protected void initData() {
        super.initData();
        ArrayList<String> list = new ArrayList<>();
        list.add("电影");
        list.add("影院");
        ArrayList<Fragment> fragment = new ArrayList<>();
        fragment.add(new MovieFragment());
        fragment.add(new YingYuanPingLunFragment());
        goupiaojiluVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
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
        goupiaojiluTab.setupWithViewPager(goupiaojiluVp);
        goupiaojiluVp.setOffscreenPageLimit(2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.goupiaojilu_fanhui)
    public void onViewClicked() {
        finish();
    }
}
