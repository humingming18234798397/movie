package com.bw.movie.contract;


/**
 *@describe(描述)：HomeContract
 *@data（日期）: 2019/11/19
 *@time（时间）: 18:31
 *@author（作者）: 胡明明
 **/

import android.content.Intent;

import com.bw.movie.base.IBaseView;
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

import retrofit2.http.Field;
import retrofit2.http.Header;

//首页契约类
public interface HomeContract {
    //view
    interface Iview extends IBaseView {
        //轮播图
        void onHomesuccess(XBannerBean xBannerBean);
        //热映
        void onHomesuccess(ReYingBean reYingBean);
        //即将上映
        void onHomesuccess(ShangYingBean shangYingBean);
        //热门
        void onHomesuccess(HomeBean homeBean);
        //详情
        void onHomesuccess(XiangQingBean xiangQingBean);
        //影评
        void onHomesuccess(YingPingBean yingPingBean);
        //首页搜索
        void onHomesuccess(HomeSouSuoBean homeSouSuoBean);
        //id
        void onHomesuccess(QuLeiBean quLeiBean);
        //选座影院信息
        void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean);
        //时间周期
        void onHomesuccess(ShiJianBean shiJianBean);
        //价格
        void onHomesuccess(PriceBean priceBean);
        //shiji时间查询影院
        void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean);
        //cha查询影厅
        void onHomesuccess(YingTingBean yingTingBean);
        void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean);
        //xie写影评
        void onHomesuccess(XieYingPingBean xieYingPingBean);
        //下单
        void onHomesuccess(XiaDanBean xiaDanBean);
        //支付
        void onHomesuccess(ZhiFuBean zhiFuBean);
        void onHomesuccess(GuanZhuBean guanZhuBean);
        void onHomesuccess(WeiGuanZhuBean weiGuanZhuBean);
        void onHomesuccess(HomeYuYueBean homeYuYueBean);
        //dianzan点赞
        void onHomesuccess(MovieDianZan movieDianZan);
        //shibai 失败的方法
        void onHomeFaiure(Throwable e);
    }
    //model
    interface Imodel{
        //轮播图
        void getModelXbanner(ImodelCallBack imodelCallBack);
        //热映
        void getModelReYing(Integer page,Integer count,ImodelCallBack imodelCallBack);
        //即将上映
        void getModelShangYing(Integer page,Integer count,ImodelCallBack imodelCallBack);
        //热门
        void getModelHome(Integer page,Integer count,ImodelCallBack imodelCallBack);
        //详情
        void getModelXiangQing(Integer movieId,ImodelCallBack imodelCallBack);
        //影评
        void getModelYingPing(Integer movieId,Integer page,Integer count,ImodelCallBack imodelCallBack);
        //    //首页搜索
        void getModelSouSuo(String keyword,Integer page,Integer count,ImodelCallBack imodelCallBack);
        //选座影院信息
        void getModelXinXi(Integer movieId,Integer regionId,Integer page,Integer count,ImodelCallBack imodelCallBack);
        void getModelQuLei(ImodelCallBack imodelCallBack);
        void getModelshijian(ImodelCallBack imodelCallBack);
        void getModelPrice(Integer movieId,Integer page,Integer count,ImodelCallBack imodelCallBack);
        void getModelshijianyingyuan(Integer movieId,String date,Integer page,Integer count,ImodelCallBack imodelCallBack);
        void getModelyingting(Integer movieId, Integer cinemaId, ImodelCallBack imodelCallBack);
        void getModelzuowei(Integer hallId, ImodelCallBack imodelCallBack);
        void getModelxieyp(Integer userId,String sessionId,Integer movieId,String commentContent,Double score, ImodelCallBack imodelCallBack);
        void getModelxiadan(Integer userId,String sessionId,String scheduleId,String seat,String sign,ImodelCallBack imodelCallBack);
        void getModelzhifu(Integer userId,String sessionId,Integer payType,String orderId,ImodelCallBack imodelCallBack);
        void getModelguanzhu(Integer userId,String sessionId,Integer movieId,ImodelCallBack imodelCallBack);
        void getModelweiguanzhu(Integer userId,String sessionId,Integer movieId,ImodelCallBack imodelCallBack);
        void getModelhomeyuyue(Integer userId,String sessionId,Integer movieId,ImodelCallBack imodelCallBack);
        void getModeldianzan(Integer userId,String sessionId,Integer commentId,ImodelCallBack imodelCallBack);


        interface ImodelCallBack{
            void onHomesuccess(XBannerBean xBannerBean);
            void onHomesuccess(ReYingBean reYingBean);
            void onHomesuccess(ShangYingBean shangYingBean);
            void onHomesuccess(HomeBean homeBean);
            void onHomesuccess(XiangQingBean xiangQingBean);
            void onHomesuccess(YingPingBean yingPingBean);
            void onHomesuccess(HomeSouSuoBean homeSouSuoBean);
            void onHomesuccess(QuLeiBean quLeiBean);
            void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean);
            //时间周期
            void onHomesuccess(ShiJianBean shiJianBean);
            void onHomesuccess(PriceBean priceBean);
            void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean);
            void onHomesuccess(YingTingBean yingTingBean);
            void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean);
            //xie写影评
            void onHomeSuccess(XieYingPingBean xieYingPingBean);
            //下单
            void onHomesuccess(XiaDanBean xiaDanBean);
            //支付
            void onHomesuccess(ZhiFuBean zhiFuBean);
            void onHomesuccess(GuanZhuBean guanZhuBean);
            void onHomesuccess(WeiGuanZhuBean weiGuanZhuBean);
            void onHomesuccess(HomeYuYueBean homeYuYueBean);
            //dianzan点赞
            void onHomesuccess(MovieDianZan movieDianZan);
            void onHomeFaiure(Throwable e);
        }
    }
    //presenter
    interface Ipresenter{
        //轮播图
        void getPresenterXbanner();
        //热映
        void getPresenterReYing(Integer page,Integer count);
       // 即将上映
        void getPresenterShangYing(Integer page,Integer count);
        //热门
        void getPresenterHome(Integer page,Integer count);
        //详情
        void getModelXiangQing(Integer movieId);
        //影评
        void getPresenterYingPing(Integer movieId,Integer page,Integer count);
        //首页搜索
        void getPresenterSouSuo(String keyword,Integer page,Integer count);
        void getModelQuLei();
        //yng影院信息
        void getPresenterXinXi(Integer movieId,Integer regionId,Integer page,Integer count);
        //时间周期
        void getPresentershijian();
        //价格
        void getPresenterPrice(Integer movieId,Integer page,Integer count);
        //
        void getPresentershijianyingyuan(Integer movieId,String date,Integer page,Integer count);
        //
        void getPresenteryingting(Integer movieId, Integer cinemaId);
        void getPresenterzuowei(Integer hallId);
        void getPresenterxieyp(Integer userId,String sessionId,Integer movieId,String commentContent,Double score);
        void getPresenterxiadan(Integer userId,String sessionId,String scheduleId,String seat,String sign);
        //支付
        void getPresenterzhifu(Integer userId,String sessionId,Integer payType,String orderId);
        void getPresenterguanzhu(Integer userId,String sessionId,Integer movieId);
        void getPresenterweiguanzhu(Integer userId,String sessionId,Integer movieId);

        void getPresenterhomeyuyue(Integer userId,String sessionId,Integer movieId);
        void getPresenterdianzan(Integer userId,String sessionId,Integer commentId);
    }
}
