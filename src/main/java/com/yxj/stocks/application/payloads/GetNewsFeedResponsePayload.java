package com.yxj.stocks.application.payloads;

import java.util.List;

public class GetNewsFeedResponsePayload extends BaseResponsePayload {


    private List<NewsFeedResponse> newsFeedResponseList;


    public List<NewsFeedResponse> getNewsFeedResponseList() {

        return newsFeedResponseList;
    }

    public void setNewsFeedResponseList(List<NewsFeedResponse> newsFeedResponseList) {
        this.newsFeedResponseList = newsFeedResponseList;
    }





    public class NewsFeedResponse {
        private String datetime;
        private String headline;
        private String source;
        private String url;
        private String summary;
        private String related;

        public NewsFeedResponse() {

        }

        public String getDatetime() {
            return datetime;
        }

        public void setDatetime(String datetime) {
            this.datetime = datetime;
        }

        public String getHeadline() {
            return headline;
        }

        public void setHeadline(String headline) {
            this.headline = headline;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getRelated() {
            return related;
        }

        public void setRelated(String related) {
            this.related = related;
        }



    }


}



