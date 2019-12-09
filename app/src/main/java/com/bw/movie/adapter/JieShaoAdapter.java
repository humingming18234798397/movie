package com.bw.movie.adapter;


/**
 *@describe(描述)：JieShaoAdapter
 *@data（日期）: 2019/11/19
 *@time（时间）: 18:29
 *@author（作者）: 胡明明
 **/
import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.XiangQingBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zd.baserecyadapterlib.base.BaseRecyclerAdapter;

public class JieShaoAdapter extends BaseRecyclerAdapter<XiangQingBean.ResultBean.MovieDirectorBean>{
    public JieShaoAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.jieshao_item1;
    }

    @Override
    public void bindViewDataPosition(BaseViewHolder baseViewHolder, XiangQingBean.ResultBean.MovieDirectorBean movieDirectorBean, int i) {
        super.bindViewDataPosition(baseViewHolder, movieDirectorBean, i);
             baseViewHolder.setText(R.id.jieshao_name,movieDirectorBean.getName());
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) baseViewHolder.get(R.id.jieshao_img);
        simpleDraweeView.setImageURI(movieDirectorBean.getPhoto());
    }

    @Override
    public void bindViewData(BaseViewHolder baseViewHolder, XiangQingBean.ResultBean.MovieDirectorBean movieDirectorBean) {

    }





}
