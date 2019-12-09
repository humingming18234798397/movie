package com.bw.movie.bean;


/*
 *@auther:胡明明
 *@Date: 2019/11/30
 *@Time:11:44
 *@Description:${DESCRIPTION}
 **/

import java.util.List;

public class DaiFuKuanBean {

    /**
     * result : [{"amount":1,"createTime":1575005911000,"id":4135,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191129133831738","price":0.01},{"amount":1,"createTime":1575006232000,"id":4139,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191129134352270","price":0.01},{"amount":1,"createTime":1575006233000,"id":4140,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191129134353707","price":0.01},{"amount":1,"createTime":1575008488000,"id":4176,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191129142128285","price":0.01},{"amount":1,"createTime":1575013113000,"id":4214,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191129153833888","price":0.01},{"amount":1,"createTime":1575016313000,"id":4300,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191129163153500","price":0.01},{"amount":1,"createTime":1575016382000,"id":4302,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191129163302586","price":0.01},{"amount":1,"createTime":1575017946000,"id":4343,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191129165906473","price":0.01},{"amount":1,"createTime":1575018171000,"id":4350,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191129170251309","price":0.01},{"amount":1,"createTime":1575018264000,"id":4353,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191129170424266","price":0.01},{"amount":1,"createTime":1575018374000,"id":4355,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191129170614746","price":0.01},{"amount":1,"createTime":1575023976000,"id":4380,"imageUrl":"http://172.17.8.100/images/movie/stills/zgjz/zgjz1.jpg","movieName":"中国机长","orderId":"20191129183936086","price":0.01},{"amount":1,"createTime":1575024504000,"id":4406,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191129184824839","price":0.01},{"amount":1,"createTime":1575024516000,"id":4408,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191129184836938","price":0.01},{"amount":1,"createTime":1575024603000,"id":4414,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191129185003139","price":0.01},{"amount":1,"createTime":1575024615000,"id":4415,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191129185015273","price":0.01},{"amount":1,"createTime":1575034415000,"id":5113,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191129213335190","price":0.01},{"amount":1,"createTime":1575034757000,"id":5129,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191129213917722","price":0.01},{"amount":1,"createTime":1575034826000,"id":5130,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191129214026010","price":0.01},{"amount":1,"createTime":1575078730000,"id":5200,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieName":"少年的你","orderId":"20191130095210312","price":0.01}]
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
         * amount : 1
         * createTime : 1575005911000
         * id : 4135
         * imageUrl : http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg
         * movieName : 少年的你
         * orderId : 20191129133831738
         * price : 0.01
         */

        private int amount;
        private long createTime;
        private int id;
        private String imageUrl;
        private String movieName;
        private String orderId;
        private double price;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getMovieName() {
            return movieName;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
