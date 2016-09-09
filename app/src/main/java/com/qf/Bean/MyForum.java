package com.qf.Bean;

import java.util.List;

/**
 * Created by Administrator on 16-9-8.
 */
public class MyForum {
    /**
     * title : 风雪219-2016梧桐凤凰新藏线骑行纪实
     * author : oysw
     * views : 28255
     * reply : 1221
     * doc_url : http://api.fengniao.com/app_ipad/bbs_hot_detail.php?tid=9268127&fid=15&isPad=1&cid=0&sid=999&page=1
     * doc_url_v2 : http://api.fengniao.com/app_ipad/bbs_hot_detail_v2.php?tid=9268127&fid=15&isPad=1&cid=0&sid=999&page=1
     * docTotalPage : 62
     * tid : 9268127
     * fid : 15
     * web_url : http://bbs.fengniao.com/forum/9268127.html
     * docLzTotalPage : 57
     */

    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        private String title;
        private String author;
        private String views;
        private String reply;
        private String doc_url;
        private String doc_url_v2;
        private String web_url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getViews() {
            return views;
        }

        public void setViews(String views) {
            this.views = views;
        }

        public String getReply() {
            return reply;
        }

        public void setReply(String reply) {
            this.reply = reply;
        }

        public String getDoc_url() {
            return doc_url;
        }

        public void setDoc_url(String doc_url) {
            this.doc_url = doc_url;
        }

        public String getDoc_url_v2() {
            return doc_url_v2;
        }

        public void setDoc_url_v2(String doc_url_v2) {
            this.doc_url_v2 = doc_url_v2;
        }

        public String getWeb_url() {
            return web_url;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }
    }
}
