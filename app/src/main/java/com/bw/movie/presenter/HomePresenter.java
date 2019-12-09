package com.bw.movie.presenter;


/*
 *@auther:胡明明
 *@Date: 2019/11/12
 *@Time:18:56
 *@Description:${DESCRIPTION}
 **/

import android.widget.Toast;

import com.bw.movie.app.App;
import com.bw.movie.app.Constantes;
import com.bw.movie.base.BasePresenter;
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
import com.bw.movie.model.HomeModel;
import com.bw.movie.utils.Constant;

public class HomePresenter extends BasePresenter<HomeContract.Iview> implements HomeContract.Ipresenter {

    private HomeModel homeModel;
//chu初始化HomeModle
    @Override
    protected void initModel() {
        homeModel = new HomeModel();
    }
//轮播图
    @Override
    public void getPresenterXbanner() {
            homeModel.getModelXbanner(new HomeContract.Imodel.ImodelCallBack() {
                @Override
                public void onHomesuccess(XBannerBean xBannerBean) {
                    //pa判断是否挂载
                    if (isViewAttached()){
                        if (xBannerBean.getStatus().equals(Constantes.SUCCESS_CODE)&&xBannerBean!=null){
                            getView().onHomesuccess(xBannerBean);
                        }else{
                            getView().onHomeFaiure(new Exception("服务器异常"));
                            Toast.makeText(App.getsAppContext(), xBannerBean.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                @Override
                public void onHomesuccess(ReYingBean reYingBean) {
                }
                @Override
                public void onHomesuccess(ShangYingBean shangYingBean) {
                }
                @Override
                public void onHomesuccess(HomeBean homeBean) {
                }
                @Override
                public void onHomesuccess(XiangQingBean xiangQingBean) {

                }
                @Override
                public void onHomesuccess(YingPingBean yingPingBean) {

                }
                @Override
                public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {

                }
                @Override
                public void onHomesuccess(QuLeiBean quLeiBean) {
                }

                @Override
                public void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean) {
                }
                @Override
                public void onHomesuccess(ShiJianBean shiJianBean) {
                }
                @Override
                public void onHomesuccess(PriceBean priceBean) {
                }
                @Override
                public void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean) {
                }
                @Override
                public void onHomesuccess(YingTingBean yingTingBean) {
                }
                @Override
                public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {
                }
                @Override
                public void onHomeSuccess(XieYingPingBean xieYingPingBean) {
                }

                @Override
                public void onHomesuccess(XiaDanBean xiaDanBean) {

                }
                @Override
                public void onHomesuccess(ZhiFuBean zhiFuBean) {
                }

                @Override
                public void onHomesuccess(GuanZhuBean guanZhuBean) {

                }

                @Override
                public void onHomesuccess(WeiGuanZhuBean weiGuanZhuBean) {

                }

                @Override
                public void onHomesuccess(HomeYuYueBean homeYuYueBean) {

                }

                @Override
                public void onHomesuccess(MovieDianZan movieDianZan) {

                }

                @Override
                public void onHomeFaiure(Throwable e) {
                        getView().onHomeFaiure(e);
                }
            });
    }
//热映
    @Override
    public void getPresenterReYing(Integer page, Integer count) {
        homeModel.getModelReYing(page, count, new HomeContract.Imodel.ImodelCallBack() {
            @Override
            public void onHomesuccess(XBannerBean xBannerBean) {
            }
           @Override
            public void onHomesuccess(ReYingBean reYingBean) {
                //pa判断是否挂载
                if (isViewAttached()){
                    if (reYingBean.getStatus().equals(Constantes.SUCCESS_CODE)&&reYingBean!=null){
                        getView().onHomesuccess(reYingBean);
                    }else{
                        getView().onHomeFaiure(new Exception("服务器异常"));
                        Toast.makeText(App.getsAppContext(), reYingBean.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
            @Override
            public void onHomesuccess(ShangYingBean shangYingBean) {
            }
            @Override
            public void onHomesuccess(HomeBean homeBean) {
            }
            @Override
            public void onHomesuccess(XiangQingBean xiangQingBean) {

            }
            @Override
            public void onHomesuccess(YingPingBean yingPingBean) {

            }
            @Override
            public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {
            }
            @Override
            public void onHomesuccess(QuLeiBean quLeiBean) {
            }
            @Override
            public void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean) {
            }
            @Override
            public void onHomesuccess(ShiJianBean shiJianBean) {
            }
            @Override
            public void onHomesuccess(PriceBean priceBean) {
            }
            @Override
            public void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean) {
            }
            @Override
            public void onHomesuccess(YingTingBean yingTingBean) {
            }
            @Override
            public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {
            }
            @Override
            public void onHomeSuccess(XieYingPingBean xieYingPingBean) {
            }
            @Override
            public void onHomesuccess(XiaDanBean xiaDanBean) {
            }
            @Override
            public void onHomesuccess(ZhiFuBean zhiFuBean) {
            }

            @Override
            public void onHomesuccess(GuanZhuBean guanZhuBean) {

            }

            @Override
            public void onHomesuccess(WeiGuanZhuBean weiGuanZhuBean) {

            }

            @Override
            public void onHomesuccess(HomeYuYueBean homeYuYueBean) {

            }

            @Override
            public void onHomesuccess(MovieDianZan movieDianZan) {

            }

            @Override
            public void onHomeFaiure(Throwable e) {
                getView().onHomeFaiure(e);
            }
        });
    }
//即将上映
    @Override
    public void getPresenterShangYing(Integer page, Integer count) {
        homeModel.getModelShangYing(page, count, new HomeContract.Imodel.ImodelCallBack() {
            @Override
            public void onHomesuccess(XBannerBean xBannerBean) {
            }

            @Override
            public void onHomesuccess(ReYingBean reYingBean) {
            }
            @Override
            public void onHomesuccess(ShangYingBean shangYingBean) {
                //pa判断是否挂载
                if (isViewAttached()){
                    if (shangYingBean.getStatus().equals(Constantes.SUCCESS_CODE)&&shangYingBean!=null){
                        getView().onHomesuccess(shangYingBean);
                    }else{
                        getView().onHomeFaiure(new Exception("服务器异常"));
                        Toast.makeText(App.getsAppContext(), shangYingBean.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
            @Override
            public void onHomesuccess(HomeBean homeBean) {
            }
            @Override
            public void onHomesuccess(XiangQingBean xiangQingBean) {
            }
            @Override
            public void onHomesuccess(YingPingBean yingPingBean) {
            }
            @Override
            public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {
            }
            @Override
            public void onHomesuccess(QuLeiBean quLeiBean) {
            }
            @Override
            public void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean) {
            }
            @Override
            public void onHomesuccess(ShiJianBean shiJianBean) {
            }
            @Override
            public void onHomesuccess(PriceBean priceBean) {
            }
            @Override
            public void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean) {
            }
            @Override
            public void onHomesuccess(YingTingBean yingTingBean) {
            }
            @Override
            public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {
            }
            @Override
            public void onHomeSuccess(XieYingPingBean xieYingPingBean) {
            }
            @Override
            public void onHomesuccess(XiaDanBean xiaDanBean) {
            }
            @Override
            public void onHomesuccess(ZhiFuBean zhiFuBean) {
            }

            @Override
            public void onHomesuccess(GuanZhuBean guanZhuBean) {

            }

            @Override
            public void onHomesuccess(WeiGuanZhuBean weiGuanZhuBean) {

            }

            @Override
            public void onHomesuccess(HomeYuYueBean homeYuYueBean) {

            }

            @Override
            public void onHomesuccess(MovieDianZan movieDianZan) {

            }

            @Override
            public void onHomeFaiure(Throwable e) {
                getView().onHomeFaiure(e);
            }
        });
    }
//热门
    @Override
    public void getPresenterHome(Integer page, Integer count) {
       homeModel.getModelHome(page, count, new HomeContract.Imodel.ImodelCallBack() {
           @Override
           public void onHomesuccess(XBannerBean xBannerBean) {
           }
           @Override
           public void onHomesuccess(ReYingBean reYingBean) {

           }

           @Override
           public void onHomesuccess(ShangYingBean shangYingBean) {

           }

           @Override
           public void onHomesuccess(HomeBean homeBean) {
               //pa判断是否挂载
               if (isViewAttached()){
                   if (homeBean.getStatus().equals(Constantes.SUCCESS_CODE)&&homeBean!=null){
                       getView().onHomesuccess(homeBean);
                   }else{
                       getView().onHomeFaiure(new Exception("服务器异常"));
                       Toast.makeText(App.getsAppContext(), homeBean.getMessage(), Toast.LENGTH_SHORT).show();
                   }
               }
           }

           @Override
           public void onHomesuccess(XiangQingBean xiangQingBean) {

           }

           @Override
           public void onHomesuccess(YingPingBean yingPingBean) {

           }

           @Override
           public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {

           }

           @Override
           public void onHomesuccess(QuLeiBean quLeiBean) {

           }

           @Override
           public void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean) {

           }

           @Override
           public void onHomesuccess(ShiJianBean shiJianBean) {

           }

           @Override
           public void onHomesuccess(PriceBean priceBean) {

           }

           @Override
           public void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean) {

           }

           @Override
           public void onHomesuccess(YingTingBean yingTingBean) {

           }

           @Override
           public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {

           }

           @Override
           public void onHomeSuccess(XieYingPingBean xieYingPingBean) {

           }

           @Override
           public void onHomesuccess(XiaDanBean xiaDanBean) {

           }

           @Override
           public void onHomesuccess(ZhiFuBean zhiFuBean) {


           }

           @Override
           public void onHomesuccess(GuanZhuBean guanZhuBean) {

           }

           @Override
           public void onHomesuccess(WeiGuanZhuBean weiGuanZhuBean) {

           }

           @Override
           public void onHomesuccess(HomeYuYueBean homeYuYueBean) {

           }

           @Override
           public void onHomesuccess(MovieDianZan movieDianZan) {

           }

           @Override
           public void onHomeFaiure(Throwable e) {
               getView().onHomeFaiure(e);
           }
       });
    }
//详情
    @Override
    public void getModelXiangQing(Integer movieId) {
        homeModel.getModelXiangQing(movieId, new HomeContract.Imodel.ImodelCallBack() {
            @Override
            public void onHomesuccess(XBannerBean xBannerBean) {

            }

            @Override
            public void onHomesuccess(ReYingBean reYingBean) {

            }

            @Override
            public void onHomesuccess(ShangYingBean shangYingBean) {

            }

            @Override
            public void onHomesuccess(HomeBean homeBean) {

            }

            @Override
            public void onHomesuccess(XiangQingBean xiangQingBean) {
                //pa判断是否挂载
                if (isViewAttached()){
                    if (xiangQingBean.getStatus().equals(Constantes.SUCCESS_CODE)&&xiangQingBean!=null){
                        getView().onHomesuccess(xiangQingBean);
                    }else{
                        getView().onHomeFaiure(new Exception("服务器异常"));
                       // Toast.makeText(App.getsAppContext(), xiangQingBean.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onHomesuccess(YingPingBean yingPingBean) {

            }

            @Override
            public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {

            }

            @Override
            public void onHomesuccess(QuLeiBean quLeiBean) {

            }

            @Override
            public void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean) {

            }

            @Override
            public void onHomesuccess(ShiJianBean shiJianBean) {

            }

            @Override
            public void onHomesuccess(PriceBean priceBean) {

            }

            @Override
            public void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean) {

            }

            @Override
            public void onHomesuccess(YingTingBean yingTingBean) {

            }

            @Override
            public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {

            }

            @Override
            public void onHomeSuccess(XieYingPingBean xieYingPingBean) {

            }

            @Override
            public void onHomesuccess(XiaDanBean xiaDanBean) {

            }

            @Override
            public void onHomesuccess(ZhiFuBean zhiFuBean) {

            }

            @Override
            public void onHomesuccess(GuanZhuBean guanZhuBean) {

            }

            @Override
            public void onHomesuccess(WeiGuanZhuBean weiGuanZhuBean) {

            }

            @Override
            public void onHomesuccess(HomeYuYueBean homeYuYueBean) {

            }

            @Override
            public void onHomesuccess(MovieDianZan movieDianZan) {

            }

            @Override
            public void onHomeFaiure(Throwable e) {
                getView().onHomeFaiure(e);
            }
        });
    }
//影评
    @Override
    public void getPresenterYingPing(Integer movieId, Integer page, Integer count) {
        homeModel.getModelYingPing(movieId, page, count, new HomeContract.Imodel.ImodelCallBack() {
            @Override
            public void onHomesuccess(XBannerBean xBannerBean) {

            }

            @Override
            public void onHomesuccess(ReYingBean reYingBean) {

            }

            @Override
            public void onHomesuccess(ShangYingBean shangYingBean) {

            }

            @Override
            public void onHomesuccess(HomeBean homeBean) {

            }

            @Override
            public void onHomesuccess(XiangQingBean xiangQingBean) {

            }

            @Override
            public void onHomesuccess(YingPingBean yingPingBean) {
                //pa判断是否挂载
                if (isViewAttached()){
                    if (yingPingBean.getStatus().equals(Constantes.SUCCESS_CODE)&&yingPingBean!=null){
                        getView().onHomesuccess(yingPingBean);
                    }else{
                        getView().onHomeFaiure(new Exception("服务器异常"));
                        Toast.makeText(App.getsAppContext(), yingPingBean.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {

            }

            @Override
            public void onHomesuccess(QuLeiBean quLeiBean) {

            }

            @Override
            public void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean) {

            }

            @Override
            public void onHomesuccess(ShiJianBean shiJianBean) {

            }

            @Override
            public void onHomesuccess(PriceBean priceBean) {

            }

            @Override
            public void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean) {

            }

            @Override
            public void onHomesuccess(YingTingBean yingTingBean) {

            }

            @Override
            public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {

            }

            @Override
            public void onHomeSuccess(XieYingPingBean xieYingPingBean) {

            }

            @Override
            public void onHomesuccess(XiaDanBean xiaDanBean) {

            }

            @Override
            public void onHomesuccess(ZhiFuBean zhiFuBean) {

            }

            @Override
            public void onHomesuccess(GuanZhuBean guanZhuBean) {

            }

            @Override
            public void onHomesuccess(WeiGuanZhuBean weiGuanZhuBean) {

            }

            @Override
            public void onHomesuccess(HomeYuYueBean homeYuYueBean) {

            }

            @Override
            public void onHomesuccess(MovieDianZan movieDianZan) {

            }

            @Override
            public void onHomeFaiure(Throwable e) {
                    getView().onHomeFaiure(e);
            }
        });
    }
//搜索
    @Override
    public void getPresenterSouSuo(String keyword, Integer page, Integer count) {
        homeModel.getModelSouSuo(keyword, page, count, new HomeContract.Imodel.ImodelCallBack() {
            @Override
            public void onHomesuccess(XBannerBean xBannerBean) {

            }

            @Override
            public void onHomesuccess(ReYingBean reYingBean) {

            }

            @Override
            public void onHomesuccess(ShangYingBean shangYingBean) {

            }

            @Override
            public void onHomesuccess(HomeBean homeBean) {

            }

            @Override
            public void onHomesuccess(XiangQingBean xiangQingBean) {

            }

            @Override
            public void onHomesuccess(YingPingBean yingPingBean) {

            }

            @Override
            public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {
                //pa判断是否挂载
                if (isViewAttached()){
                    if (homeSouSuoBean.getStatus().equals(Constantes.SUCCESS_CODE)&&homeSouSuoBean!=null){
                        getView().onHomesuccess(homeSouSuoBean);
                    }else{
                        getView().onHomeFaiure(new Exception("服务器异常"));
                        Toast.makeText(App.getsAppContext(), homeSouSuoBean.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onHomesuccess(QuLeiBean quLeiBean) {

            }

            @Override
            public void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean) {

            }

            @Override
            public void onHomesuccess(ShiJianBean shiJianBean) {

            }

            @Override
            public void onHomesuccess(PriceBean priceBean) {

            }

            @Override
            public void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean) {

            }

            @Override
            public void onHomesuccess(YingTingBean yingTingBean) {

            }

            @Override
            public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {

            }

            @Override
            public void onHomeSuccess(XieYingPingBean xieYingPingBean) {

            }

            @Override
            public void onHomesuccess(XiaDanBean xiaDanBean) {

            }

            @Override
            public void onHomesuccess(ZhiFuBean zhiFuBean) {

            }

            @Override
            public void onHomesuccess(GuanZhuBean guanZhuBean) {

            }

            @Override
            public void onHomesuccess(WeiGuanZhuBean weiGuanZhuBean) {

            }

            @Override
            public void onHomesuccess(HomeYuYueBean homeYuYueBean) {

            }

            @Override
            public void onHomesuccess(MovieDianZan movieDianZan) {

            }

            @Override
            public void onHomeFaiure(Throwable e) {
                    getView().onHomeFaiure(e);
            }
        });
    }

    @Override
    public void getModelQuLei() {
        homeModel.getModelQuLei(new HomeContract.Imodel.ImodelCallBack() {
            @Override
            public void onHomesuccess(XBannerBean xBannerBean) {

            }

            @Override
            public void onHomesuccess(ReYingBean reYingBean) {

            }

            @Override
            public void onHomesuccess(ShangYingBean shangYingBean) {

            }

            @Override
            public void onHomesuccess(HomeBean homeBean) {

            }

            @Override
            public void onHomesuccess(XiangQingBean xiangQingBean) {

            }

            @Override
            public void onHomesuccess(YingPingBean yingPingBean) {

            }

            @Override
            public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {

            }

            @Override
            public void onHomesuccess(QuLeiBean quLeiBean) {
                    getView().onHomesuccess(quLeiBean);
            }

            @Override
            public void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean) {

            }

            @Override
            public void onHomesuccess(ShiJianBean shiJianBean) {

            }

            @Override
            public void onHomesuccess(PriceBean priceBean) {

            }

            @Override
            public void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean) {

            }

            @Override
            public void onHomesuccess(YingTingBean yingTingBean) {

            }

            @Override
            public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {

            }

            @Override
            public void onHomeSuccess(XieYingPingBean xieYingPingBean) {

            }

            @Override
            public void onHomesuccess(XiaDanBean xiaDanBean) {

            }

            @Override
            public void onHomesuccess(ZhiFuBean zhiFuBean) {

            }

            @Override
            public void onHomesuccess(GuanZhuBean guanZhuBean) {

            }

            @Override
            public void onHomesuccess(WeiGuanZhuBean weiGuanZhuBean) {

            }

            @Override
            public void onHomesuccess(HomeYuYueBean homeYuYueBean) {

            }

            @Override
            public void onHomesuccess(MovieDianZan movieDianZan) {

            }

            @Override
            public void onHomeFaiure(Throwable e) {
                    getView().onHomeFaiure(e);
            }
        });
    }

    @Override
    public void getPresenterXinXi(Integer movieId, Integer regionId, Integer page, Integer count) {
                homeModel.getModelXinXi(movieId, regionId, page, count, new HomeContract.Imodel.ImodelCallBack() {
                    @Override
                    public void onHomesuccess(XBannerBean xBannerBean) {

                    }

                    @Override
                    public void onHomesuccess(ReYingBean reYingBean) {

                    }

                    @Override
                    public void onHomesuccess(ShangYingBean shangYingBean) {

                    }

                    @Override
                    public void onHomesuccess(HomeBean homeBean) {

                    }

                    @Override
                    public void onHomesuccess(XiangQingBean xiangQingBean) {

                    }

                    @Override
                    public void onHomesuccess(YingPingBean yingPingBean) {

                    }

                    @Override
                    public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {

                    }

                    @Override
                    public void onHomesuccess(QuLeiBean quLeiBean) {

                    }

                    @Override
                    public void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean) {
                        //pa判断是否挂载
                        if (isViewAttached()){
                            if (xuanZuoXinXiBean.getStatus().equals(Constantes.SUCCESS_CODE)&&xuanZuoXinXiBean!=null){
                                getView().onHomesuccess(xuanZuoXinXiBean);
                            }else{
                                getView().onHomeFaiure(new Exception("服务器异常"));
                                Toast.makeText(App.getsAppContext(), xuanZuoXinXiBean.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onHomesuccess(ShiJianBean shiJianBean) {

                    }

                    @Override
                    public void onHomesuccess(PriceBean priceBean) {

                    }

                    @Override
                    public void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean) {

                    }

                    @Override
                    public void onHomesuccess(YingTingBean yingTingBean) {

                    }

                    @Override
                    public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {

                    }

                    @Override
                    public void onHomeSuccess(XieYingPingBean xieYingPingBean) {

                    }

                    @Override
                    public void onHomesuccess(XiaDanBean xiaDanBean) {

                    }

                    @Override
                    public void onHomesuccess(ZhiFuBean zhiFuBean) {

                    }

                    @Override
                    public void onHomesuccess(GuanZhuBean guanZhuBean) {

                    }

                    @Override
                    public void onHomesuccess(WeiGuanZhuBean weiGuanZhuBean) {

                    }

                    @Override
                    public void onHomesuccess(HomeYuYueBean homeYuYueBean) {

                    }

                    @Override
                    public void onHomesuccess(MovieDianZan movieDianZan) {

                    }

                    @Override
                    public void onHomeFaiure(Throwable e) {
                        getView().onHomeFaiure(e);
                    }
                });
    }

    @Override
    public void getPresentershijian() {
        homeModel.getModelshijian(new HomeContract.Imodel.ImodelCallBack() {
            @Override
            public void onHomesuccess(XBannerBean xBannerBean) {

            }

            @Override
            public void onHomesuccess(ReYingBean reYingBean) {

            }

            @Override
            public void onHomesuccess(ShangYingBean shangYingBean) {

            }

            @Override
            public void onHomesuccess(HomeBean homeBean) {

            }

            @Override
            public void onHomesuccess(XiangQingBean xiangQingBean) {

            }

            @Override
            public void onHomesuccess(YingPingBean yingPingBean) {

            }

            @Override
            public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {

            }

            @Override
            public void onHomesuccess(QuLeiBean quLeiBean) {

            }

            @Override
            public void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean) {

            }

            @Override
            public void onHomesuccess(ShiJianBean shiJianBean) {
//pa判断是否挂载
                if (isViewAttached()){
                    if (shiJianBean.getStatus().equals(Constantes.SUCCESS_CODE)&&shiJianBean!=null){
                        getView().onHomesuccess(shiJianBean);
                    }else{
                        getView().onHomeFaiure(new Exception("服务器异常"));
                        Toast.makeText(App.getsAppContext(), shiJianBean.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            }

            @Override
            public void onHomesuccess(PriceBean priceBean) {

            }

            @Override
            public void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean) {

            }

            @Override
            public void onHomesuccess(YingTingBean yingTingBean) {

            }

            @Override
            public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {

            }

            @Override
            public void onHomeSuccess(XieYingPingBean xieYingPingBean) {

            }

            @Override
            public void onHomesuccess(XiaDanBean xiaDanBean) {

            }

            @Override
            public void onHomesuccess(ZhiFuBean zhiFuBean) {

            }

            @Override
            public void onHomesuccess(GuanZhuBean guanZhuBean) {

            }

            @Override
            public void onHomesuccess(WeiGuanZhuBean weiGuanZhuBean) {

            }

            @Override
            public void onHomesuccess(HomeYuYueBean homeYuYueBean) {

            }

            @Override
            public void onHomesuccess(MovieDianZan movieDianZan) {

            }

            @Override
            public void onHomeFaiure(Throwable e) {
                    getView().onHomeFaiure(e);
            }
        });
    }

    @Override
    public void getPresenterPrice(Integer movieId, Integer page, Integer count) {
        homeModel.getModelPrice(movieId, page, count, new HomeContract.Imodel.ImodelCallBack() {
            @Override
            public void onHomesuccess(XBannerBean xBannerBean) {

            }

            @Override
            public void onHomesuccess(ReYingBean reYingBean) {

            }

            @Override
            public void onHomesuccess(ShangYingBean shangYingBean) {

            }

            @Override
            public void onHomesuccess(HomeBean homeBean) {

            }

            @Override
            public void onHomesuccess(XiangQingBean xiangQingBean) {

            }

            @Override
            public void onHomesuccess(YingPingBean yingPingBean) {

            }

            @Override
            public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {

            }

            @Override
            public void onHomesuccess(QuLeiBean quLeiBean) {

            }

            @Override
            public void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean) {

            }

            @Override
            public void onHomesuccess(ShiJianBean shiJianBean) {

            }

            @Override
            public void onHomesuccess(PriceBean priceBean) {
                //pa判断是否挂载
                if (isViewAttached()){
                    if (priceBean.getStatus().equals(Constantes.SUCCESS_CODE)&&priceBean!=null){
                        getView().onHomesuccess(priceBean);
                    }else{
                        getView().onHomeFaiure(new Exception("服务器异常"));
                        Toast.makeText(App.getsAppContext(), priceBean.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            }

            @Override
            public void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean) {

            }

            @Override
            public void onHomesuccess(YingTingBean yingTingBean) {

            }

            @Override
            public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {

            }

            @Override
            public void onHomeSuccess(XieYingPingBean xieYingPingBean) {

            }

            @Override
            public void onHomesuccess(XiaDanBean xiaDanBean) {

            }

            @Override
            public void onHomesuccess(ZhiFuBean zhiFuBean) {

            }

            @Override
            public void onHomesuccess(GuanZhuBean guanZhuBean) {

            }

            @Override
            public void onHomesuccess(WeiGuanZhuBean weiGuanZhuBean) {

            }

            @Override
            public void onHomesuccess(HomeYuYueBean homeYuYueBean) {

            }

            @Override
            public void onHomesuccess(MovieDianZan movieDianZan) {

            }

            @Override
            public void onHomeFaiure(Throwable e) {
                getView().onHomeFaiure(e);
            }
        });
    }

    @Override
    public void getPresentershijianyingyuan(Integer movieId, String date, Integer page, Integer count) {
        homeModel.getModelshijianyingyuan(movieId, date, page, count, new HomeContract.Imodel.ImodelCallBack() {
            @Override
            public void onHomesuccess(XBannerBean xBannerBean) {

            }

            @Override
            public void onHomesuccess(ReYingBean reYingBean) {

            }

            @Override
            public void onHomesuccess(ShangYingBean shangYingBean) {

            }

            @Override
            public void onHomesuccess(HomeBean homeBean) {

            }

            @Override
            public void onHomesuccess(XiangQingBean xiangQingBean) {

            }

            @Override
            public void onHomesuccess(YingPingBean yingPingBean) {

            }

            @Override
            public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {

            }

            @Override
            public void onHomesuccess(QuLeiBean quLeiBean) {

            }

            @Override
            public void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean) {

            }

            @Override
            public void onHomesuccess(ShiJianBean shiJianBean) {

            }

            @Override
            public void onHomesuccess(PriceBean priceBean) {

            }

            @Override
            public void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean) {
                //pa判断是否挂载
                if (isViewAttached()){
                    if (shiJianYingYuanBean.getStatus().equals(Constantes.SUCCESS_CODE)&&shiJianYingYuanBean!=null){
                        getView().onHomesuccess(shiJianYingYuanBean);
                    }else{
                        getView().onHomeFaiure(new Exception("服务器异常"));
                        Toast.makeText(App.getsAppContext(), shiJianYingYuanBean.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            }

            @Override
            public void onHomesuccess(YingTingBean yingTingBean) {

            }

            @Override
            public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {

            }

            @Override
            public void onHomeSuccess(XieYingPingBean xieYingPingBean) {

            }

            @Override
            public void onHomesuccess(XiaDanBean xiaDanBean) {

            }

            @Override
            public void onHomesuccess(ZhiFuBean zhiFuBean) {

            }

            @Override
            public void onHomesuccess(GuanZhuBean guanZhuBean) {


            }

            @Override
            public void onHomesuccess(WeiGuanZhuBean weiGuanZhuBean) {

            }

            @Override
            public void onHomesuccess(HomeYuYueBean homeYuYueBean) {

            }

            @Override
            public void onHomesuccess(MovieDianZan movieDianZan) {

            }

            @Override
            public void onHomeFaiure(Throwable e) {
                getView().onHomeFaiure(e);
            }
        });
    }

    @Override
    public void getPresenteryingting(Integer movieId, Integer cinemaId) {
        homeModel.getModelyingting(movieId, cinemaId, new HomeContract.Imodel.ImodelCallBack() {
            @Override
            public void onHomesuccess(XBannerBean xBannerBean) {

            }

            @Override
            public void onHomesuccess(ReYingBean reYingBean) {

            }

            @Override
            public void onHomesuccess(ShangYingBean shangYingBean) {

            }

            @Override
            public void onHomesuccess(HomeBean homeBean) {

            }

            @Override
            public void onHomesuccess(XiangQingBean xiangQingBean) {

            }

            @Override
            public void onHomesuccess(YingPingBean yingPingBean) {

            }

            @Override
            public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {

            }

            @Override
            public void onHomesuccess(QuLeiBean quLeiBean) {

            }

            @Override
            public void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean) {

            }

            @Override
            public void onHomesuccess(ShiJianBean shiJianBean) {

            }

            @Override
            public void onHomesuccess(PriceBean priceBean) {

            }

            @Override
            public void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean) {

            }

            @Override
            public void onHomesuccess(YingTingBean yingTingBean) {
                //pa判断是否挂载
                if (isViewAttached()){
                    if (yingTingBean.getStatus().equals(Constantes.SUCCESS_CODE)&&yingTingBean!=null){
                        getView().onHomesuccess(yingTingBean);
                    }else{
                        getView().onHomeFaiure(new Exception("服务器异常"));
                        Toast.makeText(App.getsAppContext(), yingTingBean.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            }

            @Override
            public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {

            }

            @Override
            public void onHomeSuccess(XieYingPingBean xieYingPingBean) {

            }

            @Override
            public void onHomesuccess(XiaDanBean xiaDanBean) {

            }

            @Override
            public void onHomesuccess(ZhiFuBean zhiFuBean) {

            }

            @Override
            public void onHomesuccess(GuanZhuBean guanZhuBean) {

            }

            @Override
            public void onHomesuccess(WeiGuanZhuBean weiGuanZhuBean) {

            }

            @Override
            public void onHomesuccess(HomeYuYueBean homeYuYueBean) {

            }

            @Override
            public void onHomesuccess(MovieDianZan movieDianZan) {

            }

            @Override
            public void onHomeFaiure(Throwable e) {
                getView().onHomeFaiure(e);
            }
        });
    }

    @Override
    public void getPresenterzuowei(Integer hallId) {
        homeModel.getModelzuowei(hallId, new HomeContract.Imodel.ImodelCallBack() {
            @Override
            public void onHomesuccess(XBannerBean xBannerBean) {

            }

            @Override
            public void onHomesuccess(ReYingBean reYingBean) {

            }

            @Override
            public void onHomesuccess(ShangYingBean shangYingBean) {

            }

            @Override
            public void onHomesuccess(HomeBean homeBean) {

            }
            @Override
            public void onHomesuccess(XiangQingBean xiangQingBean) {
            }
            @Override
            public void onHomesuccess(YingPingBean yingPingBean) {
            }
            @Override
            public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {
            }
            @Override
            public void onHomesuccess(QuLeiBean quLeiBean) {
            }
            @Override
            public void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean) {
            }
            @Override
            public void onHomesuccess(ShiJianBean shiJianBean) {
            }
            @Override
            public void onHomesuccess(PriceBean priceBean) {
            }
            @Override
            public void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean) {
            }
            @Override
            public void onHomesuccess(YingTingBean yingTingBean) {
            }
            @Override
            public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {
                //pa判断是否挂载
                if (isViewAttached()){
                    if (zuoWeiHaoBean.getStatus().equals(Constantes.SUCCESS_CODE)&&zuoWeiHaoBean!=null){
                        getView().onHomesuccess(zuoWeiHaoBean);
                    }else{
                        getView().onHomeFaiure(new Exception("服务器异常"));
                        Toast.makeText(App.getsAppContext(), zuoWeiHaoBean.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            }
            @Override
            public void onHomeSuccess(XieYingPingBean xieYingPingBean) {
            }
            @Override
            public void onHomesuccess(XiaDanBean xiaDanBean) {
            }
            @Override
            public void onHomesuccess(ZhiFuBean zhiFuBean) {
            }

            @Override
            public void onHomesuccess(GuanZhuBean guanZhuBean) {

            }

            @Override
            public void onHomesuccess(WeiGuanZhuBean weiGuanZhuBean) {

            }

            @Override
            public void onHomesuccess(HomeYuYueBean homeYuYueBean) {

            }

            @Override
            public void onHomesuccess(MovieDianZan movieDianZan) {

            }

            @Override
            public void onHomeFaiure(Throwable e) {
                getView().onHomeFaiure(e);
            }
        });
    }
    @Override
    public void getPresenterxieyp(Integer userId, String sessionId, Integer movieId, String commentContent, Double score) {
        homeModel.getModelxieyp(userId, sessionId, movieId, commentContent, score, new HomeContract.Imodel.ImodelCallBack() {
            @Override
            public void onHomesuccess(XBannerBean xBannerBean) {
            }
            @Override
            public void onHomesuccess(ReYingBean reYingBean) {
            }
            @Override
            public void onHomesuccess(ShangYingBean shangYingBean) {
            }
            @Override
            public void onHomesuccess(HomeBean homeBean) {
            }
            @Override
            public void onHomesuccess(XiangQingBean xiangQingBean) {
            }
            @Override
            public void onHomesuccess(YingPingBean yingPingBean) {
            }
            @Override
            public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {
            }
            @Override
            public void onHomesuccess(QuLeiBean quLeiBean) {
            }
            @Override
            public void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean) {
            }
            @Override
            public void onHomesuccess(ShiJianBean shiJianBean) {
            }
            @Override
            public void onHomesuccess(PriceBean priceBean) {
            }
            @Override
            public void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean) {
            }
            @Override
            public void onHomesuccess(YingTingBean yingTingBean) {
            }
            @Override
            public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {
            }
            @Override
            public void onHomeSuccess(XieYingPingBean xieYingPingBean) {
            //判断是否挂载
                if (isViewAttached()){
                    if (xieYingPingBean.getStatus().equals(Constantes.SUCCESS_CODE)&&xieYingPingBean!=null){
                        getView().onHomesuccess(xieYingPingBean);
                    }else{
                        getView().onHomeFaiure(new Exception("服务器异常"));
                        Toast.makeText(App.getsAppContext(), xieYingPingBean.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            }
            @Override
            public void onHomesuccess(XiaDanBean xiaDanBean) {
            }
            @Override
            public void onHomesuccess(ZhiFuBean zhiFuBean) {
            }

            @Override
            public void onHomesuccess(GuanZhuBean guanZhuBean) {

            }

            @Override
            public void onHomesuccess(WeiGuanZhuBean weiGuanZhuBean) {

            }

            @Override
            public void onHomesuccess(HomeYuYueBean homeYuYueBean) {

            }

            @Override
            public void onHomesuccess(MovieDianZan movieDianZan) {

            }

            @Override
            public void onHomeFaiure(Throwable e) {
                getView().onHomeFaiure(e);
            }
        });
    }
    @Override
    public void getPresenterxiadan(Integer userId, String sessionId, String scheduleId, String seat, String sign) {
        homeModel.getModelxiadan(userId, sessionId, scheduleId, seat, sign, new HomeContract.Imodel.ImodelCallBack() {
            @Override
            public void onHomesuccess(XBannerBean xBannerBean) {
            }
            @Override
            public void onHomesuccess(ReYingBean reYingBean) {
            }
            @Override
            public void onHomesuccess(ShangYingBean shangYingBean) {
            }
            @Override
            public void onHomesuccess(HomeBean homeBean) {
            }
            @Override
            public void onHomesuccess(XiangQingBean xiangQingBean) {
            }
            @Override
            public void onHomesuccess(YingPingBean yingPingBean) {

            }
            @Override
            public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {
            }
            @Override
            public void onHomesuccess(QuLeiBean quLeiBean) {
            }
            @Override
            public void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean) {
            }
            @Override
            public void onHomesuccess(ShiJianBean shiJianBean) {

            }
            @Override
            public void onHomesuccess(PriceBean priceBean) {
            }
            @Override
            public void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean) {
            }
            @Override
            public void onHomesuccess(YingTingBean yingTingBean) {

            }
            @Override
            public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {

            }
            @Override
            public void onHomeSuccess(XieYingPingBean xieYingPingBean) {

            }
            @Override
            public void onHomesuccess(XiaDanBean xiaDanBean) {
                //判断是否挂载
                if (isViewAttached()){
                    if (xiaDanBean.getStatus().equals(Constantes.SUCCESS_CODE)&&xiaDanBean!=null){
                        getView().onHomesuccess(xiaDanBean);
                    }else{
                        getView().onHomeFaiure(new Exception("服务器异常"));
                        Toast.makeText(App.getsAppContext(), xiaDanBean.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            }
            @Override
            public void onHomesuccess(ZhiFuBean zhiFuBean) {

            }

            @Override
            public void onHomesuccess(GuanZhuBean guanZhuBean) {

            }

            @Override
            public void onHomesuccess(WeiGuanZhuBean weiGuanZhuBean) {

            }

            @Override
            public void onHomesuccess(HomeYuYueBean homeYuYueBean) {

            }

            @Override
            public void onHomesuccess(MovieDianZan movieDianZan) {

            }

            @Override
            public void onHomeFaiure(Throwable e) {
                getView().onHomeFaiure(e);
            }
        });
    }
    @Override
    public void getPresenterzhifu(Integer userId, String sessionId, Integer payType, String orderId) {
        homeModel.getModelzhifu(userId, sessionId, payType, orderId, new HomeContract.Imodel.ImodelCallBack() {
            @Override
            public void onHomesuccess(XBannerBean xBannerBean) {
            }
            @Override
            public void onHomesuccess(ReYingBean reYingBean) {
            }
            @Override
            public void onHomesuccess(ShangYingBean shangYingBean) {
            }
            @Override
            public void onHomesuccess(HomeBean homeBean) {
            }
            @Override
            public void onHomesuccess(XiangQingBean xiangQingBean) {
            }
            @Override
            public void onHomesuccess(YingPingBean yingPingBean) {
            }
            @Override
            public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {
            }
            @Override
            public void onHomesuccess(QuLeiBean quLeiBean) {
            }
            @Override
            public void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean) {
            }
            @Override
            public void onHomesuccess(ShiJianBean shiJianBean) {
            }
            @Override
            public void onHomesuccess(PriceBean priceBean) {
            }
            @Override
            public void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean) {
            }
            @Override
            public void onHomesuccess(YingTingBean yingTingBean) {
            }
            @Override
            public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {
            }
            @Override
            public void onHomeSuccess(XieYingPingBean xieYingPingBean) {
            }
            @Override
            public void onHomesuccess(XiaDanBean xiaDanBean) {
            }
            @Override
            public void onHomesuccess(ZhiFuBean zhiFuBean) {
                //判断是否挂载
                if (isViewAttached()){
                    if (zhiFuBean.getStatus().equals(Constantes.SUCCESS_CODE)&&zhiFuBean!=null){
                        getView().onHomesuccess(zhiFuBean);
                    }else{
                        getView().onHomeFaiure(new Exception("服务器异常"));
                        Toast.makeText(App.getsAppContext(), zhiFuBean.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            }

            @Override
            public void onHomesuccess(GuanZhuBean guanZhuBean) {

            }

            @Override
            public void onHomesuccess(WeiGuanZhuBean weiGuanZhuBean) {

            }

            @Override
            public void onHomesuccess(HomeYuYueBean homeYuYueBean) {

            }

            @Override
            public void onHomesuccess(MovieDianZan movieDianZan) {

            }

            @Override
            public void onHomeFaiure(Throwable e) {
                    getView().onHomeFaiure(e);
            }
        });
    }

    @Override
    public void getPresenterguanzhu(Integer userId, String sessionId, Integer movieId) {
        homeModel.getModelguanzhu(userId, sessionId, movieId, new HomeContract.Imodel.ImodelCallBack() {
            @Override
            public void onHomesuccess(XBannerBean xBannerBean) {

            }

            @Override
            public void onHomesuccess(ReYingBean reYingBean) {

            }

            @Override
            public void onHomesuccess(ShangYingBean shangYingBean) {

            }

            @Override
            public void onHomesuccess(HomeBean homeBean) {

            }

            @Override
            public void onHomesuccess(XiangQingBean xiangQingBean) {

            }

            @Override
            public void onHomesuccess(YingPingBean yingPingBean) {

            }

            @Override
            public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {

            }

            @Override
            public void onHomesuccess(QuLeiBean quLeiBean) {

            }

            @Override
            public void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean) {

            }

            @Override
            public void onHomesuccess(ShiJianBean shiJianBean) {

            }

            @Override
            public void onHomesuccess(PriceBean priceBean) {

            }

            @Override
            public void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean) {

            }

            @Override
            public void onHomesuccess(YingTingBean yingTingBean) {

            }

            @Override
            public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {

            }

            @Override
            public void onHomeSuccess(XieYingPingBean xieYingPingBean) {

            }

            @Override
            public void onHomesuccess(XiaDanBean xiaDanBean) {

            }

            @Override
            public void onHomesuccess(ZhiFuBean zhiFuBean) {

            }

            @Override
            public void onHomesuccess(GuanZhuBean guanZhuBean) {
                //判断是否挂载
                if (isViewAttached()){
                    if (guanZhuBean.getStatus().equals(Constantes.SUCCESS_CODE)&&guanZhuBean!=null){
                        getView().onHomesuccess(guanZhuBean);
                    }else{
                        getView().onHomeFaiure(new Exception("服务器异常"));
                       Toast.makeText(App.getsAppContext(), guanZhuBean.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onHomesuccess(WeiGuanZhuBean weiGuanZhuBean) {

            }

            @Override
            public void onHomesuccess(HomeYuYueBean homeYuYueBean) {

            }

            @Override
            public void onHomesuccess(MovieDianZan movieDianZan) {

            }

            @Override
            public void onHomeFaiure(Throwable e) {
                getView().onHomeFaiure(e);
            }
        });
    }

    @Override
    public void getPresenterweiguanzhu(Integer userId, String sessionId, Integer movieId) {
        homeModel.getModelweiguanzhu(userId, sessionId, movieId, new HomeContract.Imodel.ImodelCallBack() {
            @Override
            public void onHomesuccess(XBannerBean xBannerBean) {

            }

            @Override
            public void onHomesuccess(ReYingBean reYingBean) {

            }

            @Override
            public void onHomesuccess(ShangYingBean shangYingBean) {

            }

            @Override
            public void onHomesuccess(HomeBean homeBean) {

            }

            @Override
            public void onHomesuccess(XiangQingBean xiangQingBean) {

            }

            @Override
            public void onHomesuccess(YingPingBean yingPingBean) {

            }

            @Override
            public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {

            }

            @Override
            public void onHomesuccess(QuLeiBean quLeiBean) {

            }

            @Override
            public void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean) {

            }

            @Override
            public void onHomesuccess(ShiJianBean shiJianBean) {

            }

            @Override
            public void onHomesuccess(PriceBean priceBean) {

            }

            @Override
            public void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean) {

            }

            @Override
            public void onHomesuccess(YingTingBean yingTingBean) {

            }

            @Override
            public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {

            }

            @Override
            public void onHomeSuccess(XieYingPingBean xieYingPingBean) {

            }

            @Override
            public void onHomesuccess(XiaDanBean xiaDanBean) {

            }

            @Override
            public void onHomesuccess(ZhiFuBean zhiFuBean) {

            }

            @Override
            public void onHomesuccess(GuanZhuBean guanZhuBean) {

            }

            @Override
            public void onHomesuccess(WeiGuanZhuBean weiGuanZhuBean) {
                    //判断是否挂载
                if (isViewAttached()){
                    if (weiGuanZhuBean.getStatus().equals(Constantes.SUCCESS_CODE)&&weiGuanZhuBean!=null){
                        getView().onHomesuccess(weiGuanZhuBean);
                    }else{
                        getView().onHomeFaiure(new Exception("服务器异常"));
                        Toast.makeText(App.getsAppContext(), weiGuanZhuBean.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onHomesuccess(HomeYuYueBean homeYuYueBean) {

            }

            @Override
            public void onHomesuccess(MovieDianZan movieDianZan) {

            }

            @Override
            public void onHomeFaiure(Throwable e) {
                getView().onHomeFaiure(e);
            }
        });
    }

    @Override
    public void getPresenterhomeyuyue(Integer userId, String sessionId, Integer movieId) {
        homeModel.getModelhomeyuyue(userId, sessionId, movieId, new HomeContract.Imodel.ImodelCallBack() {
            @Override
            public void onHomesuccess(XBannerBean xBannerBean) {

            }

            @Override
            public void onHomesuccess(ReYingBean reYingBean) {

            }

            @Override
            public void onHomesuccess(ShangYingBean shangYingBean) {

            }

            @Override
            public void onHomesuccess(HomeBean homeBean) {

            }

            @Override
            public void onHomesuccess(XiangQingBean xiangQingBean) {

            }

            @Override
            public void onHomesuccess(YingPingBean yingPingBean) {

            }

            @Override
            public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {

            }

            @Override
            public void onHomesuccess(QuLeiBean quLeiBean) {

            }

            @Override
            public void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean) {

            }

            @Override
            public void onHomesuccess(ShiJianBean shiJianBean) {

            }

            @Override
            public void onHomesuccess(PriceBean priceBean) {

            }

            @Override
            public void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean) {

            }

            @Override
            public void onHomesuccess(YingTingBean yingTingBean) {

            }

            @Override
            public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {

            }

            @Override
            public void onHomeSuccess(XieYingPingBean xieYingPingBean) {

            }

            @Override
            public void onHomesuccess(XiaDanBean xiaDanBean) {

            }

            @Override
            public void onHomesuccess(ZhiFuBean zhiFuBean) {

            }

            @Override
            public void onHomesuccess(GuanZhuBean guanZhuBean) {

            }

            @Override
            public void onHomesuccess(WeiGuanZhuBean weiGuanZhuBean) {

            }

            @Override
            public void onHomesuccess(HomeYuYueBean homeYuYueBean) {
                //判断是否挂载
                if (isViewAttached()){
                    if (homeYuYueBean.getStatus().equals(Constantes.SUCCESS_CODE)&&homeYuYueBean!=null){
                        getView().onHomesuccess(homeYuYueBean);
                    }else{
                        getView().onHomeFaiure(new Exception("服务器异常"));
                    //    Toast.makeText(App.getsAppContext(), homeYuYueBean.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onHomesuccess(MovieDianZan movieDianZan) {

            }

            @Override
            public void onHomeFaiure(Throwable e) {
                getView().onHomeFaiure(e);
            }
        });
    }

    @Override
    public void getPresenterdianzan(Integer userId, String sessionId, Integer commentId) {
        homeModel.getModeldianzan(userId, sessionId, commentId, new HomeContract.Imodel.ImodelCallBack() {
            @Override
            public void onHomesuccess(XBannerBean xBannerBean) {

            }

            @Override
            public void onHomesuccess(ReYingBean reYingBean) {

            }

            @Override
            public void onHomesuccess(ShangYingBean shangYingBean) {

            }

            @Override
            public void onHomesuccess(HomeBean homeBean) {

            }

            @Override
            public void onHomesuccess(XiangQingBean xiangQingBean) {

            }

            @Override
            public void onHomesuccess(YingPingBean yingPingBean) {

            }

            @Override
            public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {

            }

            @Override
            public void onHomesuccess(QuLeiBean quLeiBean) {

            }

            @Override
            public void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean) {

            }

            @Override
            public void onHomesuccess(ShiJianBean shiJianBean) {

            }

            @Override
            public void onHomesuccess(PriceBean priceBean) {

            }

            @Override
            public void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean) {

            }

            @Override
            public void onHomesuccess(YingTingBean yingTingBean) {

            }

            @Override
            public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {

            }

            @Override
            public void onHomeSuccess(XieYingPingBean xieYingPingBean) {

            }

            @Override
            public void onHomesuccess(XiaDanBean xiaDanBean) {

            }

            @Override
            public void onHomesuccess(ZhiFuBean zhiFuBean) {

            }

            @Override
            public void onHomesuccess(GuanZhuBean guanZhuBean) {

            }

            @Override
            public void onHomesuccess(WeiGuanZhuBean weiGuanZhuBean) {

            }

            @Override
            public void onHomesuccess(HomeYuYueBean homeYuYueBean) {

            }

            @Override
            public void onHomesuccess(MovieDianZan movieDianZan) {
                //判断是否挂载
                if (isViewAttached()){
                    if (movieDianZan.getStatus().equals(Constantes.SUCCESS_CODE)&&movieDianZan!=null){
                        getView().onHomesuccess(movieDianZan);
                    }else{
                        getView().onHomeFaiure(new Exception("服务器异常"));
                        Toast.makeText(App.getsAppContext(), movieDianZan.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onHomeFaiure(Throwable e) {
                    getView().onHomeFaiure(e);
            }
        });
    }
}
