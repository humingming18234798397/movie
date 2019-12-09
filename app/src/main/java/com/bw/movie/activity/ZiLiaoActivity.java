package com.bw.movie.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.bigkoo.pickerview.TimePickerView;
import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.bean.BirthBean;
import com.bw.movie.bean.ChaYingPingBean;
import com.bw.movie.bean.DaiFuKuanBean;
import com.bw.movie.bean.DingDanBean;
import com.bw.movie.bean.ErWeiMaBean;
import com.bw.movie.bean.FanKuiBean;
import com.bw.movie.bean.GuanZhuMovie;
import com.bw.movie.bean.GuanZhuYingYuan;
import com.bw.movie.bean.MovieBean;
import com.bw.movie.bean.MoviePiaoBean;
import com.bw.movie.bean.OldMovieBean;
import com.bw.movie.bean.PhoneBean;
import com.bw.movie.bean.PwdBean;
import com.bw.movie.bean.TouXiangBean;
import com.bw.movie.bean.XiTongMessage;
import com.bw.movie.bean.YiFuKuanBean;
import com.bw.movie.bean.YongHuBean;
import com.bw.movie.bean.YuYueBean;
import com.bw.movie.bean.ZhiFuBean;
import com.bw.movie.contract.MyContract;
import com.bw.movie.presenter.MyPresenter;
import com.bw.movie.utils.ImageUtil;
import com.facebook.drawee.view.SimpleDraweeView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class ZiLiaoActivity extends BaseActivity<MyPresenter> implements MyContract.Iview {


    @BindView(R.id.cinemadetail_fanhui)
    SimpleDraweeView cinemadetailFanhui;
    @BindView(R.id.ziliao_img)
    SimpleDraweeView ziliaoImg;
    @BindView(R.id.ziliao_name)
    TextView ziliaoName;
    @BindView(R.id.ziliao_sex)
    TextView ziliaoSex;
    @BindView(R.id.ziliao_email)
    TextView ziliaoEmail;
    @BindView(R.id.ziliao_riqi)
    TextView ziliaoRiqi;
    private SharedPreferences sp;
    private int userId;
    private String s;
    private static SimpleDateFormat format;
    @Override
    protected MyPresenter providePresenter() {
        return new MyPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_zi_liao;
    }

    @Override
    protected void initData() {
        super.initData();
        sp = getSharedPreferences("movie", Context.MODE_PRIVATE);
        userId = sp.getInt("u", 0);
        s = sp.getString("s", null);
        mPresenter.getPresenteryonghu(userId, s);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.cinemadetail_fanhui, R.id.ziliao_img})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.cinemadetail_fanhui:
                finish();
                break;
            case R.id.ziliao_img:
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 10);
                break;
        }
    }


    @Override
    public void onMysuccess(DaiFuKuanBean daiFuKuanBean) {

    }

    @Override
    public void onMysuccess(YiFuKuanBean yiFuKuanBean) {

    }

    @Override
    public void onMysuccess(MovieBean movieBean) {

    }

    @Override
    public void onMysuccess(ChaYingPingBean chaYingPingBean) {

    }

    @Override
    public void onMysuccess(GuanZhuMovie guanZhuMovie) {

    }

    @Override
    public void onMysuccess(GuanZhuYingYuan guanZhuYingYuan) {

    }

    @Override
    public void onMysuccess(DingDanBean dingDanBean) {

    }

    @Override
    public void onMysuccess(ZhiFuBean zhiFuBean) {

    }

    @Override
    public void onMysuccess(YuYueBean yuYueBean) {

    }

    @Override
    public void onMysuccess(XiTongMessage xiTongMessage) {

    }

    @Override
    public void onMysuccess(MoviePiaoBean moviePiaoBean) {

    }

    @Override
    public void onMysuccess(ErWeiMaBean erWeiMaBean) {

    }

    @Override
    public void onMysuccess(FanKuiBean fanKuiBean) {

    }

    @Override
    public void onMysuccess(OldMovieBean oldMovieBean) {

    }

    @Override
    public void onMysuccess(TouXiangBean touXiangBean) {
        if (touXiangBean.getStatus().equals("0000")) {
            Toast.makeText(this, touXiangBean.getMessage(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, touXiangBean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onMysuccess(YongHuBean yongHuBean) {
        if (yongHuBean.getStatus().equals("0000")) {
            YongHuBean.ResultBean result = yongHuBean.getResult();
            ziliaoImg.setImageURI(result.getHeadPic());
            ziliaoName.setText(result.getNickName());
            ziliaoEmail.setText(result.getEmail());
            int sex = result.getSex();
            if (sex == 1) {
                ziliaoSex.setText("男");
            } else {
                ziliaoSex.setText("女");
            }
        /*    Date date = new Date(result.getLastLoginTime());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            ziliaoRiqi.setText(format.format(date));*/

            ziliaoRiqi.setText("2019-12-07");
           ziliaoRiqi.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   TimePickerView timePickerView = new TimePickerView(ZiLiaoActivity.this, TimePickerView.Type.YEAR_MONTH_DAY);
                   // 设置是否循环
                   timePickerView.setCyclic(true);
                   timePickerView.setTime(new Date());
                   timePickerView.setCyclic(false);
                   timePickerView.setCancelable(true);
                   //时间选择后回调
                   timePickerView.setOnTimeSelectListener(new TimePickerView.OnTimeSelectListener() {

                       @Override
                       public void onTimeSelect(Date date) {
                        //   edit.putString("birth",getTime(date)).commit();
                           ziliaoRiqi.setText(getTime(date));

                           String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(date);
                           mPresenter.getPresenterriqi(userId,s,dateStr);
                       }
                   });
                   timePickerView.show();
               }
           });



        }


    }

    @Override
    public void onMysuccess(PwdBean pwdBean) {

    }

    @Override
    public void onMysuccess(PhoneBean phoneBean) {

    }

    @Override
    public void onMysuccess(BirthBean birthBean) {
        Toast.makeText(this,birthBean.getMessage(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onMyFaiure(Throwable e) {

    }
    //修改生日
    public static String getTime(Date date) {
        format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 & resultCode == RESULT_OK) {
            Uri uri = data.getData();
            if (uri != null) {
                //用一个工具类获取图片的绝对路径,我会粘到下方
                String path = ImageUtil.getPath(this, uri);
                if (path != null) {
                    //转换为file类型
                    File file1 = new File(path);
                    //进行类型转换,因为在RetrofitService定义的是@Part MultipartBody.Part,所以要转成这样的格式
                    RequestBody requestBody1 = RequestBody.create(MediaType.parse("multipart/form-data"), file1);
                    MultipartBody.Part image1 = MultipartBody.Part.createFormData("image", file1.getName(), requestBody1);
                    //调用P层
                    mPresenter.getPresentertouxiang(userId, s, image1);
                }
            }
        }
    }


}
