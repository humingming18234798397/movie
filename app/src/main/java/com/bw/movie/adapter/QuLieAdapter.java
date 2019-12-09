package com.bw.movie.adapter;


/*
 *@auther:胡明明
 *@Date: 2019/11/13
 *@Time:20:30
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.bw.movie.R;
import com.bw.movie.bean.QuLeiBean;
import com.zd.baserecyadapterlib.base.BaseRecyclerAdapter;

public class QuLieAdapter extends BaseRecyclerAdapter<QuLeiBean.ResultBean> {
    public QuLieAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.yingyuan_item;
    }

    @Override
    public void bindViewDataPosition(BaseViewHolder baseViewHolder, QuLeiBean.ResultBean resultBean, int i) {
        super.bindViewDataPosition(baseViewHolder, resultBean, i);
           if (resultBean!=null){
               baseViewHolder.setText(R.id.yingyuan_text,resultBean.getRegionName());
               LinearLayout linearLayout = (LinearLayout) baseViewHolder.get(R.id.yingyuan_linear);
               linearLayout.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       onItemClicks.onChangeData(resultBean.getRegionId());
                   }
               });
           }
    }

    @Override
    public void bindViewData(BaseViewHolder baseViewHolder, QuLeiBean.ResultBean resultBean) {

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
