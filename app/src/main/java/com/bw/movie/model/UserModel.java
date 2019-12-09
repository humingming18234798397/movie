package com.bw.movie.model;


/*
 *@auther:胡明明
 *@Date: 2019/11/11
 *@Time:19:35
 *@Description:${DESCRIPTION}
 **/

import com.bw.movie.app.ApiService;
import com.bw.movie.bean.EmailBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.bean.WXBean;
import com.bw.movie.contract.UserContract;
import com.bw.movie.utils.CommonObserver;
import com.bw.movie.utils.CommonSchedulers;
import com.bw.movie.utils.RetrofitManager;

public class UserModel implements UserContract.Imodel {
    //发送邮箱
    @Override
    public void getModelEmail(String email, ImodelCallback imodelCallback) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getemail(email)
                .compose(CommonSchedulers.<EmailBean>io2main())
                .subscribe(new CommonObserver<EmailBean>() {
                    @Override
                    public void onNext(EmailBean emailBean) {
                        imodelCallback.onUserSuccess(emailBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallback.onUserFaiure(e);
                    }
                });
    }
//注册
    @Override
    public void getModelRegister(String nickName, String pwd, String email, String code, ImodelCallback imodelCallback) {
                RetrofitManager.getInstance().create(ApiService.class)
                        .getRegister(nickName, pwd, email, code)
                        .compose(CommonSchedulers.<RegisterBean>io2main())
                        .subscribe(new CommonObserver<RegisterBean>() {
                            @Override
                            public void onNext(RegisterBean registerBean) {
                                imodelCallback.onUserSuccess(registerBean);
                            }

                            @Override
                            public void onError(Throwable e) {
                                imodelCallback.onUserFaiure(e);
                            }
                        });
    }
//登录
    @Override
    public void getModelLogin(String email, String pwd, ImodelCallback imodelCallback) {
            RetrofitManager.getInstance().create(ApiService.class)
                    .getLogin(email, pwd)
                    .compose(CommonSchedulers.<LoginBean>io2main())
                    .subscribe(new CommonObserver<LoginBean>() {
                        @Override
                        public void onNext(LoginBean loginBean) {
                            imodelCallback.onUserSuccess(loginBean);
                        }

                        @Override
                        public void onError(Throwable e) {
                                imodelCallback.onUserFaiure(e);
                        }
                    });
    }

    @Override
    public void getModelweixin(String code, ImodelCallback imodelCallback) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getweixin(code)
                .compose(CommonSchedulers.<WXBean>io2main())
                .subscribe(new CommonObserver<WXBean>() {
                    @Override
                    public void onNext(WXBean wxBean) {
                        imodelCallback.onUserSuccess(wxBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallback.onUserFaiure(e);
                    }
                });
    }
}
