package com.collage.wxz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.collage.wxz.mapper")
public class WxzApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxzApplication.class, args);
    }

}
