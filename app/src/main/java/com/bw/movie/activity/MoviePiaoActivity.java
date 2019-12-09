package com.bw.movie.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.adapter.MoviePiaoAdaoter;
import com.bw.movie.base.BaseActivity;
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
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MoviePiaoActivity extends BaseActivity<MyPresenter> implements MyContract.Iview {
    @BindView(R.id.goupiaojilu_fanhui)
    SimpleDraweeView goupiaojiluFanhui;
    @BindView(R.id.moviepiao_rlv)
    RecyclerView moviepiaoRlv;
    @BindView(R.id.movie_simp)
    SimpleDraweeView movieSimp;
    @BindView(R.id.movie_button)
    Button movieButton;
    @BindView(R.id.moviewpiao_relat)
    RelativeLayout moviewpiaoRelat;
    @BindView(R.id.relative)
    RelativeLayout relative;
    private int userId;
    private String s;
    private SharedPreferences sp;

    @Override
    protected MyPresenter providePresenter() {
        return new MyPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_movie_piao;
    }

    @Override
    protected void initData() {
        super.initData();
        //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        moviepiaoRlv.setLayoutManager(linearLayoutManager);
        sp = getSharedPreferences("movie", Context.MODE_PRIVATE);
        userId = sp.getInt("u", 0);
        s = sp.getString("s", null);
        mPresenter.getPresentermoviepiao(userId, s);
    }

    @Override
    public void onMysuccess(DaiFuKuanBean daiFuKuanBean) {

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
        List<MoviePiaoBean.ResultBean> result = moviePiaoBean.getResult();
        if (result != null) {
            MoviePiaoAdaoter moviePiaoAdaoter = new MoviePiaoAdaoter(this);
            moviePiaoAdaoter.setList(result);
            moviepiaoRlv.setAdapter(moviePiaoAdaoter);
            moviePiaoAdaoter.setOnItemClicks(new MoviePiaoAdaoter.onItemClicks() {
                @Override
                public void onChangeData(int p) {
                    if (p != 0) {
                        mPresenter.getPresentererweima(userId, s, p);
                        moviewpiaoRelat.setVisibility(View.VISIBLE);
                    }

                    movieButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            moviewpiaoRelat.setVisibility(View.GONE);

                        }
                    });
                }
            });

        }else{
            relative.setVisibility(View.VISIBLE);
            moviepiaoRlv.setVisibility(View.GONE);
        }
    }

    @Override
    public void onMysuccess(ErWeiMaBean erWeiMaBean) {
       if (erWeiMaBean.getStatus().equals("0000")){
           ErWeiMaBean.ResultBean result = erWeiMaBean.getResult();
           if (result!=null){
               movieSimp.setImageURI(result.getExchangeCode());
           }

       }else{
           Toast.makeText(this, erWeiMaBean.getMessage(), Toast.LENGTH_SHORT).show();
       }

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.goupiaojilu_fanhui)
    public void onViewClicked() {
        finish();
    }
}
