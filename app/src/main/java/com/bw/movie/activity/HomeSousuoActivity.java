package com.bw.movie.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.bw.movie.R;
import com.bw.movie.adapter.HomeSouSuoAdaprer;
import com.bw.movie.base.BaseActivity;
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
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeSousuoActivity extends BaseActivity<HomePresenter> implements HomeContract.Iview {

    @BindView(R.id.edit_text)
    EditText editText;
    @BindView(R.id.sousuo_button)
    Button sousuoButton;
    @BindView(R.id.sousuo_xrlv)
    XRecyclerView sousuoXrlv;
    int page = 1;
    @BindView(R.id.sousuo_simple)
    SimpleDraweeView sousuoSimple;
    @BindView(R.id.include_text)
    TextView includeText;
    @BindView(R.id.include_relate)
    RelativeLayout includeRelate;
    private String text;

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_home_sousuo;
    }

    @OnClick(R.id.sousuo_button)
    public void onViewClicked() {
        //获取输入框内容
        text = editText.getText().toString().trim();
        mPresenter.getPresenterSouSuo(text, 1, 5);
    }

    @Override
    protected void initData() {
        super.initData();
        //点击返回
        sousuoSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //下拉刷新,上拉加载
        sousuoXrlv.setPullRefreshEnabled(true);
        sousuoXrlv.setLoadingMoreEnabled(true);
        sousuoXrlv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                mPresenter.getPresenterSouSuo(text, page, 5);
                sousuoXrlv.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                page++;
                mPresenter.getPresenterSouSuo(text, page, 5);
                sousuoXrlv.loadMoreComplete();
            }
        });
        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        sousuoXrlv.setLayoutManager(linearLayoutManager);
        mPresenter.getPresenterSouSuo("", page, 5);
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

    }

    @Override
    public void onHomesuccess(YingPingBean yingPingBean) {

    }

    //ssousuos搜索
    @Override
    public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {
        if (homeSouSuoBean.getStatus().equals("0000")) {
            List<HomeSouSuoBean.ResultBean> result = homeSouSuoBean.getResult();
            if (result != null) {
                includeRelate.setVisibility(View.GONE);
                sousuoXrlv.setVisibility(View.VISIBLE);
                HomeSouSuoAdaprer homeSouSuoAdaprer = new HomeSouSuoAdaprer(this);
                homeSouSuoAdaprer.setList(result);
                sousuoXrlv.setAdapter(homeSouSuoAdaprer);
                //布局管理器
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                sousuoXrlv.setLayoutManager(linearLayoutManager);
            } else {
                includeRelate.setVisibility(View.VISIBLE);
                sousuoXrlv.setVisibility(View.GONE);
                includeText.setText("没有相关搜索结果\n" +
                        " 换个词试试吧\"");
            }
        } else {
            Toast.makeText(this, homeSouSuoBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

}
