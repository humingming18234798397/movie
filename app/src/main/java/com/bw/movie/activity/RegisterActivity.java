package com.bw.movie.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.bean.EmailBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.bean.WXBean;
import com.bw.movie.contract.UserContract;
import com.bw.movie.presenter.UserPresenter;
import com.bw.movie.utils.EncryptUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class RegisterActivity extends BaseActivity<UserPresenter> implements UserContract.Iview {

    @BindView(R.id.edit_name)
    EditText editName;
    @BindView(R.id.edit_email)
    EditText editEmail;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.edit_card)
    EditText editCard;
    @BindView(R.id.button)
    Button button;
    @BindView(R.id.text_view)
    TextView textView;
    @BindView(R.id.but_register)
    Button butRegister;
    private Unbinder bind;

    @Override
    protected UserPresenter providePresenter() {
        return new UserPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initData() {
        super.initData();
        // TODO: add setContentView(...) invocation
        bind = ButterKnife.bind(this);
    }
    //fasong发送邮箱,获取验证码
    @Override
    public void onUserSuccess(EmailBean emailBean) {
       if (emailBean.getStatus().equals("0000")){
           Toast.makeText(this, ""+emailBean.getMessage(), Toast.LENGTH_SHORT).show();
       }else {
           Toast.makeText(this, ""+emailBean.getMessage(), Toast.LENGTH_SHORT).show();
       }
    }
//z注册
    @Override
    public void onUserSuccess(RegisterBean registerBean) {
      if (registerBean.getStatus().equals("0000")){
          Toast.makeText(this, ""+registerBean.getMessage(), Toast.LENGTH_SHORT).show();
          finish();
      }else{
          Toast.makeText(this, ""+registerBean.getMessage(), Toast.LENGTH_SHORT).show();
      }
    }

    @Override
    public void onUserSuccess(LoginBean loginBean) {

    }

    @Override
    public void onUserSuccess(WXBean wxBean) {

    }

    @Override
    public void onUserFaiure(Throwable faiure) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
//注册
    @OnClick({R.id.button, R.id.text_view, R.id.but_register})
    public void onViewClicked(View view) {
       //huoqu 获取密码和邮箱
        String nickName = editName.getText().toString().trim();
        String email = editEmail.getText().toString().trim();
        String pwd = password.getText().toString().trim();
        //密码加密
        String encrypt = EncryptUtil.encrypt(pwd);
        String code = editCard.getText().toString().trim();
        switch (view.getId()) {
            case R.id.button:
                //非空判断
                if (email.isEmpty()){
                    Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
                }else{
                    mPresenter.getPresenterEmail(email);
                }
                break;
            case R.id.text_view:
                //返回
                finish();
                break;
            case R.id.but_register:
                //非空判断
                if (nickName.isEmpty()||email.isEmpty()||encrypt.isEmpty()||code.isEmpty()){
                    Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
                }else{
                    mPresenter.getPresenterRegister(nickName,encrypt,email,code);
                }
                break;
        }
    }
//xiaohui销毁,释放内存
    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
