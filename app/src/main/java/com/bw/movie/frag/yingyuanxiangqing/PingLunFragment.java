package com.bw.movie.frag.yingyuanxiangqing;


/*
 *@auther:胡明明
 *@Date: 2019/11/21
 *@Time:14:34
 *@Description:${DESCRIPTION}
 **/

import android.content.Intent;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.adapter.PingLunAdapter;
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

public class PingLunFragment extends BaseFragment<YingYuanPresenter> implements YingYuanContract.Iview {

    @BindView(R.id.yingping_xrlv)
    RecyclerView yingpingXrlv;
    private int id;

    @Override
    protected YingYuanPresenter providePresenter() {
        return new YingYuanPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.yingyuanpingjia;
    }

    @Override
    protected void initData() {
        super.initData();
        Intent intent = getActivity().getIntent();
        id = intent.getIntExtra("id", 0);
        mPresenter.getPresenterpinglun(id, 1, 5);
        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        yingpingXrlv.setLayoutManager(linearLayoutManager);


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
        List<YingYuanPingLun.ResultBean> result = yingYuanPingLun.getResult();
        PingLunAdapter pingLunAdapter = new PingLunAdapter(getActivity());
        pingLunAdapter.setList(result);
        yingpingXrlv.setAdapter(pingLunAdapter);
        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        yingpingXrlv.setLayoutManager(linearLayoutManager);
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
        if (yingYuanDianZan.getStatus().equals("0000")){
            Toast.makeText(getActivity(), ""+yingYuanDianZan.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onHomeFaiure(Throwable e) {

    }
}
