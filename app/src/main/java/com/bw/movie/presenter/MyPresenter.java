package com.bw.movie.presenter;


/*
 *@auther:胡明明
 *@Date: 2019/11/30
 *@Time:11:58
 *@Description:${DESCRIPTION}
 **/


import android.widget.Toast;

import com.bw.movie.app.App;
import com.bw.movie.app.Constantes;
import com.bw.movie.base.BasePresenter;
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
import com.bw.movie.model.MyModel;

import okhttp3.MultipartBody;

public class MyPresenter extends BasePresenter<MyContract.Iview> implements MyContract.IPresenter {

    private MyModel myModel;

    @Override
    protected void initModel() {
        myModel = new MyModel();
    }

    @Override
    public void getPresenterdaifukuan(Integer userId, String sessionId, Integer page, Integer count, Integer status) {
            myModel.getModeldaifukuan(userId, sessionId, page, count, status, new MyContract.Imodel.ImodelCallback() {
                @Override
                public void onMysuccess(DaiFuKuanBean daiFuKuanBean) {
                    //pa判断是否挂载
                    if (isViewAttached()){
                        if (daiFuKuanBean.getStatus().equals(Constantes.SUCCESS_CODE)&&daiFuKuanBean!=null){
                            getView().onMysuccess(daiFuKuanBean);
                        }else{
                            getView().onMyFaiure(new Exception("服务器异常"));
                            Toast.makeText(App.getsAppContext(), daiFuKuanBean.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
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

                }

                @Override
                public void onMysuccess(PhoneBean phoneBean) {

                }

                @Override
                public void onMysuccess(BirthBean birthBean) {

                }

                @Override
                public void onMyFaiure(Throwable e) {
                        getView().onMyFaiure(e);
                }
            });
    }

    @Override
    public void getPresenteryifukuan(Integer userId, String sessionId, Integer page, Integer count, Integer status) {
        myModel.getModelyifukuan(userId, sessionId, page, count, status, new MyContract.Imodel.ImodelCallback() {
            @Override
            public void onMysuccess(DaiFuKuanBean daiFuKuanBean) {

            }

            @Override
            public void onMysuccess(YiFuKuanBean yiFuKuanBean) {
                //pa判断是否挂载
                if (isViewAttached()){
                    if (yiFuKuanBean.getStatus().equals(Constantes.SUCCESS_CODE)&&yiFuKuanBean!=null){
                        getView().onMysuccess(yiFuKuanBean);
                    }else{
                        getView().onMyFaiure(new Exception("服务器异常"));
                        Toast.makeText(App.getsAppContext(), yiFuKuanBean.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
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

            }

            @Override
            public void onMysuccess(PhoneBean phoneBean) {

            }

            @Override
            public void onMysuccess(BirthBean birthBean) {

            }

            @Override
            public void onMyFaiure(Throwable e) {
                getView().onMyFaiure(e);
            }
        });
    }

    @Override
    public void getPresenterdianying(Integer userId, String sessionId, Integer page, Integer count) {
        myModel.getModeldianying(userId, sessionId, page, count, new MyContract.Imodel.ImodelCallback() {
            @Override
            public void onMysuccess(DaiFuKuanBean daiFuKuanBean) {

            }

            @Override
            public void onMysuccess(YiFuKuanBean yiFuKuanBean) {

            }

            @Override
            public void onMysuccess(MovieBean movieBean) {
                //pa判断是否挂载
                if (isViewAttached()){
                    if (movieBean.getStatus().equals(Constantes.SUCCESS_CODE)&&movieBean!=null){
                        getView().onMysuccess(movieBean);
                    }else{
                        getView().onMyFaiure(new Exception("服务器异常"));
                        Toast.makeText(App.getsAppContext(), movieBean.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
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

            }

            @Override
            public void onMysuccess(PhoneBean phoneBean) {

            }

            @Override
            public void onMysuccess(BirthBean birthBean) {

            }

            @Override
            public void onMyFaiure(Throwable e) {
                    getView().onMyFaiure(e);
            }
        });
    }

    @Override
    public void getPresenterchayingping(Integer userId, String sessionId, String longitude, String latitude, Integer page, Integer count) {
        myModel.getModelchayingping(userId, sessionId, longitude, latitude, page, count, new MyContract.Imodel.ImodelCallback() {
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
                //pa判断是否挂载
                if (isViewAttached()){
                    if (chaYingPingBean.getStatus().equals(Constantes.SUCCESS_CODE)&&chaYingPingBean!=null){
                        getView().onMysuccess(chaYingPingBean);
                    }else{
                        getView().onMyFaiure(new Exception("服务器异常"));
                        Toast.makeText(App.getsAppContext(), chaYingPingBean.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
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

            }

            @Override
            public void onMysuccess(PhoneBean phoneBean) {

            }

            @Override
            public void onMysuccess(BirthBean birthBean) {

            }

            @Override
            public void onMyFaiure(Throwable e) {
                getView().onMyFaiure(e);
            }
        });
    }

    @Override
    public void getPresenterguanzhumovie(Integer userId, String sessionId, Integer page, Integer count) {
        myModel.getModelguanzhumovie(userId, sessionId, page, count, new MyContract.Imodel.ImodelCallback() {
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
                //pa判断是否挂载
                if (isViewAttached()){
                    if (guanZhuMovie.getStatus().equals(Constantes.SUCCESS_CODE)&&guanZhuMovie!=null){
                        getView().onMysuccess(guanZhuMovie);
                    }else{
                        getView().onMyFaiure(new Exception("服务器异常"));
                        Toast.makeText(App.getsAppContext(), guanZhuMovie.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
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

            }

            @Override
            public void onMysuccess(PhoneBean phoneBean) {

            }

            @Override
            public void onMysuccess(BirthBean birthBean) {

            }

            @Override
            public void onMyFaiure(Throwable e) {
                getView().onMyFaiure(e);
            }
        });
    }

    @Override
    public void getPresenterguanzhuyingyuan(Integer userId, String sessionId, Integer page, Integer count) {
            myModel.getModelguanzhuyingyuan(userId, sessionId, page, count, new MyContract.Imodel.ImodelCallback() {
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
                        //pa判断是否挂载
                    if (isViewAttached()){
                        if (guanZhuYingYuan.getStatus().equals(Constantes.SUCCESS_CODE)&&guanZhuYingYuan!=null){
                            getView().onMysuccess(guanZhuYingYuan);
                        }else{
                            getView().onMyFaiure(new Exception("服务器异常"));
                            Toast.makeText(App.getsAppContext(), guanZhuYingYuan.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
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

                }

                @Override
                public void onMysuccess(PhoneBean phoneBean) {

                }

                @Override
                public void onMysuccess(BirthBean birthBean) {

                }

                @Override
                public void onMyFaiure(Throwable e) {
                    getView().onMyFaiure(e);
                }
            });
    }

    @Override
    public void getPresenterdingdan(Integer userId, String sessionId, String orderId) {
        myModel.getModeldingdan(userId, sessionId, orderId, new MyContract.Imodel.ImodelCallback() {
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
                //pa判断是否挂载
                if (isViewAttached()){
                    if (dingDanBean.getStatus().equals(Constantes.SUCCESS_CODE)&&dingDanBean!=null){
                        getView().onMysuccess(dingDanBean);
                    }else{
                        getView().onMyFaiure(new Exception("服务器异常"));
                        Toast.makeText(App.getsAppContext(), dingDanBean.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
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

            }

            @Override
            public void onMysuccess(PhoneBean phoneBean) {

            }

            @Override
            public void onMysuccess(BirthBean birthBean) {

            }

            @Override
            public void onMyFaiure(Throwable e) {
                    getView().onMyFaiure(e);
            }
        });
    }

    @Override
    public void getPresenterzhifu(Integer userId, String sessionId, Integer payType, String orderId) {
        myModel.getModelzhifu(userId, sessionId, payType, orderId, new MyContract.Imodel.ImodelCallback() {
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
                //pa判断是否挂载
                if (isViewAttached()){
                    if (zhiFuBean.getStatus().equals(Constantes.SUCCESS_CODE)&&zhiFuBean!=null){
                        getView().onMysuccess(zhiFuBean);
                    }else{
                        getView().onMyFaiure(new Exception("服务器异常"));
                        Toast.makeText(App.getsAppContext(), zhiFuBean.getMessage(), Toast.LENGTH_SHORT).show();
                    }
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
                getView().onMyFaiure(e);
            }
        });
    }

    @Override
    public void getPresenteryuyue(Integer userId, String sessionId) {
        myModel.getModelyuyue(userId, sessionId, new MyContract.Imodel.ImodelCallback() {
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
                //pa判断是否挂载
                if (isViewAttached()){
                    if (yuYueBean.getStatus().equals(Constantes.SUCCESS_CODE)&&yuYueBean!=null){
                        getView().onMysuccess(yuYueBean);
                    }else{
                        getView().onMyFaiure(new Exception("服务器异常"));
                        Toast.makeText(App.getsAppContext(), yuYueBean.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
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
                getView().onMyFaiure(e);
            }
        });
    }

    @Override
    public void getPresentermessage(Integer userId, String sessionId, Integer page, Integer count) {
        myModel.getModelmessage(userId, sessionId, page, count, new MyContract.Imodel.ImodelCallback() {
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
                //pa判断是否挂载
                if (isViewAttached()){
                    if (xiTongMessage.getStatus().equals(Constantes.SUCCESS_CODE)&&xiTongMessage!=null){
                        getView().onMysuccess(xiTongMessage);
                    }else{
                        getView().onMyFaiure(new Exception("服务器异常"));
                        Toast.makeText(App.getsAppContext(), xiTongMessage.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
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
                    getView().onMyFaiure(e);
            }
        });
    }

    @Override
    public void getPresentermoviepiao(Integer userId, String sessionId) {
        myModel.getModelmoviepiao(userId, sessionId, new MyContract.Imodel.ImodelCallback() {
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
//pa判断是否挂载
                if (isViewAttached()){
                    if (moviePiaoBean.getStatus().equals(Constantes.SUCCESS_CODE)&&moviePiaoBean!=null){
                        getView().onMysuccess(moviePiaoBean);
                    }else{
                        getView().onMyFaiure(new Exception("服务器异常"));
                        Toast.makeText(App.getsAppContext(), moviePiaoBean.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
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
                    getView().onMyFaiure(e);
            }
        });
    }

    @Override
    public void getPresentererweima(Integer userId, String sessionId, Integer recordId) {
        myModel.getModelerweima(userId, sessionId, recordId, new MyContract.Imodel.ImodelCallback() {
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
                //pa判断是否挂载
                if (isViewAttached()){
                    if (erWeiMaBean.getStatus().equals(Constantes.SUCCESS_CODE)&&erWeiMaBean!=null){
                        getView().onMysuccess(erWeiMaBean);
                    }else{
                        getView().onMyFaiure(new Exception("服务器异常"));
                    }
                }
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
                getView().onMyFaiure(e);
        }
        });
    }

    @Override
    public void getPresenterfankui(Integer userId, String sessionId, String content) {
        myModel.getModelfankui(userId, sessionId, content, new MyContract.Imodel.ImodelCallback() {
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
                //pa判断是否挂载
                if (isViewAttached()){
                    if (fanKuiBean.getStatus().equals(Constantes.SUCCESS_CODE)&&fanKuiBean!=null){
                        getView().onMysuccess(fanKuiBean);
                    }else{
                        getView().onMyFaiure(new Exception("服务器异常"));
                        Toast.makeText(App.getsAppContext(), fanKuiBean.getMessage(), Toast.LENGTH_SHORT).show();
                    }
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
                getView().onMyFaiure(e);
            }
        });
    }

    @Override
    public void getPresenteroldmovie(Integer userId, String sessionId) {
        myModel.getModeloldmovie(userId, sessionId, new MyContract.Imodel.ImodelCallback() {
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
                //pa判断是否挂载
                if (isViewAttached()){
                    if (oldMovieBean.getStatus().equals(Constantes.SUCCESS_CODE)&&oldMovieBean!=null){
                        getView().onMysuccess(oldMovieBean);
                    }else{
                        getView().onMyFaiure(new Exception("服务器异常"));
                        Toast.makeText(App.getsAppContext(), oldMovieBean.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
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
                getView().onMyFaiure(e);
            }
        });
    }

    @Override
    public void getPresentertouxiang(Integer userId, String sessionId, MultipartBody.Part image) {
        myModel.getModeltouxiang(userId, sessionId, image, new MyContract.Imodel.ImodelCallback() {
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
                //pa判断是否挂载
                if (isViewAttached()){
                    if (touXiangBean.getStatus().equals(Constantes.SUCCESS_CODE)&&touXiangBean!=null){
                        getView().onMysuccess(touXiangBean);
                    }else{
                        getView().onMyFaiure(new Exception("服务器异常"));
                        Toast.makeText(App.getsAppContext(), touXiangBean.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
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
                getView().onMyFaiure(e);
            }
        });
    }

    @Override
    public void getPresenteryonghu(Integer userId, String sessionId) {
        myModel.getModelyonghu(userId, sessionId, new MyContract.Imodel.ImodelCallback() {
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
//pa判断是否挂载
                if (isViewAttached()){
                    if (yongHuBean.getStatus().equals(Constantes.SUCCESS_CODE)&&yongHuBean!=null){
                        getView().onMysuccess(yongHuBean);
                    }else{
                        getView().onMyFaiure(new Exception("服务器异常"));
                        Toast.makeText(App.getsAppContext(), yongHuBean.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
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
                getView().onMyFaiure(e);
            }
        });
    }

    @Override
    public void getPresenterpwd(Integer userId, String sessionId, String oldPwd, String newPwd, String newPwd2) {
        myModel.getModelpwd(userId, sessionId, oldPwd, newPwd, newPwd2, new MyContract.Imodel.ImodelCallback() {
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
                    //pa判断是否挂载
                if (isViewAttached()){
                    if (pwdBean.getStatus().equals(Constantes.SUCCESS_CODE)&&pwdBean!=null){
                        getView().onMysuccess(pwdBean);
                    }else{
                        getView().onMyFaiure(new Exception("服务器异常"));
                        Toast.makeText(App.sContext, pwdBean.getMessage(), Toast.LENGTH_SHORT).show();
                    }
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
                getView().onMyFaiure(e);
            }
        });
    }

    @Override
    public void getPresenterphone(Integer userId, String sessionId, String phone) {
            myModel.getModelphone(userId, sessionId, phone, new MyContract.Imodel.ImodelCallback() {
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

                }

                @Override
                public void onMysuccess(PhoneBean phoneBean) {
                    //pa判断是否挂载
                    if (isViewAttached()){
                        if (phoneBean.getStatus().equals(Constantes.SUCCESS_CODE)&&phoneBean!=null){
                            getView().onMysuccess(phoneBean);
                        }else{
                            getView().onMyFaiure(new Exception("服务器异常"));
                            Toast.makeText(App.getsAppContext(), phoneBean.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onMysuccess(BirthBean birthBean) {

                }

                @Override
                public void onMyFaiure(Throwable e) {
                    getView().onMyFaiure(e);
                }
            });
    }

    @Override
    public void getPresenterriqi(Integer userId, String sessionId, String birthday) {
        myModel.getModelriqi(userId, sessionId, birthday, new MyContract.Imodel.ImodelCallback() {
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

            }

            @Override
            public void onMysuccess(PhoneBean phoneBean) {

            }

            @Override
            public void onMysuccess(BirthBean birthBean) {
//pa判断是否挂载
                if (isViewAttached()){
                    if (birthBean.getStatus().equals(Constantes.SUCCESS_CODE)&&birthBean!=null){
                        getView().onMysuccess(birthBean);
                    }else{
                        getView().onMyFaiure(new Exception("服务器异常"));
                        Toast.makeText(App.getsAppContext(), birthBean.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onMyFaiure(Throwable e) {
                getView().onMyFaiure(e);
            }
        });
    }
}
