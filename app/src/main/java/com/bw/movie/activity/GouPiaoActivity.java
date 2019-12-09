package com.bw.movie.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.adapter.YingTingAdapter;
import com.bw.movie.adapter.ZuoWeiAdapter;
import com.bw.movie.app.App;
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
import com.tencent.mm.opensdk.modelpay.PayReq;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class GouPiaoActivity extends BaseActivity<HomePresenter> implements HomeContract.Iview {
    @BindView(R.id.goupiao_fanhui)
    SimpleDraweeView goupiaoFanhui;
    @BindView(R.id.goupiao_name)
    TextView goupiaoName;
    @BindView(R.id.goupiao_jcvideo)
    JCVideoPlayer goupiaoJcvideo;
    @BindView(R.id.img_jcv)
    SimpleDraweeView imgJcv;
    @BindView(R.id.goupiao_rlv)
    RecyclerView goupiaoRlv;
    @BindView(R.id.cb_cinemaseatkexuan)
    CheckBox cbCinemaseatkexuan;
    @BindView(R.id.cb_cinemaseatyishou)
    CheckBox cbCinemaseatyishou;
    @BindView(R.id.cb_cinemaseat_xuanzhong)
    CheckBox cbCinemaseatXuanzhong;
    @BindView(R.id.liner)
    LinearLayout liner;
    @BindView(R.id.tv_cinema)
    TextView tvCinema;
    @BindView(R.id.recycle_yingting)
    RecyclerView recycleYingting;
    @BindView(R.id.btn_xiadan)
    Button btnXiadan;
    @BindView(R.id.btn_xuanzuo)
    Button btnXuanzuo;
    @BindView(R.id.rela)
    RelativeLayout rela;
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
    private int key;
    private int cinemaid;
    //  EventBus.getDefault().register(this);
    double money = 0;
    private double fare1;
    private String scheduleId;
    private String seats;
    private int userId;
    private String s;
    private String orderId;
    int id;
    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_gou_piao;
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getIntent();
        key = intent.getIntExtra("key", 0);
        cinemaid = intent.getIntExtra("cinemaid", 0);
        mPresenter.getModelXiangQing(key);
        mPresenter.getPresenteryingting(key, cinemaid);
        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recycleYingting.setLayoutManager(linearLayoutManager);

        btnXiadan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("movie", Context.MODE_PRIVATE);
                userId = sp.getInt("u", 0);
                s = sp.getString("s", null);
                String s1 = MD5(userId + "" + scheduleId + "movie");
                Log.d("aaa", "onClick: " + userId + scheduleId + "movie");
                mPresenter.getPresenterxiadan(userId, s, scheduleId, seats, s1);

            }
        });
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
        XiangQingBean.ResultBean result = xiangQingBean.getResult();
        goupiaoName.setText(result.getName());
        goupiaoJcvideo.setUp(result.getShortFilmList().get(0).getVideoUrl(),JCVideoPlayer.SCREEN_LAYOUT_NORMAL,"" );
       /* Glide.with(this).load(result.getShortFilmList().get(0).getImageUrl()).into(goupiaoJcvideo.ivThumb);
*/
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
        if (yingTingBean.getStatus().equals("0000")) {
            List<YingTingBean.ResultBean> result = yingTingBean.getResult();
            YingTingAdapter yingTingAdapter = new YingTingAdapter(GouPiaoActivity.this);
            yingTingAdapter.setList(result);
            recycleYingting.setAdapter(yingTingAdapter);
            //布局管理器
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            recycleYingting.setLayoutManager(linearLayoutManager);
            //接口回调
            yingTingAdapter.setOnItemClicks(new YingTingAdapter.onItemClicks() {
                @Override
                public void onChangeData(int p, double fare, int ytid) {
                    scheduleId = ytid + "";
                    mPresenter.getPresenterzuowei(p);
                    fare1 = fare;
                    money = 0;
                    btnXiadan.setVisibility(View.INVISIBLE);
                    //chooseSeat.setText("￥ "+money);
                    btnXuanzuo.setVisibility(View.VISIBLE);
                }
            });
        } else {
            Toast.makeText(this, yingTingBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {
        if (zuoWeiHaoBean.getStatus().equals("0000")) {
            List<ZuoWeiHaoBean.ResultBean> result = zuoWeiHaoBean.getResult();
            int seat = Integer.parseInt(result.get(result.size() - 1).getSeat());
            ZuoWeiAdapter zuoWeiAdapter = new ZuoWeiAdapter(this, result);
            goupiaoRlv.setAdapter(zuoWeiAdapter);
            //布局管理器
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, seat);
            goupiaoRlv.setLayoutManager(gridLayoutManager);
            zuoWeiAdapter.setOnclickListener(new ZuoWeiAdapter.OnclickListener() {
                @Override
                public void onclick(String row, String seat, boolean ischecked) {
                    if (ischecked == true) {
                        Toast.makeText(GouPiaoActivity.this, row + "-" + seat, Toast.LENGTH_SHORT).show();
                        money = money + fare1;
                        btnXuanzuo.setVisibility(View.INVISIBLE);
                        btnXiadan.setVisibility(View.VISIBLE);
                        btnXiadan.setText("￥ " + money);
                        seats = row + "-" + seat;
                    } else {
                        money = money - fare1;
                        btnXuanzuo.setVisibility(View.INVISIBLE);
                        btnXiadan.setVisibility(View.VISIBLE);
                        btnXiadan.setText("￥ " + money);

                    }
                }
            });
        } else {
            Toast.makeText(this, zuoWeiHaoBean.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onHomesuccess(XieYingPingBean xieYingPingBean) {

    }

    @Override
    public void onHomesuccess(XiaDanBean xiaDanBean) {
        //吐司下单成功
        if (xiaDanBean.getStatus().equals("0000")) {
            Toast.makeText(this, "" + xiaDanBean.getMessage(), Toast.LENGTH_SHORT).show();
            orderId = xiaDanBean.getOrderId();

            btnXiadan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  //  btnXiadan.setVisibility(View.INVISIBLE);
                    paybck.setVisibility(View.VISIBLE);
                  //  payBtn.setVisibility(View.VISIBLE);
                 //   payBtn.setText("￥" + result.getPrice());
                    wechat.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            wechat.setChecked(true);
                            zfb.setChecked(false);
                            id = 1;
                            btnXiadan.setText("微信支付￥ " + money);
                        }
                    });
                    zfb.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            zfb.setChecked(true);
                            wechat.setChecked(false);
                            id = 2;
                            btnXiadan.setText("支付宝支付￥ " + money);
                        }
                    });

                    btnXiadan.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mPresenter.getPresenterzhifu(userId, s, id, orderId);
                        }
                    });
                }
            });


        } else {
            Toast.makeText(this, "下单失败", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onHomesuccess(ZhiFuBean zhiFuBean) {
        if (zhiFuBean.getStatus().equals("0000")) {
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

        }

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
    @Override
    public void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
        //yuGaoAdapter.notifyDataSetChanged();
    }


    public static String MD5(String sourceStr) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return result;
    }

    @OnClick(R.id.goupiao_fanhui)
    public void onViewClicked() {
        finish();
    }


/*    @Subscribe(threadMode = ThreadMode.POSTING,sticky = true)
    public void setinit(XuanZuoXinXiBean xuanZuoXinXiBean){

    }*/

   /* @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }*/

}
