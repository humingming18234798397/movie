package com.bw.movie.model;


/*
 *@auther:胡明明
 *@Date: 2019/11/12
 *@Time:18:52
 *@Description:${DESCRIPTION}
 **/

import com.bw.movie.app.ApiService;
import com.bw.movie.bean.GuanZhuBean;
import com.bw.movie.bean.HomeBean;
import com.bw.movie.bean.HomeSouSuoBean;
import com.bw.movie.bean.HomeYuYueBean;
import com.bw.movie.bean.MovieDianZan;
import com.bw.movie.bean.PriceBean;
import com.bw.movie.bean.QuLeiBean;
import com.bw.movie.bean.ReYingBean;
import com.bw.movie.bean.ShangYingBean;
import com.bw.movie.bean.ShiJianBean;
import com.bw.movie.bean.ShiJianYingYuanBean;
import com.bw.movie.bean.WeiGuanZhuBean;
import com.bw.movie.bean.XBannerBean;
import com.bw.movie.bean.XiaDanBean;
import com.bw.movie.bean.XiangQingBean;
import com.bw.movie.bean.XieYingPingBean;
import com.bw.movie.bean.XuanZuoXinXiBean;
import com.bw.movie.bean.YingPingBean;
import com.bw.movie.bean.YingTingBean;
import com.bw.movie.bean.ZhiFuBean;
import com.bw.movie.bean.ZuoWeiHaoBean;
import com.bw.movie.contract.HomeContract;
import com.bw.movie.utils.CommonObserver;
import com.bw.movie.utils.CommonSchedulers;
import com.bw.movie.utils.RetrofitManager;

