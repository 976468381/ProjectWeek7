package com.qf.Bean;

import java.util.List;

/**
 * Created by Administrator on 16-9-6.
 */
public class MyKit {


    /**
     * title : 重塑画质升级防抖 腾龙150-600 G2评测首发
     * pic_url : http://img2.fengniao.com/article/12_280x210/36/liUT5oqFoL5Hk.jpg
     * doc_url : http://api.fengniao.com/app_ipad/news_doc.php?docid=5338640&isPad=1
     * comment_page_num : 0
     * comments_num : 0
     * more_comment_url : http://api.fengniao.com/app_ipad/news_doc_comments.php?docid=5338640&isPad=1
     * doc_id : 5338640
     * web_url : http://qicai.fengniao.com/533/5338640.html
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
        private String pic_url;
        private String doc_url;
        private String web_url;

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

        public String getWeb_url() {
            return web_url;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }
    }
}
