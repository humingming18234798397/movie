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
import com.bw.movie.adapter.HomeListAdaprer2;
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

public class ListReMen extends BaseFragment<HomePresenter> implements HomeContract.Iview {
    @BindView(R.id.listremen_xrlv)
    XRecyclerView listremenXrlv;
int page = 1;
    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.homelist_remen;
    }

    @Override
    protected void initData() {
        super.initData();
        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        listremenXrlv.setLayoutManager(linearLayoutManager);
        //下拉刷新,上拉加载
        listremenXrlv.setPullRefreshEnabled(true);
        listremenXrlv.setLoadingMoreEnabled(true);
        listremenXrlv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page=1;
                mPresenter.getPresenterHome(page,5);
                listremenXrlv.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                page++;
                mPresenter.getPresenterHome(page,5);
                listremenXrlv.loadMoreComplete();
            }
        });
        mPresenter.getPresenterHome(1,5);
    }

    @Override
    public void onHomesuccess(XBannerBean xBannerBean) {

    }

    @Override
    public void onHomesuccess(ReYingBean reYingBean) {

    }

    @Override
    public void onHomesuccess(ShangYingBean shangYingBean) {

    }
//热门
    @Override
    public void onHomesuccess(HomeBean homeBean) {
        List<HomeBean.ResultBean> result = homeBean.getResult();
        HomeListAdaprer2 homeListAdaprer2 = new HomeListAdaprer2(getActivity());
        homeListAdaprer2.setList(result);
        listremenXrlv.setAdapter(homeListAdaprer2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        listremenXrlv.setLayoutManager(linearLayoutManager);
        homeListAdaprer2.setOnItemClicks(new HomeListAdaprer2.onItemClicks() {
            @Override
            public void onChangeData(int p) {
                Intent intent = new Intent(getActivity(), XiangQingActivity.class);
                intent.putExtra("key",p);
                startActivity(intent);
            }
        });

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
