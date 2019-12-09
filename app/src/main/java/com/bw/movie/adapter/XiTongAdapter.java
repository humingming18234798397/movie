package com.bw.movie.adapter;


/*
 *@auther:胡明明
 *@Date: 2019/12/3
 *@Time:19:41
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;

import com.bw.movie.R;
import com.bw.movie.bean.XiTongMessage;
import com.zd.baserecyadapterlib.base.BaseRecyclerAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class XiTongAdapter extends BaseRecyclerAdapter<XiTongMessage.ResultBean> {
    public XiTongAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.xitong_item;
    }

    @Override
    public void bindViewDataPosition(BaseViewHolder baseViewHolder, XiTongMessage.ResultBean resultBean, int i) {
        super.bindViewDataPosition(baseViewHolder, resultBean, i);
        baseViewHolder.setText(R.id.xitong_name,resultBean.getTitle());
        Date date = new Date(resultBean.getPushTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd  hh:mm");
        baseViewHolder.setText(R.id.xitong_time,simpleDateFormat.format(date));
        baseViewHolder.setText(R.id.xitong_message,resultBean.getContent());
    }

    @Override
    public void bindViewData(BaseViewHolder baseViewHolder, XiTongMessage.ResultBean resultBean) {

    }
}
