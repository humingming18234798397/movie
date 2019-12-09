package com.bw.movie.frag;


/*
 *@auther:胡明明
 *@Date: 2019/11/11
 *@Time:21:03
 *@Description:${DESCRIPTION}
 **/

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.activity.BanBenActivity;
import com.bw.movie.activity.ChaXunPingLunActivity;
import com.bw.movie.activity.FanKuiActivity;
import com.bw.movie.activity.GouPiaoJiLuActivity;
import com.bw.movie.activity.GuanZhuActivity;
import com.bw.movie.activity.LoginActivity;
import com.bw.movie.activity.MoviePiaoActivity;
import com.bw.movie.activity.MyYuYueActivity;
import com.bw.movie.activity.OldModelActivity;
import com.bw.movie.activity.SheZhiActivity;
import com.bw.movie.activity.XiTongActivity;
import com.bw.movie.activity.ZiLiaoActivity;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.BasePresenter;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.OnClick;

public class FragMy extends BaseFragment {
    @BindView(R.id.my_shezhi)
    LinearLayout myShezhi;
    @BindView(R.id.my_touxiang)
    SimpleDraweeView myTouxiang;
    @BindView(R.id.my_name)
    TextView myName;
    @BindView(R.id.my_text)
    TextView myText;
    @BindView(R.id.goupiaojilu)
    LinearLayout goupiaojilu;
    @BindView(R.id.my_pinglun)
    LinearLayout myPinglun;
    @BindView(R.id.my_guanzhu)
    LinearLayout myGuanzhu;
    @BindView(R.id.wodeyuyue)
    LinearLayout wodeyuyue;
    @BindView(R.id.xitongxiaoxi)
    SimpleDraweeView xitongxiaoxi;
    @BindView(R.id.my_moviepiao)
    LinearLayout myMoviepiao;
    @BindView(R.id.my_yijian)
    LinearLayout myYijian;
    @BindView(R.id.my_oldmovie)
    LinearLayout myOldmovie;
    private SharedPreferences sp;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.frag_my;
    }

    @Override
    protected void initData() {
        super.initData();
        sp = getActivity().getSharedPreferences("movie", Context.MODE_PRIVATE);
        myTouxiang.setImageURI(sp.getString("img", null));
        myName.setText(sp.getString("name", null));
        myTouxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent1);
            }
        });
        //购票记录
        goupiaojilu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GouPiaoJiLuActivity.class);
                startActivity(intent);
            }
        });
        //pi评论
        myPinglun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ChaXunPingLunActivity.class);
                startActivity(intent);
            }
        });
        //看过的电影
        myOldmovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), OldModelActivity.class);
                startActivity(intent);
            }
        });
        //我的关注
        myGuanzhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), GuanZhuActivity.class);
                startActivity(intent);
            }
        });
        //我的预约
        wodeyuyue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MyYuYueActivity.class);
                startActivity(intent);
            }
        });
        //xi系统消息
        xitongxiaoxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), XiTongActivity.class);
                startActivity(intent);
            }
        });
        //wode我的电影票
        myMoviepiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MoviePiaoActivity.class);
                startActivity(intent);
            }
        });
        //意见反馈
        myYijian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FanKuiActivity.class);
                startActivity(intent);
            }
        });

    }

    //点击设置跳转
    @OnClick({R.id.my_text, R.id.my_shezhi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my_text:
                Intent intent1 = new Intent(getActivity(), ZiLiaoActivity.class);
                startActivity(intent1);
                break;
            case R.id.my_shezhi:
                Intent intent = new Intent(getActivity(), SheZhiActivity.class);
                startActivity(intent);
                break;
        }
    }


    @OnClick(R.id.xitongxiaoxi)
    public void onViewClicked() {
    }
}
