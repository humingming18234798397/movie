package com.bw.movie.adapter;


/*
 *@auther:胡明明
 *@Date: 2019/11/21
 *@Time:16:10
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;

import com.bw.movie.R;
import com.bw.movie.bean.YingYuanPingLun;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zd.baserecyadapterlib.base.BaseRecyclerAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PingLunAdapter extends BaseRecyclerAdapter<YingYuanPingLun.ResultBean> {
    public PingLunAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.pinglun_item;
    }

    @Override
    public void bindViewData(BaseViewHolder baseViewHolder, YingYuanPingLun.ResultBean resultBean) {
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) baseViewHolder.get(R.id.yingping_img);
        simpleDraweeView.setImageURI(resultBean.getCommentHeadPic());
        baseViewHolder.setText(R.id.yingping_name,resultBean.getCommentUserName());
        Date date = new Date(resultBean.getCommentTime());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd  hh:mm");
        baseViewHolder.setText(R.id.yingping_time,simpleDateFormat.format(date));
        baseViewHolder.setText(R.id.yingping_pinglun,resultBean.getCommentContent());
        baseViewHolder.setText(R.id.yingping_textView,"等"+resultBean.getGreatNum()+""+"人进行了回复");
        CheckBox checkBox = (CheckBox) baseViewHolder.get(R.id.item_dianzanfilmcinecism);
    }
/*    //接口回调
    onItemClicks onItemClicks;
    public void setOnItemClicks( onItemClicks onItemClicks){
        this.onItemClicks = onItemClicks;
    }
    public interface onItemClicks{
        void onChangeData();
    }*/

}
