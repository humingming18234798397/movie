package com.bw.movie.app;


/*
 *@auther:胡明明
 *@Date: 2019/11/11
 *@Time:16:17
 *@Description:${DESCRIPTION}
 **/

import com.bw.movie.bean.BirthBean;
import com.bw.movie.bean.ChaYingPingBean;
import com.bw.movie.bean.DaiFuKuanBean;
import com.bw.movie.bean.DingDanBean;
import com.bw.movie.bean.EmailBean;
import com.bw.movie.bean.ErWeiMaBean;
import com.bw.movie.bean.FanKuiBean;
import com.bw.movie.bean.GuanZhuBean;
import com.bw.movie.bean.GuanZhuMovie;
import com.bw.movie.bean.GuanZhuYingYuan;
import com.bw.movie.bean.HomeBean;
import com.bw.movie.bean.HomeSouSuoBean;
import com.bw.movie.bean.HomeYuYueBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.MovieBean;
import com.bw.movie.bean.MovieDianZan;
import com.bw.movie.bean.MoviePiaoBean;
import com.bw.movie.bean.OldMovieBean;
import com.bw.movie.bean.PhoneBean;
import com.bw.movie.bean.PriceBean;
import com.bw.movie.bean.PwdBean;
import com.bw.movie.bean.QuBean;
import com.bw.movie.bean.QuLeiBean;
import com.bw.movie.bean.ReYingBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.bean.ShangYingBean;
import com.bw.movie.bean.ShiJianBean;
import com.bw.movie.bean.ShiJianYingYuanBean;
import com.bw.movie.bean.TouXiangBean;
import com.bw.movie.bean.WXBean;
import com.bw.movie.bean.WeiGuanZhuBean;
import com.bw.movie.bean.XBannerBean;
import com.bw.movie.bean.XiTongMessage;
import com.bw.movie.bean.XiaDanBean;
import com.bw.movie.bean.XiangQingBean;
import com.bw.movie.bean.XieYingPingBean;
import com.bw.movie.bean.XuanZuoXinXiBean;
import com.bw.movie.bean.YYXQBean;
import com.bw.movie.bean.YiFuKuanBean;
import com.bw.movie.bean.YingPingBean;
import com.bw.movie.bean.YingTingBean;
import com.bw.movie.bean.YingYuanDianZan;
import com.bw.movie.bean.YingYuanFuJinBean;
import com.bw.movie.bean.YingYuanGuanZhu;
import com.bw.movie.bean.YingYuanPingLun;
import com.bw.movie.bean.YingYuanSouSuoBean;
import com.bw.movie.bean.YingYuanTuiJianBean;
import com.bw.movie.bean.YingYuanWeiGuanZhu;
import com.bw.movie.bean.YongHuBean;
import com.bw.movie.bean.YuYueBean;
import com.bw.movie.bean.ZhiFuBean;
import com.bw.movie.bean.ZhouQiBean;
import com.bw.movie.bean.ZuoWeiHaoBean;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface ApiService {

    //fasong发生邮箱post
    //  http://172.17.8.100/movieApi/user/v2/sendOutEmailCode
    @FormUrlEncoded
    @POST("movieApi/user/v2/sendOutEmailCode")
    Observable<EmailBean> getemail(@Field("email") String email);

    //注册post
    //http://172.17.8.100/movieApi/user/v2/register
    @FormUrlEncoded
    @POST("movieApi/user/v2/register")
    Observable<RegisterBean> getRegister(@Field("nickName") String nickName, @Field("pwd") String pwd, @Field("email") String email, @Field("code") String code);

    //登录post
    //http://172.17.8.100/movieApi/user/v2/login
    @FormUrlEncoded
    @POST("movieApi/user/v2/login")
    Observable<LoginBean> getLogin(@Field("email") String email, @Field("pwd") String pwd);

    //断点续传
    public static final String BASE_URL = "http://172.17.8.100/";

    @Streaming
    @GET
    Observable<ResponseBody> executeDownload(@Header("Range") String range, @Url() String url);

    //轮播图
    //http://172.17.8.100/movieApi/tool/v2/banner
    @GET("movieApi/tool/v2/banner")
    Observable<XBannerBean> getXBanner();

    //正在上映
    //http://172.17.8.100/movieApi/movie/v2/findReleaseMovieList?page=1&count=5
    @GET("movieApi/movie/v2/findReleaseMovieList")
    Observable<ReYingBean> getReYing(@Query("page") Integer page, @Query("count") Integer count);

    //即将上映
    //http://172.17.8.100/movieApi/movie/v2/findComingSoonMovieList?page=1&count=3
    @GET("movieApi/movie/v2/findComingSoonMovieList")
    Observable<ShangYingBean> getShangYing(@Query("page") Integer page, @Query("count") Integer count);

    //首页数据
    //http://172.17.8.100/movieApi/movie/v2/findHotMovieList?page=1&count=5
    @GET("movieApi/movie/v2/findHotMovieList")
    Observable<HomeBean> gethomedata(@Query("page") Integer page, @Query("count") Integer count);

    //区域查询
    //172.17.8.100/movieApi/cinema/v2/findCinemaByRegion
    @GET("movieApi/cinema/v2/findCinemaByRegion")
    Observable<QuBean> getqu(@Query("regionId") String regionId);

    //地区列表
    //172.17.8.100/movieApi/tool/v2/findRegionList
    @GET("movieApi/tool/v2/findRegionList")
    Observable<QuLeiBean> getqulei();

    //推荐影院
    //http://172.17.8.100/movieApi/cinema/v1/findRecommendCinemas?page=1&count=10
    @GET("movieApi/cinema/v1/findRecommendCinemas")
    Observable<YingYuanTuiJianBean> getYingYuantuijian(@Query("page") Integer page, @Query("count") Integer count);

    //fujin附近影院
    //http://172.17.8.100/movieApi/cinema/v1/findNearbyCinemas?longitude=116.30551391385724&latitude=40.04571807462411&page=1&count=10
    @GET("movieApi/cinema/v1/findNearbyCinemas")
    Observable<YingYuanFuJinBean> getYingYuanfujin(@Query("longitude") String longitude, @Query("latitude") String latitude, @Query("page") Integer page, @Query("count") Integer count);

    //详情
    //http://172.17.8.100/movieApi/movie/v2/findMoviesDetail?movieId=22
    @GET("movieApi/movie/v2/findMoviesDetail")
    Observable<XiangQingBean> getXiangQing(@Query("movieId") Integer movieId);

    //影评
    //http://172.17.8.100/movieApi/movie/v2/findAllMovieComment?movieId=1&page=1&count=10
    @GET("movieApi/movie/v2/findAllMovieComment")
    Observable<YingPingBean> getYingPing(@Query("movieId") Integer movieId, @Query("page") Integer page, @Query("count") Integer count);

    //首页搜索
    //http://172.17.8.100/movieApi/movie/v2/findMovieByKeyword?keyword=我&page=1&count=5
    @GET("movieApi/movie/v2/findMovieByKeyword")
    Observable<HomeSouSuoBean> getSouSuo(@Query("keyword") String keyword, @Query("page") Integer page, @Query("count") Integer count);

    //影院搜索模糊查询
    //http://172.17.8.100/movieApi/cinema/v1/findAllCinemas?cinemaName=万&page=1&count=10
    @GET("movieApi/cinema/v1/findAllCinemas")
    Observable<YingYuanSouSuoBean> getchaxun(@Query("cinemaName") String cinemaName, @Query("page") Integer page, @Query("count") Integer count);

    //yi影院信息
    //http://172.17.8.100/movieApi/movie/v2/findCinemasInfoByRegion?movieId=22&regionId=1&page=1&count=10
    @GET("movieApi/movie/v2/findCinemasInfoByRegion")
    Observable<XuanZuoXinXiBean> getxinxi(@Query("movieId") Integer movieId, @Query("regionId") Integer regionId, @Query("page") Integer page, @Query("count") Integer count);

    //时间
    //http://172.17.8.100/movieApi/tool/v2/findDateList
    @GET("movieApi/tool/v2/findDateList")
    Observable<ShiJianBean> getshijian();
    //时间查询影院信息

    //http://172.17.8.100/movieApi/movie/v2/findCinemasInfoByDate?movieId=22&date=11-20&page=1&count=5
    @GET("movieApi/movie/v2/findCinemasInfoByDate")
    Observable<ShiJianYingYuanBean> getshijianyingyuan(@Query("movieId") Integer movieId, @Query("date") String date, @Query("page") Integer page, @Query("count") Integer count);

    //价格
    //http://172.17.8.100/movieApi/movie/v2/findCinemasInfoByPrice?movieId=22&page=1&count=5
    @GET("movieApi/movie/v2/findCinemasInfoByPrice")
    Observable<PriceBean> getprice(@Query("movieId") Integer movieId, @Query("page") Integer page, @Query("count") Integer count);

    //chaxun查询影厅
    //http://172.17.8.100/movieApi/movie/v2/findMovieSchedule?movieId=22&cinemaId=1
    @GET("movieApi/movie/v2/findMovieSchedule")
    Observable<YingTingBean> getyingting(@Query("movieId") Integer movieId, @Query("cinemaId") Integer cinemaId);

    //选座
    //http://172.17.8.100/movieApi/movie/v2/findSeatInfo?hallId=3
    @GET("movieApi/movie/v2/findSeatInfo")
    Observable<ZuoWeiHaoBean> getzuowei(@Query("hallId") Integer hallId);

    //ying影院详情
    //http://172.17.8.100/movieApi/cinema/v1/findCinemaInfo?cinemaId=1
    @GET("movieApi/cinema/v1/findCinemaInfo")
    Observable<YYXQBean> getyyxq(@Query("cinemaId") Integer cinemaId);

    //影院评论
    //http://172.17.8.100/movieApi/cinema/v1/findAllCinemaComment?cinemaId=18&page=1&count=5
    @GET("movieApi/cinema/v1/findAllCinemaComment")
    Observable<YingYuanPingLun> getpinglun(@Query("cinemaId") Integer cinemaId, @Query("page") Integer page, @Query("count") Integer count);

    //ying写影评
    //http://172.17.8.100/movieApi/movie/v1/verify/movieComment
    @FormUrlEncoded
    @POST("movieApi/movie/v1/verify/movieComment")
    Observable<XieYingPingBean> getxieyingping(@Header("userId") Integer userId, @Header("sessionId") String sessionId, @Field("movieId") Integer movieId, @Field("commentContent") String commentContent, @Field("score") Double score);

    //zhou周期
    //http://172.17.8.100/movieApi/cinema/v2/findCinemaScheduleList?cinemaId=5&page=1&count=10
    @GET("movieApi/cinema/v2/findCinemaScheduleList")
    Observable<ZhouQiBean> getzhouqi(@Query("cinemaId") Integer cinemaId, @Query("page") Integer page, @Query("count") Integer count);

    //下单
    //http://172.17.8.100/movieApi/movie/v2/verify/buyMovieTickets
    @FormUrlEncoded
    @POST("movieApi/movie/v2/verify/buyMovieTickets")
    Observable<XiaDanBean> getxiadan(@Header("userId") Integer userId, @Header("sessionId") String sessionId, @Field("scheduleId") String scheduleId, @Field("seat") String seat, @Field("sign") String sign);

    //z支付
    //http://172.17.8.100/movieApi/movie/v2/verify/pay
    @FormUrlEncoded
    @POST("http://172.17.8.100/movieApi/movie/v2/verify/pay")
    Observable<ZhiFuBean> getzhifu(@Header("userId") Integer userId, @Header("sessionId") String sessionId, @Field("payType") Integer payType, @Field("orderId") String orderId);

    //购票记录
    //http://172.17.8.100/movieApi/user/v2/verify/findUserBuyTicketRecord?page=1&count=10&status=1
    @GET("movieApi/user/v2/verify/findUserBuyTicketRecord")
    Observable<DaiFuKuanBean> getdaifukuan(@Header("userId") Integer userId, @Header("sessionId") String sessionId, @Query("page") Integer page, @Query("count") Integer count, @Query("status") Integer status);

    @GET("movieApi/user/v2/verify/findUserBuyTicketRecord")
    Observable<YiFuKuanBean> getyifukuan(@Header("userId") Integer userId, @Header("sessionId") String sessionId, @Query("page") Integer page, @Query("count") Integer count, @Query("status") Integer status);

    //查看电影评轮
    //http://172.17.8.100/movieApi/user/v2/verify/findMyMovieCommentList?page=1&count=10
    @GET("movieApi/user/v2/verify/findMyMovieCommentList")
    Observable<MovieBean> getdianying(@Header("userId") Integer userId, @Header("sessionId") String sessionId, @Query("page") Integer page, @Query("count") Integer count);

    //查看影院评轮
    //http://172.17.8.100/movieApi/user/v2/verify/findMyCinemaCommentList?longitude=0&latitude=0&page=1&count=5
    @GET("movieApi/user/v2/verify/findMyCinemaCommentList")
    Observable<ChaYingPingBean> getchayingping(@Header("userId") Integer userId, @Header("sessionId") String sessionId, @Query("longitude") String longitude, @Query("latitude") String latitude, @Query("page") Integer page, @Query("count") Integer count);

    //查看关注电影
    //http://172.17.8.100/movieApi/user/v2/verify/findUserFollowMovieList?page=1&count=5
    @GET("movieApi/user/v2/verify/findUserFollowMovieList")
    Observable<GuanZhuMovie> getguanzhumovie(@Header("userId") Integer userId, @Header("sessionId") String sessionId, @Query("page") Integer page, @Query("count") Integer count);

    //查看关注影院
    //http://172.17.8.100/movieApi/user/v2/verify/findUserFollowCinemaList?page=1&count=5
    @GET("movieApi/user/v2/verify/findUserFollowCinemaList")
    Observable<GuanZhuYingYuan> getguanzhuyingyuan(@Header("userId") Integer userId, @Header("sessionId") String sessionId, @Query("page") Integer page, @Query("count") Integer count);

    //关注电影
    //http://172.17.8.100/movieApi/movie/v1/verify/followMovie?movieId=12
    @GET("movieApi/movie/v1/verify/followMovie")
    Observable<GuanZhuBean> getguanzhu(@Header("userId") Integer userId, @Header("sessionId") String sessionId, @Query("movieId") Integer movieId);

    //qu取消关注
    //http://172.17.8.100/movieApi/movie/v1/verify/cancelFollowMovie?movieId=12
    @GET("movieApi/movie/v1/verify/cancelFollowMovie")
    Observable<WeiGuanZhuBean> getweiguanzhu(@Header("userId") Integer userId, @Header("sessionId") String sessionId, @Query("movieId") Integer movieId);

    //关注影院
    //http://172.17.8.100/movieApi/cinema/v1/verify/followCinema?cinemaId=3
    @GET("movieApi/cinema/v1/verify/followCinema")
    Observable<YingYuanGuanZhu> getyingyuanguanzhu(@Header("userId") Integer userId, @Header("sessionId") String sessionId, @Query("cinemaId") Integer cinemaId);

    //取消关注影院
    //http://172.17.8.100/movieApi/cinema/v1/verify/cancelFollowCinema?cinemaId=3
    @GET("movieApi/cinema/v1/verify/cancelFollowCinema")
    Observable<YingYuanWeiGuanZhu> getyingyuanweiguanzhu(@Header("userId") Integer userId, @Header("sessionId") String sessionId, @Query("cinemaId") Integer cinemaId);

    //cha查看订单详情
    //http://172.17.8.100/movieApi/user/v2/verify/findBuyTicketRecordByOrderId?orderId=20191130145904744
    @GET("movieApi/user/v2/verify/findBuyTicketRecordByOrderId")
    Observable<DingDanBean> getdingdan(@Header("userId") Integer userId, @Header("sessionId") String sessionId, @Query("orderId") String orderId);

    //我的预约
    //http://172.17.8.100/movieApi/user/v2/verify/findUserReserve
    @GET("movieApi/user/v2/verify/findUserReserve")
    Observable<YuYueBean> getyuyue(@Header("userId") Integer userId, @Header("sessionId") String sessionId);

    //yueyue预约
    //http://172.17.8.100/movieApi/movie/v2/verify/reserve
    @FormUrlEncoded
    @POST("movieApi/movie/v2/verify/reserve")
    Observable<HomeYuYueBean> gethomeyuyue(@Header("userId") Integer userId, @Header("sessionId") String sessionId, @Field("movieId") Integer movieId);

    //电影点赞
    //http://172.17.8.100/movieApi/movie/v1/verify/movieCommentGreat
    @FormUrlEncoded
    @POST("movieApi/movie/v1/verify/movieCommentGreat")
    Observable<MovieDianZan> getmoviedianzan(@Header("userId") Integer userId, @Header("sessionId") String sessionId, @Field("commentId") Integer commentId);

    //查看系统消息
    //http://172.17.8.100/movieApi/tool/v1/verify/findAllSysMsgList?page=1&count=10
    @GET("movieApi/tool/v1/verify/findAllSysMsgList")
    Observable<XiTongMessage> getxitongmessage(@Header("userId") Integer userId, @Header("sessionId") String sessionId, @Query("page") Integer page, @Query("count") Integer count);

    //电影票
    //http://172.17.8.100/movieApi/user/v2/verify/findMyMovieTicket
    @GET("movieApi/user/v2/verify/findMyMovieTicket")
    Observable<MoviePiaoBean> getmoviepiao(@Header("userId") Integer userId, @Header("sessionId") String sessionId);

    //二维码
    //http://172.17.8.100/movieApi/user/v2/verify/findExchangeCode?recordId=5426
    @GET("movieApi/user/v2/verify/findExchangeCode")
    Observable<ErWeiMaBean> getmovieerweima(@Header("userId") Integer userId, @Header("sessionId") String sessionId, @Query("recordId") Integer recordId);

    //yi意见反馈
    //http://172.17.8.100/movieApi/tool/v1/verify/recordFeedBack
    @FormUrlEncoded
    @POST("movieApi/tool/v1/verify/recordFeedBack")
    Observable<FanKuiBean> getfanmkui(@Header("userId") Integer userId, @Header("sessionId") String sessionId, @Field("content") String content);

    //看过的电影
    //http://172.17.8.100/movieApi/user/v2/verify/findSeenMovie
    @GET("movieApi/user/v2/verify/findSeenMovie")
    Observable<OldMovieBean> getoldmovel(@Header("userId") Integer userId, @Header("sessionId") String sessionId);

    //微信登录
    //http://172.17.8.100/movieApi/user/v1/weChatBindingLogin
    @FormUrlEncoded
    @POST("movieApi/user/v1/weChatBindingLogin")
    Observable<WXBean> getweixin(@Field("code") String code);

    //上传头像
    //http://172.17.8.100/movieApi/user/v1/verify/uploadHeadPic
    @Multipart
    @POST("movieApi/user/v1/verify/uploadHeadPic")
    Observable<TouXiangBean> gettouxiang(@Header("userId") Integer userId, @Header("sessionId") String sessionId, @Part MultipartBody.Part image);

    //用户信息
    //http://172.17.8.100/movieApi/user/v1/verify/getUserInfoByUserId
    @GET("movieApi/user/v1/verify/getUserInfoByUserId")
    Observable<YongHuBean> getyonghu(@Header("userId") Integer userId, @Header("sessionId") String sessionId);

    //xiugai修改密码
    //http://172.17.8.100/movieApi/user/v1/verify/modifyUserPwd
    @FormUrlEncoded
    @POST("movieApi/user/v1/verify/modifyUserPwd")
    Observable<PwdBean> getpwd(@Header("userId") Integer userId, @Header("sessionId") String sessionId, @Field("oldPwd") String oldPwd, @Field("newPwd") String newPwd, @Field("newPwd2") String newPwd2);

    //修改手机号
    //http://172.17.8.100/movieApi/user/v2/verify/updateUserPhone
    @FormUrlEncoded
    @POST("movieApi/user/v2/verify/updateUserPhone")
    Observable<PhoneBean> getphone(@Header("userId") Integer userId, @Header("sessionId") String sessionId, @Field("phone") String phone);

    //http://172.17.8.100/movieApi/user/v2/verify/updateUserBirthday修改生日
    @FormUrlEncoded
    @POST("movieApi/user/v2/verify/updateUserBirthday")
    Observable<BirthBean> getBirth(@Header("userId") Integer userId, @Header("sessionId") String sessionId, @Field("birthday") String birthday);

    //影院点赞
    //http://172.17.8.100/movieApi/cinema/v1/verify/cinemaCommentGreat
    @FormUrlEncoded
    @POST("movieApi/cinema/v1/verify/cinemaCommentGreat")
    Observable<YingYuanDianZan> getyingyuandianzan(@Header("userId") Integer userId, @Header("sessionId") String sessionId, @Field("commentId") Integer commentId);
}
