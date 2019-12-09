package com.bw.movie.frag.fragment;


/*
 *@auther:胡明明
 *@Date: 2019/11/13
 *@Time:19:21
 *@Description:${DESCRIPTION}
 **/

import android.content.Intent;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.activity.YingYuanXiangQing;
import com.bw.movie.adapter.QuAdapter;
import com.bw.movie.adapter.QuLieAdapter;
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

import java.util.List;

import butterknife.BindView;

public class YingYuan_DiQu extends BaseFragment<YingYuanPresenter> implements YingYuanContract.Iview {
    @BindView(R.id.yingyuan_rlv1)
    RecyclerView yingyuanRlv1;
    @BindView(R.id.yingyuan_rlv2)
    RecyclerView yingyuanRlv2;

    @Override
    protected YingYuanPresenter providePresenter() {
        return new YingYuanPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.yingyuan_diqu;
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.getModelQuLei();
    }

    @Override
    public void onHomesuccess(QuLeiBean quLeiBean) {
        List<QuLeiBean.ResultBean> result = quLeiBean.getResult();
        //shipeiqi适配器
        QuLieAdapter quLieAdapter = new QuLieAdapter(getActivity());
        quLieAdapter.setList(result);
        yingyuanRlv1.setAdapter(quLieAdapter);
        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        yingyuanRlv1.setLayoutManager(linearLayoutManager);
        //接口回调
        quLieAdapter.setOnItemClicks(new QuLieAdapter.onItemClicks() {
            @Override
            public void onChangeData(int p) {
                mPresenter.getModelQu(p+"");
            }
        });

    }

    @Override
    public void onHomesuccess(QuBean quBean) {
        List<QuBean.ResultBean> result = quBean.getResult();
        QuAdapter quAdapter = new QuAdapter(getActivity());
        quAdapter.setList(result);
        yingyuanRlv2.setAdapter(quAdapter);
        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        yingyuanRlv2.setLayoutManager(linearLayoutManager);
        quAdapter.setOnItemClicks(new QuAdapter.onItemClicks() {
            @Override
            public void onChangeData(int p) {
                Intent intent = new Intent(getActivity(), YingYuanXiangQing.class);
                intent.putExtra("id",p);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onHomesuccess(YingYuanTuiJianBean yingYuanTuiJianBean) {

    }

    @Override
    public void onHomesuccess(YingYuanFuJinBean yingYuanFuJinBean) {

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
