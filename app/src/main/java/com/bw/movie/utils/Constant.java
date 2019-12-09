package com.bw.movie.utils;


import android.os.Environment;

import com.bw.movie.app.App;


/**
 *@describe(描述)：Constant
 *@data（日期）: 2019/11/19
 *@time（时间）: 19:48
 *@author（作者）: 胡明明
 **/

public class Constant {
    public final static String APP_ROOT_PATH = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + App.getsAppContext().getPackageName();
    public final static String DOWNLOAD_DIR = "/downlaod/";


}
