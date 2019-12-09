package com.bw.movie.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.presenter.MyPresenter;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SheZhiActivity extends BaseActivity<MyPresenter> {

    @BindView(R.id.shezhi_fanhui)
    SimpleDraweeView shezhiFanhui;
    @BindView(R.id.shezhi_qingchu)
    LinearLayout shezhiQingchu;
    @BindView(R.id.shezhi_gengxin)
    LinearLayout shezhiGengxin;
    @BindView(R.id.shezhi_chongzhipassword)
    LinearLayout shezhiChongzhipassword;
    @BindView(R.id.shezhi_button)
    Button shezhiButton;
    @BindView(R.id.mysetting_number)
    TextView mysettingNumber;
    private SharedPreferences sp;

    @Override
    protected MyPresenter providePresenter() {
        return new MyPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_she_zhi;
    }

    @Override
    protected void initData() {
        super.initData();
        sp = getSharedPreferences("movie", Context.MODE_PRIVATE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.shezhi_fanhui, R.id.shezhi_qingchu, R.id.shezhi_gengxin, R.id.shezhi_chongzhipassword, R.id.shezhi_button})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.shezhi_fanhui:
                finish();
                break;
            case R.id.shezhi_qingchu:
                mysettingNumber.setText(0+"m");
                break;
            case R.id.shezhi_gengxin:
                startActivity(new Intent(SheZhiActivity.this, BanBenActivity.class));
                break;
            case R.id.shezhi_chongzhipassword:
                    Intent intent = new Intent(SheZhiActivity.this,PasswordActivity.class);
                    startActivity(intent);
                break;
            case R.id.shezhi_button:
                sp.edit().clear().commit();
                finish();
                break;
        }
    }
}
