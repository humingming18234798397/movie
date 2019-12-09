package com.bw.movie.adapter;


/*
 *@auther:胡明明
 *@Date: 2019/11/12
 *@Time:19:55
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.activity.XiangQingActivity;
import com.bw.movie.bean.ReYingBean;
import com.bw.movie.bean.ShangYingBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zd.baserecyadapterlib.base.BaseRecyclerAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TwoAdaprer extends RecyclerView.Adapter<TwoAdaprer.ViewHolder> {
private Context context;
private List<ShangYingBean.ResultBean> list;

    public TwoAdaprer(Context context, List<ShangYingBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.home_item2, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (holder instanceof ViewHolder){
            holder.simpleDraweeView.setImageURI(list.get(position).getImageUrl());
            holder.textViewname.setText(list.get(position).getName());
            Date date = new Date(list.get(position).getReleaseTime());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            holder.textViewtime.setText(simpleDateFormat.format(date)+"上映");
            holder.textViewren.setText(list.get(position).getWantSeeNum()+"人想看");

            holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, XiangQingActivity.class);
                    intent.putExtra("key", list.get(position).getMovieId());
                    context.startActivity(intent);
                }
            });
            int whetherReserve = list.get(position).getWhetherReserve();
            if (whetherReserve==1){

                holder.button.setBackgroundResource(R.drawable.home_yelo);
                holder.button.setText("已预约");
            }
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClicks.onChangeData(list.get(position).getMovieId());

                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout relativeLayout;
        SimpleDraweeView simpleDraweeView;
        TextView textViewname,textViewtime,textViewren,textViewzhuyan;
        Button button;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            relativeLayout  = itemView.findViewById(R.id.relat);
            simpleDraweeView = itemView.findViewById(R.id.item2_img);
            textViewname = itemView.findViewById(R.id.item2_name);
            textViewtime = itemView.findViewById(R.id.item2_time);
            textViewren = itemView.findViewById(R.id.item2_ren);
            relativeLayout = itemView.findViewById(R.id.relat);
            button = itemView.findViewById(R.id.homeyuyue_button);
        }
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
