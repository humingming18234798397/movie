package com.bw.movie.adapter;


/*
 *@auther:胡明明
 *@Date: 2019/11/20
 *@Time:21:07
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.ZuoWeiHaoBean;

import java.util.List;

public class ZuoWeiAdapter extends RecyclerView.Adapter<ZuoWeiAdapter.ViewHolder> {
    private Context context;
    private List<ZuoWeiHaoBean.ResultBean> list;

    public ZuoWeiAdapter(Context context, List<ZuoWeiHaoBean.ResultBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.zuo_layout, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (holder instanceof ViewHolder){
            String row = list.get(position).getRow();
            String seat = list.get(position).getSeat();
            int status = list.get(position).getStatus();

            if (status==1){
                ((ViewHolder) holder).zuo_che.setChecked(false);
                ((ViewHolder) holder).zuo_che.setVisibility(View.VISIBLE);
                ((ViewHolder) holder).zuo_che2.setVisibility(View.INVISIBLE);
            }else if(status==2){
                ((ViewHolder) holder).zuo_che2.setVisibility(View.VISIBLE);
                ((ViewHolder) holder).zuo_che.setEnabled(false);
                ((ViewHolder) holder).zuo_che.setVisibility(View.INVISIBLE);
            }
            ((ViewHolder) holder).zuo_che.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    onclickListener.onclick(row,seat,b);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CheckBox zuo_che,zuo_che2;
        RelativeLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.zuo_linear);
            zuo_che = itemView.findViewById(R.id.zuo_che);
            zuo_che2 = itemView.findViewById(R.id.zuo_che2);
        }
    }
//接口回调
    OnclickListener onclickListener;

    public void setOnclickListener(OnclickListener onclickListener) {
        this.onclickListener = onclickListener;
    }

    public interface OnclickListener{
        void onclick(String row,String seat,boolean ischecked);
    }
}
