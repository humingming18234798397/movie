package com.bw.movie.frag.xiangqing;


/*
 *@auther:胡明明
 *@Date: 2019/11/14
 *@Time:21:38
 *@Description:${DESCRIPTION}
 **/

import android.content.Intent;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.adapter.JieShaoAdapter;
import com.bw.movie.adapter.JieShaoAdapter2;
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

import java.util.List;

import butterknife.BindView;

public class JieShaoFragment extends BaseFragment<HomePresenter> implements HomeContract.Iview {
    @BindView(R.id.juqingjianjie)
    TextView juqingjianjie;
    @BindView(R.id.jieshao_rlv1)
    RecyclerView jieshaoRlv1;
    @BindView(R.id.jieshao_rlv2)
    RecyclerView jieshaoRlv2;

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.xiangqing_jieshao;
    }

    @Override
    protected void initData() {
        super.initData();
        //接收movieId
        Intent intent = getActivity().getIntent();
        int key = intent.getIntExtra("key", 0);
        mPresenter.getModelXiangQing(key);
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

    @Override
    public void onHomesuccess(HomeBean homeBean) {

    }

    @Override
    public void onHomesuccess(XiangQingBean xiangQingBean) {
        //剧情简介
        XiangQingBean.ResultBean result = xiangQingBean.getResult();
        juqingjianjie.setText(result.getSummary());
        //导演
        //适配器
        JieShaoAdapter jieShaoAdapter = new JieShaoAdapter(getActivity());
        jieShaoAdapter.setList(result.getMovieDirector());
        jieshaoRlv1.setAdapter(jieShaoAdapter);
        //wangge 网格布局管理器
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3);
        jieshaoRlv1.setLayoutManager(gridLayoutManager);
        //电影演员
        List<XiangQingBean.ResultBean.MovieActorBean> movieActor = xiangQingBean.getResult().getMovieActor();
        //适配器
        JieShaoAdapter2 jieShaoAdapter2 = new JieShaoAdapter2(getActivity());
        jieShaoAdapter2.setList(movieActor);
        jieshaoRlv2.setAdapter(jieShaoAdapter2);
        //buju布局管理器
        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(getActivity(),4);
        jieshaoRlv2.setLayoutManager(gridLayoutManager1);
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
