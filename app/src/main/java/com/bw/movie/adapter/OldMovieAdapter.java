package com.bw.movie.adapter;


/*
 *@auther:胡明明
 *@Date: 2019/12/4
 *@Time:20:33
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.bw.movie.R;
import com.bw.movie.activity.YingPingActivity;
import com.bw.movie.bean.OldMovieBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zd.baserecyadapterlib.base.BaseRecyclerAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OldMovieAdapter extends BaseRecyclerAdapter<OldMovieBean.ResultBean> {
    public OldMovieAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.oldmovie_item;
    }

    @Override
    public void bindViewDataPosition(BaseViewHolder baseViewHolder, OldMovieBean.ResultBean resultBean, int i) {
        super.bindViewDataPosition(baseViewHolder, resultBean, i);
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) baseViewHolder.get(R.id.old_img);
        simpleDraweeView.setImageURI(resultBean.getImageUrl());
        baseViewHolder.setText(R.id.old_name,resultBean.getMovieName());
        Date date = new Date(resultBean.getEndTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:MM:SS" + "观影");
        baseViewHolder.setText(R.id.old_time,simpleDateFormat.format(date));
        Button button = (Button) baseViewHolder.get(R.id.old_pingjia);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, YingPingActivity.class);
                intent.putExtra("key",resultBean.getMovieId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public void bindViewData(BaseViewHolder baseViewHolder, OldMovieBean.ResultBean resultBean) {

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
