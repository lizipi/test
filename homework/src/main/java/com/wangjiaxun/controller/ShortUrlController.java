package com.wangjiaxun.controller;

import com.wangjiaxun.domain.Result;
import com.wangjiaxun.domain.UrlRequest;
import com.wangjiaxun.service.ShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


/**
 * 短链接生成的Controller
 * @author wangjiaxun
 * @version 1.0
 * @date 2018/9/30
 */
@RestController
public class ShortUrlController {


    @Autowired
    private ShortUrlService shortUrlService;

    @RequestMapping("/")
    public ModelAndView index(){
        return new ModelAndView("forward:index.html");
    }


    /**`
     * 生成短链接
     * @param urlRequest    前台表单传进来的参数
     * @return
     */
    @RequestMapping(value = "/generateShortUrl",method = POST)
    public Result generateShortUrl(@RequestBody UrlRequest urlRequest){
        if (!StringUtils.isEmpty(urlRequest.getTag())) {
            if (shortUrlService.generateShortUrl(urlRequest.getTag(), urlRequest.getUrl())) {

                return new Result(200, "生成成功！", urlRequest.getTag());
            } else {

                return new Result(0, "生成失败，该短链接已被使用", urlRequest);
            }
        } else {

            // 填充默认值
            if (urlRequest.getType() == null) {
                urlRequest.setType(-1);
            }
            if (urlRequest.getLength() == null) {
                urlRequest.setLength(4 + (new Random()).nextInt(12));
            }
            if(urlRequest.getLength() <4 ||urlRequest.getLength() >16){
                return new Result(0, "生成失败，指定生成字符长度不合法", null);
            }
            if (urlRequest.getGenerator() == null) {
                urlRequest.setGenerator(1);
            }

            // 生成短链接
            String tag = shortUrlService.generateShortUrl(urlRequest.getUrl(), urlRequest.getType(), urlRequest.getLength(), urlRequest.getGenerator());

            if (StringUtils.isEmpty(tag)) {
                return new Result(0, "生成失败，请重试", null);
            } else {
                return new Result(200, "生成成功", tag);
            }
        }



    }


    /**
     * 短链接访问操作，如果不存在记录则跳转到主页
     *
     * @param tag 短连接标识
     */
    @RequestMapping(value = "/{tag:[0-9a-zA-Z]{4,16}}",method = GET)
    public ModelAndView setShortUrl(@PathVariable("tag") String tag) {
        String url = shortUrlService.getUrl(tag);
        if (url == null) {
            return new ModelAndView("forward:index.html");
        } else {
            return new ModelAndView("redirect:" + url);
        }
    }




}
