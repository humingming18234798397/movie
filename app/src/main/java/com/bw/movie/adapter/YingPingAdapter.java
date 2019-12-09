package com.bw.movie.adapter;


/*
 *@auther:胡明明
 *@Date: 2019/11/16
 *@Time:16:05
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.YingPingBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zd.baserecyadapterlib.base.BaseRecyclerAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class YingPingAdapter extends BaseRecyclerAdapter<YingPingBean.ResultBean> {
    public YingPingAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.yingping_item;
    }

    @Override
    public void bindViewDataPosition(BaseViewHolder baseViewHolder, YingPingBean.ResultBean resultBean, int i) {
        super.bindViewDataPosition(baseViewHolder, resultBean, i);
      if (resultBean!=null){
          SimpleDraweeView simpleDraweeView = (SimpleDraweeView) baseViewHolder.get(R.id.yingping_img);
          simpleDraweeView.setImageURI(resultBean.getCommentHeadPic());
          baseViewHolder.setText(R.id.yingping_name,resultBean.getCommentUserName());
          baseViewHolder.setText(R.id.yingping_pinglun,resultBean.getCommentContent());
          baseViewHolder.setText(R.id.yingping_fenshu,resultBean.getScore()+"分");
          baseViewHolder.setText(R.id.yingping_renshu,resultBean.getGreatNum()+"");
          Date date = new Date(resultBean.getCommentTime());
          SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd  hh:mm");
          baseViewHolder.setText(R.id.yingping_time,simpleDateFormat.format(date));
          baseViewHolder.setText(R.id.yingping_textView,"等"+resultBean.getReplyNum()+""+"人进行了回复");
          //  RecyclerView recyclerView = (RecyclerView) baseViewHolder.get(R.id.yingping_rlv);
      /*  YingPingSimpleAdapter yingPingSimpleAdapter = new YingPingSimpleAdapter(context, (List<String>) resultBean.getReplyHeadPic());
        recyclerView.setAdapter(yingPingSimpleAdapter);
       //布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);*/
          SimpleDraweeView simpleDraweeView1 = (SimpleDraweeView) baseViewHolder.get(R.id.yingping_dianzan);
          SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) baseViewHolder.get(R.id.yingping_yidianzan);
        simpleDraweeView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 setChangeAdapter.getChang(resultBean.getCommentId());
                simpleDraweeView1.setVisibility(View.GONE);
                simpleDraweeView2.setVisibility(View.VISIBLE);
            }
        });


      }

    }

    @Override
    public void bindViewData(BaseViewHolder baseViewHolder, YingPingBean.ResultBean resultBean) {

    }
    //接口回调
    setChangeAdapter setChangeAdapter;

    public void setSetChangeAdapter(setChangeAdapter setChangeAdapter) {
        this.setChangeAdapter = setChangeAdapter;
    }

    public interface setChangeAdapter {
        void getChang(int p);
    }

}
