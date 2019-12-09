package com.bw.movie.adapter;


/*
 *@auther:胡明明
 *@Date: 2019/11/15
 *@Time:21:35
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;

import com.bw.movie.R;
import com.bw.movie.bean.XiangQingBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zd.baserecyadapterlib.base.BaseRecyclerAdapter;

public class JieShaoAdapter2 extends BaseRecyclerAdapter<XiangQingBean.ResultBean.MovieActorBean> {
    public JieShaoAdapter2(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.jieshao_item2;
    }

    @Override
    public void bindViewDataPosition(BaseViewHolder baseViewHolder, XiangQingBean.ResultBean.MovieActorBean movieActorBean, int i) {
        super.bindViewDataPosition(baseViewHolder, movieActorBean, i);
        baseViewHolder.setText(R.id.jieshao_name,movieActorBean.getName());
        baseViewHolder.setText(R.id.jieshao_shiyan,movieActorBean.getRole());
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) baseViewHolder.get(R.id.jieshao_img);
        simpleDraweeView.setImageURI(movieActorBean.getPhoto());
    }

    @Override
    public void bindViewData(BaseViewHolder baseViewHolder, XiangQingBean.ResultBean.MovieActorBean movieActorBean) {

    }
}
