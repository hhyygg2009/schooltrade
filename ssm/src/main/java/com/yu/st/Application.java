package com.yu.st;

import lombok.Getter;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author :hhyygg2009
 * @date :Created in 2021/1/8 16:21
 * @package :com.yu.st
 * @description:
 * @modified By：
 * @version:
 */
//@ComponentScan(basePackages = "com.yu.st")
@MapperScan("com.yu.st.dao")
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
