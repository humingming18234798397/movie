package com.bw.movie.adapter;

/**
 *@describe(描述)：OneAdaprer
 *@data（日期）: 2019/11/15
 *@time（时间）: 9:54
 *@author（作者）: 胡明明
 **/

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.bw.movie.R;
import com.bw.movie.activity.XuanZuoActivity;
import com.bw.movie.bean.ReYingBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zd.baserecyadapterlib.base.BaseRecyclerAdapter;

public class HomeListAdaprer extends BaseRecyclerAdapter<ReYingBean.ResultBean> {
    public HomeListAdaprer(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.homelist_item;
    }

    @Override
    public void bindViewDataPosition(BaseViewHolder baseViewHolder, ReYingBean.ResultBean resultBean, int i) {
        super.bindViewDataPosition(baseViewHolder, resultBean, i);
        baseViewHolder.setText(R.id.item2_ren,"评分:"+resultBean.getScore()+"分");
        baseViewHolder.setText(R.id.item2_name,resultBean.getName());
        baseViewHolder.setText(R.id.item2_time,resultBean.getDirector());
        baseViewHolder.setText(R.id.item2_zhuyan,resultBean.getStarring());
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) baseViewHolder.get(R.id.item2_img);
        simpleDraweeView.setImageURI(resultBean.getImageUrl());
        //接口回调
        RelativeLayout relativeLayout = (RelativeLayout) baseViewHolder.get(R.id.relat);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClicks.onChangeData(resultBean.getMovieId());
            }
        });
        Button button = (Button) baseViewHolder.get(R.id.button_will);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, XuanZuoActivity.class);
                intent.putExtra("key", resultBean.getMovieId());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public void bindViewData(BaseViewHolder baseViewHolder, ReYingBean.ResultBean resultBean) {

    }

    //接口回调
    onItemClicks onItemClicks;
    public void setOnItemClicks( onItemClicks onItemClicks){
        this.onItemClicks = onItemClicks;
    }
    public interface onItemClicks{
        void onChangeData(int p);
    }

}
