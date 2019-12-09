package com.bw.movie.frag;


/*
 *@auther:胡明明
 *@Date: 2019/11/11
 *@Time:21:03
 *@Description:${DESCRIPTION}
 **/

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.bw.movie.R;
import com.bw.movie.activity.HomeSousuoActivity;
import com.bw.movie.adapter.MyAdapter;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.bean.GuanZhuBean;
import com.bw.movie.bean.HomeBean;
import com.bw.movie.bean.HomeSouSuoBean;
import com.bw.movie.bean.HomeYuYueBean;
import com.bw.movie.bean.MovieDianZan;
import com.bw.movie.bean.PriceBean;
import com.bw.movie.bean.QuLeiBean;
import com.bw.movie.bean.ReYingBean;
import com.bw.movie.bean.ShangYingBean;
import com.bw.movie.bean.ShiJianBean;
import com.bw.movie.bean.ShiJianYingYuanBean;
import com.bw.movie.bean.WeiGuanZhuBean;
import com.bw.movie.bean.XBannerBean;
import com.bw.movie.bean.XiaDanBean;
import com.bw.movie.bean.XiangQingBean;
import com.bw.movie.bean.XieYingPingBean;
import com.bw.movie.bean.XuanZuoXinXiBean;
import com.bw.movie.bean.YingPingBean;
import com.bw.movie.bean.YingTingBean;
import com.bw.movie.bean.ZhiFuBean;
import com.bw.movie.bean.ZuoWeiHaoBean;
import com.bw.movie.contract.HomeContract;
import com.bw.movie.presenter.HomePresenter;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class FragHome extends BaseFragment<HomePresenter> implements HomeContract.Iview {

    @BindView(R.id.home_xrecyclerview)
    RecyclerView homeXrecyclerview;
    @BindView(R.id.home_sousuo)
    SimpleDraweeView homeSousuo;
    @BindView(R.id.img_dingweisimp)
    SimpleDraweeView img_dingweisimp;
    @BindView(R.id.beijingeses)
    TextView beijingeses;
    @BindView(R.id.shouye_smart)
    SmartRefreshLayout shouyeSmart;
    private List<XBannerBean.ResultBean> result;
    private List<ReYingBean.ResultBean> remen;
    private List<ShangYingBean.ResultBean> shangying;
    private List<HomeBean.ResultBean> home;
    int page = 1;

    private AMapLocationClient mlocationClient;
    private AMapLocationClientOption mLocationOption;
    private int GPS_REQUEST_CODE = 10;
    private int userId;
    private String s;
    private SharedPreferences sp;
  //  private Unbinder bind;

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.frag_home;
    }

    @Override
    protected void initData() {
        super.initData();
     //   bind = ButterKnife.bind(this, view);

        sp = getActivity().getSharedPreferences("movie", Context.MODE_PRIVATE);
        userId = sp.getInt("u", 0);
        s = sp.getString("s", null);

        //下拉刷新,上拉加载
        shouyeSmart.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                page = 1;
                mPresenter.getPresenterXbanner();
                mPresenter.getPresenterReYing(page, 5);
                mPresenter.getPresenterShangYing(page, 3);
                mPresenter.getPresenterHome(page, 5);
                shouyeSmart.finishRefresh(2000/*,false*/);
            }
        });
        shouyeSmart.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                page++;
                mPresenter.getPresenterXbanner();
                mPresenter.getPresenterReYing(page, 5);
                mPresenter.getPresenterShangYing(page, 3);
                mPresenter.getPresenterHome(page, 5);
                shouyeSmart.finishLoadMore(2000);
            }
        });






     /*   homeXrecyclerview.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                mPresenter.getPresenterXbanner();
                mPresenter.getPresenterReYing(page, 5);
                mPresenter.getPresenterShangYing(page, 3);
                mPresenter.getPresenterHome(page, 5);
                homeXrecyclerview.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                page++;
                mPresenter.getPresenterXbanner();
                mPresenter.getPresenterReYing(page, 5);
                mPresenter.getPresenterShangYing(page, 3);
                mPresenter.getPresenterHome(page, 5);
                homeXrecyclerview.loadMoreComplete();
            }
        });*/

        mPresenter.getPresenterXbanner();
        mPresenter.getPresenterReYing(1, 5);
        mPresenter.getPresenterShangYing(1, 3);
        mPresenter.getPresenterHome(1, 5);
    }

    //多条目
    @Override
    public void onHomesuccess(XBannerBean xBannerBean) {
        result = xBannerBean.getResult();
      /*  xbanner.setBannerData(R.layout.simpledraweeview, new AbstractList<SimpleBannerInfo>() {
            @Override
            public SimpleBannerInfo get(int index) {
                return null;
            }

            @Override
            public int size() {
                return result.size();
            }
        });
        xbanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                SimpleDraweeView simpleDraweeView = view.findViewById(R.id.xbanner_simview);
                String imageUrl = result.get(position).getImageUrl();
                DraweeController controller = Fresco.newDraweeControllerBuilder()
                        .setUri(imageUrl)
                        .setAutoPlayAnimations(true)
                        .build();
                simpleDraweeView.setController(controller);
                TextView tvContent = (TextView) view.findViewById(R.id.tv);
                tvContent.setText(xBannerBean.getResult().get(position).getRank()+"/5");
            }
        });*/
       /* LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        homeXrecyclerview.setLayoutManager(linearLayoutManager);
        homeXrecyclerview.setAdapter(new MyAdapter(result,remen,shangying,home,getActivity()));
*/
    }

    @Override
    public void onHomesuccess(ReYingBean reYingBean) {
        remen = reYingBean.getResult();
      /*  LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        homeXrecyclerview.setLayoutManager(linearLayoutManager);
        homeXrecyclerview.setAdapter(new MyAdapter(result,remen,shangying,home,getActivity()));*/


    }

    @Override
    public void onHomesuccess(ShangYingBean shangYingBean) {
        shangying = shangYingBean.getResult();
      /*  LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        homeXrecyclerview.setLayoutManager(linearLayoutManager);
        homeXrecyclerview.setAdapter(new MyAdapter(result,remen,shangying,home,getActivity()));
*/
    }

    @Override
    public void onHomesuccess(HomeBean homeBean) {
        home = homeBean.getResult();
        MyAdapter myAdapter = new MyAdapter(result, remen, shangying, home, getActivity());
        homeXrecyclerview.setAdapter(myAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        homeXrecyclerview.setLayoutManager(linearLayoutManager);
        myAdapter.setSetChangeAdapter(new MyAdapter.setChangeAdapter() {
            @Override
            public void getChang(int movie) {
                if (userId!=0&&s!=null){
                    mPresenter.getPresenterhomeyuyue(userId, s, movie);
                }else{
                    Toast.makeText(getActivity(), "请先登录", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onHomesuccess(XiangQingBean xiangQingBean) {

    }

    @Override
    public void onHomesuccess(YingPingBean yingPingBean) {

    }

    @Override
    public void onHomesuccess(HomeSouSuoBean homeSouSuoBean) {

    }

    @Override
    public void onHomesuccess(QuLeiBean quLeiBean) {

    }

    @Override
    public void onHomesuccess(XuanZuoXinXiBean xuanZuoXinXiBean) {

    }

    @Override
    public void onHomesuccess(ShiJianBean shiJianBean) {

    }

    @Override
    public void onHomesuccess(PriceBean priceBean) {

    }

    @Override
    public void onHomesuccess(ShiJianYingYuanBean shiJianYingYuanBean) {

    }

    @Override
    public void onHomesuccess(YingTingBean yingTingBean) {

    }

    @Override
    public void onHomesuccess(ZuoWeiHaoBean zuoWeiHaoBean) {

    }

    @Override
    public void onHomesuccess(XieYingPingBean xieYingPingBean) {

    }

    @Override
    public void onHomesuccess(XiaDanBean xiaDanBean) {

    }

    @Override
    public void onHomesuccess(ZhiFuBean zhiFuBean) {

    }

    @Override
    public void onHomesuccess(GuanZhuBean guanZhuBean) {

    }

    @Override
    public void onHomesuccess(WeiGuanZhuBean weiGuanZhuBean) {

    }

    @Override
    public void onHomesuccess(HomeYuYueBean homeYuYueBean) {
        if (homeYuYueBean.equals("0000")) {
            Toast.makeText(getActivity(), "" + homeYuYueBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onHomesuccess(MovieDianZan movieDianZan) {

    }

    @Override
    public void onHomeFaiure(Throwable e) {

    }

    @OnClick({R.id.img_dingweisimp, R.id.home_sousuo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_dingweisimp:
                Toast.makeText(getActivity(), "定位", Toast.LENGTH_SHORT).show();
                if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {//未开启定位权限
                    //开启定位权限,200是标识码
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 200);
                } else {
                    MyLocation(getActivity());//开始定位
                }
                break;
            case R.id.home_sousuo:
                Intent intent = new Intent(getActivity(), HomeSousuoActivity.class);
                startActivity(intent);
                break;
        }
    }

    /*
     * 定位 判断是否开启权限
     * 有 执行
     * 无 弹框提示进入设置开启权限
     * */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 200://刚才的识别码
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {//用户同意权限,执行我们的操作
                    MyLocation(getActivity());//开始定位
                } else {//用户拒绝之后,当然我们也可以弹出一个窗口,直接跳转到系统设置页面
                    Toast.makeText(getActivity(), "未开启定位权限,请手动到设置去开启权限", Toast.LENGTH_LONG).show();
                }
                break;
            default:
                break;
        }
    }

    /*
     * 定位成功回调信息，设置相关消息
     * */
    public void MyLocation(Context context) {
        mlocationClient = new AMapLocationClient(context);
        mLocationOption = new AMapLocationClientOption();
        mlocationClient.setLocationListener(new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation amapLocation) {
                try {
                    if (amapLocation != null) {
                        if (amapLocation.getErrorCode() == 0) {
                            //定位成功回调信息，设置相关消息

                            //获取当前定位结果来源，如网络定位结果，详见定位类型表
                            Log.i("定位类型", amapLocation.getLocationType() + "");
                            Log.i("获取纬度", amapLocation.getLatitude() + "");
                            Log.i("获取经度", amapLocation.getLongitude() + "");
                            Log.i("获取精度信息", amapLocation.getAccuracy() + "");
                            //如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
                            Log.i("地址", amapLocation.getAddress());
                            Log.i("国家信息", amapLocation.getCountry());
                            Log.i("省信息", amapLocation.getProvince());
                            Log.i("城市信息", amapLocation.getCity());
                            Log.i("城区信息", amapLocation.getDistrict());
                            Log.i("街道信息", amapLocation.getStreet());
                            Log.i("街道门牌号信息", amapLocation.getStreetNum());
                            Log.i("城市编码", amapLocation.getCityCode());
                            Log.i("地区编码", amapLocation.getAdCode());
                            Log.i("获取当前定位点的AOI信息", amapLocation.getAoiName());
                            Log.i("获取当前室内定位的建筑物Id", amapLocation.getBuildingId());
                            Log.i("获取当前室内定位的楼层", amapLocation.getFloor());
                            Log.i("获取GPS的当前状态", amapLocation.getGpsAccuracyStatus() + "");
                            //获取定位时间
                            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            Date date = new Date(amapLocation.getTime());
                            Log.i("获取定位时间", df.format(date));
                            beijingeses.setText(amapLocation.getDistrict());
                            // 停止定位
                            mlocationClient.stopLocation();
                        } else {
                            //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                            Log.e("AmapError", "location Error, ErrCode:"
                                    + amapLocation.getErrorCode() + ", errInfo:"
                                    + amapLocation.getErrorInfo());
                            Toast.makeText(getActivity(), "没有权限，请打开权限...", Toast.LENGTH_SHORT).show();
                            new AlertDialog.Builder(getActivity())
                                    .setTitle("定位服务未开启")
                                    .setMessage("请在系统设置中开启定位服务\n" +
                                            "以便为您提供更好的服务")
                                    .setPositiveButton("设置", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                            startActivityForResult(intent, GPS_REQUEST_CODE);
                                        }
                                    })
                                    .show();
                        }
                    }
                } catch (Exception e) {
                }

            }
        });
        //设置定位模式为高精度模式，Battery_Saving为低功耗模式，Device_Sensors是仅设备模式
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        mLocationOption.setInterval(5000);
        //设置定位参数
        mlocationClient.setLocationOption(mLocationOption);
        //启动定位
        mlocationClient.startLocation();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {//未开启定位权限
            //开启定位权限,200是标识码
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 200);

        } else {
            MyLocation(getActivity());//开始定位
            //Toast.makeText(getActivity(),"已开启定位权限",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        // 停止定位
        if (null != mlocationClient) {
            mlocationClient.stopLocation();
        }

    }

    //内存泄露和定位
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (null != mlocationClient) {
            /**
             * 如果AMapLocationClient是在当前Activity实例化的，
             * 在Activity的onDestroy中一定要执行AMapLocationClient的onDestroy
             */
            mlocationClient.onDestroy();
            mlocationClient = null;
        }
       // bind.unbind();
    }

}
