package com.bw.movie.model;


/*
 *@auther:胡明明
 *@Date: 2019/11/13
 *@Time:20:18
 *@Description:${DESCRIPTION}
 **/

import android.annotation.SuppressLint;

import com.bw.movie.app.ApiService;
import com.bw.movie.bean.QuBean;
import com.bw.movie.bean.QuLeiBean;
import com.bw.movie.bean.ShiJianBean;
import com.bw.movie.bean.YYXQBean;
import com.bw.movie.bean.YingYuanDianZan;
import com.bw.movie.bean.YingYuanFuJinBean;
import com.bw.movie.bean.YingYuanGuanZhu;
import com.bw.movie.bean.YingYuanPingLun;
import com.bw.movie.bean.YingYuanSouSuoBean;
import com.bw.movie.bean.YingYuanTuiJianBean;
import com.bw.movie.bean.YingYuanWeiGuanZhu;
import com.bw.movie.bean.ZhouQiBean;
import com.bw.movie.contract.YingYuanContract;
import com.bw.movie.frag.fragment.YingYuan_FuJin;
import com.bw.movie.frag.fragment.YingYuan_TuiJian;
import com.bw.movie.utils.CommonObserver;
import com.bw.movie.utils.CommonSchedulers;
import com.bw.movie.utils.RetrofitManager;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class YingYuanModel implements YingYuanContract.Imodel {
    //
    @Override
    public void getModelQuLei(ImodelCallBack imodelCallBack) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getqulei()
                .compose(CommonSchedulers.<QuLeiBean>io2main())
                .subscribe(new CommonObserver<QuLeiBean>() {
                    @Override
                    public void onNext(QuLeiBean quLeiBean) {
                        imodelCallBack.onHomesuccess(quLeiBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallBack.onHomeFaiure(e);
                    }
                });
    }

    @Override
    public void getModelQu(String regionId, ImodelCallBack imodelCallBack) {
            RetrofitManager.getInstance().create(ApiService.class)
                    .getqu(regionId)
                    .compose(CommonSchedulers.<QuBean>io2main())
                    .subscribe(new CommonObserver<QuBean>() {
                        @Override
                        public void onNext(QuBean quBean) {
                            imodelCallBack.onHomesuccess(quBean);
                        }

                        @Override
                        public void onError(Throwable e) {
                            imodelCallBack.onHomeFaiure(e);
                        }
                    });
    }
//影院推荐
    @Override
    public void getModelYingYuantuijian(Integer page, Integer count, ImodelCallBack imodelCallBack) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getYingYuantuijian(page, count)
                .compose(CommonSchedulers.<YingYuanTuiJianBean>io2main())
                .subscribe(new CommonObserver<YingYuanTuiJianBean>() {
                    @Override
                    public void onNext(YingYuanTuiJianBean yingYuanTuiJianBean) {
                        imodelCallBack.onHomesuccess(yingYuanTuiJianBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallBack.onHomeFaiure(e);
                    }
                });
    }
//影院附近
    @Override
    public void getModelYingYuanfujin(String longitude, String latitude, Integer page, Integer count, ImodelCallBack imodelCallBack) {
            RetrofitManager.getInstance().create(ApiService.class)
                    .getYingYuanfujin(longitude, latitude, page, count)
                    .compose(CommonSchedulers.<YingYuanFuJinBean>io2main())
                    .subscribe(new CommonObserver<YingYuanFuJinBean>() {
                        @Override
                        public void onNext(YingYuanFuJinBean yingYuanFuJinBean) {
                            imodelCallBack.onHomesuccess(yingYuanFuJinBean);
                        }

                        @Override
                        public void onError(Throwable e) {
                                imodelCallBack.onHomeFaiure(e);
                        }
                    });
    }
//搜索
    @Override
    public void getModelsousuo(String cinemaName, Integer page, Integer count, ImodelCallBack imodelCallBack) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getchaxun(cinemaName, page, count)
                .compose(CommonSchedulers.<YingYuanSouSuoBean>io2main())
                .subscribe(new CommonObserver<YingYuanSouSuoBean>() {
                    @Override
                    public void onNext(YingYuanSouSuoBean yingYuanSouSuoBean) {
                        imodelCallBack.onHomesuccess(yingYuanSouSuoBean);
                    }
                    @Override
                    public void onError(Throwable e) {
                        imodelCallBack.onHomeFaiure(e);
                    }
                });
    }

    @Override
    public void getModelyyxq(Integer cinemaId, ImodelCallBack imodelCallBack) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getyyxq(cinemaId)
                .compose(CommonSchedulers.<YYXQBean>io2main())
                .subscribe(new Observer<YYXQBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(YYXQBean yyxqBean) {
                            imodelCallBack.onHomesuccess(yyxqBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallBack.onHomeFaiure(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getModelpinglun(Integer cinemaId, Integer page, Integer count, ImodelCallBack imodelCallBack) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getpinglun(cinemaId,page,count)
                .compose(CommonSchedulers.<YingYuanPingLun>io2main())
                .subscribe(new CommonObserver<YingYuanPingLun>() {
                    @Override
                    public void onNext(YingYuanPingLun yingYuanPingLun) {
                        imodelCallBack.onHomesuccess(yingYuanPingLun);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallBack.onHomeFaiure(e);
                    }
                });
    }

    @Override
    public void getModelshijian(ImodelCallBack imodelCallBack) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getshijian()
                .compose(CommonSchedulers.<ShiJianBean>io2main())
                .subscribe(new CommonObserver<ShiJianBean>() {
                    @Override
                    public void onNext(ShiJianBean shiJianBean) {
                        imodelCallBack.onHomesuccess(shiJianBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallBack.onHomeFaiure(e);
                    }
                });
    }

    @Override
    public void getModelzhouqi(Integer cinemaId, Integer page, Integer count, ImodelCallBack imodelCallBack) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getzhouqi(cinemaId, page, count)
                .compose(CommonSchedulers.<ZhouQiBean>io2main())
                .subscribe(new CommonObserver<ZhouQiBean>() {
                    @Override
                    public void onNext(ZhouQiBean zhouQiBean) {
                        imodelCallBack.onHomesuccess(zhouQiBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallBack.onHomeFaiure(e);
                    }
                });
    }

    @Override
    public void getModelyingyuanguanzhu(Integer userId, String sessionId, Integer cinemaId, ImodelCallBack imodelCallBack) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getyingyuanguanzhu(userId, sessionId, cinemaId)
                .compose(CommonSchedulers.<YingYuanGuanZhu>io2main())
                .subscribe(new CommonObserver<YingYuanGuanZhu>() {
                    @Override
                    public void onNext(YingYuanGuanZhu yingYuanGuanZhu) {
                        imodelCallBack.onHomesuccess(yingYuanGuanZhu);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallBack.onHomeFaiure(e);
                    }
                });
    }

    @Override
    public void getModelyingyuanweiguanzhu(Integer userId, String sessionId, Integer cinemaId, ImodelCallBack imodelCallBack) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getyingyuanweiguanzhu(userId, sessionId, cinemaId)
                .compose(CommonSchedulers.<YingYuanWeiGuanZhu>io2main())
                .subscribe(new CommonObserver<YingYuanWeiGuanZhu>() {
                    @Override
                    public void onNext(YingYuanWeiGuanZhu yingYuanWeiGuanZhu) {
                        imodelCallBack.onHomesuccess(yingYuanWeiGuanZhu);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallBack.onHomeFaiure(e);
                    }
                });
    }

    @Override
    public void getModelyingyuandianzan(Integer userId, String sessionId, Integer cinemaId, ImodelCallBack imodelCallBack) {
        RetrofitManager.getInstance().create(ApiService.class).getyingyuandianzan(userId,sessionId,cinemaId)
                .compose(CommonSchedulers.<YingYuanDianZan>io2main())
                .subscribe(new CommonObserver<YingYuanDianZan>() {
                    @Override
                    public void onNext(YingYuanDianZan yingYuanDianZan) {
                       imodelCallBack.onHomesuccess(yingYuanDianZan);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallBack.onHomeFaiure(e);
                    }
                });
    }
}
