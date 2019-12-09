package com.bw.movie.frag;


/*
 *@auther:胡明明
 *@Date: 2019/11/21
 *@Time:21:14
 *@Description:${DESCRIPTION}
 **/

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.activity.GouPiaoActivity;
import com.bw.movie.activity.XiangQingActivity;
import com.bw.movie.adapter.ZhouQiAdaprer;
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

public class ZhouQiFragment extends BaseFragment<YingYuanPresenter> implements YingYuanContract.Iview {
    /*    @BindView(R.id.nnnnn)
        TextView nnnnn;*/
    @BindView(R.id.zhouqi_rlv)
    RecyclerView zhouqiRlv;
    @BindView(R.id.include_text)
    TextView includeText;
    @BindView(R.id.include_relate)
    RelativeLayout includeRelate;
    private int key;

    @Override
    protected YingYuanPresenter providePresenter() {
        return new YingYuanPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_zhouqi;
    }

    @Override
    protected void initData() {
        super.initData();
        //获取Activity传来的数据
        Bundle bundle = getArguments();
        String url = bundle.getString("url");
        //  mPresenter.getPresentershijianyingyuan(url,p,1,5);
        Intent intent = getActivity().getIntent();
        key = intent.getIntExtra("key", 0);
        mPresenter.getPresenterzhouqi(key, 1, 10);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        zhouqiRlv.setLayoutManager(linearLayoutManager);
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

    }

    @Override
    public void onHomesuccess(ShiJianBean shiJianBean) {

    }

    @Override
    public void onHomesuccess(ZhouQiBean zhouQiBean) {
        if (zhouQiBean.getStatus().equals("0000")) {
            List<ZhouQiBean.ResultBean> result = zhouQiBean.getResult();
            if (result != null) {
                zhouqiRlv.setVisibility(View.VISIBLE);
                includeRelate.setVisibility(View.GONE);
                ZhouQiAdaprer zhouQiAdaprer = new ZhouQiAdaprer(getActivity());
                zhouQiAdaprer.setList(result);
                zhouqiRlv.setAdapter(zhouQiAdaprer);
                //布局管理器
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                zhouqiRlv.setLayoutManager(linearLayoutManager);
               zhouQiAdaprer.setOnItemClicks(new ZhouQiAdaprer.onItemClicks() {
                    @Override
                    public void onChangeData(int p) {
                        Intent intent = new Intent(getActivity(), GouPiaoActivity.class);
                        intent.putExtra("key",p);
                        intent.putExtra("cinemaid",key);
                        startActivity(intent);
                    }
                });
            }else{
                zhouqiRlv.setVisibility(View.GONE);
                includeRelate.setVisibility(View.VISIBLE);
                includeText.setText("暂无数据");
            }
        } else {
            Toast.makeText(getActivity(), zhouQiBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
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
