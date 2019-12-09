package com.bw.movie.adapter;


/*
 *@auther:胡明明
 *@Date: 2019/11/14
 *@Time:10:21
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;

import com.bw.movie.R;
import com.bw.movie.activity.GouPiaoActivity;
import com.bw.movie.bean.XuanZuoXinXiBean;
import com.bw.movie.bean.YingYuanTuiJianBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zd.baserecyadapterlib.base.BaseRecyclerAdapter;

public class XuanZuoXinXiAdapter extends BaseRecyclerAdapter<XuanZuoXinXiBean.ResultBean> {
    public XuanZuoXinXiAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.yingyuan_item1;
    }

    @Override
    public void bindViewDataPosition(BaseViewHolder baseViewHolder, XuanZuoXinXiBean.ResultBean resultBean, int i) {
        super.bindViewDataPosition(baseViewHolder, resultBean, i);
        baseViewHolder.setText(R.id.yingyuan_item1_name,resultBean.getName());
        baseViewHolder.setText(R.id.yingyuan_item1_dizhi,resultBean.getAddress());
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView)baseViewHolder.get(R.id.yingyuan_item1_img);
        simpleDraweeView.setImageURI(resultBean.getLogo());
        RelativeLayout relativeLayout = (RelativeLayout) baseViewHolder.get(R.id.relative);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onItemClicks.onChangeData(resultBean.getCinemaId());
            }
        });
    }

    @Override
    public void bindViewData(BaseViewHolder baseViewHolder, XuanZuoXinXiBean.ResultBean resultBean) {

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
