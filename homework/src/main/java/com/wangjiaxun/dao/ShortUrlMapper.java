package com.wangjiaxun.dao;

import com.wangjiaxun.entity.ShortUrl;

/**
 * 短链接dao层接口
 * @author wangjiaxun
 * @version 1.0
 * @date 2018/9/30
 */
public interface ShortUrlMapper {

    void save(ShortUrl shortUrl);

    ShortUrl selectByTag(String tag);

    void updateCouent(ShortUrl shortUrl);
}
