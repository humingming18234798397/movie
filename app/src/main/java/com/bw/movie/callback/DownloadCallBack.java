package com.bw.movie.callback;

/**
 *@describe(描述)：DownloadCallBack
 *@data（日期）: 2019/11/19
 *@time（时间）: 19:48
 *@author（作者）: 胡明明
 **/
public interface DownloadCallBack {

      void onProgress(int progress);

    void onCompleted();

    void onError(String msg);

}
