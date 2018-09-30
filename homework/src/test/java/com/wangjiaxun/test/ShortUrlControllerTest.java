package com.wangjiaxun.test;

import com.wangjiaxun.ConvertUtil;
import com.wangjiaxun.Md5ConvertUtil;
import com.wangjiaxun.UuidConvertUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/springmvc.xml")
public class ShortUrlControllerTest {

    @Test
    public void md5ConvertTest() {
        ConvertUtil convertUtil = Md5ConvertUtil.getInstance();
        Random r = new Random();
        int length = r.nextInt(13) + 4;
        int charset = r.nextInt(5);

        System.out.println("短字符串转换,字符集:"+charset+",长度:"+length);

        String tag[] = convertUtil.shortString("Cheivin", charset, length);

        for (String s : tag) {
            System.out.println("生成结果:" + s);
        }
    }

    @Test
    public void md5ConvertCheckTest() {
        ConvertUtil convertUtil = Md5ConvertUtil.getInstance();
        Random r = new Random();
        int length = r.nextInt(13) + 4;
        int charset = r.nextInt(5);

        System.out.println(String.format("短字符串转换,字符集:%d,长度:%d", charset, length));

        String tag1[] = convertUtil.shortString("Cheivin", charset, length);
        String tag2[] = convertUtil.shortString("Cheivin", charset, length);

        for (int i = 0; i < tag1.length; i++) {
            assert tag1[i].equals(tag2[i]) : "两次md5生成结果不一致";
        }
        System.out.println("两次生成结果一致");
    }

    @Test
    public void uuidConvertTest() {
        ConvertUtil convertUtil = UuidConvertUtil.getInstance();
        Random r = new Random();
        int length = r.nextInt(13) + 4;
        int charset = r.nextInt(5);

        System.out.println(String.format("短字符串转换,字符集:%d,长度:%d", charset, length));

        String tag[] = convertUtil.shortString("Cheivin", charset, length);

        for (String s : tag) {
            System.out.println("生成结果:" + s);
        }
    }

    @Test
    public void uuidConvertCheckTest() {
        ConvertUtil convertUtil = UuidConvertUtil.getInstance();
        Random r = new Random();
        int length = r.nextInt(13) + 4;
        int charset = r.nextInt(5);

        System.out.println(String.format("短字符串转换,字符集:%d,长度:%d", charset, length));

        String tag1[] = convertUtil.shortString("Cheivin", charset, length);
        String tag2[] = convertUtil.shortString("Cheivin", charset, length);

        for (int i = 0; i < tag1.length; i++) {
            assert !tag1[i].equals(tag2[i]) : "两次uuid生成结果不应一致";
        }
        System.out.println("两次生成结果不同");
    }
}
