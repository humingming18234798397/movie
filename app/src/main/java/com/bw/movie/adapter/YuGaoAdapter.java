package com.bw.movie.adapter;


/*
 *@auther:胡明明
 *@Date: 2019/11/16
 *@Time:17:13
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.bean.XiangQingBean;
import com.zd.baserecyadapterlib.base.BaseRecyclerAdapter;

import fm.jiecao.jcvideoplayer_lib.JCUserActionStandard;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class YuGaoAdapter extends BaseRecyclerAdapter<XiangQingBean.ResultBean.ShortFilmListBean> {
    public YuGaoAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public int getLayoutId() {
        return R.layout.yugao_item;
    }

    @Override
    public void bindViewDataPosition(BaseViewHolder baseViewHolder, XiangQingBean.ResultBean.ShortFilmListBean shortFilmListBean, int i) {
        super.bindViewDataPosition(baseViewHolder, shortFilmListBean, i);
        JCVideoPlayer jcVideoPlayer = (JCVideoPlayer) baseViewHolder.get(R.id.yugao_video);
       // jcVideoPlayer.setUp(shortFilmListBean.getVideoUrl(),null);

        jcVideoPlayer.setUp(shortFilmListBean.getVideoUrl(),JCVideoPlayer.SCREEN_LAYOUT_NORMAL,"");
     //   baseViewHolder.setPic(R.id.yugao_video,shortFilmListBean.getVideoUrl());
       // Glide.with(context).load(shortFilmListBean.getImageUrl()).into(jcVideoPlayer.);
    }
    @Override
    public void bindViewData(BaseViewHolder baseViewHolder, XiangQingBean.ResultBean.ShortFilmListBean shortFilmListBean) {

    }

}
