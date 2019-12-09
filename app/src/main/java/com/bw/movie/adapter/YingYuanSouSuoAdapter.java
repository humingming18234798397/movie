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
import com.bw.movie.activity.YingYuanXiangQing;
import com.bw.movie.bean.YingYuanSouSuoBean;
import com.bw.movie.bean.YingYuanTuiJianBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zd.baserecyadapterlib.base.BaseRecyclerAdapter;

public class YingYuanSouSuoAdapter extends BaseRecyclerAdapter<YingYuanSouSuoBean.ResultBean> {
    public YingYuanSouSuoAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.yingyuan_item1;
    }

    @Override
    public void bindViewDataPosition(BaseViewHolder baseViewHolder, YingYuanSouSuoBean.ResultBean resultBean, int i) {
        super.bindViewDataPosition(baseViewHolder, resultBean, i);
        baseViewHolder.setText(R.id.yingyuan_item1_name,resultBean.getName());
        baseViewHolder.setText(R.id.yingyuan_item1_dizhi,resultBean.getAddress());
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView)baseViewHolder.get(R.id.yingyuan_item1_img);
        simpleDraweeView.setImageURI(resultBean.getLogo());
        RelativeLayout relativeLayout = (RelativeLayout) baseViewHolder.get(R.id.relative);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, YingYuanXiangQing.class);
                intent.putExtra("id",resultBean.getId());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public void bindViewData(BaseViewHolder baseViewHolder, YingYuanSouSuoBean.ResultBean resultBean) {

    }
}
