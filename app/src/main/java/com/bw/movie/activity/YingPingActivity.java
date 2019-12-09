package com.bw.movie.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

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
import com.bw.movie.presenter.HomePresenter;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class YingPingActivity extends BaseActivity<HomePresenter> implements HomeContract.Iview {

    @BindView(R.id.writefilm_fanhui)
    SimpleDraweeView writefilmFanhui;
    @BindView(R.id.xie_name)
    TextView xieName;
    @BindView(R.id.write_ratfenfilm)
    RatingBar writeRatfenfilm;
    @BindView(R.id.xie_edittext)
    EditText xieEdittext;
    @BindView(R.id.xie_button)
    Button xieButton;
    private int key;
    private SharedPreferences sp;
    private int u;
    private String s;
    private double score;

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_ying_ping;
    }

    @Override
    protected void initData() {
        super.initData();
        sp = getSharedPreferences("movie", Context.MODE_PRIVATE);
        u = sp.getInt("u", 0);
        s = sp.getString("s", null);
        Intent intent = getIntent();
        key = intent.getIntExtra("key", 0);
        mPresenter.getModelXiangQing(key);
    }
    @OnClick({R.id.writefilm_fanhui, R.id.xie_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.writefilm_fanhui:
                finish();
                break;
            case R.id.xie_button:
                //huo获取输入框
                String commentContent = xieEdittext.getText().toString();
                mPresenter.getPresenterxieyp(u,s,key,commentContent,score);
                finish();
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

    @Override
    public void onHomesuccess(XiangQingBean xiangQingBean) {
       if (xiangQingBean.getStatus().equals("0000")){
           XiangQingBean.ResultBean result = xiangQingBean.getResult();
          if (result!=null){
              xieName.setText(result.getName());
              score = result.getScore();
          }
       }else{
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
       if (xieYingPingBean.getStatus().equals("0000")){
           Toast.makeText(this, ""+xieYingPingBean.getMessage(), Toast.LENGTH_SHORT).show();
       }else{
           Toast.makeText(this, ""+xieYingPingBean.getMessage(), Toast.LENGTH_SHORT).show();
       }
    }

    @Override
    public void onHomesuccess(XiaDanBean xiaDanBean) {

    }

    @Override
    public void onHomesuccess(ZhiFuBean zhiFuBean) {

    }

    @Override
    public void onHomesuccess(GuanZhuBean guanZhuBean) {

    }

    @Override
    public void onHomesuccess(WeiGuanZhuBean weiGuanZhuBean) {

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
