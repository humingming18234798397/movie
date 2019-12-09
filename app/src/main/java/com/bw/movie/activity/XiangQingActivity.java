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

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.bean.GuanZhuBean;
import com.bw.movie.bean.HomeBean;
import com.bw.movie.bean.HomeSouSuoBean;
import com.bw.movie.bean.HomeYuYueBean;
import com.bw.movie.bean.MovieDianZan;
import com.bw.movie.bean.PriceBean;
import com.bw.movie.bean.QuLeiBean;
import com.bw.movie.bean.ReYingBean;
import com.bw.movie.bean.ShangYingBean;
import com.bw.movie.bean.ShiJianBean;
import com.bw.movie.bean.ShiJianYingYuanBean;
import com.bw.movie.bean.WeiGuanZhuBean;
import com.bw.movie.bean.XBannerBean;
import com.bw.movie.bean.XiaDanBean;
import com.bw.movie.bean.XiangQingBean;
import com.bw.movie.bean.XieYingPingBean;
import com.bw.movie.bean.XuanZuoXinXiBean;
import com.bw.movie.bean.YingPingBean;
import com.bw.movie.bean.YingTingBean;
import com.bw.movie.bean.ZhiFuBean;
import com.bw.movie.bean.ZuoWeiHaoBean;
import com.bw.movie.contract.HomeContract;
import com.bw.movie.frag.xiangqing.JieShaoFragment;
import com.bw.movie.frag.xiangqing.JuZhaoFragment;
import com.bw.movie.frag.xiangqing.YingPingFragment;
import com.bw.movie.frag.xiangqing.YuGaoFragment;
import com.bw.movie.presenter.HomePresenter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class XiangQingActivity extends BaseActivity<HomePresenter> implements HomeContract.Iview {


    @BindView(R.id.simp_xiangqing)
    SimpleDraweeView simpXiangqing;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.dt_guanzhu)
    TextView dtGuanzhu;
    @BindView(R.id.text_xiangqing_name)
    TextView textXiangqingName;
    @BindView(R.id.text_xiangqing_leixing)
    TextView textXiangqingLeixing;
    @BindView(R.id.text_xiangqing_time)
    TextView textXiangqingTime;
    @BindView(R.id.tab_xiangqing)
    TabLayout tabXiangqing;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.movie_pager)
    ViewPager moviePager;
    @BindView(R.id.filmdetail_write)
    Button filmdetailWrite;
    @BindView(R.id.xiangqing_xuanzuo)
    Button xiangqingXuanzuo;
    @BindView(R.id.xiangqing_guanzhu)
    CheckBox xiangqingGuanzhu;
    private int key;
    private int userId;
    private String s;
    private SharedPreferences sp;

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_xiang_qing;
    }

    @Override
    protected void initData() {
        super.initData();
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        Intent intent = getIntent();
        key = intent.getIntExtra("key", 0);
        mPresenter.getModelXiangQing(key);
        sp = getSharedPreferences("movie", Context.MODE_PRIVATE);
        userId = sp.getInt("u", 0);
        s = sp.getString("s", null);



        //关注电影
        xiangqingGuanzhu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                  if (userId!=0&&s!=null){
                      xiangqingGuanzhu.setChecked(true);
                      xiangqingGuanzhu.setBackgroundResource(R.drawable.yiguanzhu);
                      //关注
                      mPresenter.getPresenterguanzhu(userId, s, key);
                  }else{
                      Toast.makeText(XiangQingActivity.this, "请先登录", Toast.LENGTH_SHORT).show();
                  }
                } else {
                    xiangqingGuanzhu.setChecked(false);
                    xiangqingGuanzhu.setBackgroundResource(R.drawable.weiguanzhu);
                    //未关注
                    mPresenter.getPresenterweiguanzhu(userId, s, key);
                }
            }
        });





        final ArrayList<Fragment> list = new ArrayList<>();
        final ArrayList<String> listab = new ArrayList<>();
        list.add(new JieShaoFragment());
        list.add(new YuGaoFragment());
        list.add(new JuZhaoFragment());
        list.add(new YingPingFragment());
        listab.add("介绍");
        listab.add("预告");
        listab.add("剧照");
        listab.add("影评");

        moviePager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            // getPageTitle
            @Override
            public CharSequence getPageTitle(int position) {
                return listab.get(position);
            }
        });
        tabXiangqing.setupWithViewPager(moviePager);


    }

    @OnClick({R.id.filmdetail_write, R.id.xiangqing_xuanzuo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //写影评
            case R.id.filmdetail_write:
                Intent intent1 = new Intent(XiangQingActivity.this, YingPingActivity.class);
                intent1.putExtra("key", key);
                startActivity(intent1);
                break;
            //选座
            case R.id.xiangqing_xuanzuo:
                Intent intent = new Intent(XiangQingActivity.this, XuanZuoActivity.class);
                intent.putExtra("key", key);
                startActivity(intent);

                break;
        }
    }

    @Override
    public void onHomesuccess(XBannerBean xBannerBean) {

    }

    @Override
    public void onHomesuccess(ReYingBean reYingBean) {

    }

    @Override
    public void onHomesuccess(ShangYingBean shangYingBean) {

    }

    @Override
    public void onHomesuccess(HomeBean homeBean) {

    }

    //详情
    @Override
    public void onHomesuccess(XiangQingBean xiangQingBean) {
        if (xiangQingBean.getStatus().equals("0000")) {
            XiangQingBean.ResultBean result = xiangQingBean.getResult();
            if (result != null) {
                String duration = result.getDuration();
                String imageUrl = result.getImageUrl();
                textXiangqingName.setText(result.getName());
                textXiangqingLeixing.setText(result.getMovieType());
                Date date = new Date(result.getReleaseTime());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                textXiangqingTime.setText(simpleDateFormat.format(date) + "上映");
                simpXiangqing.setImageURI(imageUrl);
                toolbar.setTitle(result.getName());

                int whetherFollow = result.getWhetherFollow();
                if (whetherFollow==1){
                    xiangqingGuanzhu.setChecked(true);
                }else{
                    xiangqingGuanzhu.setChecked(false);
                }


            /*  scoreFilmdetail.setText("评分  " + result.getScore() + "分");
              wetherFilmdetail.setText("评论  " + result.getCommentNum() + "万条");
              nameFilmdetail.setText(result.getName());
              typeFilmdetail.setText(result.getMovieType());
              timeFilmdetail.setText(duration);
              Date date = new Date(result.getReleaseTime());
              SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
              dataFilmdetail.setText(String.valueOf(simpleDateFormat.format(date) + "上映"));
              locationFilmdetail.setText(result.getPlaceOrigin());
              SimpleDraweeView simpleDraweeView = findViewById(R.id.img_filmdetail);
              simpleDraweeView.setImageURI(imageUrl);
              name = xiangQingBean.getResult().getName();*/
            }
        } else {
            Toast.makeText(this, xiangQingBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onHomesuccess(YingPingBean yingPingBean) {

    }

    @Override
    public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {

    }

    @Override
    public void onHomesuccess(QuLeiBean quLeiBean) {

    }

    @Override
    public void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean) {

    }

    @Override
    public void onHomesuccess(ShiJianBean shiJianBean) {

    }

    @Override
    public void onHomesuccess(PriceBean priceBean) {

    }

    @Override
    public void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean) {

    }

    @Override
    public void onHomesuccess(YingTingBean yingTingBean) {

    }

    @Override
    public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {

    }

    @Override
    public void onHomesuccess(XieYingPingBean xieYingPingBean) {

    }

    @Override
    public void onHomesuccess(XiaDanBean xiaDanBean) {

    }

    @Override
    public void onHomesuccess(ZhiFuBean zhiFuBean) {

    }

    @Override
    public void onHomesuccess(GuanZhuBean guanZhuBean) {
        if (guanZhuBean.getStatus().equals("0000")) {
                    Toast.makeText(XiangQingActivity.this, guanZhuBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onHomesuccess(WeiGuanZhuBean weiGuanZhuBean) {
        if (weiGuanZhuBean.getStatus().equals("0000")) {
                    Toast.makeText(XiangQingActivity.this, weiGuanZhuBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onHomesuccess(HomeYuYueBean homeYuYueBean) {

    }

    @Override
    public void onHomesuccess(MovieDianZan movieDianZan) {


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
