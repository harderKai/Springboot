package com.lukai.firstboot;
import java.util.*;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//@EnableCaching   //表示开启了redis缓存
//@ComponentScan(basePackages = {"com.lukai.firstboot.dao.Dao"})

@SpringBootApplication
public class FirstbootApplication  {

    public static void main(String[] args) {
        SpringApplication.run(FirstbootApplication.class, args);
    }

    //中文支付宝？显示困扰我很久，并不是中文问题，在springboot中 中文是正常显示的，但是如果用new String(request.getParameter("").getBytes("ISO-XXXX"),"utf-8")
    //这种处理是无法获取到中文的，因为ISO编码就已经把中文剔除了！


//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        super.configureMessageConverters(converters);
//        //定义一个convert 转换消息的对象
//        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//        // 2 添加fastjson 的配置信息 比如 是否要格式化 返回的json数据
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(
//                SerializerFeature.PrettyFormat
//        );
//        fastConverter.setFastJsonConfig(fastJsonConfig);
//        // 解决乱码的问题
//        List<MediaType> fastMediaTypes = new ArrayList<>();
//        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
//        fastConverter.setSupportedMediaTypes(fastMediaTypes);
//        converters.add(fastConverter);
//    }



}
