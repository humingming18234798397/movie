package com.bw.movie.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FanKuiActivity extends BaseActivity<MyPresenter> implements MyContract.Iview {
    @BindView(R.id.feedback_fanhui)
    SimpleDraweeView feedbackFanhui;
    @BindView(R.id.feedback_et_message)
    EditText feedbackEtMessage;
    @BindView(R.id.feedback_btn_tijiao)
    Button feedbackBtnTijiao;
    @BindView(R.id.llone)
    LinearLayout llone;
    @BindView(R.id.yijiantwo_fanhui)
    SimpleDraweeView yijiantwoFanhui;
    @BindView(R.id.rela1)
    RelativeLayout rela1;
    @BindView(R.id.img_vis)
    SimpleDraweeView imgVis;
    @BindView(R.id.tv_success)
    TextView tvSuccess;
    @BindView(R.id.relattwo)
    RelativeLayout relattwo;
    private int userId;
    private String s;
    private SharedPreferences sp;

    @Override
    protected MyPresenter providePresenter() {
        return new MyPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_fan_kui;
    }

    @Override
    protected void initData() {
        super.initData();
        sp = getSharedPreferences("movie", Context.MODE_PRIVATE);
        userId = sp.getInt("u", 0);
        s = sp.getString("s", null);
        // mPresenter.getPresenterfankui(userId,s);
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

    }

    @Override
    public void onMysuccess(ZhiFuBean zhiFuBean) {

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
        if ("0000".equals(fanKuiBean.getStatus())){
            Toast.makeText(this, fanKuiBean.getMessage(), Toast.LENGTH_SHORT).show();
            llone.setVisibility(llone.GONE);
            relattwo.setVisibility(relattwo.VISIBLE);
        }else{
            Toast.makeText(this, fanKuiBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
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

    @OnClick({R.id.feedback_fanhui, R.id.feedback_btn_tijiao, R.id.yijiantwo_fanhui})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.feedback_fanhui:
                finish();
                break;
            case R.id.feedback_btn_tijiao:
                String content = feedbackEtMessage.getText().toString();
                mPresenter.getPresenterfankui(userId,s,content);
                break;
            case R.id.yijiantwo_fanhui:
                finish();
                break;
        }
    }
}
