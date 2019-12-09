package com.bw.movie.adapter;


/*
 *@auther:胡明明
 *@Date: 2019/11/12
 *@Time:19:55
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.bw.movie.R;
import com.bw.movie.activity.XiangQingActivity;
import com.bw.movie.activity.XuanZuoActivity;
import com.bw.movie.bean.HomeBean;
import com.bw.movie.bean.ReYingBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zd.baserecyadapterlib.base.BaseRecyclerAdapter;

public class ThreeAdaprer extends BaseRecyclerAdapter<HomeBean.ResultBean> {
    public ThreeAdaprer(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.home_item1;
    }

    @Override
    public void bindViewDataPosition(BaseViewHolder baseViewHolder, HomeBean.ResultBean resultBean, int i) {
        super.bindViewDataPosition(baseViewHolder, resultBean, i);
        baseViewHolder.setText(R.id.item1_fen,resultBean.getScore()+"分");
        baseViewHolder.setText(R.id.item1_name,resultBean.getName());
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) baseViewHolder.get(R.id.item1_img);
        simpleDraweeView.setImageURI(resultBean.getImageUrl());
        RelativeLayout relativeLayout = (RelativeLayout) baseViewHolder.get(R.id.rel);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, XiangQingActivity.class);
                intent.putExtra("key", resultBean.getMovieId());
                context.startActivity(intent);
            }
        });
        Button button = (Button) baseViewHolder.get(R.id.pay_playing);
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
    public void bindViewData(BaseViewHolder baseViewHolder, HomeBean.ResultBean resultBean) {

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
