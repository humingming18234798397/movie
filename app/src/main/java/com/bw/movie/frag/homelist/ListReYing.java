package com.bw.movie.frag.homelist;


/*
 *@auther:胡明明
 *@Date: 2019/11/17
 *@Time:19:41
 *@Description:${DESCRIPTION}
 **/

import android.content.Intent;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.bw.movie.R;
import com.bw.movie.activity.XiangQingActivity;
import com.bw.movie.adapter.HomeListAdaprer;
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

public class ListReYing extends BaseFragment<HomePresenter> implements HomeContract.Iview {
    @BindView(R.id.listreying_xrlv)
    XRecyclerView listreyingXrlv;
int page = 1;
    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.homelist_reying;
    }

    @Override
    protected void initData() {
        super.initData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        listreyingXrlv.setLayoutManager(linearLayoutManager);
        //下拉刷新,上拉加载
        listreyingXrlv.setPullRefreshEnabled(true);
        listreyingXrlv.setLoadingMoreEnabled(true);
        listreyingXrlv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page=1;
                mPresenter.getPresenterReYing(page,5);
                listreyingXrlv.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                page++;
                mPresenter.getPresenterReYing(page,5);
                listreyingXrlv.loadMoreComplete();
            }
        });
        mPresenter.getPresenterReYing(1,5);
    }

    @Override
    public void onHomesuccess(XBannerBean xBannerBean) {

    }
//热映
    @Override
    public void onHomesuccess(ReYingBean reYingBean) {
        List<ReYingBean.ResultBean> result = reYingBean.getResult();
        HomeListAdaprer homeListAdaprer = new HomeListAdaprer(getActivity());
        homeListAdaprer.setList(result);
        listreyingXrlv.setAdapter(homeListAdaprer);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        listreyingXrlv.setLayoutManager(linearLayoutManager);
        homeListAdaprer.setOnItemClicks(new HomeListAdaprer.onItemClicks() {
            @Override
            public void onChangeData(int p) {
                Intent intent = new Intent(getActivity(), XiangQingActivity.class);
                intent.putExtra("key",p);
                startActivity(intent);
            }
        });
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

    }

    @Override
    public void onHomeFaiure(Throwable e) {

    }
}
