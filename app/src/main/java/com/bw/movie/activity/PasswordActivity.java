package com.bw.movie.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import com.bw.movie.utils.EncryptUtil;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PasswordActivity extends BaseActivity<MyPresenter> implements MyContract.Iview {

    @BindView(R.id.shezhi_fanhui)
    SimpleDraweeView shezhiFanhui;
    @BindView(R.id.pwd_oldpwd)
    EditText pwdOldpwd;
    @BindView(R.id.pwd_newpwd)
    EditText pwdNewpwd;
    @BindView(R.id.pwd_newpwd2)
    EditText pwdNewpwd2;
    @BindView(R.id.pwd_buttton)
    Button pwdButtton;
    private SharedPreferences sp;
    private int userId;
    private String s;
    @Override
    protected MyPresenter providePresenter() {
        return new MyPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_password;
    }

    @Override
    protected void initData() {
        super.initData();
        sp = getSharedPreferences("movie", Context.MODE_PRIVATE);
        userId = sp.getInt("u", 0);
        s = sp.getString("s", null);
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
        if (pwdBean.getStatus().equals("0000")){
            Toast.makeText(this, pwdBean.getMessage(), Toast.LENGTH_SHORT).show();
            finish();
        }else{
            Toast.makeText(this, pwdBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
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

    @OnClick({R.id.shezhi_fanhui, R.id.pwd_buttton})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.shezhi_fanhui:
                finish();
                break;
            case R.id.pwd_buttton:
                //获取输入框的值
                String oldPwd = pwdOldpwd.getText().toString().trim();
                String newPwd = pwdNewpwd.getText().toString().trim();
                String newPwd2 = pwdNewpwd2.getText().toString().trim();
                //加密后
                String oldencrypt = EncryptUtil.encrypt(oldPwd);
                String newencrypt = EncryptUtil.encrypt(newPwd);
                String new2encrypt = EncryptUtil.encrypt(newPwd2);
                if (oldencrypt.isEmpty() && newencrypt.isEmpty()&&new2encrypt.isEmpty()){
                    Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
                }else{
                    if (newencrypt.equals(new2encrypt)){
                        mPresenter.getPresenterpwd(userId,s,oldencrypt,newencrypt,new2encrypt);
                    }else{
                        Toast.makeText(this, "密码不一致", Toast.LENGTH_SHORT).show();
                    }
                }

                break;
        }
    }
}
