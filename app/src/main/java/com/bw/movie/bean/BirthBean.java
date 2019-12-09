package com.bw.movie.bean;

/**
 *@describe(描述)：BirthBean
 *@data（日期）: 2019/12/6
 *@time（时间）: 20:15
 *@author（作者）: 胡明明
 **/

public class BirthBean {
    /**
     * message : 修改成功
     * status : 0000
     */

    private String message;
    private String status;

    @Override
    public String toString() {
        return "BirthBean{" +
                "message='" + message + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
