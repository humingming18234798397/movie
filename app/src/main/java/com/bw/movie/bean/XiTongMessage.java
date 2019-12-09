package com.bw.movie.bean;


/*
 *@auther:胡明明
 *@Date: 2019/12/3
 *@Time:18:45
 *@Description:${DESCRIPTION}
 **/

import java.util.List;

public class XiTongMessage {

    /**
     * result : [{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":8614,"pushTime":1575359304000,"status":0,"title":"系统通知","userId":13794},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":8604,"pushTime":1575355133000,"status":0,"title":"系统通知","userId":13794},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":8553,"pushTime":1575332926000,"status":0,"title":"系统通知","userId":13794},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":8552,"pushTime":1575332919000,"status":0,"title":"系统通知","userId":13794},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":8513,"pushTime":1575275655000,"status":0,"title":"系统通知","userId":13794},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":8406,"pushTime":1575204342000,"status":0,"title":"系统通知","userId":13794},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":8358,"pushTime":1575178527000,"status":0,"title":"系统通知","userId":13794},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":8298,"pushTime":1575097144000,"status":0,"title":"系统通知","userId":13794},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":8071,"pushTime":1575078730000,"status":0,"title":"系统通知","userId":13794},{"content":"您已购买电影票,请尽快完成支付,以免影响到您的观影","id":7992,"pushTime":1575034826000,"status":0,"title":"系统通知","userId":13794}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * content : 您已购买电影票,请尽快完成支付,以免影响到您的观影
         * id : 8614
         * pushTime : 1575359304000
         * status : 0
         * title : 系统通知
         * userId : 13794
         */

        private String content;
        private int id;
        private long pushTime;
        private int status;
        private String title;
        private int userId;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public long getPushTime() {
            return pushTime;
        }

        public void setPushTime(long pushTime) {
            this.pushTime = pushTime;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }
}
