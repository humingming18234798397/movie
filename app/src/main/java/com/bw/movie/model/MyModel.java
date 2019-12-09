package com.bw.movie.model;


/*
 *@auther:胡明明
 *@Date: 2019/11/30
 *@Time:11:54
 *@Description:${DESCRIPTION}
 **/

import com.bw.movie.app.ApiService;
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
import com.bw.movie.frag.guanzhu.GuanzhuMovieFrag;
import com.bw.movie.utils.CommonObserver;
import com.bw.movie.utils.CommonSchedulers;
import com.bw.movie.utils.RetrofitManager;

import okhttp3.MultipartBody;

public class MyModel implements MyContract.Imodel {
    @Override
    public void getModeldaifukuan(Integer userId, String sessionId, Integer page, Integer count, Integer status, ImodelCallback imodelCallback) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getdaifukuan(userId, sessionId, page, count, status)
                .compose(CommonSchedulers.<DaiFuKuanBean>io2main())
                .subscribe(new CommonObserver<DaiFuKuanBean>() {
                    @Override
                    public void onNext(DaiFuKuanBean daiFuKuanBean) {
                        imodelCallback.onMysuccess(daiFuKuanBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallback.onMyFaiure(e);
                    }
                });
    }

    @Override
    public void getModelyifukuan(Integer userId, String sessionId, Integer page, Integer count, Integer status, ImodelCallback imodelCallback) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getyifukuan(userId, sessionId, page, count, status)
                .compose(CommonSchedulers.<YiFuKuanBean>io2main())
                .subscribe(new CommonObserver<YiFuKuanBean>() {
                    @Override
                    public void onNext(YiFuKuanBean yiFuKuanBean) {
                        imodelCallback.onMysuccess(yiFuKuanBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallback.onMyFaiure(e);
                    }
                });
    }

    @Override
    public void getModeldianying(Integer userId, String sessionId, Integer page, Integer count, ImodelCallback imodelCallback) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getdianying(userId, sessionId, page, count)
                .compose(CommonSchedulers.<MovieBean>io2main())
                .subscribe(new CommonObserver<MovieBean>() {
                    @Override
                    public void onNext(MovieBean movieBean) {
                        imodelCallback.onMysuccess(movieBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallback.onMyFaiure(e);
                    }
                });
    }

    @Override
    public void getModelchayingping(Integer userId, String sessionId, String longitude, String latitude, Integer page, Integer count, ImodelCallback imodelCallback) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getchayingping(userId, sessionId, longitude, latitude, page, count)
                .compose(CommonSchedulers.<ChaYingPingBean>io2main())
                .subscribe(new CommonObserver<ChaYingPingBean>() {
                    @Override
                    public void onNext(ChaYingPingBean chaYingPingBean) {
                        imodelCallback.onMysuccess(chaYingPingBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallback.onMyFaiure(e);
                    }
                });
    }

