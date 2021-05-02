package com.yu.st.config;

import com.yu.st.interceptor.LoginInterceptor;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author hhyygg2009
 * @date Created in 2021/5/22 20:39
 */
@Component
@AllArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {

    final private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor);
    }

//    @Value(("${file.upload.path}"))
//    String path;
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/uploads/**")
//                .addResourceLocations("file:"+Paths.get(path).toAbsolutePath()+File.separator)
//                .setCacheControl(CacheControl.maxAge(30, TimeUnit.MINUTES));
//    }
}
