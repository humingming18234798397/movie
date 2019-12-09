package com.bw.movie.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.app.App;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.bean.BirthBean;
import com.bw.movie.bean.ChaYingPingBean;
import com.bw.movie.bean.DaiFuKuanBean;
import com.bw.movie.bean.DingDanBean;
import com.bw.movie.bean.ErWeiMaBean;
import com.bw.movie.bean.FanKuiBean;
import com.bw.movie.bean.GuanZhuMovie;
import com.bw.movie.bean.GuanZhuYingYuan;
import com.bw.movie.bean.MovieBean;
import com.bw.movie.bean.MoviePiaoBean;
import com.bw.movie.bean.OldMovieBean;
import com.bw.movie.bean.PhoneBean;
import com.bw.movie.bean.PwdBean;
import com.bw.movie.bean.TouXiangBean;
import com.bw.movie.bean.XiTongMessage;
import com.bw.movie.bean.YiFuKuanBean;
import com.bw.movie.bean.YongHuBean;
import com.bw.movie.bean.YuYueBean;
import com.bw.movie.bean.ZhiFuBean;
import com.bw.movie.contract.MyContract;
import com.bw.movie.presenter.MyPresenter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.tencent.mm.opensdk.modelpay.PayReq;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DingDanFuKuanActivity extends BaseActivity<MyPresenter> implements MyContract.Iview {
    @BindView(R.id.details_back)
    SimpleDraweeView detailsBack;
    @BindView(R.id.movie_name_seat)
    TextView movieNameSeat;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.position)
    TextView position;
    @BindView(R.id.home)
    TextView home;
    @BindView(R.id.count)
    TextView count;
    @BindView(R.id.seat)
    TextView seat;
    @BindView(R.id.time)
    TextView time;
    @BindView(R.id.orderId1)
    TextView orderId1;
    @BindView(R.id.createtime)
    TextView createtime;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.line)
    LinearLayout line;
    @BindView(R.id.pay)
    Button pay;
    @BindView(R.id.img)
    SimpleDraweeView img;
    @BindView(R.id.wechat)
    CheckBox wechat;
    @BindView(R.id.img1)
    SimpleDraweeView img1;
    @BindView(R.id.zfb)
    CheckBox zfb;
    @BindView(R.id.paybck)
    LinearLayout paybck;
    @BindView(R.id.pay_btn)
    Button payBtn;
    private int userId;
    private String s;
    private SharedPreferences sp;
    private String orderId;
    int id;
    @Override
    protected MyPresenter providePresenter() {
        return new MyPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_ding_dan_fu_kuan;
    }

    @Override
    protected void initData() {
        super.initData();
        sp = getSharedPreferences("movie", Context.MODE_PRIVATE);
        userId = sp.getInt("u", 0);
        s = sp.getString("s", null);
        Intent intent = getIntent();
        orderId = intent.getStringExtra("orderId");
        mPresenter.getPresenterdingdan(userId, s, orderId);

    }

    @Override
    public void onMysuccess(DaiFuKuanBean daiFuKuanBean) {

    }

    @Override
    public void onMysuccess(YiFuKuanBean yiFuKuanBean) {

    }

    @Override
    public void onMysuccess(MovieBean movieBean) {

    }

    @Override
    public void onMysuccess(ChaYingPingBean chaYingPingBean) {

    }

    @Override
    public void onMysuccess(GuanZhuMovie guanZhuMovie) {

    }

    @Override
    public void onMysuccess(GuanZhuYingYuan guanZhuYingYuan) {

    }

    @Override
    public void onMysuccess(DingDanBean dingDanBean) {
        DingDanBean.ResultBean result = dingDanBean.getResult();
        name.setText(result.getMovieName());
        position.setText(result.getCinemaName());
        home.setText(result.getScreeningHall());
        count.setText(result.getAmount() + "张");
        seat.setText(result.getSeat());
        time.setText(result.getBeginTime() + "-" + result.getEndTime());
        orderId1.setText(orderId);
        Date date = new Date(result.getCreateTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        createtime.setText(simpleDateFormat.format(date));
        price.setText("￥" + result.getPrice());
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pay.setVisibility(View.INVISIBLE);
                paybck.setVisibility(View.VISIBLE);
                payBtn.setVisibility(View.VISIBLE);
                payBtn.setText("￥" + result.getPrice());
                wechat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        wechat.setChecked(true);
                        zfb.setChecked(false);
                        id = 1;
                        payBtn.setText("微信支付￥ " + result.getPrice());
                    }
                });
                zfb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        zfb.setChecked(true);
                        wechat.setChecked(false);
                        id = 2;
                        payBtn.setText("支付宝支付￥ " + result.getPrice());
                    }
                });
                SharedPreferences movie = getSharedPreferences("movie", MODE_PRIVATE);
                s = movie.getString("s", "");
                userId = movie.getInt("u", 0);
                payBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPresenter.getPresenterzhifu(userId, s, id, result.getOrderId());
                    }
                });
            }
        });
    }

    @Override
    public void onMysuccess(ZhiFuBean zhiFuBean) {
        if (zhiFuBean.getStatus().equals("0000")){
            PayReq payReq = new PayReq();
            payReq.appId = zhiFuBean.getAppId();
            payReq.nonceStr = zhiFuBean.getNonceStr();
            payReq.partnerId = zhiFuBean.getPartnerId();
            payReq.prepayId = zhiFuBean.getPrepayId();
            payReq.sign = zhiFuBean.getSign();
            payReq.timeStamp = zhiFuBean.getTimeStamp();
            payReq.packageValue = zhiFuBean.getPackageValue();
            payReq.extData = "app data";
            App.api.sendReq(payReq);
            paybck.setVisibility(View.GONE);
            payBtn.setVisibility(View.GONE);
            Toast.makeText(this,"支付成功",Toast.LENGTH_SHORT).show();
            finish();
        }else{
            Toast.makeText(this, zhiFuBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onMysuccess(YuYueBean yuYueBean) {

    }

    @Override
    public void onMysuccess(XiTongMessage xiTongMessage) {

    }

    @Override
    public void onMysuccess(MoviePiaoBean moviePiaoBean) {

    }

    @Override
    public void onMysuccess(ErWeiMaBean erWeiMaBean) {

    }

    @Override
    public void onMysuccess(FanKuiBean fanKuiBean) {

    }

    @Override
    public void onMysuccess(OldMovieBean oldMovieBean) {

    }

    @Override
    public void onMysuccess(TouXiangBean touXiangBean) {

    }

    @Override
    public void onMysuccess(YongHuBean yongHuBean) {

    }

    @Override
    public void onMysuccess(PwdBean pwdBean) {

    }

    @Override
    public void onMysuccess(PhoneBean phoneBean) {

    }

    @Override
    public void onMysuccess(BirthBean birthBean) {

    }

    @Override
    public void onMyFaiure(Throwable e) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.details_back)
    public void onViewClicked() {
        finish();
    }
}
