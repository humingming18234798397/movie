package com.bw.movie.adapter;


/*
 *@auther:胡明明
 *@Date: 2019/11/30
 *@Time:17:42
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.view.View;

import com.bw.movie.R;
import com.bw.movie.bean.MovieBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zd.baserecyadapterlib.base.BaseRecyclerAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DianYingAdapter extends BaseRecyclerAdapter<MovieBean.ResultBean> {

    public DianYingAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.dianyingpinglun_item;
    }

    @Override
    public void bindViewDataPosition(BaseViewHolder baseViewHolder, MovieBean.ResultBean resultBean, int i) {
        super.bindViewDataPosition(baseViewHolder, resultBean, i);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) baseViewHolder.get(R.id.dianying_img);
        simpleDraweeView.setImageURI(resultBean.getImageUrl());
        baseViewHolder.setText(R.id.dianying_name,resultBean.getMovieName());
        baseViewHolder.setText(R.id.dianying_daoyan,resultBean.getDirector());
        baseViewHolder.setText(R.id.dianying_zhuyan,resultBean.getStarring());
        baseViewHolder.setText(R.id.dianying_pingfen,resultBean.getMovieScore()+"分");
        baseViewHolder.setText(R.id.dingying_pinglun,resultBean.getMyCommentContent());
        baseViewHolder.setText(R.id.yingping_fenshu,"("+resultBean.getMyCommentScore()+"分"+")");

        Date date = new Date(resultBean.getCommentTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd  hh:mm");
        baseViewHolder.setText(R.id.dianuing_time,simpleDateFormat.format(date));


    }

    @Override
    public void bindViewData(BaseViewHolder baseViewHolder, MovieBean.ResultBean resultBean) {

    }
}
