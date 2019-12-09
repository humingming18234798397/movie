package com.bw.movie.contract;


import com.bw.movie.base.IBaseView;
import com.bw.movie.bean.EmailBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.bean.WXBean;

import retrofit2.http.Query;

/*
 *@auther:胡明明
 *@Date: 2019/11/11
 *@Time:19:27
 *@Description:${DESCRIPTION}
 **/
//denglu登录注册契约类
public interface UserContract {
    interface Iview extends IBaseView {
        //发送邮箱
        void onUserSuccess(EmailBean emailBean);
        //注册
        void onUserSuccess(RegisterBean registerBean);
        //登录
        void onUserSuccess(LoginBean loginBean);
        void onUserSuccess(WXBean wxBean);
        //失败的方法
        void onUserFaiure(Throwable faiure);
    }
    interface Imodel{
        //发送邮箱
        void getModelEmail(String email,ImodelCallback imodelCallback);
        //注册
        void getModelRegister(String nickName,String pwd,String email,String code,ImodelCallback imodelCallback);
        //登录
        void getModelLogin(String email,String pwd,ImodelCallback imodelCallback);
        void getModelweixin(String code,ImodelCallback imodelCallback);
        interface ImodelCallback{
            void onUserSuccess(EmailBean emailBean);
            void onUserSuccess(RegisterBean registerBean);
            void onUserSuccess(LoginBean loginBean);
            void onUserSuccess(WXBean wxBean);
            void onUserFaiure(Throwable faiure);
        }
    }
    interface Ipresenter{
        //发送邮箱
        void getPresenterEmail(String email);
        //注册
        void getPresenterRegister(String nickName,String pwd,String email,String code);
        //登录
        void getPresenterLogin(String email,String pwd);
        void getPresenterweixin(String code);
    }
}
