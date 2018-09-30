package com.wangjiaxun.entity;

import java.util.Date;

/**
 * 短连接表
 *
 * @author wangjiaxun
 * @version 1.0
 * @date 2018/9/30
 */
public class ShortUrl {
    /**
     * 主键id
     */
    private int id;
    /**
     * 短网址标记
     */
    private String tag;
    /**
     * 指向url
     */
    private String url;
    /**
     * 访问计数
     */
    private int count;
    /**
     * 创建时间
     */
    private Date createDate;


    public ShortUrl() {
    }

    public ShortUrl(String tag, String url, int count, Date createDate) {
        this.tag = tag;
        this.url = url;
        this.count = count;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "ShortUrl{" +
                "id=" + id +
                ", tag='" + tag + '\'' +
                ", url='" + url + '\'' +
                ", count=" + count +
                ", createDate=" + createDate +
                '}';
    }
}