    @Override
    public void getModelguanzhumovie(Integer userId, String sessionId, Integer page, Integer count, ImodelCallback imodelCallback) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getguanzhumovie(userId, sessionId, page, count)
                .compose(CommonSchedulers.<GuanZhuMovie>io2main())
                .subscribe(new CommonObserver<GuanZhuMovie>() {
                    @Override
                    public void onNext(GuanZhuMovie guanZhuMovie) {
                        imodelCallback.onMysuccess(guanZhuMovie);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallback.onMyFaiure(e);
                    }
                });
    }

    @Override
    public void getModelguanzhuyingyuan(Integer userId, String sessionId, Integer page, Integer count, ImodelCallback imodelCallback) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getguanzhuyingyuan(userId, sessionId, page, count)
                .compose(CommonSchedulers.<GuanZhuYingYuan>io2main())
                .subscribe(new CommonObserver<GuanZhuYingYuan>() {
                    @Override
                    public void onNext(GuanZhuYingYuan guanZhuYingYuan) {
                        imodelCallback.onMysuccess(guanZhuYingYuan);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallback.onMyFaiure(e);
                    }
                });
    }

    @Override
    public void getModeldingdan(Integer userId, String sessionId, String orderId, ImodelCallback imodelCallback) {
        RetrofitManager.getInstance().create(ApiService.class).getdingdan(userId, sessionId, orderId)
                .compose(CommonSchedulers.<DingDanBean>io2main())
                .subscribe(new CommonObserver<DingDanBean>() {
                    @Override
                    public void onNext(DingDanBean dingDanBean) {
                        imodelCallback.onMysuccess(dingDanBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallback.onMyFaiure(e);
                    }
                });
    }

    @Override
    public void getModelzhifu(Integer userId, String sessionId, Integer payType, String orderId, ImodelCallback imodelCallback) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getzhifu(userId, sessionId, payType, orderId)
                .compose(CommonSchedulers.<ZhiFuBean>io2main())
                .subscribe(new CommonObserver<ZhiFuBean>() {
                    @Override
                    public void onNext(ZhiFuBean zhiFuBean) {
                        imodelCallback.onMysuccess(zhiFuBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallback.onMyFaiure(e);
                    }
                });
    }

    @Override
    public void getModelyuyue(Integer userId, String sessionId, ImodelCallback imodelCallback) {
        RetrofitManager.getInstance().create(ApiService.class).getyuyue(userId, sessionId)
                .compose(CommonSchedulers.<YuYueBean>io2main())
                .subscribe(new CommonObserver<YuYueBean>() {
                    @Override
                    public void onNext(YuYueBean yuYueBean) {
                        imodelCallback.onMysuccess(yuYueBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                            imodelCallback.onMyFaiure(e);
                    }
                });
    }

    @Override
    public void getModelmessage(Integer userId, String sessionId, Integer page, Integer count, ImodelCallback imodelCallback) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getxitongmessage(userId, sessionId, page, count)
                .compose(CommonSchedulers.<XiTongMessage>io2main())
                .subscribe(new CommonObserver<XiTongMessage>() {
                    @Override
                    public void onNext(XiTongMessage xiTongMessage) {
                        imodelCallback.onMysuccess(xiTongMessage);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallback.onMyFaiure(e);
                    }
                });
    }

    @Override
    public void getModelmoviepiao(Integer userId, String sessionId, ImodelCallback imodelCallback) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getmoviepiao(userId, sessionId)
                .compose(CommonSchedulers.<MoviePiaoBean>io2main())
                .subscribe(new CommonObserver<MoviePiaoBean>() {
                    @Override
                    public void onNext(MoviePiaoBean moviePiaoBean) {
                        imodelCallback.onMysuccess(moviePiaoBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallback.onMyFaiure(e);
                    }
                });
    }

    @Override
    public void getModelerweima(Integer userId, String sessionId, Integer recordId, ImodelCallback imodelCallback) {
        RetrofitManager.getInstance().create(ApiService.class).getmovieerweima(userId,sessionId,recordId)
                .compose(CommonSchedulers.<ErWeiMaBean>io2main())
                .subscribe(new CommonObserver<ErWeiMaBean>() {
                    @Override
                    public void onNext(ErWeiMaBean erWeiMaBean) {
                        imodelCallback.onMysuccess(erWeiMaBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallback.onMyFaiure(e);
                    }
                });
    }

    @Override
    public void getModelfankui(Integer userId, String sessionId, String content, ImodelCallback imodelCallback) {
        RetrofitManager.getInstance().create(ApiService.class).getfanmkui(userId, sessionId, content)
                .compose(CommonSchedulers.<FanKuiBean>io2main())
                .subscribe(new CommonObserver<FanKuiBean>() {
                    @Override
                    public void onNext(FanKuiBean fanKuiBean) {
                        imodelCallback.onMysuccess(fanKuiBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallback.onMyFaiure(e);
                    }
                });
    }

    @Override
    public void getModeloldmovie(Integer userId, String sessionId, ImodelCallback imodelCallback) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getoldmovel(userId,sessionId)
                .compose(CommonSchedulers.<OldMovieBean>io2main())
                .subscribe(new CommonObserver<OldMovieBean>() {
                    @Override
                    public void onNext(OldMovieBean oldMovieBean) {
                        imodelCallback.onMysuccess(oldMovieBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                            imodelCallback.onMyFaiure(e);
                    }
                });
    }

    @Override
    public void getModeltouxiang(Integer userId, String sessionId, MultipartBody.Part image, ImodelCallback imodelCallback) {
        RetrofitManager.getInstance().create(ApiService.class)
                .gettouxiang(userId, sessionId, image)
                .compose(CommonSchedulers.<TouXiangBean>io2main())
                .subscribe(new CommonObserver<TouXiangBean>() {
                    @Override
                    public void onNext(TouXiangBean touXiangBean) {
                      imodelCallback.onMysuccess(touXiangBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallback.onMyFaiure(e);
                    }
                });
    }

    @Override
    public void getModelyonghu(Integer userId, String sessionId, ImodelCallback imodelCallback) {
        RetrofitManager.getInstance().create(ApiService.class).getyonghu(userId, sessionId)
                .compose(CommonSchedulers.<YongHuBean>io2main())
                .subscribe(new CommonObserver<YongHuBean>() {
                    @Override
                    public void onNext(YongHuBean yongHuBean) {
                        imodelCallback.onMysuccess(yongHuBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallback.onMyFaiure(e);
                    }
                });
    }

    @Override
    public void getModelpwd(Integer userId, String sessionId, String oldPwd, String newPwd, String newPwd2, ImodelCallback imodelCallback) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getpwd(userId, sessionId, oldPwd, newPwd, newPwd2)
                .compose(CommonSchedulers.<PwdBean>io2main())
                .subscribe(new CommonObserver<PwdBean>() {
                    @Override
                    public void onNext(PwdBean pwdBean) {
                      imodelCallback.onMysuccess(pwdBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallback.onMyFaiure(e);
                    }
                });
    }

    @Override
    public void getModelphone(Integer userId, String sessionId, String phone, ImodelCallback imodelCallback) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getphone(userId, sessionId, phone)
                .compose(CommonSchedulers.<PhoneBean>io2main())
                .subscribe(new CommonObserver<PhoneBean>() {
                    @Override
                    public void onNext(PhoneBean phoneBean) {
                        imodelCallback.onMysuccess(phoneBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                            imodelCallback.onMyFaiure(e);
                    }
                });
    }

    @Override
    public void getModelriqi(Integer userId, String sessionId, String birthday, ImodelCallback imodelCallback) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getBirth(userId,sessionId,birthday)
                .compose(CommonSchedulers.<BirthBean>io2main())
                .subscribe(new CommonObserver<BirthBean>() {
                    @Override
                    public void onNext(BirthBean birthBean) {
                      imodelCallback.onMysuccess(birthBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallback.onMyFaiure(e);
                    }
                });
    }

}
