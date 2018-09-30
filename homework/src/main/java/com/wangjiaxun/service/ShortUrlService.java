package com.wangjiaxun.service;

/**
 * 短链接操作的接口
 * @author wangjiaxun
 * @version 1.0
 * @date 2018/9/30
 */
public interface ShortUrlService {

	boolean generateShortUrl(String tag, String url);

	String generateShortUrl(String url, Integer type, Integer length, Integer generator);

    String getUrl(String tag);
}
