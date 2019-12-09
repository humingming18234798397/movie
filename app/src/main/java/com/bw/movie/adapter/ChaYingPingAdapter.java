package com.bw.movie.adapter;


/*
 *@auther:胡明明
 *@Date: 2019/11/30
 *@Time:18:56
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.ChaYingPingBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zd.baserecyadapterlib.base.BaseRecyclerAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ChaYingPingAdapter extends RecyclerView.Adapter<ChaYingPingAdapter.ViewHolder> {
    private Context context;
    private List<ChaYingPingBean.ResultBean> list;

    public ChaYingPingAdapter(Context context, List<ChaYingPingBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.chayingping_item, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (holder instanceof ViewHolder){
           if (list!=null){
               holder.simpleDraweeView.setImageURI(list.get(position).getLogo());
               holder.textViewname.setText(list.get(position).getCinemaName());
               holder.textViewdizhi.setText(list.get(position).getAddress());
               holder.textViewjuli.setText(list.get(position).getDistance()+"m");
               holder.textViewpinglun.setText(list.get(position).getMyCommentContent());
               Date date = new Date(list.get(position).getCommentTime());
               SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd  hh:mm");

               holder.textViewtime.setText(simpleDateFormat.format(date));
           }else{
               holder.relativeLayout.setVisibility(View.VISIBLE);
           }
        }
    }

    @Override
    public int getItemCount() {
        if (list!=null){
            return list.size();
        }
       return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout relativeLayout;
        SimpleDraweeView simpleDraweeView;
        TextView textViewname,textViewdizhi,textViewjuli,textViewpinglun,textViewtime;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.chayingping_img);
            textViewname = itemView.findViewById(R.id.chayingping_name);
            textViewdizhi = itemView.findViewById(R.id.chayingping_dizhi);
            textViewjuli = itemView.findViewById(R.id.chayingping_juli);
            textViewpinglun = itemView.findViewById(R.id.chayingping_pinglun);
            textViewtime = itemView.findViewById(R.id.chayingping_time);
            relativeLayout = itemView.findViewById(R.id.movie_relats);
        }
    }


   /* @Override
    public int getLayoutId() {
        return R.layout.chayingping_item;
    }

    @Override
    public void bindViewDataPosition(BaseViewHolder baseViewHolder, ChaYingPingBean.ResultBean resultBean, int i) {
        super.bindViewDataPosition(baseViewHolder, resultBean, i);
      if(resultBean!=null){
          SimpleDraweeView simpleDraweeView = (SimpleDraweeView) baseViewHolder.get(R.id.chayingping_img);
          simpleDraweeView.setImageURI(resultBean.getLogo());
          baseViewHolder.setText(R.id.chayingping_name,resultBean.getCinemaName());
          baseViewHolder.setText(R.id.chayingping_dizhi,resultBean.getAddress());
          baseViewHolder.setText(R.id.chayingping_juli,resultBean.getDistance()+"m");
          baseViewHolder.setText(R.id.chayingping_pinglun,resultBean.getMyCommentContent());
          Date date = new Date(resultBean.getCommentTime());
          SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd  hh:mm");
          baseViewHolder.setText(R.id.chayingping_time,simpleDateFormat.format(date));

      }else{
          RelativeLayout relativeLayout = (RelativeLayout) baseViewHolder.get(R.id.movie_relats);
          relativeLayout.setVisibility(View.VISIBLE);
      }

    }
*/
}
