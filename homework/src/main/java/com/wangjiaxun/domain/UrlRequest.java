package com.wangjiaxun.domain;


/**
 * 短连接生成请求参数类
 *
 * @author wangjiaxun
 * @version 1.0
 * @date 2018/9/30
 */
public class UrlRequest {
    /**
     * 原始链接
     */
    private String url;
    /**
     * 指定字符串
     */
    private String tag;
    /**
     * 字符集 0:数字 1:小写字母 2:大写字母 3:大小写字母 其他:数字+大小写字母
     */
    private Integer type;
    /**
     * 输出长度4~16之间，超出范围会自动修正
     */
    private Integer length;
    /**
     * 生成方式：0:MD5方式，1:UUID方式
     */
    private Integer generator;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getGenerator() {
        return generator;
    }

    public void setGenerator(Integer generator) {
        this.generator = generator;
    }
}
