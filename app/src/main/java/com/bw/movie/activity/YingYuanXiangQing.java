package com.bw.movie.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.bean.QuBean;
import com.bw.movie.bean.QuLeiBean;
import com.bw.movie.bean.ShiJianBean;
import com.bw.movie.bean.YYXQBean;
import com.bw.movie.bean.YingYuanDianZan;
import com.bw.movie.bean.YingYuanFuJinBean;
import com.bw.movie.bean.YingYuanGuanZhu;
import com.bw.movie.bean.YingYuanPingLun;
import com.bw.movie.bean.YingYuanSouSuoBean;
import com.bw.movie.bean.YingYuanTuiJianBean;
import com.bw.movie.bean.YingYuanWeiGuanZhu;
import com.bw.movie.bean.ZhouQiBean;
import com.bw.movie.contract.YingYuanContract;
import com.bw.movie.frag.yingyuanxiangqing.PingLunFragment;
import com.bw.movie.frag.yingyuanxiangqing.XiangQingFragment;
import com.bw.movie.presenter.YingYuanPresenter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class YingYuanXiangQing extends BaseActivity<YingYuanPresenter> implements YingYuanContract.Iview {

    @BindView(R.id.cinemadetail_fanhui)
    SimpleDraweeView cinemadetailFanhui;
    @BindView(R.id.xiangqing_name)
    TextView xiangqingName;
    @BindView(R.id.xiangqing_yanjin)
    TextView xiangqingYanjin;
    @BindView(R.id.xiangqing_tab)
    TabLayout xiangqingTab;
    @BindView(R.id.xiangqing_vp)
    ViewPager xiangqingVp;
    @BindView(R.id.button_paiqi)
    Button buttonPaiqi;
    @BindView(R.id.xiangqing_guanzhu)
    CheckBox xiangqingGuanzhu;
    private int id;
    private int userId;
    private String s;
    private SharedPreferences sp;

    @Override
    protected YingYuanPresenter providePresenter() {
        return new YingYuanPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_ying_yuan_xiang_qing;
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        mPresenter.getPresenteryyxq(id);
        sp = getSharedPreferences("movie", Context.MODE_PRIVATE);
        userId = sp.getInt("u", 0);
        s = sp.getString("s", null);
        //关注影院
        xiangqingGuanzhu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    if (userId!=0&&s!=null){
                        xiangqingGuanzhu.setBackgroundResource(R.drawable.yiguanzhu);
                        //关注
                        mPresenter.getPresenteryingyuanguanzhu(userId, s, id);
                    }else{
                        Toast.makeText(YingYuanXiangQing.this, "请先登录", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    xiangqingGuanzhu.setBackgroundResource(R.drawable.weiguanzhu);
                    //未关注
                    mPresenter.getPresenteryingyuanweiguanzhu(userId, s, id);
                }
            }
        });

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new XiangQingFragment());
        fragments.add(new PingLunFragment());
        ArrayList<String> list = new ArrayList<>();
        list.add("影院详情");
        list.add("影院评价");
        xiangqingVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }
        });
        xiangqingTab.setupWithViewPager(xiangqingVp);
    }

    @OnClick({R.id.cinemadetail_fanhui, R.id.button_paiqi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cinemadetail_fanhui:
                finish();
                break;
            case R.id.button_paiqi:
                Intent intent = new Intent(YingYuanXiangQing.this, ZhouQiActivity.class);
                intent.putExtra("key", id);
                startActivity(intent);
                break;
        }
    }


    @Override
    public void onHomesuccess(QuLeiBean quLeiBean) {

    }

    @Override
    public void onHomesuccess(QuBean quBean) {

    }

    @Override
    public void onHomesuccess(YingYuanTuiJianBean yingYuanTuiJianBean) {

    }

    @Override
    public void onHomesuccess(YingYuanFuJinBean yingYuanFuJinBean) {

    }

    @Override
    public void onHomesuccess(YingYuanSouSuoBean yingYuanSouSuoBean) {

    }

    @Override
    public void onHomesuccess(YYXQBean yyxqBean) {
        if (yyxqBean.getStatus().equals("0000")) {
            YYXQBean.ResultBean result = yyxqBean.getResult();
            if (result != null) {
                xiangqingName.setText(result.getName());
                xiangqingYanjin.setText(result.getLabel());
            }else{
                Toast.makeText(this,"无数据", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, yyxqBean.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onHomesuccess(YingYuanPingLun yingYuanPingLun) {

    }

    @Override
    public void onHomesuccess(ShiJianBean shiJianBean) {

    }

    @Override
    public void onHomesuccess(ZhouQiBean zhouQiBean) {

    }

    @Override
    public void onHomesuccess(YingYuanGuanZhu yingYuanGuanZhu) {
        if (yingYuanGuanZhu.equals("0000")) {

            Toast.makeText(YingYuanXiangQing.this, yingYuanGuanZhu.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onHomesuccess(YingYuanWeiGuanZhu yingYuanWeiGuanZhu) {
        if (yingYuanWeiGuanZhu.equals("0000")) {
            Toast.makeText(YingYuanXiangQing.this, yingYuanWeiGuanZhu.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onHomesuccess(YingYuanDianZan yingYuanDianZan) {

    }

    @Override
    public void onHomeFaiure(Throwable e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


}
