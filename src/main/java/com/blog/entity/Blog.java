package com.blog.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
public class Blog implements Serializable {
    private static final long serialVersionUID = 1L;
//    主键
    private Integer id;
    //    标题
    private String title;
    //    摘要
    private String summary;
//    发表时间
    private Date releaseDate;
//    点击数
    private Integer clickHit;
//    评论数
    private Integer replyHit;
//    内容
    private String content;
//    所属博客类型, 采用t_blog中添加外键的方式来进行，引入BlogType bean即可
    private BlogType blogType;
//    关键字
    private String keyWord;

//    纯文本格式的内容
    private String contentNoTag;
//    发表时间
    private String releaseDateStr;
    //博客数量
    private Integer blogCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getClickHit() {
        return clickHit;
    }

    public void setClickHit(Integer clickHit) {
        this.clickHit = clickHit;
    }

    public Integer getReplyHit() {
        return replyHit;
    }

    public void setReplyHit(Integer replyHit) {
        this.replyHit = replyHit;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BlogType getBlogType() {
        return blogType;
    }

    public void setBlogType(BlogType blogType) {
        this.blogType = blogType;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getContentNoTag() {
        return contentNoTag;
    }

    public void setContentNoTag(String contentNoTag) {
        this.contentNoTag = contentNoTag;
    }

    public String getReleaseDateStr() {
        return releaseDateStr;
    }

    public void setReleaseDateStr(String releaseDateStr) {
        this.releaseDateStr = releaseDateStr;
    }

    public Integer getBlogCount() {
        return blogCount;
    }

    public void setBlogCount(Integer blogCount) {
        this.blogCount = blogCount;
    }
}
