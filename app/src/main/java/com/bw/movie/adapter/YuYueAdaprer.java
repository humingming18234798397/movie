package com.bw.movie.adapter;


/*
 *@auther:胡明明
 *@Date: 2019/11/12
 *@Time:19:55
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;

import com.bw.movie.R;
import com.bw.movie.bean.ShangYingBean;
import com.bw.movie.bean.YuYueBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zd.baserecyadapterlib.base.BaseRecyclerAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class YuYueAdaprer extends BaseRecyclerAdapter<YuYueBean.ResultBean> {
    public YuYueAdaprer(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.yuyue_item;
    }

    @Override
    public void bindViewDataPosition(BaseViewHolder baseViewHolder, YuYueBean.ResultBean resultBean, int i) {
        super.bindViewDataPosition(baseViewHolder, resultBean, i);
        baseViewHolder.setText(R.id.item2_name,resultBean.getName());
        Date date = new Date(resultBean.getReleaseTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
       // ((MyViewHolder) holder).textView1.setText(simpleDateFormat.format(date)+"上映");
        baseViewHolder.setText(R.id.item2_time,simpleDateFormat.format(date)+"上映");
        baseViewHolder.setText(R.id.item2_ren,resultBean.getWantSeeNum()+"人想看");
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) baseViewHolder.get(R.id.item2_img);
        simpleDraweeView.setImageURI(resultBean.getImageUrl());

        RelativeLayout relativeLayout = (RelativeLayout) baseViewHolder.get(R.id.relat);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClicks.onChangeData(resultBean.getMovieId());
            }
        });
    }

    @Override
    public void bindViewData(BaseViewHolder baseViewHolder, YuYueBean.ResultBean resultBean) {

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
