package com.yu.st;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author :hhyygg2009
 * @date :Created in 2021/1/8 16:21
 * @package :com.yu.st
 * @description:
 * @modified By：
 * @version:
 */
//@ComponentScan(basePackages = "com.yu.st")
@SpringBootApplication
@MapperScan("com.yu.st.dao")
@EnableCaching
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
