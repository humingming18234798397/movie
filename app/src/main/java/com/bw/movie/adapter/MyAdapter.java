package com.bw.movie.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.R;
import com.bw.movie.activity.HomeListActivity;
import com.bw.movie.activity.XiangQingActivity;
import com.bw.movie.bean.HomeBean;
import com.bw.movie.bean.ReYingBean;
import com.bw.movie.bean.ShangYingBean;
import com.bw.movie.bean.XBannerBean;
import com.bw.movie.frag.homelist.ListJiJiang;
import com.bw.movie.frag.homelist.ListReMen;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.tabs.TabLayout;
import com.stx.xhb.androidx.XBanner;
import com.stx.xhb.androidx.entity.SimpleBannerInfo;

import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
/**
 *@describe(描述)：MyAdapter
 *@data（日期）: 2019/11/15
 *@time（时间）: 11:16
 *@author（作者）: 胡明明
 **/
//多条目
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private  List<XBannerBean.ResultBean> banners;
    private List<ReYingBean.ResultBean> yList;
    private List<ShangYingBean.ResultBean> jList;
    private List<HomeBean.ResultBean> hotList;
    private Context context;

    public MyAdapter(List<XBannerBean.ResultBean> banners, List<ReYingBean.ResultBean> yList, List<ShangYingBean.ResultBean> jList, List<HomeBean.ResultBean> hotList, Context context) {
        this.banners = banners;
        this.yList = yList;
        this.jList = jList;
        this.hotList = hotList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.home_xbanner, parent, false);
            return new myFourHolder(inflate);
        } else if (viewType == 1) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.home_list1, parent, false);
            return new myOneHolder(inflate);
        } else if (viewType == 2) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.home_list2, parent, false);
            return new myTwoHolder(inflate);
        } else if (viewType == 3) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.home_list3, parent, false);
            return new myThreeHolder(inflate);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        switch (itemViewType) {
            case 0:
                if (holder instanceof myFourHolder) {
                    if (banners != null) {
                        ((myFourHolder) holder).tab.setBannerData(R.layout.simpledraweeview, new AbstractList<SimpleBannerInfo>() {
                            @Override
                            public SimpleBannerInfo get(int index) {

                                return null;
                            }

                            @Override
                            public int size() {
                                return banners.size();
                            }
                        });
                        ((myFourHolder) holder).tab.loadImage(new XBanner.XBannerAdapter() {
                            @Override
                            public void loadBanner(XBanner banner, Object model, View view, int position) {
                                String jumpUrl = banners.get(position).getJumpUrl();
                               // Log.d("jumpUrl", "loadBanner: "+jumpUrl);
                                String[] split = jumpUrl.split("=");
                                view.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Intent intent = new Intent(context, XiangQingActivity.class);
                                        Integer integer = Integer.valueOf(split[1]);
                                        intent.putExtra("key",integer);
                                        context.startActivity(intent);
                                    }
                                });

                                String imageUrl = banners.get(position).getImageUrl();
                                SimpleDraweeView simpleDraweeView = view.findViewById(R.id.xbanner_simview);
                                DraweeController controller = Fresco.newDraweeControllerBuilder()
                                        .setUri(imageUrl)
                                        .setAutoPlayAnimations(true)
                                        .build();
                                simpleDraweeView.setController(controller);
                                TextView tvContent = (TextView) view.findViewById(R.id.tv);
                                tvContent.setText( banners.get(position).getRank()+"/5");
                            }
                        });


                    }

                }

                break;
            case 1:
                if (holder instanceof myOneHolder) {
                    if (yList != null) {
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
                        ((myOneHolder) holder).onecy.setLayoutManager(linearLayoutManager);
                        OneAdaprer myYingAdapter = new OneAdaprer(context);
                        myYingAdapter.setList(yList);
                        ((myOneHolder) holder).onecy.setAdapter(myYingAdapter);
                      /*  //接口回调
                        myYingAdapter.setOnItemClicks(new OneAdaprer.onItemClicks() {
                            @Override
                            public void onChangeData(int p) {
                                setChangeAdapter.getChang(p);
                            }
                        });*/
                        //更多跳转
                       ((myOneHolder) holder).textView.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View v) {
                               Intent intent = new Intent(context, HomeListActivity.class);
                               context.startActivity(intent);
                           }
                       });

                    }
                }
                break;
            case 2:
                if (holder instanceof myTwoHolder) {
                    if (jList != null) {
                        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(context);
                        ((myTwoHolder) holder).twocy.setLayoutManager(linearLayoutManager1);
                        TwoAdaprer twoAdaprer = new TwoAdaprer(context,jList);
                        ((myTwoHolder) holder).twocy.setAdapter(twoAdaprer);
                        //接口回调
                        twoAdaprer.setOnItemClicks(new TwoAdaprer.onItemClicks() {
                            @Override
                            public void onChangeData(int p) {
                                setChangeAdapter.getChang(p);
                            }
                        });
                        //更多跳转
                        ((myTwoHolder) holder).textView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(context, HomeListActivity.class);
                                context.startActivity(intent);
                            }
                        });


                    }
                }
                break;
            case 3:
                if (holder instanceof myThreeHolder) {
                    if (hotList != null) {
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
                        ((myThreeHolder) holder).threecy.setLayoutManager(linearLayoutManager);
                        ThreeAdaprer threeAdaprer = new ThreeAdaprer(context);
                        threeAdaprer.setList(hotList);
                        ((myThreeHolder) holder).threecy.setAdapter(threeAdaprer);
                        if (banners != null) {
                            //  Glide.with(context).load().three_image);
                            Uri parse = Uri.parse(banners.get(0).getImageUrl());
                            ((myThreeHolder) holder).three_image.setImageURI(parse);
                            ((myThreeHolder) holder).three_image.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(context, XiangQingActivity.class);
                                    intent.putExtra("key",16);
                                    context.startActivity(intent);
                                }
                            });

                        }
                      /*  //接口回调
                        threeAdaprer.setOnItemClicks(new ThreeAdaprer.onItemClicks() {
                            @Override
                            public void onChangeData(int p) {
                                setChangeAdapter.getChang(p);
                            }
                        });*/
                        //更多跳转
                        ((myThreeHolder) holder).textView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(context, HomeListActivity.class);
                                context.startActivity(intent);
                            }
                        });

                    }
                }
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else if (position == 2) {
            return 2;
        } else if (position == 3) {
            return 3;
        }
        return 0;
    }

    public class myOneHolder extends RecyclerView.ViewHolder {
       RecyclerView onecy;
       TextView textView;
        public myOneHolder(@NonNull View itemView) {
            super(itemView);
            onecy = itemView.findViewById(R.id.rlv1);
            textView = itemView.findViewById(R.id.list1_text);
        }
    }

    public class myTwoHolder extends RecyclerView.ViewHolder {
        RecyclerView twocy;
        TextView textView;
        public myTwoHolder(@NonNull View itemView) {
            super(itemView);
            twocy = itemView.findViewById(R.id.rlv2);
            textView = itemView.findViewById(R.id.list2_text);
        }
    }

    public class myThreeHolder extends RecyclerView.ViewHolder {

        RecyclerView threecy;
         SimpleDraweeView three_image;
        TextView textView;
        public myThreeHolder(@NonNull View itemView) {
            super(itemView);
            threecy = itemView.findViewById(R.id.rlv3);
            three_image = itemView.findViewById(R.id.list1_sim);
            textView = itemView.findViewById(R.id.list3_text);
        }
    }

    public class myFourHolder extends RecyclerView.ViewHolder {

        XBanner tab;

        public myFourHolder(@NonNull View itemView) {
            super(itemView);
            tab = itemView.findViewById(R.id.xbanner);
        }
    }

     setChangeAdapter setChangeAdapter;

    public void setSetChangeAdapter(setChangeAdapter setChangeAdapter) {
        this.setChangeAdapter = setChangeAdapter;
    }

    public interface setChangeAdapter {
        void getChang(int movie);
    }
}
