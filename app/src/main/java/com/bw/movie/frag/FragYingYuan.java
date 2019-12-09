package com.bw.movie.frag;


/*
 *@auther:胡明明
 *@Date: 2019/11/11
 *@Time:21:03
 *@Description:${DESCRIPTION}
 **/

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bw.movie.R;
import com.bw.movie.activity.YingYuanSouSuo;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.BasePresenter;
import com.bw.movie.frag.fragment.YingYuan_DiQu;
import com.bw.movie.frag.fragment.YingYuan_FuJin;
import com.bw.movie.frag.fragment.YingYuan_TuiJian;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class FragYingYuan extends BaseFragment {
    /* @BindView(R.id.rg)
     RadioGroup rg;*/
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.yingyuan_sousuo)
    SimpleDraweeView yingyuanSousuo;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.frag_yingyuan;
    }

    @Override
    protected void initData() {
        super.initData();
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("推荐影院");
        list1.add("附近影院");
        list1.add("海淀区");
        ArrayList<Fragment> list = new ArrayList<>();
        list.add(new YingYuan_TuiJian());
        list.add(new YingYuan_FuJin());
        list.add(new YingYuan_DiQu());
        vp.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return list1.get(position);
            }
        });
        tab.setupWithViewPager(vp);
       /* vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                rg.check(rg.getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb1:
                        vp.setCurrentItem(0);
                        break;
                    case R.id.rb2:
                        vp.setCurrentItem(1);
                        break;
                    case R.id.rb3:
                        vp.setCurrentItem(2);
                        break;
                }
            }
        });*/
        vp.setOffscreenPageLimit(3);
    }
    //点击影院搜索跳转
    @OnClick(R.id.yingyuan_sousuo)
    public void onViewClicked() {
        Intent intent = new Intent(getActivity(), YingYuanSouSuo.class);
        startActivity(intent);
    }


}
