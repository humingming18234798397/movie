package com.bw.movie.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.bw.movie.app.App;


/**
 *@describe(描述)：SPDownloadUtil
 *@data（日期）: 2019/11/19
 *@time（时间）: 19:48
 *@author（作者）: 胡明明
 **/
public class SPDownloadUtil {

    private static SharedPreferences mSharedPreferences;
    private static SPDownloadUtil instance;

    private SPDownloadUtil() {
    }

    public static SPDownloadUtil getInstance() {
        if (mSharedPreferences == null || instance == null) {
            synchronized (SPDownloadUtil.class) {
                if (mSharedPreferences == null || instance == null) {
                    instance = new SPDownloadUtil();
                    mSharedPreferences = App.getsAppContext().getSharedPreferences(App.getsAppContext().getPackageName() + ".downloadSp", Context.MODE_PRIVATE);
                }
            }
        }
        return instance;
    }

    /**
     * 清空数据
     *
     * @return true 成功
     */
    public boolean clear() {
        return mSharedPreferences.edit().clear().commit();
    }

    /**
     * 保存数据
     *
     * @param key   键
     * @param value 保存的value
     */
    public boolean save(String key, long value) {
        return mSharedPreferences.edit().putLong(key, value).commit();
    }

    /**
     * 获取保存的数据
     *
     * @param key      键
     * @param defValue 默认返回的value
     * @return value
     */
    public long get(String key, long defValue) {
        return mSharedPreferences.getLong(key, defValue);
    }

}

