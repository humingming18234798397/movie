package com.bw.movie.adapter;


/*
 *@auther:胡明明
 *@Date: 2019/11/30
 *@Time:12:20
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.activity.DingDanXiangQingActivity;
import com.bw.movie.bean.DaiFuKuanBean;
import com.bw.movie.bean.YiFuKuanBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zd.baserecyadapterlib.base.BaseRecyclerAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class YiFuKuanAdapter extends BaseRecyclerAdapter<YiFuKuanBean.ResultBean> {

    public YiFuKuanAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.goupiaojilu_item1;
    }

    @Override
    public void bindViewDataPosition(BaseViewHolder baseViewHolder, YiFuKuanBean.ResultBean resultBean, int i) {
        super.bindViewDataPosition(baseViewHolder, resultBean, i);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) baseViewHolder.get(R.id.goupiaojilu_item_simple);
            simpleDraweeView.setImageURI(resultBean.getImageUrl());
            baseViewHolder.setText(R.id.goupiaojilu_name,resultBean.getMovieName());
            baseViewHolder.setText(R.id.goupiaojilu_dingdanhao,resultBean.getOrderId());
        Date date = new Date(resultBean.getCreateTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd  hh:mm");
            baseViewHolder.setText(R.id.goupiaojilu_shijian,simpleDateFormat.format(date));
        TextView textView = (TextView) baseViewHolder.get(R.id.yifukuan_dingdanxiangding);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DingDanXiangQingActivity.class);
                intent.putExtra("dingdanhao",resultBean.getOrderId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public void bindViewData(BaseViewHolder baseViewHolder, YiFuKuanBean.ResultBean resultBean) {

    }
}
