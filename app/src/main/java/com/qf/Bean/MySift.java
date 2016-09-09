package com.qf.Bean;

import java.util.List;

/**
 * Created by Administrator on 16-9-5.
 */
public class MySift {


    /**
     * title : 专业电影变焦头 蔡司LWZ.3 预计明年发售
     * pic_url : http://img2.fengniao.com/product/157_280x280/636/ce1Rlt9GpUJXw.jpg
     * date : 2016-09-05 06:00:00
     * doc_url : http://api.fengniao.com/app_ipad/news_doc.php?docid=5338549&isPad=1
     * doc_id : 5338549
     * web_url : http://qicai.fengniao.com/533/5338549.html
     * comment_page_num : 0
     * comments_num : 0
     * more_comment_url : http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338549&isPad=1
     */

    private List<HeadlineBean> headline;
    /**
     * title : 4K摄像新选择 佳能CX15将于本月上市发售
     * pic_url : http://img2.fengniao.com/product/157_160x120/690/cewHLhxKGclA.jpg
     * date : 2016-09-05 06:00:00
     * author : 房时宇
     * doc_url : http://api.fengniao.com/app_ipad/news_doc.php?docid=5338563&isPad=1
     * doc_id : 5338563
     * web_url : http://qicai.fengniao.com/533/5338563.html
     * comment_page_num : 0
     * comments_num : 0
     * more_comment_url : http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338563&isPad=1
     */

    private List<ContentBean> content;

    public List<HeadlineBean> getHeadline() {
        return headline;
    }

    public void setHeadline(List<HeadlineBean> headline) {
        this.headline = headline;
    }

    public List<ContentBean> getContent() {
        return content;
    }

    public void setContent(List<ContentBean> content) {
        this.content = content;
    }

    public static class HeadlineBean {
        private String title;
        private String pic_url;
        private String doc_url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPic_url() {
            return pic_url;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }

        public String getDoc_url() {
            return doc_url;
        }

        public void setDoc_url(String doc_url) {
            this.doc_url = doc_url;
        }
    }

    public static class ContentBean {
        private String title;
        private String pic_url;
        private String date;
        private String doc_url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPic_url() {
            return pic_url;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDoc_url() {
            return doc_url;
        }

        public void setDoc_url(String doc_url) {
            this.doc_url = doc_url;
        }
    }
}
