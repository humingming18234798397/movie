package com.bw.movie.frag.goupiaojilu;


/*
 *@auther:胡明明
 *@Date: 2019/11/30
 *@Time:11:05
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.adapter.DaiFuKuanAdapter;
import com.bw.movie.base.BaseFragment;
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
import com.bw.movie.contract.MyContract;
import com.bw.movie.presenter.MyPresenter;

import java.util.List;

import butterknife.BindView;

public class DaiFuKuanFragment extends BaseFragment<MyPresenter> implements MyContract.Iview {
    @BindView(R.id.daifukuan_rlv)
    RecyclerView daifukuanRlv;
    @BindView(R.id.include_text)
    TextView includeText;
    @BindView(R.id.include_relate)
    RelativeLayout includeRelate;
    private int userId;
    private String s;
    private SharedPreferences sp;

    @Override
    protected MyPresenter providePresenter() {
        return new MyPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.frag_daifukuan;
    }

    @Override
    protected void initData() {
        super.initData();
        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        daifukuanRlv.setLayoutManager(linearLayoutManager);
        sp = getActivity().getSharedPreferences("movie", Context.MODE_PRIVATE);
        userId = sp.getInt("u", 0);
        s = sp.getString("s", null);

        mPresenter.getPresenterdaifukuan(userId, s, 1, 10, 1);
    }

    @Override
    public void onMysuccess(DaiFuKuanBean daiFuKuanBean) {
        if (daiFuKuanBean.getStatus().equals("0000")) {
            List<DaiFuKuanBean.ResultBean> result = daiFuKuanBean.getResult();
            if (result != null) {
                includeRelate.setVisibility(View.GONE);
                daifukuanRlv.setVisibility(View.VISIBLE);
                DaiFuKuanAdapter daiFuKuanAdapter = new DaiFuKuanAdapter(getActivity());
                daiFuKuanAdapter.setList(result);
                daifukuanRlv.setAdapter(daiFuKuanAdapter);
                //布局管理器
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                daifukuanRlv.setLayoutManager(linearLayoutManager);
            } else {
                includeRelate.setVisibility(View.VISIBLE);
                daifukuanRlv.setVisibility(View.GONE);
                includeText.setText("暂无信息");
            }
        } else {
            Toast.makeText(getActivity(), daiFuKuanBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onMysuccess(YiFuKuanBean yiFuKuanBean) {

    }

    @Override
    public void onMysuccess(MovieBean movieBean) {

    }

    @Override
    public void onMysuccess(ChaYingPingBean chaYingPingBean) {

    }

    @Override
    public void onMysuccess(GuanZhuMovie guanZhuMovie) {

    }

    @Override
    public void onMysuccess(GuanZhuYingYuan guanZhuYingYuan) {

    }

    @Override
    public void onMysuccess(DingDanBean dingDanBean) {

    }

    @Override
    public void onMysuccess(ZhiFuBean zhiFuBean) {

    }

    @Override
    public void onMysuccess(YuYueBean yuYueBean) {

    }

    @Override
    public void onMysuccess(XiTongMessage xiTongMessage) {

    }

    @Override
    public void onMysuccess(MoviePiaoBean moviePiaoBean) {

    }

    @Override
    public void onMysuccess(ErWeiMaBean erWeiMaBean) {

    }

    @Override
    public void onMysuccess(FanKuiBean fanKuiBean) {

    }

    @Override
    public void onMysuccess(OldMovieBean oldMovieBean) {

    }

    @Override
    public void onMysuccess(TouXiangBean touXiangBean) {

    }

    @Override
    public void onMysuccess(YongHuBean yongHuBean) {

    }

    @Override
    public void onMysuccess(PwdBean pwdBean) {

    }

    @Override
    public void onMysuccess(PhoneBean phoneBean) {

    }

    @Override
    public void onMysuccess(BirthBean birthBean) {

    }

    @Override
    public void onMyFaiure(Throwable e) {

    }
}
