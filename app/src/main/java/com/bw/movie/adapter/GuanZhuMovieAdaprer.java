package com.bw.movie.adapter;

/**
 *@describe(描述)：HomeSouSuoAdaprer
 *@data（日期）: 2019/11/18
 *@time（时间）: 19:52
 *@author（作者）: 胡明明
 **/

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.GuanZhuMovie;
import com.bw.movie.bean.HomeSouSuoBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zd.baserecyadapterlib.base.BaseRecyclerAdapter;

import java.util.List;

public class GuanZhuMovieAdaprer extends RecyclerView.Adapter<GuanZhuMovieAdaprer.ViewHolder> {
    private Context context;
    private List<GuanZhuMovie.ResultBean> list;

    public GuanZhuMovieAdaprer(Context context, List<GuanZhuMovie.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.guanzhu_item, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (holder instanceof ViewHolder){
            if (list!=null){
                holder.simpleDraweeView.setImageURI(list.get(position).getImageUrl());
                holder.textViewname.setText(list.get(position).getName());
                holder.textViewren.setText("评分"+list.get(position).getScore()+"分");
                holder.textViewtime.setText(list.get(position).getDirector());
                holder.textViewzhuyan.setText(list.get(position).getStarring());
            }else{
                holder.relativeLayout.setVisibility(View.VISIBLE);
            }
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
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.item2_img);
            textViewname = itemView.findViewById(R.id.item2_name);
            textViewtime = itemView.findViewById(R.id.item2_time);
            textViewren = itemView.findViewById(R.id.item2_ren);
            textViewzhuyan = itemView.findViewById(R.id.item2_zhuyan);
            relativeLayout = itemView.findViewById(R.id.movie_relat);

        }
    }



}
