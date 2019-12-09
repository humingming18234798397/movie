package com.bw.movie.contract;


import com.bw.movie.base.IBaseView;
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

import okhttp3.MultipartBody;
import retrofit2.http.Field;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 *@describe(描述)：MyContract
 *@data（日期）: 2019/11/30
 *@time（时间）: 11:48
 *@author（作者）: 胡明明
 **/

//我的页面  契约类
public interface MyContract {
    interface Iview extends IBaseView {
        void onMysuccess(DaiFuKuanBean daiFuKuanBean);
        void onMysuccess(YiFuKuanBean yiFuKuanBean);
        void onMysuccess(MovieBean movieBean);
        void onMysuccess(ChaYingPingBean chaYingPingBean);
        void onMysuccess(GuanZhuMovie guanZhuMovie);
        void onMysuccess(GuanZhuYingYuan guanZhuYingYuan);
        void onMysuccess(DingDanBean dingDanBean);
        //支付
        void onMysuccess(ZhiFuBean zhiFuBean);
        void onMysuccess(YuYueBean yuYueBean);
        void onMysuccess(XiTongMessage xiTongMessage);
        void onMysuccess(MoviePiaoBean moviePiaoBean);
        void onMysuccess(ErWeiMaBean erWeiMaBean);
        void onMysuccess(FanKuiBean fanKuiBean);
        void onMysuccess(OldMovieBean oldMovieBean);
        void onMysuccess(TouXiangBean touXiangBean);
        void onMysuccess(YongHuBean yongHuBean);
        //修改密码
        void onMysuccess(PwdBean pwdBean);
        //修改手机号
        void onMysuccess(PhoneBean phoneBean);
        void onMysuccess(BirthBean birthBean);
        void onMyFaiure(Throwable e);
    }
    interface Imodel{
        void getModeldaifukuan(Integer userId,String sessionId,Integer page,Integer count,Integer status,ImodelCallback imodelCallback);
        void getModelyifukuan(Integer userId,String sessionId,Integer page,Integer count,Integer status,ImodelCallback imodelCallback);
        void getModeldianying(Integer userId,String sessionId,Integer page,Integer count,ImodelCallback imodelCallback);
        void getModelchayingping(Integer userId,String sessionId,String longitude,String latitude,Integer page,Integer count,ImodelCallback imodelCallback);
        void getModelguanzhumovie(Integer userId,String sessionId,Integer page,Integer count,ImodelCallback imodelCallback);
        void getModelguanzhuyingyuan(Integer userId,String sessionId,Integer page,Integer count,ImodelCallback imodelCallback);
        void getModeldingdan(Integer userId,String sessionId,String orderId,ImodelCallback imodelCallback);
        void getModelzhifu(Integer userId,String sessionId,Integer payType,String orderId,ImodelCallback imodelCallback);
        void getModelyuyue(Integer userId,String sessionId,ImodelCallback imodelCallback);
        void getModelmessage(Integer userId,String sessionId,Integer page,Integer count,ImodelCallback imodelCallback);
        void getModelmoviepiao(Integer userId,String sessionId,ImodelCallback imodelCallback);
        void getModelerweima(Integer userId,String sessionId,Integer recordId,ImodelCallback imodelCallback);
        void getModelfankui(Integer userId,String sessionId,String content,ImodelCallback imodelCallback);
        void getModeloldmovie(Integer userId,String sessionId,ImodelCallback imodelCallback);
        void getModeltouxiang(Integer userId, String sessionId, MultipartBody.Part image, ImodelCallback imodelCallback);
        void getModelyonghu(Integer userId,String sessionId,ImodelCallback imodelCallback);
        void getModelpwd(Integer userId, String sessionId, String oldPwd,String newPwd,String newPwd2,ImodelCallback imodelCallback);
        void getModelphone(Integer userId,String sessionId,String phone,ImodelCallback imodelCallback);
        void getModelriqi(Integer userId,String sessionId,String birthday,ImodelCallback imodelCallback);
        interface ImodelCallback{
            void onMysuccess(DaiFuKuanBean daiFuKuanBean);
            void onMysuccess(YiFuKuanBean yiFuKuanBean);
            void onMysuccess(MovieBean movieBean);
            void onMysuccess(ChaYingPingBean chaYingPingBean);
            void onMysuccess(GuanZhuMovie guanZhuMovie);
            void onMysuccess(GuanZhuYingYuan guanZhuYingYuan);
            void onMysuccess(DingDanBean dingDanBean);
            //支付
            void onMysuccess(ZhiFuBean zhiFuBean);
            void onMysuccess(YuYueBean yuYueBean);
            void onMysuccess(XiTongMessage xiTongMessage);
            void onMysuccess(MoviePiaoBean moviePiaoBean);
            void onMysuccess(ErWeiMaBean erWeiMaBean);
            void onMysuccess(FanKuiBean fanKuiBean);
            void onMysuccess(OldMovieBean oldMovieBean);
            void onMysuccess(TouXiangBean touXiangBean);
            void onMysuccess(YongHuBean yongHuBean);
            //修改密码
            void onMysuccess(PwdBean pwdBean);
            //修改手机号
            void onMysuccess(PhoneBean phoneBean);
            void onMysuccess(BirthBean birthBean);
            void onMyFaiure(Throwable e);
        }
    }
    interface IPresenter{
        void getPresenterdaifukuan(Integer userId,String sessionId,Integer page,Integer count,Integer status);
        void getPresenteryifukuan(Integer userId,String sessionId,Integer page,Integer count,Integer status);
        void getPresenterdianying(Integer userId,String sessionId,Integer page,Integer count);
        void getPresenterchayingping(Integer userId,String sessionId,String longitude,String latitude,Integer page,Integer count);
        void getPresenterguanzhumovie(Integer userId,String sessionId,Integer page,Integer count);
        void getPresenterguanzhuyingyuan(Integer userId,String sessionId,Integer page,Integer count);
        void getPresenterdingdan(Integer userId,String sessionId,String orderId);
        //支付
        void getPresenterzhifu(Integer userId,String sessionId,Integer payType,String orderId);
        void getPresenteryuyue(Integer userId,String sessionId);
        void getPresentermessage(Integer userId,String sessionId,Integer page,Integer count);
        void getPresentermoviepiao(Integer userId,String sessionId);
        void getPresentererweima(Integer userId,String sessionId,Integer recordId);
        void getPresenterfankui(Integer userId,String sessionId,String content);
        void getPresenteroldmovie(Integer userId,String sessionId);
        void getPresentertouxiang(Integer userId,String sessionId,MultipartBody.Part image);
        void getPresenteryonghu(Integer userId,String sessionId);
        void getPresenterpwd(Integer userId, String sessionId, String oldPwd,String newPwd,String newPwd2);
        void getPresenterphone(Integer userId,String sessionId,String phone);
        void getPresenterriqi(Integer userId,String sessionId,String birthday);
    }
}
