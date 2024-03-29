package com.yu.st.config;

import com.yu.st.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author hhyygg2009
 * @date Created in 2021/5/22 20:39
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor);
    }

//    @Value(("${file.upload.path}"))
//    String path="/static";

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**")
//                .addResourceLocations("classpath:/static/")
////                .addResourceLocations("file:" + Paths.get(path).toAbsolutePath() + File.separator)
//                .setCacheControl(CacheControl.maxAge(30, TimeUnit.MINUTES));
//    }
}
