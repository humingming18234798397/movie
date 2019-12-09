package com.bw.movie.adapter;


/*
 *@auther:胡明明
 *@Date: 2019/12/4
 *@Time:13:44
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.view.View;
import android.widget.Button;

import com.bw.movie.R;
import com.bw.movie.bean.MoviePiaoBean;
import com.zd.baserecyadapterlib.base.BaseRecyclerAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MoviePiaoAdaoter extends BaseRecyclerAdapter<MoviePiaoBean.ResultBean> {
    public MoviePiaoAdaoter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.moviepiao_item;
    }

    @Override
    public void bindViewDataPosition(BaseViewHolder baseViewHolder, MoviePiaoBean.ResultBean resultBean, int i) {
        super.bindViewDataPosition(baseViewHolder, resultBean, i);
        baseViewHolder.setText(R.id.ticket_name,resultBean.getMovieName());
        baseViewHolder.setText(R.id.ticket_seat,resultBean.getSeat());
        baseViewHolder.setText(R.id.ticket_cinema,resultBean.getCinemaName());
        baseViewHolder.setText(R.id.ticket_yt,resultBean.getScreeningHall());
        Date date = new Date(resultBean.getCreateTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        baseViewHolder.setText(R.id.ticket_time,simpleDateFormat.format(date));
        baseViewHolder.setText(R.id.ticket_sun,resultBean.getBeginTime()+"-"+resultBean.getEndTime());
        Button button = (Button) baseViewHolder.get(R.id.ticket_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClicks.onChangeData(resultBean.getId());
            }
        });
    }

    @Override
    public void bindViewData(BaseViewHolder baseViewHolder, MoviePiaoBean.ResultBean resultBean) {

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
