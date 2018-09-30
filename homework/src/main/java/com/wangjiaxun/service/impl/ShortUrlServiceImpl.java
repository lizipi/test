package com.wangjiaxun.service.impl;

import com.wangjiaxun.ConvertUtil;
import com.wangjiaxun.Md5ConvertUtil;
import com.wangjiaxun.UuidConvertUtil;
import com.wangjiaxun.dao.ShortUrlMapper;
import com.wangjiaxun.entity.ShortUrl;
import com.wangjiaxun.service.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 短链接操作实现类
 * @author wangjiaxun
 * @version 1.0
 * @date 2018/9/30
 */
@Service
public class ShortUrlServiceImpl implements ShortUrlService {

	/**
	 * 短链接数据库对象
	 */
	@Autowired
	private  ShortUrlMapper shortUrlMapper;

	/**
	 * 判断短链接是否存在，如果存在返回false
	 * @param tag	生成的短链接
	 * @param url	原长连接
	 * @return
	 */
	@Override
	public boolean generateShortUrl(String tag, String url) {

		shortUrlMapper.selectByTag(tag);

		if(shortUrlMapper.selectByTag(tag)!=null){
			return false;
		}

		ShortUrl shortUrl = new ShortUrl(tag, url, 0, new Date());
		// 存数据库
		try {
			shortUrlMapper.save(shortUrl);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * 按照指定条件生成短链接
	 * @param url	原长连接
	 * @param type	短链接的字符集	0:数字 1:小写字母 2:大写字母 3:大小写字母 其他:数字+大小写字母
	 * @param length	短链接的长度
	 * @param generator	短链接的生成方式	0:MD5方式，1:UUID方式
	 * @return	返回生成的短链接或者null
	 */
	@Override
	public String generateShortUrl(String url, Integer type, Integer length, Integer generator) {
		ConvertUtil convertUtil;
		switch (generator) {
			case 0:
				convertUtil = Md5ConvertUtil.getInstance();
				break;
			case 1:
				convertUtil = UuidConvertUtil.getInstance();
				break;
			default:
				convertUtil = Md5ConvertUtil.getInstance();
		}

		String[] tags = convertUtil.shortString(url, type, length);
		for (String tag : tags) {
			if (generateShortUrl(tag, url)) {
				return tag;
			}
		}
		return null;
	}

	/**
	 * 根据短链接获取长连接
	 * @param tag	短链接
	 * @return	返回查找出来的长连接或null
	 */
	@Override
	public String getUrl(String tag) {
		ShortUrl shortUrl = shortUrlMapper.selectByTag(tag);
		if(shortUrl==null){
			return null;
		}else{
			shortUrl.setCount(shortUrl.getCount()+1);
			shortUrlMapper.updateCouent(shortUrl);
			return shortUrl.getUrl();
		}


	}

}
