package com.bw.movie.adapter;


/*
 *@auther:胡明明
 *@Date: 2019/11/16
 *@Time:8:38
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.bean.XiangQingBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zd.baserecyadapterlib.base.BaseRecyclerAdapter;

import java.util.List;

public class JuZhaoAdapter extends RecyclerView.Adapter<JuZhaoAdapter.ViewHolder> {
        private Context context;
    private List<String> posterList = new XiangQingBean.ResultBean().getPosterList();

/*    public JuZhaoAdapter(Context context, XiangQingBean.ResultBean resultBean) {
            this.context = context;
            this.resultBean = resultBean;
        }*/

    public JuZhaoAdapter(Context context, List<String> posterList) {
        this.context = context;
        this.posterList = posterList;
    }

    @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.juzhao_item, null);
            return new ViewHolder(inflate);
        }

        @Override
        public void onBindViewHolder( ViewHolder holder, int position) {
            if (holder instanceof ViewHolder){
                        if (posterList!=null){
                            holder.simpleDraweeView.setImageURI(posterList.get(position));
                        }



            }
        }

        @Override
        public int getItemCount() {
        if(posterList!=null){
            return posterList.size();
        }
        return 0;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            SimpleDraweeView simpleDraweeView;
            public ViewHolder(View itemView) {
                super(itemView);
                simpleDraweeView = itemView.findViewById(R.id.juzhao_img);
            }
        }
}
