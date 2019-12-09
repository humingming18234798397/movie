package com.bw.movie.frag.xiangqing;


/*
 *@auther:胡明明
 *@Date: 2019/11/14
 *@Time:21:38
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.adapter.YingPingAdapter;
import com.bw.movie.base.BaseFragment;
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
import com.bw.movie.presenter.HomePresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;

public class YingPingFragment extends BaseFragment<HomePresenter> implements HomeContract.Iview {
  @BindView(R.id.yingping_xrlv)
    XRecyclerView yingpingXrlv;
    private int userId;
    private String s;
    private SharedPreferences sp;
    int page = 1;
    private int key;
    /*  @BindView(R.id.yingping_xrlv)
    RecyclerView yingpingXrlv;*/

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.xiangqing_yingping;
    }

    @Override
    protected void initData() {
        super.initData();
        sp = getActivity().getSharedPreferences("movie", Context.MODE_PRIVATE);
        userId = sp.getInt("u", 0);
        s = sp.getString("s", null);


        //下拉刷新,上拉加载
        yingpingXrlv.setPullRefreshEnabled(true);
        yingpingXrlv.setLoadingMoreEnabled(true);
        yingpingXrlv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page=1;
                mPresenter.getPresenterYingPing(key, page, 10);
                yingpingXrlv.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                page++;
                mPresenter.getPresenterYingPing(key, page, 10);
                yingpingXrlv.loadMoreComplete();
            }
        });
        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        yingpingXrlv.setLayoutManager(linearLayoutManager);
        //jieshou接受movedid
        Intent intent = getActivity().getIntent();
        key = intent.getIntExtra("key", 0);
        //jiekou 接口
        mPresenter.getPresenterYingPing(key, 1, 5);

    }

    @Override
    public void onHomesuccess(XBannerBean xBannerBean) {

    }

    //正在上映
    @Override
    public void onHomesuccess(ReYingBean reYingBean) {

    }

    //即将上映
    @Override
    public void onHomesuccess(ShangYingBean shangYingBean) {

    }

    //热门电影
    @Override
    public void onHomesuccess(HomeBean homeBean) {

    }

    //详情
    @Override
    public void onHomesuccess(XiangQingBean xiangQingBean) {

    }

    //影评
    @Override
    public void onHomesuccess(YingPingBean yingPingBean) {
          if (yingPingBean!=null){
              List<YingPingBean.ResultBean> result = yingPingBean.getResult();
             if (result!=null){
                 YingPingAdapter yingPingAdapter = new YingPingAdapter(getActivity());
                 yingPingAdapter.setList(result);
                 yingpingXrlv.setAdapter(yingPingAdapter);
                 yingPingAdapter.setSetChangeAdapter(new YingPingAdapter.setChangeAdapter() {
                     @Override
                     public void getChang(int p) {
                         mPresenter.getPresenterdianzan(userId,s,p);
                     }
                 });
             }
          }else{
              Toast.makeText(getActivity(), yingPingBean.getMessage(), Toast.LENGTH_SHORT).show();
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
    public void onHomesuccess(XieYingPingBean xieYingPingBean) {

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
            if (movieDianZan.getStatus().equals("0000")){
                Toast.makeText(getActivity(), ""+movieDianZan.getMessage(), Toast.LENGTH_SHORT).show();
            }
    }

    @Override
    public void onHomeFaiure(Throwable e) {

    }
}
