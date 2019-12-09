package com.bw.movie.bean;


/*
 *@auther:胡明明
 *@Date: 2019/12/4
 *@Time:19:51
 *@Description:${DESCRIPTION}
 **/

import java.util.List;

public class OldMovieBean {

    /**
     * result : [{"beginTime":31800000,"cinemaId":11,"endTime":38100000,"imageUrl":"http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg","movieId":22,"movieName":"少年的你","recordId":5426,"whetherComment":2}]
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
         * beginTime : 31800000
         * cinemaId : 11
         * endTime : 38100000
         * imageUrl : http://172.17.8.100/images/movie/stills/sndn/sndn1.jpg
         * movieId : 22
         * movieName : 少年的你
         * recordId : 5426
         * whetherComment : 2
         */

        private int beginTime;
        private int cinemaId;
        private int endTime;
        private String imageUrl;
        private int movieId;
        private String movieName;
        private int recordId;
        private int whetherComment;

        public int getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(int beginTime) {
            this.beginTime = beginTime;
        }

        public int getCinemaId() {
            return cinemaId;
        }

        public void setCinemaId(int cinemaId) {
            this.cinemaId = cinemaId;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
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

        public int getRecordId() {
            return recordId;
        }

        public void setRecordId(int recordId) {
            this.recordId = recordId;
        }

        public int getWhetherComment() {
            return whetherComment;
        }

        public void setWhetherComment(int whetherComment) {
            this.whetherComment = whetherComment;
        }
    }
}
