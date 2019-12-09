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
import android.widget.Button;

import com.bw.movie.R;
import com.bw.movie.activity.DingDanFuKuanActivity;
import com.bw.movie.bean.DaiFuKuanBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zd.baserecyadapterlib.base.BaseRecyclerAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DaiFuKuanAdapter extends BaseRecyclerAdapter<DaiFuKuanBean.ResultBean> {

    public DaiFuKuanAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.goupiaojilu_item;
    }

    @Override
    public void bindViewDataPosition(BaseViewHolder baseViewHolder, DaiFuKuanBean.ResultBean resultBean, int i) {
        super.bindViewDataPosition(baseViewHolder, resultBean, i);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) baseViewHolder.get(R.id.goupiaojilu_item_simple);
            simpleDraweeView.setImageURI(resultBean.getImageUrl());
            baseViewHolder.setText(R.id.goupiaojilu_name,resultBean.getMovieName());
            baseViewHolder.setText(R.id.goupiaojilu_dingdanhao,resultBean.getOrderId());
        Date date = new Date(resultBean.getCreateTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd  hh:mm");
            baseViewHolder.setText(R.id.goupiaojilu_shijian,simpleDateFormat.format(date));
        Button button = (Button) baseViewHolder.get(R.id.goupiaojilu_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DingDanFuKuanActivity.class);
                intent.putExtra("orderId",resultBean.getOrderId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public void bindViewData(BaseViewHolder baseViewHolder, DaiFuKuanBean.ResultBean resultBean) {

    }
}
