package com.bw.movie.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.app.App;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.bean.EmailBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.bean.WXBean;
import com.bw.movie.contract.UserContract;
import com.bw.movie.presenter.UserPresenter;
import com.bw.movie.utils.EncryptUtil;
import com.bw.movie.utils.Logger;
import com.bw.movie.wxapi.WXEntryActivity;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class LoginActivity extends BaseActivity<UserPresenter> implements UserContract.Iview {

    @BindView(R.id.edit_email)
    EditText editEmail;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.text_view)
    TextView textView;
    @BindView(R.id.but_login)
    Button butLogin;
    @BindView(R.id.weixin_button)
    Button weixinButton;
    private Unbinder bind;
    private SharedPreferences sp;
    private SharedPreferences.Editor edit;
    private static final String TAG ="LoginActivity" ;
    @Override
    protected UserPresenter providePresenter() {
        return new UserPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initData() {
        super.initData();
        // TODO: add setContentView(...) invocation
        bind = ButterKnife.bind(this);
        sp = getSharedPreferences("movie", Context.MODE_PRIVATE);
        edit = sp.edit();

        editEmail.setText("1257647673@qq.com");
        password.setText("123");

        Intent intent = getIntent();
        String code = intent.getStringExtra("code");
        if (code!=null){
            Logger.i(TAG, "initData: "+code);
            mPresenter.getPresenterweixin(code);
        }

        //weixin微信登录
        weixinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendAuth.Req req = new SendAuth.Req();
                req.scope = "snsapi_userinfo";
                req.state = "wechat_sdk_login";
                App.api.sendReq(req);
            }
        });

    }

    @Override
    public void onUserSuccess(EmailBean emailBean) {

    }

    @Override
    public void onUserSuccess(RegisterBean registerBean) {

    }

    //登录
    @Override
    public void onUserSuccess(LoginBean loginBean) {
        if (loginBean.getStatus().equals("0000")) {
            Toast.makeText(this, "" + loginBean.getMessage(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, Main2Activity.class);
            startActivity(intent);
            edit.putInt("u", loginBean.getResult().getUserId());
            edit.putString("s", loginBean.getResult().getSessionId());
            edit.putString("img", loginBean.getResult().getUserInfo().getHeadPic());
            edit.putString("name", loginBean.getResult().getUserInfo().getNickName());
            edit.putString("email", loginBean.getResult().getUserInfo().getEmail());
            edit.putInt("sex", loginBean.getResult().getUserInfo().getSex());
            edit.commit();
        } else {
            Toast.makeText(this,loginBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUserSuccess(WXBean wxBean) {
        Logger.i(TAG,"onWxloginSuccess: "+wxBean.message);
        if (wxBean.message.equals("登陆成功")){
            Toast.makeText(this, wxBean.message, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this,Main2Activity.class));
            edit.putInt("u", wxBean.result.userId);
            edit.putString("s", wxBean.result.sessionId);
            edit.putString("img", wxBean.result.userInfo.headPic);
            edit.putString("name", wxBean.result.userInfo.nickName);
            edit.putInt("sex",wxBean.result.userInfo.sex);
            edit.commit();

        }else{
            Toast.makeText(this, wxBean.message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUserFaiure(Throwable faiure) {

    }

    //点击登录,注册
    @OnClick({R.id.text_view, R.id.but_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.text_view:
                //注册跳转
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.but_login:
                //huoqu 获取密码和邮箱
                String email = editEmail.getText().toString().trim();
                String pwd = password.getText().toString().trim();
                //密码加密
                String encrypt = EncryptUtil.encrypt(pwd);
                //非空判断
                if (email.isEmpty() && encrypt.isEmpty()) {
                    Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
                } else {

                    mPresenter.getPresenterLogin(email, encrypt);
                }
                break;
        }
    }

    //shifang释放内存,销毁
    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
