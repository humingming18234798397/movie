package com.bw.movie.bean;


/*
 *@auther:胡明明
 *@Date: 2019/11/30
 *@Time:17:01
 *@Description:${DESCRIPTION}
 **/

import java.util.List;

public class MovieBean {


    /**
     * result : [{"commentTime":1575103029000,"director":"林德禄","imageUrl":"http://172.17.8.100/images/movie/stills/ftfb3/ftfb(3)1.jpg","movieId":17,"movieName":"反贪风暴3","movieScore":0,"myCommentContent":"","myCommentScore":9.1,"starring":"古天乐,张智霖,郑嘉颖,邓丽欣,谢天华"},{"commentTime":1574940745000,"director":"吕乐","imageUrl":"http://172.17.8.100/images/movie/stills/zdn/zdn1.jpg","movieId":21,"movieName":"找到你","movieScore":0,"myCommentContent":"感动,想哭!!!","myCommentScore":8.5,"starring":"姚晨,马伊琍,袁文康,吴昊宸"},{"commentTime":1574930305000,"director":"\r\n李仁港","imageUrl":"http://172.17.8.100/images/movie/stills/pdz/pdz1.jpg","movieId":25,"movieName":"攀登者","movieScore":0,"myCommentContent":"好看1","myCommentScore":9.4,"starring":"吴京,章子怡,井柏然,胡歌"},{"commentTime":1574929807000,"director":"曾国祥","imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieId":22,"movieName":"少年的你","movieScore":0,"myCommentContent":"很好","myCommentScore":0,"starring":"周冬雨,易烊千玺,张耀,周也,尹昉"},{"commentTime":1574920356000,"director":"\r\n刘伟强","imageUrl":"http://172.17.8.100/images/movie/stills/zgjz/zgjz1.jpg","movieId":24,"movieName":"中国机长","movieScore":0,"myCommentContent":"好看","myCommentScore":9.4,"starring":"张涵予,欧豪,袁泉,张天爱,李沁"}]
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
         * commentTime : 1575103029000
         * director : 林德禄
         * imageUrl : http://172.17.8.100/images/movie/stills/ftfb3/ftfb(3)1.jpg
         * movieId : 17
         * movieName : 反贪风暴3
         * movieScore : 0
         * myCommentContent :
         * myCommentScore : 9.1
         * starring : 古天乐,张智霖,郑嘉颖,邓丽欣,谢天华
         */

        private long commentTime;
        private String director;
        private String imageUrl;
        private int movieId;
        private String movieName;
        private int movieScore;
        private String myCommentContent;
        private double myCommentScore;
        private String starring;

        public long getCommentTime() {
            return commentTime;
        }

        public void setCommentTime(long commentTime) {
            this.commentTime = commentTime;
        }

        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public int getMovieId() {
            return movieId;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }

        public String getMovieName() {
            return movieName;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public int getMovieScore() {
            return movieScore;
        }

        public void setMovieScore(int movieScore) {
            this.movieScore = movieScore;
        }

        public String getMyCommentContent() {
            return myCommentContent;
        }

        public void setMyCommentContent(String myCommentContent) {
            this.myCommentContent = myCommentContent;
        }

        public double getMyCommentScore() {
            return myCommentScore;
        }

        public void setMyCommentScore(double myCommentScore) {
            this.myCommentScore = myCommentScore;
        }

        public String getStarring() {
            return starring;
        }

        public void setStarring(String starring) {
            this.starring = starring;
        }
    }
}