public class HomeModel implements HomeContract.Imodel {
    //轮播图
    @Override
    public void getModelXbanner(ImodelCallBack imodelCallBack) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getXBanner()
                .compose(CommonSchedulers.<XBannerBean>io2main())
                .subscribe(new CommonObserver<XBannerBean>() {
                    @Override
                    public void onNext(XBannerBean xBannerBean) {
                        imodelCallBack.onHomesuccess(xBannerBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallBack.onHomeFaiure(e);
                    }
                });
    }
        //热映
    @Override
    public void getModelReYing(Integer page, Integer count, ImodelCallBack imodelCallBack) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getReYing(page, count)
                .compose(CommonSchedulers.<ReYingBean>io2main())
                .subscribe(new CommonObserver<ReYingBean>() {
                    @Override
                    public void onNext(ReYingBean reYingBean) {
                        imodelCallBack.onHomesuccess(reYingBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallBack.onHomeFaiure(e);
                    }
                });
    }
//即将上映
    @Override
    public void getModelShangYing(Integer page, Integer count, ImodelCallBack imodelCallBack) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getShangYing(page, count)
                .compose(CommonSchedulers.<ShangYingBean>io2main())
                .subscribe(new CommonObserver<ShangYingBean>() {
                    @Override
                    public void onNext(ShangYingBean shangYingBean) {
                        imodelCallBack.onHomesuccess(shangYingBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallBack.onHomeFaiure(e);
                    }
                });
    }
//热门
    @Override
    public void getModelHome(Integer page, Integer count, ImodelCallBack imodelCallBack) {
        RetrofitManager.getInstance().create(ApiService.class)
                .gethomedata(page, count)
                .compose(CommonSchedulers.<HomeBean>io2main())
                .subscribe(new CommonObserver<HomeBean>() {
                    @Override
                    public void onNext(HomeBean homeBean) {
                        imodelCallBack.onHomesuccess(homeBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallBack.onHomeFaiure(e);
                    }
                });
    }
//详情
    @Override
    public void getModelXiangQing(Integer movieId, ImodelCallBack imodelCallBack) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getXiangQing(movieId)
                .compose(CommonSchedulers.<XiangQingBean>io2main())
                .subscribe(new CommonObserver<XiangQingBean>() {
                    @Override
                    public void onNext(XiangQingBean xiangQingBean) {
                        imodelCallBack.onHomesuccess(xiangQingBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallBack.onHomeFaiure(e);
                    }
                });
    }
//影评
    @Override
    public void getModelYingPing(Integer movieId, Integer page, Integer count, ImodelCallBack imodelCallBack) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getYingPing(movieId, page, count)
                .compose(CommonSchedulers.<YingPingBean>io2main())
                .subscribe(new CommonObserver<YingPingBean>() {
                    @Override
                    public void onNext(YingPingBean yingPingBean) {
                        imodelCallBack.onHomesuccess(yingPingBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallBack.onHomeFaiure(e);
                    }
                });
    }
//搜索
    @Override
    public void getModelSouSuo(String keyword, Integer page, Integer count, ImodelCallBack imodelCallBack) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getSouSuo(keyword, page, count)
                .compose(CommonSchedulers.<HomeSouSuoBean>io2main())
                .subscribe(new CommonObserver<HomeSouSuoBean>() {
                    @Override
                    public void onNext(HomeSouSuoBean homeSouSuoBean) {
                        imodelCallBack.onHomesuccess(homeSouSuoBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallBack.onHomeFaiure(e);
                    }
                });
    }

    @Override
    public void getModelXinXi(Integer movieId, Integer regionId, Integer page, Integer count, ImodelCallBack imodelCallBack) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getxinxi(movieId, regionId, page, count)
                .compose(CommonSchedulers.<XuanZuoXinXiBean>io2main())
                .subscribe(new CommonObserver<XuanZuoXinXiBean>() {
                    @Override
                    public void onNext(XuanZuoXinXiBean xuanZuoXinXiBean) {
                        imodelCallBack.onHomesuccess(xuanZuoXinXiBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                            imodelCallBack.onHomeFaiure(e);
                    }
                });
    }

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
    public void getModelPrice(Integer movieId, Integer page, Integer count, ImodelCallBack imodelCallBack) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getprice(movieId, page, count)
                .compose(CommonSchedulers.<PriceBean>io2main())
                .subscribe(new CommonObserver<PriceBean>() {
                    @Override
                    public void onNext(PriceBean priceBean) {
                        imodelCallBack.onHomesuccess(priceBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallBack.onHomeFaiure(e);
                    }
                });
    }

    @Override
    public void getModelshijianyingyuan(Integer movieId, String date, Integer page, Integer count, ImodelCallBack imodelCallBack) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getshijianyingyuan(movieId,date,page,count)
                .compose(CommonSchedulers.<ShiJianYingYuanBean>io2main())
                .subscribe(new CommonObserver<ShiJianYingYuanBean>() {
                    @Override
                    public void onNext(ShiJianYingYuanBean shiJianYingYuanBean) {
                        imodelCallBack.onHomesuccess(shiJianYingYuanBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                            imodelCallBack.onHomeFaiure(e);
                    }
                });
    }

    @Override
    public void getModelyingting(Integer movieId, Integer cinemaId, ImodelCallBack imodelCallBack) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getyingting(movieId, cinemaId)
                .compose(CommonSchedulers.<YingTingBean>io2main())
                .subscribe(new CommonObserver<YingTingBean>() {
                    @Override
                    public void onNext(YingTingBean yingTingBean) {
                        imodelCallBack.onHomesuccess(yingTingBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallBack.onHomeFaiure(e);
                    }
                });
    }

    @Override
    public void getModelzuowei(Integer hallId, ImodelCallBack imodelCallBack) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getzuowei(hallId)
                .compose(CommonSchedulers.<ZuoWeiHaoBean>io2main())
                .subscribe(new CommonObserver<ZuoWeiHaoBean>() {
                    @Override
                    public void onNext(ZuoWeiHaoBean zuoWeiHaoBean) {
                        imodelCallBack.onHomesuccess(zuoWeiHaoBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallBack.onHomeFaiure(e);
                    }
                });
    }

    @Override
    public void getModelxieyp(Integer userId, String sessionId, Integer movieId, String commentContent, Double score, ImodelCallBack imodelCallBack) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getxieyingping(userId, sessionId, movieId, commentContent, score)
                .compose(CommonSchedulers.<XieYingPingBean>io2main())
                .subscribe(new CommonObserver<XieYingPingBean>() {
                    @Override
                    public void onNext(XieYingPingBean xieYingPingBean) {
                        imodelCallBack.onHomeSuccess(xieYingPingBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallBack.onHomeFaiure(e);
                    }
                });
    }

    @Override
    public void getModelxiadan(Integer userId, String sessionId, String scheduleId, String seat, String sign, ImodelCallBack imodelCallBack) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getxiadan(userId, sessionId, scheduleId, seat, sign)
                .compose(CommonSchedulers.<XiaDanBean>io2main())
                .subscribe(new CommonObserver<XiaDanBean>() {
                    @Override
                    public void onNext(XiaDanBean xiaDanBean) {
                        imodelCallBack.onHomesuccess(xiaDanBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallBack.onHomeFaiure(e);
                    }
                });
    }

    @Override
    public void getModelzhifu(Integer userId, String sessionId, Integer payType, String orderId, ImodelCallBack imodelCallBack) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getzhifu(userId, sessionId, payType, orderId)
                .compose(CommonSchedulers.<ZhiFuBean>io2main())
                .subscribe(new CommonObserver<ZhiFuBean>() {
                    @Override
                    public void onNext(ZhiFuBean zhiFuBean) {
                        imodelCallBack.onHomesuccess(zhiFuBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallBack.onHomeFaiure(e);
                    }
                });
    }

    @Override
    public void getModelguanzhu(Integer userId, String sessionId, Integer movieId, ImodelCallBack imodelCallBack) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getguanzhu(userId, sessionId, movieId)
                .compose(CommonSchedulers.<GuanZhuBean>io2main())
                .subscribe(new CommonObserver<GuanZhuBean>() {
                    @Override
                    public void onNext(GuanZhuBean guanZhuBean) {
                        imodelCallBack.onHomesuccess(guanZhuBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallBack.onHomeFaiure(e);
                    }
                });
    }

    @Override
    public void getModelweiguanzhu(Integer userId, String sessionId, Integer movieId, ImodelCallBack imodelCallBack) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getweiguanzhu(userId, sessionId, movieId)
                .compose(CommonSchedulers.<WeiGuanZhuBean>io2main())
                .subscribe(new CommonObserver<WeiGuanZhuBean>() {
                    @Override
                    public void onNext(WeiGuanZhuBean weiGuanZhuBean) {
                        imodelCallBack.onHomesuccess(weiGuanZhuBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallBack.onHomeFaiure(e);
                    }
                });
    }

    @Override
    public void getModelhomeyuyue(Integer userId, String sessionId, Integer movieId, ImodelCallBack imodelCallBack) {
        RetrofitManager.getInstance().create(ApiService.class)
                .gethomeyuyue(userId,sessionId,movieId)
                .compose(CommonSchedulers.<HomeYuYueBean>io2main())
                .subscribe(new CommonObserver<HomeYuYueBean>() {
                    @Override
                    public void onNext(HomeYuYueBean homeYuYueBean) {
                        imodelCallBack.onHomesuccess(homeYuYueBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                            imodelCallBack.onHomeFaiure(e);
                    }
                });
    }

    @Override
    public void getModeldianzan(Integer userId, String sessionId, Integer commentId, ImodelCallBack imodelCallBack) {
        RetrofitManager.getInstance().create(ApiService.class)
                .getmoviedianzan(userId, sessionId, commentId)
                .compose(CommonSchedulers.<MovieDianZan>io2main())
                .subscribe(new CommonObserver<MovieDianZan>() {
                    @Override
                    public void onNext(MovieDianZan movieDianZan) {
                        imodelCallBack.onHomesuccess(movieDianZan);
                    }

                    @Override
                    public void onError(Throwable e) {
                        imodelCallBack.onHomeFaiure(e);
                    }
                });
    }

}
