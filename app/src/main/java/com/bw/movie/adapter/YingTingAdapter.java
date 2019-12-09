package com.bw.movie.adapter;


/*
 *@auther:胡明明
 *@Date: 2019/11/20
 *@Time:20:30
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;

import com.bw.movie.R;
import com.bw.movie.bean.YingTingBean;
import com.zd.baserecyadapterlib.base.BaseRecyclerAdapter;

public class YingTingAdapter extends BaseRecyclerAdapter<YingTingBean.ResultBean> {
    public YingTingAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.yingying_item;
    }

    @Override
    public void bindViewDataPosition(BaseViewHolder baseViewHolder, YingTingBean.ResultBean resultBean, int i) {
        super.bindViewDataPosition(baseViewHolder, resultBean, i);
        baseViewHolder.setText(R.id.yingting_name,resultBean.getScreeningHall());
        baseViewHolder.setText(R.id.yingting_timestart,resultBean.getBeginTime());
        baseViewHolder.setText(R.id.yingting_timeclose,resultBean.getEndTime());
        RelativeLayout relativeLayout = (RelativeLayout) baseViewHolder.get(R.id.relaview);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClicks.onChangeData(resultBean.getHallId(),resultBean.getFare(),resultBean.getId());
            }
        });
    }

    @Override
    public void bindViewData(BaseViewHolder baseViewHolder, YingTingBean.ResultBean resultBean) {

    }
    //接口回调
    onItemClicks onItemClicks;
    public void setOnItemClicks( onItemClicks onItemClicks){
        this.onItemClicks = onItemClicks;
    }
    public interface onItemClicks{
        void onChangeData(int p,double fare,int ytid);
    }
}
