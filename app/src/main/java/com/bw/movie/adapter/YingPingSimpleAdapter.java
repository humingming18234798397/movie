package com.bw.movie.adapter;


/*
 *@auther:胡明明
 *@Date: 2019/11/16
 *@Time:16:28
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.YingPingBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class YingPingSimpleAdapter extends RecyclerView.Adapter<YingPingSimpleAdapter.ViewHolder> {
    private Context context;
    private YingPingBean.ResultBean resultBean;
    List<String> replyHeadPic  = (List<String>) resultBean.getReplyHeadPic();

    public YingPingSimpleAdapter(Context context, List<String> replyHeadPic) {
        this.context = context;
        this.replyHeadPic = replyHeadPic;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.yingping_simpleimg, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (holder instanceof  ViewHolder){
            if (resultBean!=null) {
                holder.simpleDraweeView.setImageURI(replyHeadPic.get(position) + "");
            }
        }
    }

    @Override
    public int getItemCount() {
        return replyHeadPic.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView simpleDraweeView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            simpleDraweeView = itemView.findViewById(R.id.yingping_simple);
        }
    }
}
