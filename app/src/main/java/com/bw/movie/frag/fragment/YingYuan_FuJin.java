package com.bw.movie.frag.fragment;


/*
 *@auther:胡明明
 *@Date: 2019/11/13
 *@Time:19:21
 *@Description:${DESCRIPTION}
 **/

import android.content.Intent;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.bw.movie.R;
import com.bw.movie.activity.YingYuanXiangQing;
import com.bw.movie.adapter.YingYuanFuJinAdapter;
import com.bw.movie.adapter.YingYuanTuiJinAdapter;
import com.bw.movie.base.BaseFragment;
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
import com.bw.movie.presenter.YingYuanPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;

public class YingYuan_FuJin extends BaseFragment<YingYuanPresenter> implements YingYuanContract.Iview {
    @BindView(R.id.yingyuan_fujin_xrlv)
    XRecyclerView yingyuanFujinXrlv;
int page = 1;
    @Override
    protected YingYuanPresenter providePresenter() {
        return new YingYuanPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.yingyuan_fujin;
    }

    @Override
    protected void initData() {
        super.initData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        yingyuanFujinXrlv.setLayoutManager(linearLayoutManager);
        //下拉刷新,上拉加载
        yingyuanFujinXrlv.setPullRefreshEnabled(true);
        yingyuanFujinXrlv.setLoadingMoreEnabled(true);
        yingyuanFujinXrlv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page=1;
                mPresenter.getPresenterYingYuanfujin("116.30551391385724","40.04571807462411",page,5);
                yingyuanFujinXrlv.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                page++;
                mPresenter.getPresenterYingYuanfujin("116.30551391385724","40.04571807462411",page,5);
                yingyuanFujinXrlv.loadMoreComplete();
            }
        });
        mPresenter.getPresenterYingYuanfujin("116.30551391385724","40.04571807462411",1,5);
    }

    @Override
    public void onHomesuccess(QuLeiBean quLeiBean) {

    }

    @Override
    public void onHomesuccess(QuBean quBean) {

    }

    @Override
    public void onHomesuccess(YingYuanTuiJianBean yingYuanTuiJianBean) {

    }
        //影院附近
    @Override
    public void onHomesuccess(YingYuanFuJinBean yingYuanFuJinBean) {
        List<YingYuanFuJinBean.ResultBean> result = yingYuanFuJinBean.getResult();
        YingYuanFuJinAdapter yingYuanFuJinAdapter = new YingYuanFuJinAdapter(getActivity());
        yingYuanFuJinAdapter.setList(result);
        yingyuanFujinXrlv.setAdapter(yingYuanFuJinAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        yingyuanFujinXrlv.setLayoutManager(linearLayoutManager);
        yingYuanFuJinAdapter.setOnItemClicks(new YingYuanFuJinAdapter.onItemClicks() {
            @Override
            public void onChangeData(int p) {
                Intent intent = new Intent(getActivity(), YingYuanXiangQing.class);
                intent.putExtra("id",p);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onHomesuccess(YingYuanSouSuoBean yingYuanSouSuoBean) {

    }

    @Override
    public void onHomesuccess(YYXQBean yyxqBean) {

    }

    @Override
    public void onHomesuccess(YingYuanPingLun yingYuanPingLun) {

    }

    @Override
    public void onHomesuccess(ShiJianBean shiJianBean) {

    }

    @Override
    public void onHomesuccess(ZhouQiBean zhouQiBean) {

    }

    @Override
    public void onHomesuccess(YingYuanGuanZhu yingYuanGuanZhu) {

    }

    @Override
    public void onHomesuccess(YingYuanWeiGuanZhu yingYuanWeiGuanZhu) {

    }

    @Override
    public void onHomesuccess(YingYuanDianZan yingYuanDianZan) {

    }

    @Override
    public void onHomeFaiure(Throwable e) {

    }
}
